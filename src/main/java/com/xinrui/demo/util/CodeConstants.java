package com.xinrui.demo.util;

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
	 * SQL语法错误
	 */
	public final static int SQL_SYNTAX_ERROR = SERVER_ERROR + DB + 1;

}
