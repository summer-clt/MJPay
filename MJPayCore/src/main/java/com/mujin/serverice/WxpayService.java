package com.mujin.serverice;

import com.mujin.config.OrderCreate;
import com.mujin.dto.PaymentWx;
import com.mujin.utils.PayUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @Author: 伍成林
 * @Date： 2021年 03月15日
 */
@Slf4j
@Service
public class WxpayService {
    @Autowired
    private OrderCreate orderCreate;
//    @Autowired
//    private WXPay wxPay;
//    @Autowired
//    private WxConfigs wxConfigs;



    /**
     * 生成微信支付二维码供给用户扫码
     *
     * @Title createQrCode
     * @Description
     * @param paymentWx 微信支付的原始参数的接受
     * @throws Exception
     * @return ResponseResult
     * @author 伍成林
     * @date: 2020年3月13日
     */
//    public ResponseResult<String> createQrCode(PaymentWx paymentWx) throws Exception {
//
//        Map<String, String> resultMap = getUnifiedOrderResult(paymentWx, PayTypeEnums.NATIVE, wxConfigs.getRechargeNotifyUrl());
//
//        if ("SUCCESS".equals(resultMap.get(WxPayEnum.RETURN_CODE.getValue()))
//                && "SUCCESS".equals(resultMap.get(WxPayEnum.RESULT_CODE.getValue()))) {
//
//            // 预付款成功后需要完成的业务逻辑
//
//            return ResponseUtils.success(resultMap.get(WxPayEnum.CODE_URL.getValue()));
//        }
//        paymentWx.setErrCode(resultMap.get(WxPayEnum.ERR_CODE.getValue()));
//        paymentWx.setErrCodeDes(resultMap.get(WxPayEnum.ERR_CODE_DES.getValue()));
//
//        // 微信预生成订单之后的业务逻辑
//
//        log.info("微信返回的错误码信息为，{}", resultMap.get(WxPayEnum.ERR_CODE_DES.getValue()));
//
//        return ResponseUtils.fail(ErrCodeEnum.BUSINESS.getCode(), "下单失败！");
//
//    }

    /**
     * 生成微信支付二维码供给用户扫码
     *
     * @Title createQrCode
     * @Description
     * @param paymentWx 微信支付的原始参数的接受
     * @throws Exception
     * @return ResponseResult
     * @author 伍成林
     * @date: 2020年3月13日
     */
//    public ResponseResult<String> createH5Pay(PaymentWx paymentWx) throws Exception {
//        // 调用统一下单接口
//        Map<String, String> resultMap = getUnifiedOrderResult(paymentWx, PayTypeEnums.MWEB, wxConfigs.getRechargeNotifyUrl());
//
//        if ("SUCCESS".equals(resultMap.get(WxPayEnum.RETURN_CODE.getValue()))
//                && "SUCCESS".equals(resultMap.get(WxPayEnum.RESULT_CODE.getValue()))) {
//
//            // 预付款成功后需要完成的业务逻辑
//
//            return ResponseUtils.success(resultMap.get("h5_url"));
//        }
//        paymentWx.setErrCode(resultMap.get(WxPayEnum.ERR_CODE.getValue()));
//        paymentWx.setErrCodeDes(resultMap.get(WxPayEnum.ERR_CODE_DES.getValue()));
//
//        // 微信预生成订单之后的业务逻辑
//
//        log.info("微信返回的错误码信息为，{}", resultMap.get(WxPayEnum.ERR_CODE_DES.getValue()));
//
//        return ResponseUtils.fail(ErrCodeEnum.BUSINESS.getCode(), resultMap.get(WxPayEnum.RETURN_MSG.getValue()));
//
//    }
    /**
     *
     * @Title getUnifiedOrderResult
     * @Description: 统一下单的接口调用
     * @param paymentWx 微信支付的接收参数类
     * @param payType 支付类型的枚举
     * @return Map<String,String>
     * @author 伍成林
     * @date 2021年03月16日
     */
//    private Map<String, String> getUnifiedOrderResult(PaymentWx paymentWx, PayTypeEnums payType,String notifyUrl) throws Exception {
//        Map<String, String> data = createRequestMap(paymentWx, payType.getValue());
//        // 通知地址
//        data.put("notify_url", notifyUrl);
//        wxPay.fillRequestData(data);
//
//        log.info("生成订单时的sign_type是：{}", wxConfigs.getSignType());
//        String responseString = wxPay.requestWithoutCert(WXPayConstants.UNIFIEDORDER_URL, data,
//                wxConfigs.getHttpConnectTimeoutMs(), wxConfigs.getHttpReadTimeoutMs());
//
//        log.info("调用统一下单API返回的结果XML为：{}", responseString);
//        // 解析返回的xml
//        Map<String, String> resultMap = wxPay.processResponseXml(responseString);
//        data.putAll(resultMap);
//        return resultMap;
//    }

    /**
     * 处理数据
     *
     * @Title dealWithData
     * @Description
     * @param reqMap 支付回调的map
     * @throws Exception
     * @return boolean
     * @author 伍成林
     * @date: 2020年3月18日
     */
//    private boolean dealWithData(Map<String, String> reqMap) throws Exception {
//        String resultCode = reqMap.get(WxPayEnum.RESULT_CODE.getValue());
//        // 打印出所有的key 和 value 查看出哪些是需要的属性
//        // 具体返回的值有哪些建议参照官方文档： https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=9_7&index=8
//        reqMap.forEach((key, value) -> {
//            log.info("key: {} value : {} ",key,value);
//        });
//
//        log.info("异步回调时订单时的签名是：{}", reqMap.get("sign"));
//        log.info("异步回调时订单时的key：{}", reqMap.get("key"));
//        log.info("异步回调时订单时的sign_type：{}", reqMap.get(WxPayEnum.SIGN_TYPE.getValue()));
//
//        // 签名认证：微信方异步回调的数据需要进行签名认证,判断签名是否为这次支付的签名
//        Boolean flagBoolean = this.signVerification(reqMap);
//
//        if ("SUCCESS".equals(resultCode) && flagBoolean) {
//
//            // TODO 支付成功后的业务逻辑处理
//            return Boolean.TRUE;
//        } else {
//            // TODO 支付失败后的业务逻辑处理
//            return Boolean.FALSE;
//        }
//    }

    /**
     * 签名验证
     *
     * @Title signVerification
     * @Description
     * @param xmlMap
     * @return
     * @throws Exception
     * @return Boolean
     * @author 木槿
     * @date: 2020年3月19日
     */
//    public Boolean signVerification(Map<String, String> xmlMap) throws Exception {
//        // String s =
//        // "<xml><appid><![CDATA[wx811159be3af0f741]]></appid><bank_type><![CDATA[OTHERS]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[N]]></is_subscribe><mch_id><![CDATA[1580161461]]></mch_id><nonce_str><![CDATA[9d26f4d6d7b643eea88d87b49ca1d2da]]></nonce_str><openid><![CDATA[o3wIsuDhmMX3903vstRCCk2y-Cs4]]></openid><out_trade_no><![CDATA[12020031900000013]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[7F283D76E6EEDEF7DCF3A89EF78CD057]]></sign><time_end><![CDATA[20200319105801]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[NATIVE]]></trade_type><transaction_id><![CDATA[4200000514202003191099571830]]></transaction_id></xml>";
//        // xmlMap = WXPayUtil.xmlToMap(s);
//        String oldStr = xmlMap.get("sign");
//        log.info("之前的签名是：{}", xmlMap.get("sign"));
//        log.info("之前的key是：{}", xmlMap.get("key"));
//        String newSignString = WXPayUtil.generateSignature(xmlMap, wxConfigs.getKey(),
//                PayUtils.getSignType(xmlMap.get(WxPayEnum.SIGN_TYPE.getValue())));
//        log.info("重新签名时的签名为：{}", newSignString);
//        return oldStr.equals(newSignString);
//    }




    /**
     * 创建请求的map
     *
     * @Title createRequestMap
     * @Description
     * @param paymentWx 微信接收的原始数据
     * @return Map<String,String>
     * @author 木槿
     * @throws Exception
     * @date: 2020年3月27日
     */
    private Map<String, String> createRequestMap(PaymentWx paymentWx, String tradeType)
            throws Exception {
        // 设置过期时间
        String timeExpire = PayUtils.getTimeExpire(180000);
        // 订单号
        long outTradeNo = orderCreate.getId();
        // 微信支付请求的封装
        Map<String, String> data = new HashMap<String, String>();
        // 商户订单号
        data.put("out_trade_no", outTradeNo+"");
        // wxPay.fillRequestData(data);
        // 商品描述
        data.put("body", paymentWx.getBody());
        // 标价币种
        data.put("fee_type", "CNY");
        // 标价金额
        data.put("total_fee", String.valueOf(paymentWx.getTotalFee()));
        // 用户的IP
        data.put("spbill_create_ip", paymentWx.getSpbillCreateIp());

        // 交易类型
        data.put("trade_type", tradeType);

        // 过期时间
        data.put("time_expire", timeExpire);

        return data;
    }
}
