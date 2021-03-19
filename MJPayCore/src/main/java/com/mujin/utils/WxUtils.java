package com.mujin.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WxUtils {
	/**
	 * 默认字符编码
	 */
	private static final String DEFAULT_CHARSET = "UTF-8";
	/**
	 * 向微信返回正确的数据
	 */
	public static final String SUCCESS_REPONSE="<xml>" + 
			"<return_code><![CDATA[SUCCESS]]></return_code>" + 
			"<return_msg><![CDATA[OK]]></return_msg>" + 
			"</xml>";
    /**
     * 向微信返回失败的数据方便微信重新推送
     */
	public static final String FAUILT_REPONSE="<xml>" + 
			"<return_code><![CDATA[FAIL]]></return_code>" + 
			"<return_msg><![CDATA[签名失败]]></return_msg>" + 
			"</xml>";
	 /**
	    * 输入流转化为字符串
     *
     * @param inputStream 流
     * @return String 字符串
     * @throws Exception
     */
    public static String getStreamString(InputStream inputStream,String charSet) throws Exception {
        StringBuffer buffer = new StringBuffer();
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
        	if (charSet == null) {
        		inputStreamReader = new InputStreamReader(inputStream,DEFAULT_CHARSET);
        	}else {
        		inputStreamReader = new InputStreamReader(inputStream,charSet);
        	}
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            throw new Exception();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return buffer.toString();
    }
    

    /**
     * 主要用于将微信返回值的数据处理完毕后将逗号替换成""
     * @Title 
     * @Description
     * @param str
     * @return
     * @return String
     * @author 伍成林
     * @date: 2020年3月20日
     */
    private static  String replaceData(String str) {
    	return str.replaceAll(",", "").trim();
    }

}
