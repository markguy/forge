package com.meiliwan.com.emall.commons.util;

import org.testng.annotations.Test;

import com.wzm.github.util.BaseConfig;

public class BaseConfigUtilTest {
	
	@Test
	public void testBaseConfig(){
		
		System.out.println(BaseConfig.getValue("mlw-version"));
		
		System.out.println(BaseConfig.getValue("mlw-version", "默认值"));
	}
}
