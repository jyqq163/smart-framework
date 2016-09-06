package org.jy.smart.framework.util;

public class CastUtil {

	/**
	 * 转为String 型(可指定默认值)
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static String castString(Object obj, String defaultValue) {
		return obj != null ? String.valueOf(obj) : defaultValue;
	}

	/**
	 * 转为String 型(默认空字符串)
	 * 
	 * @param obj
	 * @return
	 */
	public static String castString(Object obj) {
		return CastUtil.castString(obj, "");
	}

	/**
	 * 转为double 型(可指定默认值)
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static double castDouble(Object obj, double defaultValue) {
		double value = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					value = Double.parseDouble(strValue);
				} catch (Exception e) {
					value = defaultValue;
				}
			}
		}
		return value;
	}

	/**
	 * 转为double 型(默认0)
	 * 
	 * @param obj
	 * @return
	 */
	public static double castDouble(Object obj) {
		return castDouble(obj, 0);
	}

	/**
	 * 转为long 型(可指定默认值)
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static long castLong(Object obj, long defaultValue) {
		long value = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					value = Long.parseLong(strValue);
				} catch (Exception e) {
					value = defaultValue;
				}
			}
		}
		return value;
	}

	/**
	 * 转为long 型(默认0)
	 * 
	 * @param obj
	 * @return
	 */
	public static long castLong(Object obj) {
		return castLong(obj, 0);
	}

	/**
	 * 转为int 型(可指定默认值)
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static int castInt(Object obj, int defaultValue) {
		int value = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					value = Integer.parseInt(strValue);
				} catch (Exception e) {
					value = defaultValue;
				}
			}
		}
		return value;
	}

	/**
	 * 转为int 型(默认0)
	 * 
	 * @param obj
	 * @return
	 */
	public static int castInt(Object obj) {
		return castInt(obj, 0);
	}

	/**
	 * 转为boolean 型(可指定默认值)
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static boolean castBoolean(Object obj, boolean defaultValue) {
		boolean value = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					value = Boolean.parseBoolean(strValue);
				} catch (Exception e) {
					value = defaultValue;
				}
			}
		}
		return value;
	}

	/**
	 * 转为boolean 型(默认fasel)
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean castBoolean(Object obj) {
		return castBoolean(obj, false);
	}

	public static boolean castBoolean(String property) {
		return false;
	}

}
