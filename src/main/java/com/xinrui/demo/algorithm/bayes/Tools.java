package com.xinrui.demo.algorithm.bayes;

public class Tools {

    /**
     * �߳�����
     * 
     * @param millis
     *          ����ʱ��(����)
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * �ж�һ���ַ����Ƿ�Ϊ���ַ���
     * 
     * @param text
     *          ���жϵ��ַ���
     * @return
     *          �Ƿ�Ϊ���ַ���
     */
    public static boolean isEmptyString(String text) {
        if (text == null || text.length() == 0) {
            return true;
        }
        
        return false;
    }
}
