package com.wzm.github.bean;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by yuxiong on 13-7-5.
 */
public enum PayCode {
    //支持银行（及排序顺序）
    ALIPAY("ALIPAY", "alipay", "支付宝", "/images/pay/logo-alipay.jpg", "网上支付"),
    CHINA_PAY("CHINA_PAY", "chinapay", "银联支付", "/images/pay/chinapay.jpg", "网上支付"),
    CMB_YWT("CMB_YWT", "cmbpay", "一网通支付", "/images/pay/bank_allInOne.jpg", "网上支付"),
    CMB_ICBCB2C("0102", "cmbpay", "招行支付-中国工商银行", "/images/pay/bank_icbc.jpg", "网上支付"),
    CMB_BOCB2C("0104", "cmbpay", "招行支付-中国银行", "/images/pay/bank_bocb.jpg", "网上支付"),
    CMB_CCB("0105", "cmbpay", "招行支付-中国建设银行", "/images/pay/bank_ccb.jpg", "网上支付"),
    CMB_PSBC("0100", "cmbpay", "招行支付-中国邮政储蓄银行", "/images/pay/bank_16.jpg", "网上支付"),
    CMB_ABC("0103", "cmbpay", "招行支付-中国农业银行", "/images/pay/bank_nh.gif", "网上支付"),
    CMB_PAY("CMB_PAY", "cmbpay", "招商银行", "/images/pay/bank_cmb.jpg", "网上支付"),

//	CHINA_ICBCB2C("0102", "chinapay", "银联支付-中国工商银行", "/images/pay/bank_icbc.jpg","网上支付"),
//	CHINA_BOCB2C("0104", "chinapay", "银联支付-中国银行", "/images/pay/bank_bocb.jpg","网上支付"),
//	CHINA_CCB("0105", "chinapay", "银联支付-中国建设银行", "/images/pay/bank_ccb.jpg","网上支付"),
//	CHINA_PSBC("0100", "chinapay", "银联支付-中国邮政储蓄银行", "/images/pay/bank_16.jpg","网上支付"),
//	CHINA_ABC("0103", "chinapay", "银联支付-中国农业银行", "/images/pay/bank_nh.gif","网上支付"),
//	CHINA_CMB("6007", "chinapay", "银联支付-招商银行", "/images/pay/bank_cmb.jpg","网上支付"),

    ALI_CIB("ALI_CIB", "alipay", "支付宝-兴业银行", "/images/pay/bank_cib.jpg", "网上支付"),
    CMB_JTB("0301", "cmbpay", "招行支付-交通银行", "/images/pay/bank_bankcomm.gif", "网上支付"),
    CMB_CEBB("0303", "cmbpay", "招行支付-中国光大银行", "/images/pay/cebbank_btc.gif", "网上支付"),
    CHINA_SPDB("1022", "chinapay", "银联支付-浦发银行", "/images/pay/bank_spdb.jpg", "网上支付"),
    CMB_CMBC("0305", "cmbpay", "招行支付-中国民生银行", "/images/pay/bank_cmbc.jpg", "网上支付"),
    CMB_ECITIC("0302", "cmbpay", "招行支付-中信银行", "/images/pay/bank_citic.jpg", "网上支付"),
    CMB_HXB("0304", "cmbpay", "招行支付-华夏银行", "/images/pay/bank_huaxia.jpg", "网上支付"),
    CMB_CGBC("0306", "cmbpay", "招行支付-广发银行", "/images/pay/bank_gdb.jpg", "网上支付"),
//    CMB_SDB("0307", "cmbpay", "招行支付-深圳发展银行", "/images/pay/bank_43.jpg", "网上支付"),
    CMB_PAB("0410", "cmbpay", "招行支付-平安银行", "/images/pay/spabank_btc.gif", "网上支付"),
    CHINA_BBW("3224", "chinapay", "银联支付-北部湾银行", "/images/pay/bank_gx.jpg","网上支付"),

//	CHINA_JTB("0301", "chinapay", "银联支付-交通银行", "/images/pay/bank_bankcomm.gif","网上支付"),
//	CHINA_CEBB("0303", "chinapay", "银联支付-中国光大银行", "/images/pay/cebbank_btc.gif","网上支付"),
//	CHINA_SPDB("1022", "chinapay", "银联支付-浦发银行", "/images/pay/bank_spdb.jpg","网上支付"),
//	CHINA_CMBC("0305", "chinapay", "银联支付-中国民生银行", "/images/pay/bank_cmbc.jpg","网上支付"),
//	CHINA_ECITIC("0302", "chinapay", "银联支付-中信银行", "/images/pay/bank_citic.jpg","网上支付"),
//	CHINA_HXB("0304", "chinapay", "银联支付-华夏银行", "/images/pay/bank_huaxia.jpg","网上支付"),
//	CHINA_CGBC("0306", "chinapay", "银联支付-广发银行", "/images/pay/bank_gdb.jpg","网上支付"),
//	CHINA_SDB("0307", "chinapay", "银联支付-深圳发展银行", "/images/pay/bank_43.jpg","网上支付"),
//	CHINA_PAB("0410", "chinapay", "银联支付-平安银行", "/images/pay/spabank_btc.gif","网上支付"),

//    CHINA_HZB("0032", "chinapay", "银联支付-杭州银行", "/images/pay/bank_hzb.jpg", "网上支付"),
//    CHINA_CBHB("0624", "chinapay", "银联支付-渤海银行", "/images/pay/bank_cbhb.jpg", "网上支付"),
//    CHINA_CDRCB("3724", "chinapay", "银联支付-成都农村商业银行", "/images/pay/bank_cdrcb.jpg", "网上支付"),
//    CHINA_DLB("4024", "chinapay", "银联支付-大连银行", "/images/pay/bank_dlb.jpg", "网上支付"),
//    CHINA_DZCB("1724", "chinapay", "银联支付-德州市商业银行", "/images/pay/bank_dzcb.jpg", "网上支付"),
//    CHINA_DGB("3524", "chinapay", "银联支付-东莞银行", "/images/pay/bank_dgb.jpg", "网上支付"),
//    CHINA_DYCCB("5124", "chinapay", "银联支付-东营市商业银行", "/images/pay/bank_dyccb.jpg", "网上支付"),
//    CHINA_FDB("2524", "chinapay", "银联支付-富滇银行", "/images/pay/bank_fdb.jpg", "网上支付"),
//    CHINA_GZCB("4124", "chinapay", "银联支付-广州银行", "/images/pay/bank_gzcb.jpg", "网上支付"),
//    CHINA_HBB("3424", "chinapay", "银联支付-河北银行", "/images/pay/bank_hbb.jpg", "网上支付"),
//    CHINA_HNNXS("2924", "chinapay", "银联支付-湖南省农村信用社联合社", "/images/pay/bank_hnnxs.jpg", "网上支付"),
//    CHINA_JSBC("4924", "chinapay", "银联支付-江苏银行", "/images/pay/bank_jsbc.jpg", "网上支付"),
//    CHINA_JJCCB("6424", "chinapay", "银联支付-九江银行", "/images/pay/bank_jjccb.jpg", "网上支付"),
//    CHINA_NBCB("2324", "chinapay", "银联支付-宁波银行", "/images/pay/bank_nbcb.jpg", "网上支付"),
//    CHINA_ZCCB("6124", "chinapay", "银联支付-齐商银行", "/images/pay/bank_zccb.jpg", "网上支付"),
//    CHINA_RZB("3624", "chinapay", "银联支付-日照银行", "/images/pay/bank_rzb.jpg", "网上支付"),
//    CHINA_SRB("4624", "chinapay", "银联支付-上饶银行", "/images/pay/bank_srb.jpg", "网上支付"),
//    CHINA_SJB("5624", "chinapay", "银联支付-盛京银行", "/images/pay/bank_sjb.jpg", "网上支付"),
//    CHINA_SZB("6624", "chinapay", "银联支付-苏州银行", "/images/pay/bank_szb.jpg", "网上支付"),
//    CHINA_TACCB("4324", "chinapay", "银联支付-泰安市商业银行", "/images/pay/bank_taccb.jpg", "网上支付"),
//    CHINA_WHCCB("3924", "chinapay", "银联支付-威海市商业银行", "/images/pay/bank_wccb.jpg", "网上支付"),
//    CHINA_UCCB("4224", "chinapay", "银联支付-乌鲁木齐市商业银行", "/images/pay/bank_uccb.jpg", "网上支付"),
//    CHINA_YCCB("5824", "chinapay", "银联支付-宜昌市商业银行", "/images/pay/bank_yccb.jpg", "网上支付"),
//    CHINA_ZRCB("6724", "chinapay", "银联支付-张家港农商银行", "/images/pay/bank_zrcb.jpg", "网上支付"),
//    CHINA_ZDCB("6024", "chinapay", "银联支付-渣打银行", "/images/pay/bank_zdcb.jpg", "网上支付"),

    RET_ALI_FUND("RET_ALI_FUND", "ret_third_fund", "支付宝第三方退款", "", "支付宝"),
    RET_BANK_FUND("RET_BANK_FUND", "ret_third_fund", "银行第三方退款", "", "银行"),

    //招行、银联接口暂不支持的银行
    //银联：北京银行、山西省临汾市尧都区信用合作联社、温州银行、浙江省农村信用社（合作银行）
    //招行：广西北部湾银行、广西农村信用社、桂林银行、柳州银行、深圳农村商业银行、星辰银行
//    ALIPAY("ALIPAY", "alipay", "支付宝", "../images/pay/logo-alipay.jpg","网上支付"),
//    ALI_CCB("ALI_CCB", "alipay", "中国建设银行", "../images/pay/bank_ccb.jpg","网上支付"),
//    ALI_CMB("ALI_CMB", "alipay", "招商银行", "../images/pay/bank_cmb.jpg","网上支付"),
//    ALI_ICBCB2C("ALI_ICBCB2C", "alipay", "中国工商银行", "../images/pay/bank_icbc.jpg","网上支付"),
//    ALI_BOCB2C("ALI_BOCB2C", "alipay", "中国银行", "../images/pay/bank_bocb.jpg","网上支付"),
//    ALI_ABC("ALI_ABC", "alipay", "中国农业银行", "../images/pay/bank_abc.jpg","网上支付"),
//    ALI_COMM("ALI_COMM", "alipay", "交通银行", "../images/pay/bank_comm.jpg","网上支付"),
//    ALI_CMBC("ALI_CMBC","alipay", "民生银行", "../images/pay/bank_cmbc.jpg","网上支付"),
//    ALI_CEBBANK("ALI_CEBBANK", "alipay", "中国光大银行", "../images/pay/bank_cebbank.jpg","网上支付"),
//    ALI_SPDB("ALI_SPDB", "alipay", "浦发银行", "../images/pay/bank_spdb.jpg","网上支付"),
//    ALI_CITIC("ALI_CITIC", "alipay", "中信银行", "../images/pay/bank_citic.jpg","网上支付"),
//    ALI_GDB("ALI_GDB", "alipay","广发银行", "../images/pay/bank_gdb.jpg","网上支付"),
//    ALI_BJBANK("ALI_BJBANK","alipay", "北京银行", "../images/pay/bank_bjbank.jpg","网上支付"),
//    ALI_CITIC("ALI_CITIC", "中信银行", "../images/pay/bank_ecitic.gif"),
//    ALI_GDB("ALI_GDB", "广发银行", "../images/pay/img190x36.jpg"),
//    ALI_BJBANK("ALI_BJBANK", "北京银行", "../images/pay/bjbank_btc.gif"),
//    CHINA_PAY("CHINA_PAY", "chinapay", "银联支付", "../images/pay/chinapay.jpg","网上支付"),
//    CHINA_CMB("6007", "chinapay", "银联支付-招商银行", "../images/pay/bank_cmb.jpg","网上支付"),

    //线下支付：货到付款
    OFF_COD("OFF_COD", "cod", "货到付款", "/images/img158x48.jpg", "货到付款"),

    //线下支付：移动POS机支付
    OFF_POS("OFF_POS", "pos", "移动POS机支付", "/images/img_post.jpg", "货到付款"),

    //美丽湾账户: 钱包-----------------------------------------------------------请不要改为赠送
    MLW_W("MLW_W", "wallet", "美丽湾钱包", "/images/pay/img_wallet.jpg", "网上支付"),
    //美丽湾卡: 礼品卡
    MLW_C("MLW_C", "gift", "美丽湾礼品卡", "/images/pay/img_gif.jpg", "网上支付");

    /**
     * 是否在线支付 非美丽湾钱包 切 非礼品卡支付
     *
     * @return
     */
    public static boolean isOnlinePay(String payCode) {
        if ("MLW_W".equals(payCode) || "MLW_C".equals(payCode)) {
            return false;
        }
        return true;
    }

    /**
     * 是否货到付款
     *
     * @return
     */
    public static boolean isCOD(String payCode) {
        if ("OFF_COD".equals(payCode) || "OFF_POS".equals(payCode)) {
            return true;
        }
        return false;
    }


    private String code;
    private String payHandler;
    private String desc;
    private String img;
    //前台显示
    private String show;

    PayCode(String code, String payHandler, String desc, String img, String show) {
        this.code = code;
        this.payHandler = payHandler;
        this.desc = desc;
        this.img = img;
        this.show = show;
    }

    PayCode(String code) {
        this.code = code;
    }

    public String getShow() {
        return show;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getImg() {
        return img;
    }

    public String getPayHandler() {
        return payHandler;
    }


    /**
     * 校验是不是一个有效的payCode
     *
     * @param code
     * @return
     */
    public static boolean isValidCode(String code) {
        PayCode[] payCodes = PayCode.values();
        Set<String> codeSet = new HashSet<String>(payCodes.length);
        for (PayCode payCode : payCodes) {
            codeSet.add(payCode.getCode());
        }
        return codeSet.contains(code);
    }

    /**
     * 依据code返回payCode对象
     *
     * @param code
     * @return
     */
    public static PayCode getPayCodeByCode(String code) {
        PayCode[] payCodes = PayCode.values();
        for (PayCode payCode : payCodes) {
            if (payCode.code.equals(code)) {
                return payCode;
            }
        }
        return null;
    }

    /**
     * @return 返回所有第三方支持的所有银行列表
     */
    public static Set<PayCode> getBankPayCodes() {
        PayCode[] payCodes = PayCode.values();
        Set<PayCode> codeSet = new TreeSet<PayCode>();
        for (PayCode payCode : payCodes) {
            if (payCode.equals(PayCode.OFF_COD) || payCode.equals(PayCode.OFF_POS) || payCode.equals(PayCode.MLW_W) || payCode.equals(PayCode.MLW_C)
                    || payCode.equals(PayCode.ALIPAY) || payCode.equals(PayCode.CHINA_PAY)
                    || payCode.equals(PayCode.CMB_YWT)
                    || PayCode.RET_ALI_FUND.equals(payCode) || PayCode.RET_BANK_FUND.equals(payCode)) {
                continue;
            }

            codeSet.add(payCode);
        }
        return codeSet;
    }

    /**
     * 获取退款方式
     *
     * @return
     */
    public static Set<PayCode> getRetFundPayCodes() {
        Set<PayCode> codeSet = new TreeSet<PayCode>();
        codeSet.add(PayCode.MLW_W);
        codeSet.add(PayCode.RET_ALI_FUND);
        codeSet.add(PayCode.RET_BANK_FUND);
        return codeSet;
    }

    /**
     * @return 获取支付宝、银联、一网通三个大支付平台
     */
    public static Set<PayCode> getThirdPayCodes() {
        Set<PayCode> codeSet = new TreeSet<PayCode>();
        codeSet.add(PayCode.ALIPAY);
        codeSet.add(PayCode.CHINA_PAY);
        codeSet.add(PayCode.CMB_YWT);

        return codeSet;
    }
    
    /**
     * 判断是否为第三方支付
     * 注意：如果有新增的不是第三方支付的paycode请务必更新这里
     * @param payCodeCheck
     * @return
     */
    public static boolean isThirdPay(String payCodeCheck){
    	boolean isPK = false ;
    	PayCode[] payCodes = PayCode.values();
    	for (PayCode payCode : payCodes) {
    		if(payCodeCheck.equals(payCode.name())){
    			if (!payCodeCheck.equals(PayCode.OFF_COD.name()) 
    					&& !payCodeCheck.equals(PayCode.OFF_POS.name()) 
    					&& !payCodeCheck.equals(PayCode.MLW_W.name()) 
    					&& !payCodeCheck.equals(PayCode.MLW_C.name())
    					&& !payCodeCheck.equals(PayCode.RET_ALI_FUND.name())
    					&& !payCodeCheck.equals(PayCode.RET_BANK_FUND.name())) {
    				isPK = true ;
                    break;
                }
    		}
        }
    	return isPK ;
    }

}

