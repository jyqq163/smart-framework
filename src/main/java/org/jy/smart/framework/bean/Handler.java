package org.jy.smart.framework.bean;

import java.lang.reflect.Method;

/**
 * 封装 Action 信息
 * 
 * @author yong.jiang
 * @since 1.0
 */
public class Handler {

	/**
	 * controller 
	 */
	private Class<?> controllerClass;
	/**
	 * Action 方法
	 */
	private Method actionMethod;

	public Handler(Class<?> controllerClass, Method actionMethod) {
		this.controllerClass = controllerClass;
		this.actionMethod = actionMethod;
	}

	public Class<?> getControllerClass() {
		return controllerClass;
	}

	public Method getActionMethod() {
		return actionMethod;
	}

}
