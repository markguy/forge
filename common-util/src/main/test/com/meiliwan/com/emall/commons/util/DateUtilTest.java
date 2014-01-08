package com.meiliwan.com.emall.commons.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.wzm.github.util.DateUtil;

/**
 * 
 * @author lsf
 *
 */
public class DateUtilTest {

	@Test
	public void testTimeAdd(){
		Date date = new Date();
		
		String dateStr = DateUtil.getCurrentDateTimeStr();
		System.out.println(dateStr);
		
		dateStr = DateUtil.timeAddToStr(date, -1, TimeUnit.DAYS);
		System.out.println(dateStr);
		
		dateStr = DateUtil.getFirstDayOfMonth(date);
		System.out.println(dateStr);
		
		dateStr = DateUtil.getYestoday();
		System.out.println(dateStr);
	}
	
}
