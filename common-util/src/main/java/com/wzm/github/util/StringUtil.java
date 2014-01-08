package com.wzm.github.util;

import org.apache.commons.lang.StringUtils;

/**
 * OMS系统自用的String工具类 88209759
 */
public class StringUtil {

    /**
     * 用来对手机或者邮箱号码进行隐藏
     * @param str 手机号或邮箱号
     * @return 将手机号或邮箱号中间的部分字符替换为*号，用于在web端显示出来
     */
    public static String stringHide(String str) {
        if (RegexUtil.isEmail(str)) {
            int index = str.indexOf('@');
            String prex = str.substring(0, index);
            String sufx = str.substring(index);
            StringBuilder strBuilder = new StringBuilder();
            if (prex.length() < 3) {
                strBuilder.append("***").append(sufx);
            } else {
                strBuilder.append(prex.charAt(0));
                for (int i = 1; i < prex.length() - 1; i++) {
                    strBuilder.append("*");
                }
                strBuilder.append(prex.charAt(prex.length() - 1));
                strBuilder.append(sufx);
            }
            return strBuilder.toString();
        } else if (RegexUtil.isPhone(str)) {
            int begin = 3;
            int end = 3;
            StringBuilder strBuilder = new StringBuilder();
            if (str.length() > 5) {
                for (int i = 0; i < begin; i++) {
                    strBuilder.append(str.charAt(i));
                }
                for (int i = begin; i < str.length() - end; i++) {
                    strBuilder.append("*");
                }
                for (int i = str.length() - end; i < str.length(); i++) {
                    strBuilder.append(str.charAt(i));
                }
            } else {
                for (int i = 0; i < str.length(); i++) {
                    if (i == 0 || i == str.length() - 1) {
                        strBuilder.append(str.charAt(i));
                    } else {
                        strBuilder.append("*");
                    }
                }
            }
            return strBuilder.toString();
        } else {
            return str;
        }

    }

    /**
     * 如是为空返回空串，如果不为空则返回原值
     * @param str 需要被处理的字符串
     * @return 如果字符串为空或"null"，则返回空串"";否则返回str本身
     */
    public static String unNull(String str){
    	if(StringUtils.isBlank(str) || StringUtils.isEmpty(str) || "null".endsWith(str.trim())){
    		str = "" ;
    	}
    	return str ;
    }
    
}
