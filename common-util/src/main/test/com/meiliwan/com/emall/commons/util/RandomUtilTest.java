package com.meiliwan.com.emall.commons.util;

import org.testng.annotations.Test;

import com.wzm.github.util.RandomUtil;;

public class RandomUtilTest {

	@Test
	public void checkRandom(){
		int range = 4 ;
		System.out.println(RandomUtil.rand(range));
		
		int codeLength = 12 ;
		System.out.println(RandomUtil.randomNumCode(codeLength));
		
		int min = 4 ;
		int max = 8 ;
		System.out.println(RandomUtil.randomNumRange(min, max));
		
		int codeLength0 = 6 ;
		System.out.println(RandomUtil.randomStrCode(codeLength0));
		
	}
	
}
