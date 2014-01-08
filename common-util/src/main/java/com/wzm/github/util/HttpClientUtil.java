package com.wzm.github.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;


//import com.google.common.collect.Multiset.Entry;
//import com.meiliwan.common.search.SolrSearcher;
/**
 * httpclient 4.1 . 
 * a global connection pool, <b>DO NOT shutdown the client</b> 
 * @author lgn-mop
 *
 */
public class HttpClientUtil {
	private static HttpClientUtil http = new HttpClientUtil();
	private HttpClient httpClient ;

	private HttpClientUtil(){
		HttpParams params = new BasicHttpParams();
		DefaultHttpClient.setDefaultHttpParams(params);
		HttpConnectionParams.setConnectionTimeout(params, 3000);
		HttpConnectionParams.setSoTimeout(params, 6000);
		HttpConnectionParams.setSocketBufferSize(params, 10240);
		HttpConnectionParams.setTcpNoDelay(params, true);
		HttpClientParams.setRedirecting(params, true);
		
//		String userAgent = "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2) Gecko/20100115 Firefox/3.6";
//        HttpProtocolParams.setUserAgent(params, userAgent);
        HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
        
        ThreadSafeClientConnManager tsccm = new ThreadSafeClientConnManager();
		tsccm.setMaxTotal(200);
		tsccm.setDefaultMaxPerRoute(40);
		
		SchemeRegistry registry = new SchemeRegistry();
//	    registry.register(new Scheme("https", 443, new SSLSocketFactory()));
	    registry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
		
		httpClient = new DefaultHttpClient(tsccm, params);
		
		
		//TODO
//		ModifiableSolrParams params = new ModifiableSolrParams();
//		params.set(org.apache.solr.client.solrj.impl.HttpClientUtil.PROP_MAX_CONNECTIONS, 196);
//		params.set(org.apache.solr.client.solrj.impl.HttpClientUtil.PROP_MAX_CONNECTIONS_PER_HOST, 64);
//		params.set(org.apache.solr.client.solrj.impl.HttpClientUtil.PROP_FOLLOW_REDIRECTS, false);
//		params.set(org.apache.solr.client.solrj.impl.HttpClientUtil.PROP_SO_TIMEOUT, 6000);
//		params.set(org.apache.solr.client.solrj.impl.HttpClientUtil.PROP_CONNECTION_TIMEOUT, 3000);
//		httpClient =  org.apache.solr.client.solrj.impl.HttpClientUtil.createClient(params);
	}
	
	public static HttpClientUtil getInstance(){
		return http;
	}
	
	/**
	 * fetch httpClient for your usage,
	 * you can also use {@link #doGet(String)} or {@link #doPost(String, String)} in common 
	 * @return
	 */
	public HttpClient getHttpClient(){
		return httpClient;
	}
	
	public String doGet(String url) throws ClientProtocolException, IOException{
		HttpGet get = new HttpGet(url);
		return httpClient.execute(get, new BasicResponseHandler());
	}
	
	/**
	 * POST UTF-8 string content
	 * @param url
	 * @param content
	 * @return
	 * @throws IOException 
	 */
	public String doPost(String url, String content) throws IOException{
		HttpPost post = new HttpPost(url);
		StringEntity entity = new StringEntity(content, "UTF-8");
	    post.setEntity(entity);
	    return httpClient.execute(post, new BasicResponseHandler());
	}

    public String doPost(String url) throws IOException{
        HttpPost post = new HttpPost(url);
        return httpClient.execute(post, new BasicResponseHandler());
    }
	
	/**
	 * for payment submit usage
	 * @param url
	 * @param param
	 * @return
	 */
    @SuppressWarnings("rawtypes")
	public static String getPostBody(String url, Map param){
		HttpPost post = new HttpPost(url);
		ArrayList<NameValuePair> nvps = new ArrayList <NameValuePair>();
        Iterator it = param.entrySet().iterator();
        String result = "";
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            if(value==null){
            	value="";
            }
            nvps.add(new BasicNameValuePair(key.toString(), value.toString()));
        }
        
        try{
        	post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        	result = HttpClientUtil.getInstance().getHttpClient().execute(post, new BasicResponseHandler());
        }catch(IOException e){
        }
        return result;
        
	}
}
