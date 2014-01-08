package com.wzm.github.bean;


/**
 * 全局常量定义类
 * 
 * @author yuxiong
 * 
 */
public final class GlobalNames {

	// 全局常量定义，状态值：有效=0
	public final static short STATE_VALID = 0;

	// 全局常量定义，状态值：无效=-1
	public final static short STATE_INVALID = -1;
	
	//全局常量定义，状态值：审核通过2
    public final static short STATE_CHECK_PASS = 2;
	
	//全局常量定义，状态值：审核不通过-2
    public final static short STATE_CHECK_NOPASS = -2;

	public final static int ADMIN_ID = 888;
	public final static String ADMIN_NAME = "美丽湾客服";
	
	public static final String MSG_WHITELIST = "commons/msgWhiteList.properties";// 短信白名单

	// 默认为系统身份的管理员ID
	public final static int ADMINID_SYS_DEFAULT = 999;

	// 系统管理员id session 属性key
	public final static String SESSIONKEY_ADMIN_ID = "admin_id";

	// 系统管理员name session 属性key
	public final static String SESSIONKEY_ADMIN_NAME = "系统";

	public final static String REAL_INDEX = "indexName";

	/** 标示评论为虚假评论 */
	public final static String COMMENT_ORDERID = "0000000000";

	/** 用户类型 */
	public final static String USER_ADMIN = "admin";
	public final static String USER_FRONT = "user";
	
	public static final String DEFAULT_SYS_ERROR_MSG = "系统处理异常";
	
	/**类目积分状态 停用 */
    public final static int CATEGORY_INTEGRAL_RULE_STATE_STOP = 0;
    /**类目积分状态 启用 */
    public final static int CATEGORY_INTEGRAL_RULE_STATE_STRAT = 1;

}
