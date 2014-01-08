package com.wzm.github.util;

import java.util.Random;

public class RandomUtil {

	private final static Random random = new Random(System.currentTimeMillis());
	private static final String[] ints = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9" };

	private static final String[] strs = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
			"X", "Y", "Z" };

	/**
	 * 求指定范围的随机数
	 * 
	 * @param range 指定的int值，即随机的范围
	 * @return 返回一个0到int值（不包括int值）之间的随机整数
	 */
	public static int rand(int range) {
		return Math.abs(random.nextInt()) % range;
	}

	/**
	 * 生成指定长度的字符串
	 * 
	 * @param strarray
	 *            字符库数组
	 * @param codeLength
	 *            字符串长度
	 * @return 在strarray数组中随机抽取codeLength个元素，并按抽取的顺序连接成字符串返回
	 */
	private static String randomCode(String[] strarray, int codeLength) {
		StringBuilder sb = new StringBuilder();
		int len = strarray.length;
		Random random = new Random();
		for (int i = 0; i < codeLength; i++) {
			sb.append(strarray[random.nextInt(len)]);
		}
		return sb.toString();
	}

	/**
	 * 生成指定长度的随机字符串（数字+大写英文字母）
	 * 
	 * @param codeLength 字符串长度
	 * @return 在静态成员strs数组中随机抽取codeLength个元素，并按抽取的顺序连接成字符串返回
	 */
	public static String randomStrCode(int codeLength) {
		return randomCode(strs, codeLength);
	}

	/**
	 * 生成指定长度的随机字符串(数字)
	 * 
	 * @param codeLength 字符串长度
	 * @return 在静态成员ints数组中随机抽取codeLength个元素，并按抽取的顺序连接成字符串返回
	 */
	public static String randomNumCode(int codeLength) {
		return randomCode(ints, codeLength);
	}

	/**
	 * 
	 * @param min 生成随机数的最小值
	 * @param max 生成随机数的最大值
	 * @return 生成min(不包括min值)到max(不包括max值)之间的随机整数
	 */
	public static int randomNumRange(int min, int max) {
		Random random = new Random();
		return random.nextInt(max) % (max - min + 1) + min;
	}

}
