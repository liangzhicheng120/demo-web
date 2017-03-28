package com.xinrui.demo.util;

public class CodeConstants implements BaseCode {

	// error code ʹ��300��Χ
	// Ĭ�Ϸ���
	public final static int DEFAULT_ERROR = SERVER_UNKNOW;

	// ����û�е�¼
	public final static int NOT_LOGIN_ERROR = SERVER_ERROR + SECURITY + 1;

	// ���ȵ�¼
	public final static int PLEASE_LOGIN_ERROR = SERVER_ERROR + SECURITY + 2;

	// �������ݳ���
	public final static int ENCRYPT_THE_DATA_ERROR = SERVER_ERROR + SECURITY + 3;

	// û�е�¼Ȩ��
	public final static int NOT_LOGIN_PERMISSIONS_ERROR = SERVER_ERROR + SECURITY + 4;

	// ��������쳣
	public final static int PARAMETERS_CHECK_ERROR = SERVER_ERROR + WEB + 1;

	// �ļ��ϴ�ʧ��
	public final static int FILE_UPLOAD_ERROR = SERVER_ERROR + WEB + 2;

	public final static int WEB_PARAMETERS_CHECK_ERROR = SERVER_ERROR + WEB + 3;
	// ʱ��ת������
	public final static int TIME_CONVERT_ERROR = SERVER_ERROR + WEB + 4;

	// �˼����·��������Ѿ�����
	public final static int CATEGORY_NAME_EXISTS = SERVER_ERROR + WEB + 5;

	// �˼���������Ѿ�����
	public final static int CATEGORY_ORDER_EXISTS = SERVER_ERROR + WEB + 6;

	// �ļ��ϴ���ͼƬ������ʧ��
	public final static int FILE_UPLOAD_TO_IMGSERVER_ERROR = SERVER_ERROR + WEB + 7;

	// û�����ú�̨ǰ�˾�̬�ļ�����ַ
	public final static int NO_BACKEND_PATH = SERVER_ERROR + WEB + 16;

	// �����̨ǰ�˾�̬������
	public final static int BACKEND_TRANSFER_ERROR = SERVER_ERROR + WEB + 17;

	// ʱ��γ�ͻ
	public final static int TIME_SECTION_CONFLICT = SERVER_ERROR + BIZ + 1;

	// �����ļ�����
	public final static int SAVE_FILE_ERROR = SERVER_ERROR + DS + 1;

	// �ӿڲ�������쳣
	public final static int ANDROID_PARAMETERS_CHECK_ERROR = ANDROID_ERROR + WEB + 1;

	// ���÷��񻯴���
	public final static int KIEV_API_PUSH_ERROR = SERVER_ERROR + THIRD + 1;

	// �������ݵ��ó���
	public final static int ZD_API_PUSH_ERROR = SERVER_ERROR + THIRD + 2;

	// http�����쳣%s
	public final static int HTTP_REQUEST_ERROR = SERVER_ERROR + THIRD + 3;

	// ����ת������
	public final static int DATE_CONVERTER_ERROR = SERVER_ERROR + THIRD + 4;

}
