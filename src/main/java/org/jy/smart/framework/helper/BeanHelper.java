package org.jy.smart.framework.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jy.smart.framework.util.ReflectionUtil;

/**
 * bean 助手类
 * 
 * @author yong.jiang
 * @since 1.0
 */
public class BeanHelper {

	private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

	static {
		Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
		for (Class<?> beanClass : beanClassSet) {
			Object obj = ReflectionUtil.newInstance(beanClass);
			BEAN_MAP.put(beanClass, obj);
		}
	}

	public static Map<Class<?>, Object> getBeanMap() {
		return BEAN_MAP;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> cls) {
		if (!BEAN_MAP.containsKey(cls)) {
			throw new RuntimeException("can not get bean by class: " + cls);
		}
		return (T) BEAN_MAP.get(cls);
	}
}
