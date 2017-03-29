package com.xinrui.demo.algorithm.bayes;

public class Tools {

    /**
     * Ïß³ÌÐÝÃß
     * 
     * @param millis
     *          ÐÝÃßÊ±¼ä(ºÁÃë)
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * ÅÐ¶ÏÒ»¸ö×Ö·û´®ÊÇ·ñÎª¿Õ×Ö·û´®
     * 
     * @param text
     *          ´ýÅÐ¶ÏµÄ×Ö·û´®
     * @return
     *          ÊÇ·ñÎª¿Õ×Ö·û´®
     */
    public static boolean isEmptyString(String text) {
        if (text == null || text.length() == 0) {
            return true;
        }
        
        return false;
    }
}
