package org.jy.smart.framework.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jy.smart.framework.bean.Handler;
import org.jy.smart.framework.bean.Request;

/**
 * 控制器助手类
 * @author yong.jiang
 *  @since 1.0
 */
public class ControllerHepler {
	private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();
	
	static {
		Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
		
	}

}
