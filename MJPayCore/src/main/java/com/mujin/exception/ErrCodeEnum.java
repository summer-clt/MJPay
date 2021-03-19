/**   
* @Title: ErrCodeEnum.java 
* @Package com.fa.core.exception
* @Description: TODO 
* @author: 曾明辉  
* @date 2019年8月15日   
*/
package com.mujin.exception;

/**
 * @Description: TODO
 * @author: 曾明辉
 * @date: 2019年8月15日
 */
public enum ErrCodeEnum {

	/** 
	* REGISTER: 310跳转注册
	*/
	REGISTER(310),
	/**
	* AUTH: 401未授权
	*/
	AUTH(401),
	/**
	 * DATACHECK: 412未满足数据校验
	 */
	DATACHECK(412),
	/**
	 * BUSINESS: 9990业务异常
	 */
	BUSINESS(9990),
	/**
	 * THROWABLE: 9999程序异常
	 */
	THROWABLE(9999);

	/**
	 * 错误代码
	 */
	private int code;

	/**
	 * 
	 * @Title:
	 * @Description:
	 * @param code 错误码
	 */
	ErrCodeEnum(int code) {
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

}
