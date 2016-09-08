package org.jy.smart.framework.bean;

import java.util.Map;

import org.jy.smart.framework.util.CastUtil;

/**
 * 请求参数对象
 * @author yong.jiang
 *  @since 1.0
 */
public class Param {
	private Map<String, Object> paramMap;

	public Param(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}

	/**
	 * 获取long 类型参数值
	 * 
	 * @param name
	 * @return
	 */
	public long getLong(String name) {
		return CastUtil.castLong(paramMap.get(name));
	}

	public Map<String, Object> getMap() {
		return paramMap;
	}
}
