package com.meiliwan.com.emall.commons.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.wzm.github.util.HttpClientUtil;

public class HttpClientUtilTest {
	
	@Test
	public void testDoGet() throws ClientProtocolException, IOException{
		String result = HttpClientUtil.getInstance().doGet("http://www.meiliwan.com");
		
		System.out.println(result);
	}

}
