package com.wzm.github.util;

/**
 * Created by Sean on 13-6-12.
 */
public class ArrayUtils {

	/**
	 * 
	 * @param s 数字字符串数组
	 * @return 将String数组转换成int数组，并返回
	 */
    public static int[] stringToInts(String[] s) {
        int[] n = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            n[i] = Integer.parseInt(s[i]);
        }
        return n;
    }

    /**
     * 
     * @param s
     * @return 将String数组转换成Integer数组，并返回
     */
    public static Integer[] stringToIntegers(String[] s) {
        Integer[] n = new Integer[s.length];
        for (int i = 0; i < s.length; i++) {
            n[i] = Integer.parseInt(s[i]);
        }
        return n;
    }

    /**
     * 
     * @param separator 连接符
     * @param objects 数组
     * @return 把数组通过连接符拼接成字符串
     */
    public static String objs2StrLinkBy(String separator, Object... objects) {
        if (objects == null || objects.length == 0) return "";
        StringBuffer result = new StringBuffer();
        for (Object temp : objects) {
           if(temp != null)result.append(temp.toString()).append(separator);
        }
        if (result.toString().length() > 0) {
            return result.toString().substring(0, result.toString().lastIndexOf(separator));
        }
        return "";
    }
}
