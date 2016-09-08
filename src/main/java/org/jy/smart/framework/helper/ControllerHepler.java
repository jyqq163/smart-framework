package org.jy.smart.framework.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jy.smart.framework.annotaion.Action;
import org.jy.smart.framework.bean.Handler;
import org.jy.smart.framework.bean.Request;
import org.jy.smart.framework.util.ArrayUtil;
import org.jy.smart.framework.util.CollectionUtil;

/**
 * 控制器助手类
 * 
 * @author yong.jiang
 * @since 1.0
 */
public class ControllerHepler {
	/**
	 * 存放请求与处理器的映射关系
	 */
	private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

	static {
		// 获取所有contoller 类
		Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
		if (CollectionUtil.isNotEmpty(controllerClassSet)) {
			// 遍历Controller
			for (Class<?> controllerClass : controllerClassSet) {
				Method[] methods = controllerClass.getDeclaredMethods();
				// 获取定义的方法
				if (ArrayUtil.isNotEmpty(methods)) {
					// 遍历方法
					for (Method method : methods) {
						// 判断当前方法是否带有注解Action
						if (method.isAnnotationPresent(Action.class)) {
							// 获取映射规则
							Action action = method.getAnnotation(Action.class);
							String mapping = action.value();
							// 验证映射规则
							if (mapping.matches("\\w+:/\\W*")) {
								String[] array = mapping.split(":");
								if (ArrayUtil.isNotEmpty(array)
										&& array.length == 2) {
									// 获取请求方法与请求数据
									String requestMethod = array[0];
									String requestPath = array[1];
									Request request = new Request(
											requestMethod, requestPath);
									Handler handler = new Handler(
											controllerClass, method);

									// 初始化action map
									ACTION_MAP.put(request, handler);

								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 获取handler
	 * 
	 * @param requestMethod
	 * @param requestPath
	 * @return
	 */
	public static Handler getHandler(String requestMethod, String requestPath) {
		Request request = new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
	}

}
