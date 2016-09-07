package org.jy.smart.framework.helper;

import java.util.Properties;

import org.jy.smart.framework.ConfigConstant;
import org.jy.smart.framework.util.PropsUtil;

public class ConfigHelper {
	private static final Properties CONFIG_PROPS = PropsUtil
			.loadProps(ConfigConstant.CONFIG_FILE);

	/**
	 * 获取JDBC 驱动
	 * 
	 * @return
	 */
	public static String getJdbcDriver() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
	}

	/**
	 * 获取JDBC　URL
	 * 
	 * @return
	 */
	public static String getJdbcUrl() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
	}

	/**
	 * 获取jdbc 用户
	 * 
	 * @return
	 */
	public static String getJdbcUserName() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
	}

	/**
	 * 获取jdbc 密码
	 * 
	 * @return
	 */
	public static String getJdbcPassword() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
	}

	/**
	 * 获取应用基础包名
	 * 
	 * @return
	 */
	public static String getAppBasePackage() {
		return PropsUtil.getString(CONFIG_PROPS,
				ConfigConstant.APP_BASE_PACKAGE);
	}

	/**
	 * 获取应用 JSP 路径
	 * 
	 * @return
	 */
	public static String getAppJspPath() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH,
				"/WEB-INF/view/");
	}

	/**
	 * 获取应用静态资源路径
	 * 
	 * @return
	 */
	public static String getAppAssetPath() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH,
				"/asset/");
	}

}
