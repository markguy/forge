package com.meiliwan.com.emall.commons.util;

import org.testng.annotations.Test;

import com.wzm.github.util.RegexUtil;

public class RegexUtilTest {

	@Test
	public void testCheck(){
		boolean result = RegexUtil.isChinese("时间浪费时间");
		System.out.println(result);
		
		result = RegexUtil.isFloat("0.123");
		System.out.println(result);
		
		result = RegexUtil.isInt("89");
		System.out.println(result);
		
		result = RegexUtil.isEmail("lsflsf520@126.com");
		System.out.println(result);
		
		result = RegexUtil.isDate("2013-04-05");
		System.out.println(result);
		
		result = RegexUtil.isDateTime("2013-04-05 12:12:12");
		System.out.println(result);
		
		String str = "asdfa12adfa11adf1afd3" ;
		System.out.println(RegexUtil.getNumbers(str));
		
	}
	
}
