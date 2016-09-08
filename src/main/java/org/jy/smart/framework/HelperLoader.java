package org.jy.smart.framework;

import org.jy.smart.framework.helper.BeanHelper;
import org.jy.smart.framework.helper.ClassHelper;
import org.jy.smart.framework.helper.ControllerHepler;
import org.jy.smart.framework.helper.IocHelper;
import org.jy.smart.framework.util.ClassUtil;

public class HelperLoader {

	public static void inti() {
		Class<?>[] classList = { ClassHelper.class, BeanHelper.class,
				IocHelper.class, ControllerHepler.class };
		for (Class<?> cls : classList) {
			ClassUtil.loadClass(cls.getName());
		}
	}
}
