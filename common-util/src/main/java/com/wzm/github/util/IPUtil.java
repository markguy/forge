package com.wzm.github.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import com.wzm.github.log.MLWLogger;
import com.wzm.github.log.MLWLoggerFactory;

public class IPUtil {
	
	private static final MLWLogger LOG = MLWLoggerFactory.getLogger(IPUtil.class);

	/**
	 * @return 获取本地的内网IP
	 */
	public static String  getLocalIp() {  
		try {
            for (Enumeration<NetworkInterface> ni = NetworkInterface.getNetworkInterfaces(); ni
                .hasMoreElements();) {
                NetworkInterface eth = ni.nextElement();
                for (Enumeration<InetAddress> add = eth.getInetAddresses(); add.hasMoreElements();) {
                    InetAddress i = add.nextElement();
                    if (i instanceof Inet4Address) {
                        if (i.isSiteLocalAddress()) {
                            return i.getHostAddress();
                        }
                    }
                }
            }
        } catch (SocketException e) {
        	LOG.error(e, "get local ip failure", null);
        }
        return "";  
	}
	
	/**
	 * 
	 * @param iceConInfo ice的连接信息
	 * @return 返回 localIP:xx.xx.xx.xx,clientIP:xx.xx.xx.xx 形式的字符串
	 */
	public static String parseIceConIP(String iceConInfo){
		return iceConInfo.replaceAll(":", "_").replace("local address =", "localIP:").replace("remote address =", "clientIP:").replace("\n", ",");
	}
	
	/**
	 * 
	 * @param iceConInfo ice的连接信息
	 * @return 返回一个IP字符串数组，数组第一个元素为客户端IP；第二个元素为服务器本地IP
	 */
	public static String[] parseIceConfToIPArr(String iceConInfo){
		return iceConInfo.replaceAll(":", "_").replace("local address =", "").replace("remote address =", "").replace("\n", ",").split(",");
	}
	
}
