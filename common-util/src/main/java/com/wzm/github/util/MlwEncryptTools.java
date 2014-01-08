package com.wzm.github.util;


import org.apache.commons.lang.StringUtils;

import com.wzm.github.bean.GlobalNames;
import com.wzm.github.exception.BaseException;
import com.wzm.github.exception.BaseRuntimeException;
import com.wzm.github.log.MLWLogger;
import com.wzm.github.log.MLWLoggerFactory;

/**
 * Created by wenlepeng on 13-10-21.
 */
public class MlwEncryptTools {

    private static final MLWLogger LOGGER = MLWLoggerFactory.getLogger(MlwEncryptTools.class);


    private final static String PROPERTIES_ZK = "commons/keys.properties";

    private MlwEncryptTools(){

    }


    public static  String encrypt(String oriStr,String keyPrefix){


        if(StringUtils.isBlank(oriStr)){
            return oriStr;
        }

        if( StringUtils.isBlank(keyPrefix)){
            LOGGER.error(null, "加密key不允许空", null);
            throw new BaseRuntimeException(GlobalNames.DEFAULT_SYS_ERROR_MSG);
        }

        String md5key = null;
        String sha1Key = null;

        try {
            md5key = ConfigOnZk.getInstance().getValue(PROPERTIES_ZK, keyPrefix+".MD5");
            sha1Key =  ConfigOnZk.getInstance().getValue(PROPERTIES_ZK, keyPrefix+".SHA1");
        } catch (BaseException e) {
            LOGGER.error(e, "尝试从Zookepper获取key值发生异常.", null);
        }

       return encrypt(oriStr,md5key,sha1Key);

    }


    public static String encrypt(String oriStr,String md5KeyStr,String shaKeyStr){
        String lst = "";

        if(StringUtils.isBlank(md5KeyStr) || StringUtils.isBlank(md5KeyStr)){
            LOGGER.error(null, "MD5和SHA1加密key不允许空", null);
            throw new BaseRuntimeException(GlobalNames.DEFAULT_SYS_ERROR_MSG);
        }

        lst = EncryptTools.union(oriStr,md5KeyStr);

        lst = EncryptTools.EncryptByMD5(lst);

        lst = EncryptTools.union(lst, org.apache.commons.lang.StringUtils.reverse(shaKeyStr));

        lst = EncryptTools.EncryptBySHA1(lst);

        return lst;
    }

    /**
     * 加密登录密码
     * @param oriStr
     * @return
     */
    public static String encryptLoginPwd(String oriStr){
        return  encrypt(oriStr,"passportKey");
    }

    /**
     * 加密钱包支付密码
     * @param oriStr
     * @return
     */
    public static String encryptAccountPwd(String oriStr){
        return  encrypt(oriStr,"accountKey");
    }






}
