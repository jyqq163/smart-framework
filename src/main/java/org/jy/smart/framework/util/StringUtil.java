package org.jy.smart.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具了
 * 
 * @author yong.jiang
 * @since 1.0
 */
public class StringUtil {

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str != null) {
			str = str.trim();
		}
		return StringUtils.isEmpty(str);
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static String[] splitString(String body, String string) {
		return null;
	}
}
