package com.icei.utils;

import com.icei.domain.Result;

/**
 * 返回结果集
 * 
 * @author only
 *
 */
public class ResultUtil {

	/**
	 * 成功
	 * 
	 * @param object
	 * @return
	 */
	public static Result success(Object object) {
		Result result = new Result();
		result.setCode(0);
		result.setMsg("成功");
		result.setData(object);
		return result;
	}

	/**
	 * 返回分页
	 * @param object
	 * @param count
	 * @return
	 */
	public static Result success(Object object,int count) {
		Result result = new Result();
		result.setCode(0);
		result.setMsg("成功");
		result.setData(object);
		result.setCount(count);
		return result;
	}

	/**
	 * null
	 * @return
	 */
	public static Result success() {
		return success(null);
	}

	/**
	 * 失败
	 * @param code
	 * @param msg
	 * @return
	 */
	public static Result error(Integer code, String msg) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
}
