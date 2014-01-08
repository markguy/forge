package com.meiliwan.com.emall.commons.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wzm.github.util.NumberUtil;

public class NumberUtilTest {

	@Test
	public void testFormat(){
		String result = NumberUtil.format(12.010);
		System.out.println(result);
		Assert.assertEquals(result, "12.01");
		
		result = NumberUtil.format(10232980238l);
		System.out.println(result);
		Assert.assertEquals(result, "10232980238.00");
		
		result = NumberUtil.formatToPecent(0.8);
		System.out.println(result);
		Assert.assertEquals(result, "80.00%");
		
		double res = NumberUtil.add(0.012323, 2.34391);
		System.out.println(res);
		
		res = NumberUtil.add(0.012323, 2.34391,2);
		System.out.println(res);
		Assert.assertEquals(res, 2.36);
		
	}
	
}
