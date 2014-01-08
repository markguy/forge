package com.meiliwan.com.emall.commons.util;

import org.testng.annotations.Test;

import com.wzm.github.util.ArrayUtils;


public class ArrayUtilTest {

	@Test
	public void testArray(){
		String[] str0 = {"1","2","3"} ;
		System.out.println(ArrayUtils.objs2StrLinkBy("或", str0));

		String[] s = {"1","2","3"} ;
		System.out.println(ArrayUtils.stringToIntegers(s));
		
		String[] s1 = {"1","2","3"} ;
		System.out.println(ArrayUtils.stringToInts(s1));
		
	}
	
}
