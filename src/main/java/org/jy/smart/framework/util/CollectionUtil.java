package org.jy.smart.framework.util;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

/**
 * 集合工具类
 * 
 * @author yong.jiang
 * @since 1.0
 */
public class CollectionUtil {

	/**
	 * * 判断Collection是否为空
	 * 
	 * @param coll
	 * @return
	 */
	public static boolean isEmpty(Collection<?> coll) {
		return CollectionUtils.isEmpty(coll);
	}

	/**
	 * 判断Collection是否非空
	 * 
	 * @param coll
	 * @return
	 */
	public static boolean isNotEmpty(Collection<?> coll) {
		return !isEmpty(coll);
	}

	/**
	 * 判断Map是否为空
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return MapUtils.isEmpty(map);
	}

	/**
	 * 判断Map是否非空
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return !isEmpty(map);
	}
}
