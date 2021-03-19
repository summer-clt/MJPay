package com.mujin.enums;

import lombok.AllArgsConstructor;

/**
 * 所有舒心字段名，参照微信官方文档
 */
@AllArgsConstructor
public enum WxPayEnum {
	RETURN_CODE("return_code"),RETURN_MSG("return_msg"),APPID("appid"),MCH_ID("mch_id"),OPEN_ID("openid")
	,SIGN_TYPE("sign_type"),ERR_CODE("err_code"),ERR_CODE_DES("err_code_des"),FEE_TYPE("fee_type")
	,NONCE_STR("nonce_str"),OPENID("openid"),RESULT_CODE("result_code"),SIGN("sign"),PREPAY_ID("prepay_id")
	,TRADE_TYPE("trade_type"),CODE_URL("code_url"),RESULT_MSG("result_msg"),IS_SUBSCRIBE("is_subscribe")
	,TRANSACTION_ID("transaction_id"),COUPON_COUNT("coupon_count"),COUPON_FEE("coupon_fee"), TIME_END("time_end"),BANK_TYPE("bank_type")
	,PAYMENT_NO("payment_no"),PAYMENT_TIME("payment_time"),OUT_TRADE_NO("out_trade_no"),OUT_REFUND_NO("out_refund_no");
	private String value;

	public String getValue() {
		return value;
	}

}
