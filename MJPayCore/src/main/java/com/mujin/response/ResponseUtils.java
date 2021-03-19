package com.mujin.response;

public final class ResponseUtils {

	/**
	 * 
	 * @Title:
	 * @Description:
	 */
	private ResponseUtils() {
	}

	/**
	 * 
	 * @Title success
	 * @Description 成功有返回值
	 * @param <T> 泛型对象
	 * @param data 数据
	 * @return ResponseResult<T>
	 * @author 伍成林
	 * @date 2021年03月15日
	 */
	public static <T> ResponseResult<T> success(T data) {
		ResponseResult<T> result = new ResponseResult<T>();
		result.setResCode(0);
		result.setResMsg("OK");
		result.setResData(data);
		return result;
	}

	/**
	* @Title success
	* @Description 成功有返回值，有返回消息
	* @param <T>
	* @param data
	* @param msg
	* @return
	* @return ResponseResult<T>
	 * @author 伍成林
	 * @date 2021年03月15日
	*/
	public static <T> ResponseResult<T> success(T data,String msg) {
		ResponseResult<T> result = new ResponseResult<T>();
		result.setResCode(0);
		result.setResMsg(msg);
		result.setResData(data);
		return result;
	}

	/**
	* @Title successMsg
	* @Description 成功无返回值，有返回消息
	* @param <T>
	* @param msg
	* @return
	* @return ResponseResult<T>
	 * @author 伍成林
	 * @date 2021年03月15日
	*/
	public static <T> ResponseResult<T> successMsg(String msg) {
		ResponseResult<T> result = new ResponseResult<T>();
		result.setResCode(0);
		result.setResMsg(msg);
		result.setResData(null);
		return result;
	}
	/**
	 * 
	 * @Title success
	 * @param <T>  泛型对象
	 * @Description 成功无返回值
	 * @return
	 * @return ResponseResult<T>
	 * @author 伍成林
	 * @date 2021年03月15日
	 */
	public static <T> ResponseResult<T> success() {
		ResponseResult<T> result = new ResponseResult<T>();
		result.setResCode(0);
		result.setResMsg("OK");
		return result;
	}

	/**
	 * 
	 * @Title fail
	 * @Description 错误返回
	 * @param <T> 泛型对象
	 * @param errCode 错误代码
	 * @param errMsg 错误信息
	 * @return
	 * @return ResponseResult<T>
	 * @author 伍成林
	 * @date 2021年03月15日
	 */
	public static <T> ResponseResult<T> fail(int errCode, String errMsg) {
		ResponseResult<T> result = new ResponseResult<T>();
		result.setResCode(errCode);
		result.setResMsg(errMsg);
		return result;

	}

}
