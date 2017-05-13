package com.xinrui.demo.util.code;

public class CodeConstants implements BaseCode {

	/**
	 * 参数检查异常
	 */
	public final static int PARAMETERS_CHECK_ERROR = SERVER_ERROR + WEB + 1;
	/**
	 * 保存文件错误
	 */
	public final static int SAVE_FILE_ERROR = SERVER_ERROR + DS + 1;
	/**
	 * 文件路径访问错误
	 */
	public final static int ACCESS_FILE_ERROR = SERVER_ERROR + DS + 2;
	/**
	 * 文件读写错误
	 */
	public final static int READ_FILE_ERROR = SERVER_ERROR + DS + 4;
	/**
	 * python执行类错误
	 */
	public final static int PYTHON_CLASS_ERROR = SERVER_ERROR + DS + 5;
	/**
	 * 模型文件错误
	 */
	public final static int MODEL_FILE_ERROR = SERVER_ERROR + DS + 6;
	/**
	 * 操作系统错误
	 */
	public final static int OPERATING_SYSTEM_ERROR = SERVER_ERROR + DS + 7;
	/**
	 * 类型已存在
	 */
	public final static int CLZSS_IS_EXIST = SERVER_ERROR + DS + 8;
	/**
	 * 推荐程序出错
	 */
	public final static int RECOMMENDER_CLASS_ERROR = SERVER_ERROR + DS + 9;
	/**
	 * SQL语法错误
	 */
	public final static int SQL_SYNTAX_ERROR = SERVER_ERROR + DB + 1;
	/**
	 * 未登录异常
	 */
	public final static int NOT_LOGIN_ERROR = SERVER_ERROR + DS + 10;
}
