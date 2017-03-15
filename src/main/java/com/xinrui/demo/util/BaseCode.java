
package com.xinrui.demo.util;

public interface BaseCode {

	// 项目或产品名称，该名用于异常处理时该log住 APP_NAME + ERROR_CODE + USER_ID/SN/CELLPHONE_NUMBER/COOIKE_ID(如果能获得)

	public final static String APP_NAME = "SYNC";

	/**
	 * 
	 * 正确，下面对正确状态码的定义，正确状态码数值<=1000
	 */

	// success code 使用200范围
	public final static int SUCCESS = 200;
	// 需要升级程序
	public final static int UPGRADE = 100;
	// 需更新配置或数据
	public final static int UPGRADE_DATA = 101;
	// 重定向
	public final static int REDIRECT = 300;
	// 服务不可用
	public final static int NO_SERVICE = 600;

	// 路由
	public final static int ROUTER = 700;

	//通知，客户端收到该code，直接将returnMessage展示给用户，用于特殊通告
	public final static int NOTICE = 800;

	/**
	 * 
	 * 出错，下面对错误状态码的定义，错误状态码数值>=100000
	 * 
	 * 
	 * 
	 * 每个error code由 6 位的整型数字，分 3 段有含义的数值表示；具体定义方式后面有举例
	 * 
	 * 第1段 由第1位数字表示，其代表error的出处 1:server，2:android，3:web page，4:pc client，9:other;
	 * 
	 * 如 1XXXXX，为每个类别定义起始位
	 * 
	 * 第2段 由第2～3位数字表示，其代表error的类别
	 * 
	 * 第3段 由第4～6位数字表示，自然增长，定义是＋
	 */

	// 第1段定义

	public final static int SERVER_ERROR = 100000;
	public final static int ANDROID_ERROR = 200000;
	public final static int WEB_PAGE_ERROR = 300000;
	public final static int PC_CLIENT_ERROR = 400000;
	public final static int OTHER_ERROR = 900000;

	// 第2段定义，此段数字单独没有意义，必需与第1段及具体错误码结合使用，

	// 未能在初次设计考滤到的类别可自定义

	// 前后端共用类别
	public final static int DB = 91000; // DB访问错误
	public final static int DS = 92000; // I/O文件类访问错误
	public final static int CACHE = 93000; // 缓存类访问错误
	public final static int THIRD = 94000; // 特定第三方Local api调用错误，如文件指文计算，文件压缩，IP转城市等
	public final static int BS = 95000; // 访问其它应用出错，如其它服务化接口
	public final static int SECURITY = 98000; // 安全类出错，试图操作未授权资源

	// 服务端

	public final static int WEB = 10000; // web代码层出错
	public final static int BIZ = 20000; // service代码层出错
	public final static int DAO = 30000; // dao代码层出错

	// 手机端或PC端

	public final static int UI = 50000; // 手机app层出错或PC app层出错
	public final static int HTTP = 60000; // 手机服务访问出错

	// Web页面

	public final static int JS = 80000; // web html／js前端页面处理出错

	// error code 使用>=100000 && <=999999范围，其中server error code 使用>=100000 && <=199999范围

	// server服务端错务码定义

	public final static int SERVER_UNKNOW = SERVER_ERROR + 0; // 100000 表示为服务端未知错误unknow，可视为无定义时的默认值undefine

	// 比如要定义两个 服务端 db类 的错如下：
	//
	// public final static int SERVER_DB_CONNECTION = SERVER_ERROR + DB + 1; //110001 获取DB连接失败
	//
	// public final static int SERVER_DB_ERROR_PARAM = SERVER_ERROR + DB + 2; //110002 错误的SQL参数
	//
	//
	// //如如说要定义一个 服务端 BIZ业务类 的错如下：
	//
	// public final static int SERVER_BIZ_UPLOAD_SRCFILE_MISSSIZE = SERVER_ERROR + BIZ + 1; //120001 文件上传出错，与上传端文件不一致

}
