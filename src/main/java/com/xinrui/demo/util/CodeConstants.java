package com.xinrui.demo.util;

public class CodeConstants implements BaseCode {

	// error code 使用300范围
	// 默认服务
	public final static int DEFAULT_ERROR = SERVER_UNKNOW;

	// 您还没有登录
	public final static int NOT_LOGIN_ERROR = SERVER_ERROR + SECURITY + 1;

	// 请先登录
	public final static int PLEASE_LOGIN_ERROR = SERVER_ERROR + SECURITY + 2;

	// 加密数据出错
	public final static int ENCRYPT_THE_DATA_ERROR = SERVER_ERROR + SECURITY + 3;

	// 没有登录权限
	public final static int NOT_LOGIN_PERMISSIONS_ERROR = SERVER_ERROR + SECURITY + 4;

	// 参数检查异常
	public final static int PARAMETERS_CHECK_ERROR = SERVER_ERROR + WEB + 1;

	// 文件上传失败
	public final static int FILE_UPLOAD_ERROR = SERVER_ERROR + WEB + 2;

	public final static int WEB_PARAMETERS_CHECK_ERROR = SERVER_ERROR + WEB + 3;
	// 时间转换错误
	public final static int TIME_CONVERT_ERROR = SERVER_ERROR + WEB + 4;

	// 此级别下分类名称已经存在
	public final static int CATEGORY_NAME_EXISTS = SERVER_ERROR + WEB + 5;

	// 此级别下序号已经存在
	public final static int CATEGORY_ORDER_EXISTS = SERVER_ERROR + WEB + 6;

	// 文件上传到图片服务器失败
	public final static int FILE_UPLOAD_TO_IMGSERVER_ERROR = SERVER_ERROR + WEB + 7;

	// 没有配置后台前端静态文件包地址
	public final static int NO_BACKEND_PATH = SERVER_ERROR + WEB + 16;

	// 部署后台前端静态包出错
	public final static int BACKEND_TRANSFER_ERROR = SERVER_ERROR + WEB + 17;

	// 时间段冲突
	public final static int TIME_SECTION_CONFLICT = SERVER_ERROR + BIZ + 1;

	// 保存文件错误
	public final static int SAVE_FILE_ERROR = SERVER_ERROR + DS + 1;
	
	// 文件路径访问错误
	public final static int FILE_PATH_ERROR = SERVER_ERROR + DS + 2;

	// 接口参数检测异常
	public final static int ANDROID_PARAMETERS_CHECK_ERROR = ANDROID_ERROR + WEB + 1;

	// 调用服务化错误
	public final static int KIEV_API_PUSH_ERROR = SERVER_ERROR + THIRD + 1;

	// 正点数据调用出错
	public final static int ZD_API_PUSH_ERROR = SERVER_ERROR + THIRD + 2;

	// http请求异常%s
	public final static int HTTP_REQUEST_ERROR = SERVER_ERROR + THIRD + 3;

	// 日期转换错误
	public final static int DATE_CONVERTER_ERROR = SERVER_ERROR + THIRD + 4;
	
	// sql语法错误
	public final static int SQL_SYNTAX_ERROR = SERVER_ERROR + DB + 1;

}
