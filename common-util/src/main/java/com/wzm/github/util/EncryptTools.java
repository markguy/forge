package com.wzm.github.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;

public final class EncryptTools {

	/**
	 * 
	 * @param strSrc 需要被加密的字符串
	 * @param encName 加密方式，有 MD5、SHA-1和SHA-256 这三种加密方式
	 * @return 返回加密后的字符串
	 */
	private static String Encrypt(String strSrc, String encName) {
		// parameter strSrc is a string will be encrypted,
		// parameter encName is the algorithm name will be used.
		// encName dafault to "MD5"
		MessageDigest md = null;
		String strDes = null;

		byte[] bt = strSrc.getBytes();
		try {
			if (encName == null || encName.equals("")) {
				encName = "MD5";
			}
			md = MessageDigest.getInstance(encName);
			md.update(bt);
			strDes = bytes2Hex(md.digest()); // to HexString
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Invalid algorithm.");
			return null;
		}
		return strDes;
	}

	/**
	 * 
	 * @param str 需要被加密的字符串
	 * @return 对字符串str进行MD5加密后，将加密字符串返回
	 * 
	 */
	public static String EncryptByMD5(String str) {
		return Encrypt(str, "MD5");
	}

	/**
	 * 
	 * @param str 需要被加密的字符串
	 * @return 对字符串str进行SHA-1加密后，将加密字符串返回
	 * 
	 */
	public static String EncryptBySHA1(String str) {
		return Encrypt(str, "SHA-1");
	}

	/**
	 * 
	 * @param str 需要被加密的字符串
	 * @return 对字符串str进行SHA-256加密后，将加密字符串返回
	 * 
	 */
	public static String EncryptBySHA256(String str) {
		return Encrypt(str, "SHA-256");
	}

	/**
	 * 
	 * @param bts
	 * @return
	 */
	private static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}
	
	/**
	 * 
	 * @param str
	 * @param key
	 * @return
	 */
	public static String union(String str,String key) {
        int strLen = str.length();
        int keyLen = key.length();
        Character[] s = new Character[strLen+keyLen];

        boolean flag= true;
        int strIdx=0;
        int keyIdx=0;
        for(int i=0;i<s.length;i++){
            if(flag){
                if(strIdx<strLen){
                    s[i] = str.charAt(strIdx);
                    strIdx++;
                }
                if(keyIdx<keyLen){
                    flag=false;
                }

            }else{
                if(keyIdx<keyLen){
                    s[i]=key.charAt(keyIdx);
                    keyIdx++;
                }
                if(strIdx<strLen){
                    flag=true;
                }

            }
        }
        return StringUtils.join(s);
    }

//	public static void main(String[] args) {
//		String strSrc = "可以加密汉字.Oh,and english";
//		System.out.println("Source String:" + strSrc);
//		System.out.println("Encrypted String:");
//		System.out.println("Use Def:" + EncryptTools.Encrypt(strSrc, null));
//		System.out.println("Use MD5:" + EncryptTools.Encrypt(strSrc, "MD5"));
//		System.out.println("Use SHA:" + EncryptTools.Encrypt(strSrc, "SHA-1"));
//		System.out.println("Use SHA-256:" + EncryptTools.Encrypt(strSrc, "SHA-256"));
//	}
}
