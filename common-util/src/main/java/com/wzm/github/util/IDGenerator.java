package com.wzm.github.util;

/**
 * Created by yuxiong on 13-7-11.
 */
public class IDGenerator {

    /*
   定义默认统一长度为10位
    */
    private static final int DEFAULT_LENGTH = 10;

    private static final String ZERO1 = "0";
    private static final String ZERO2 = "00";
    private static final String ZERO3 = "000";

    /**
     * 默认十位长度的ID
     * @param id
     * @return
     */
    public static String getId(int id){
        return getId(id, DEFAULT_LENGTH);
    }

    /**
     * 指定长度的ID
     * @param id
     * @param maxLength
     * @return
     */
    public static String getId(long id, int maxLength){
        String strId = Long.toString(id);
        int num = maxLength - strId.length();
        if(num==3){
            return ZERO3+strId;
        } else if(num==2){
            return ZERO2+strId;
        } else if(num==1){
            return ZERO1+strId;
        }  else if(num>2){
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<num;i++){
                sb.append(ZERO1);
            }
            return sb.append(strId).toString();
        }
        return strId;
    }
}
