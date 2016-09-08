package org.jy.smart.framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jy.smart.framework.bean.Data;
import org.jy.smart.framework.bean.Handler;
import org.jy.smart.framework.bean.Param;
import org.jy.smart.framework.bean.View;
import org.jy.smart.framework.helper.BeanHelper;
import org.jy.smart.framework.helper.ConfigHelper;
import org.jy.smart.framework.helper.ControllerHepler;
import org.jy.smart.framework.util.ArrayUtil;
import org.jy.smart.framework.util.CodecUtil;
import org.jy.smart.framework.util.ReflectionUtil;
import org.jy.smart.framework.util.StreamUtil;
import org.jy.smart.framework.util.StringUtil;

/**
 * 请求转发器
 * 
 * @author yong.jiang
 * @since 1.0
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DisptcherServlet extends HttpServlet {

	private static final long serialVersionUID = 2428311890852728184L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取请求方法与请求领
		String requestMethod = request.getMethod().toLowerCase();
		String requestPath = request.getPathInfo();

		// 获取Action处理器
		Handler handler = ControllerHepler.getHandler(requestMethod,
				requestPath);
		if (handler != null) {
			// 获取Controller 类及其Bean 实例
			Class<?> controllerClass = handler.getControllerClass();
			Object controllerBean = BeanHelper.getBean(controllerClass);
			// 创建请求参数
			Map<String, Object> paramMap = new HashMap<String, Object>();
			Enumeration<String> paramNames = request.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String paramName = paramNames.nextElement();
				String paramValue = request.getParameter(paramName);
				paramMap.put(paramName, paramValue);
			}
			String body = CodecUtil.decodeURL(StreamUtil.getString(request
					.getInputStream()));
			if (StringUtil.isNotEmpty(body)) {
				String[] params = StringUtil.splitString(body, "&");
				if (ArrayUtil.isNotEmpty(params)) {
					for (String param : params) {
						String[] array = StringUtil.splitString(param, "=");
						if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
							paramMap.put(array[0], array[1]);
						}

					}
				}
			}
			Param param = new Param(paramMap);
			// 调用Action 方法
			Method actionMethod = handler.getActionMethod();
			Object result = ReflectionUtil.invokeMethod(controllerBean,
					actionMethod, param);
			// 处理Action 返回值
			if (result instanceof View) {
				// 返回JSP 页面
				View view = (View) result;
				String path = view.getPath();
				if (StringUtil.isNotEmpty(path)) {
					if (path.startsWith("/")) {
						response.sendRedirect(request.getContextPath() + path);
					} else {
						Map<String, Object> model = view.getModel();
						for (Map.Entry<String, Object> entry : model.entrySet()) {
							request.setAttribute(entry.getKey(),
									entry.getValue());
						}
						request.getRequestDispatcher(
								ConfigHelper.getAppJspPath() + path).forward(
								request, response);
						;
					}
				}
			} else if (result instanceof Data) {
				// 返回JSON 数据
				Data data = (Data) result;
				Object model = data.getModel();
				if (model != null) {
					response.setContentType("application/json");
					response.setCharacterEncoding(CodecUtil.DEFAUTL_UTF8);
					PrintWriter writer = response.getWriter();
					String json = "";
					writer.write(json);
					writer.flush();
					writer.close();
				}
			}
		}

	}
}
