package org.jy.smart.framework.helper;

import java.lang.reflect.Field;
import java.util.Map;

import org.jy.smart.framework.annotaion.Inject;
import org.jy.smart.framework.util.ArrayUtil;
import org.jy.smart.framework.util.CollectionUtil;
import org.jy.smart.framework.util.ReflectionUtil;

/**
 * 依赖注入 助手类
 * 
 * @author yong.jiang
 * @since 1.0
 */
public class IocHelper {
	static {
		// 获取所有 bean
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if (CollectionUtil.isNotEmpty(beanMap)) {
			// 遍历所有 bean
			for (Map.Entry<Class<?>, Object> beanEntity : beanMap.entrySet()) {
				// 取出bean 类和实例
				Class<?> beanClass = beanEntity.getKey();
				Object beanInstance = beanEntity.getValue();
				// 获取所有 成员变量
				Field[] beanFields = beanClass.getDeclaredFields();
				if (ArrayUtil.isNotEmpty(beanFields)) {
					// 遍历成员变量
					for (Field beanField : beanFields) {
						// 判断当前成员变量是否带有Inject注解
						if (beanField.isAnnotationPresent(Inject.class)) {
							// 获取成员变量类 和实例
							Class<?> beanFieldClass = beanField.getType();
							Object beanFieldInstance = beanMap
									.get(beanFieldClass);
							if (beanFieldInstance != null) {
								// 注入实例
								ReflectionUtil.setField(beanInstance,
										beanField, beanFieldInstance);
							}
						}
					}
				}

			}
		}
	}
}
