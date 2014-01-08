package com.meiliwan.com.emall.commons.util;

import org.testng.annotations.Test;

import com.wzm.github.util.StringUtil;

public class StringUtilTest {

	@Test
	public void testString(){
		String mobile = "18642983809" ;
		System.out.println(StringUtil.stringHide(mobile));
		
		String str0 = "null" ;
		System.out.println(StringUtil.unNull(str0));
		
	}
	
}
