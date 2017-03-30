package com.xinrui.demo.ml.bayes;

public class Tools {

    /**
     * 线程休眠
     * 
     * @param millis
     *          休眠时间(毫秒)
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 判断一个字符串是否为空字符串
     * 
     * @param text
     *          待判断的字符串
     * @return
     *          是否为空字符串
     */
    public static boolean isEmptyString(String text) {
        if (text == null || text.length() == 0) {
            return true;
        }
        
        return false;
    }
}
