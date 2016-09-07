package org.jy.smart.framework.helper;

import java.util.HashSet;
import java.util.Set;

import org.jy.smart.framework.annotaion.Controller;
import org.jy.smart.framework.annotaion.Service;
import org.jy.smart.framework.util.ClassUtil;

/**
 * 类操作工具类
 * 
 * @author yong.jiang
 * @since 1.0
 */
public class ClassHelper {
	private static final Set<Class<?>> CLASS_SET;
	static {
		CLASS_SET = ClassUtil.getClassSet(ConfigHelper.getAppBasePackage());
	}

	public static Set<Class<?>> getClassSet() {
		return CLASS_SET;
	}

	/**
	 * 获取应用包名下所有 service 类
	 * 
	 * @return
	 */
	public static Set<Class<?>> getServiceClassSet() {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for (Class<?> cls : classSet) {
			if (cls.isAnnotationPresent(Service.class)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}

	/**
	 * 获取应用包名下面所有controller 类
	 * 
	 * @return
	 */
	public static Set<Class<?>> getControllerClassSet() {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for (Class<?> cls : classSet) {
			if (cls.isAnnotationPresent(Controller.class))
				classSet.add(cls);
		}
		return classSet;
	}

	/**
	 * 获取应用包名下面所有的 bean 类 (包括:Service、Controller 等)
	 * @return
	 */
	public static Set<Class<?>> getBeanClassSet() {
		Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
		beanClassSet.addAll(getServiceClassSet());
		beanClassSet.addAll(getControllerClassSet());
		return beanClassSet;
	}
}
