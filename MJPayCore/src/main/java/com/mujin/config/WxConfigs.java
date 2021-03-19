package com.mujin.config;

import com.github.wxpay.sdk.WXPayConfig;
import com.mujin.annotation.PropertyKey;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * 微信支付的基本配置类
 *
 * @Description:
 * @author: 伍成林
 * @date: 2020年3月13日
 */
@Slf4j
@Getter
@ToString
public class WxConfigs implements WXPayConfig {

    /**
     * 开发者ID
     */
    private String appID;
    /**
     * 签名类型
     */

    private String signType;
    /**
     * 小程序的appid
     */

    private String mimiAppId;
    /**
     * 移动APP的APPID
     */

    private String mobileAppId;
    /**
     * 小程序的开发者秘钥
     */

    private String miniAppSecret;
    /**
     * 公众号的APPID
     */

    private String gzhAppId;
    /**
     * 公众号秘钥
     */

    private String gzhSecret;

    /**
     * 开发者密码
     */

    private String appSecret;
    /**
     * 商户号
     */

    private String mchID;

    /**
     * API密钥
     */

    private String key;
    /**
     * 对账单临时保存路径
     */
    private String billSavePath;

    /**
     * http连接超时时间
     */

    private int httpConnectTimeoutMs;
    /**
     * http读取超时时间
     */

    private int httpReadTimeoutMs;

    /**
     * 统一下单-通知链接 异步通知url可以自行配置
     */

    private String rechargeNotifyUrl;
    /**
     * 退款的时候需要证书的路径
     */

    private String wxCertPath;

    //支付map缓存处理
    private HashMap<String, String> payMap = new HashMap<String, String>();


    @Override
    public InputStream getCertStream() {
        // TODO Auto-generated method stub
        try {
            return new FileInputStream(new File(wxCertPath));
        } catch (FileNotFoundException e) {
            log.error("没有找到证书文件请检查路径是否正确，{}", wxCertPath);
        }
        return null;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        // TODO Auto-generated method stub
        return this.httpConnectTimeoutMs;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return this.httpReadTimeoutMs;
    }

    @Override
    public String getAppID() {
        // TODO Auto-generated method stub
        return this.appID;
    }

    @Override
    public String getMchID() {
        // TODO Auto-generated method stub
        return this.mchID;
    }

    @Override
    public String getKey() {
        // TODO Auto-generated method stub
        return this.key;
    }

    @PropertyKey("${wxpay.mch.appid")
    public void setAppID(String appID) {
        this.appID = appID;
    }

    @PropertyKey("${sign.type")
    public void setSignType(String signType) {
        this.signType = signType;
    }

    @PropertyKey("${wxpay.applet.appid")
    public void setMimiAppId(String mimiAppId) {
        this.mimiAppId = mimiAppId;
    }

    @PropertyKey("${wxpay.app.appid")
    public void setMobileAppId(String mobileAppId) {

        this.mobileAppId = mobileAppId;
    }

    @PropertyKey("${wxpay.applet.secret")
    public void setMiniAppSecret(String miniAppSecret) {
        this.miniAppSecret = miniAppSecret;
    }
    @PropertyKey("${wxpay.gzh.appid")
    public void setGzhAppId(String gzhAppId) {
        this.gzhAppId = gzhAppId;
    }

    @PropertyKey("${wxpay.gzh.secret")
    public void setGzhSecret(String gzhSecret) {
        this.gzhSecret = gzhSecret;
    }

    @PropertyKey("${wxpay.mch.app.secret")
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @PropertyKey("${wxpay.mch.mch.id")
    public void setMchID(String mchID) {
        this.mchID = mchID;
    }

    @PropertyKey("${wxpay.mch.key")
    public void setKey(String key) {
        this.key = key;
    }

    public void setBillSavePath(String billSavePath) {
        this.billSavePath = billSavePath;
    }
    @PropertyKey("${http.connect.timeout.ms")
    public void setHttpConnectTimeoutMs(int httpConnectTimeoutMs) {
        this.httpConnectTimeoutMs = httpConnectTimeoutMs;
    }

    @PropertyKey("${http.read.timeout.ms")
    public void setHttpReadTimeoutMs(int httpReadTimeoutMs) {
        this.httpReadTimeoutMs = httpReadTimeoutMs;
    }

    @PropertyKey("${wxpay.notify.url")
    public void setRechargeNotifyUrl(String rechargeNotifyUrl) {
        this.rechargeNotifyUrl = rechargeNotifyUrl;
    }

    @PropertyKey("${wxpay.certpath")
    public void setWxCertPath(String wxCertPath) {
        this.wxCertPath = wxCertPath;
    }


}

