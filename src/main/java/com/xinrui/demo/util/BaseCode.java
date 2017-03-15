
package com.xinrui.demo.util;

public interface BaseCode {

	// ��Ŀ���Ʒ���ƣ����������쳣����ʱ��logס APP_NAME + ERROR_CODE + USER_ID/SN/CELLPHONE_NUMBER/COOIKE_ID(����ܻ��)

	public final static String APP_NAME = "SYNC";

	/**
	 * 
	 * ��ȷ���������ȷ״̬��Ķ��壬��ȷ״̬����ֵ<=1000
	 */

	// success code ʹ��200��Χ
	public final static int SUCCESS = 200;
	// ��Ҫ��������
	public final static int UPGRADE = 100;
	// ��������û�����
	public final static int UPGRADE_DATA = 101;
	// �ض���
	public final static int REDIRECT = 300;
	// ���񲻿���
	public final static int NO_SERVICE = 600;

	// ·��
	public final static int ROUTER = 700;

	//֪ͨ���ͻ����յ���code��ֱ�ӽ�returnMessageչʾ���û�����������ͨ��
	public final static int NOTICE = 800;

	/**
	 * 
	 * ��������Դ���״̬��Ķ��壬����״̬����ֵ>=100000
	 * 
	 * 
	 * 
	 * ÿ��error code�� 6 λ���������֣��� 3 ���к������ֵ��ʾ�����嶨�巽ʽ�����о���
	 * 
	 * ��1�� �ɵ�1λ���ֱ�ʾ�������error�ĳ��� 1:server��2:android��3:web page��4:pc client��9:other;
	 * 
	 * �� 1XXXXX��Ϊÿ���������ʼλ
	 * 
	 * ��2�� �ɵ�2��3λ���ֱ�ʾ�������error�����
	 * 
	 * ��3�� �ɵ�4��6λ���ֱ�ʾ����Ȼ�����������ǣ�
	 */

	// ��1�ζ���

	public final static int SERVER_ERROR = 100000;
	public final static int ANDROID_ERROR = 200000;
	public final static int WEB_PAGE_ERROR = 300000;
	public final static int PC_CLIENT_ERROR = 400000;
	public final static int OTHER_ERROR = 900000;

	// ��2�ζ��壬�˶����ֵ���û�����壬�������1�μ������������ʹ�ã�

	// δ���ڳ�����ƿ��˵��������Զ���

	// ǰ��˹������
	public final static int DB = 91000; // DB���ʴ���
	public final static int DS = 92000; // I/O�ļ�����ʴ���
	public final static int CACHE = 93000; // ��������ʴ���
	public final static int THIRD = 94000; // �ض�������Local api���ô������ļ�ָ�ļ��㣬�ļ�ѹ����IPת���е�
	public final static int BS = 95000; // ��������Ӧ�ó������������񻯽ӿ�
	public final static int SECURITY = 98000; // ��ȫ�������ͼ����δ��Ȩ��Դ

	// �����

	public final static int WEB = 10000; // web��������
	public final static int BIZ = 20000; // service��������
	public final static int DAO = 30000; // dao��������

	// �ֻ��˻�PC��

	public final static int UI = 50000; // �ֻ�app������PC app�����
	public final static int HTTP = 60000; // �ֻ�������ʳ���

	// Webҳ��

	public final static int JS = 80000; // web html��jsǰ��ҳ�洦�����

	// error code ʹ��>=100000 && <=999999��Χ������server error code ʹ��>=100000 && <=199999��Χ

	// server����˴����붨��

	public final static int SERVER_UNKNOW = SERVER_ERROR + 0; // 100000 ��ʾΪ�����δ֪����unknow������Ϊ�޶���ʱ��Ĭ��ֵundefine

	// ����Ҫ�������� ����� db�� �Ĵ����£�
	//
	// public final static int SERVER_DB_CONNECTION = SERVER_ERROR + DB + 1; //110001 ��ȡDB����ʧ��
	//
	// public final static int SERVER_DB_ERROR_PARAM = SERVER_ERROR + DB + 2; //110002 �����SQL����
	//
	//
	// //����˵Ҫ����һ�� ����� BIZҵ���� �Ĵ����£�
	//
	// public final static int SERVER_BIZ_UPLOAD_SRCFILE_MISSSIZE = SERVER_ERROR + BIZ + 1; //120001 �ļ��ϴ��������ϴ����ļ���һ��

}
