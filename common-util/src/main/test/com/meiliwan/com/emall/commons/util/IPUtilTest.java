package com.meiliwan.com.emall.commons.util;

import org.testng.annotations.Test;

import com.wzm.github.util.IPUtil;

public class IPUtilTest {

	@Test
	public void testIP(){
		System.out.println(IPUtil.getLocalIp());
	}
	
}
