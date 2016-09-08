package org.jy.smart.framework.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 编码与解码操作工具类
 * 
 * @author yong.jiang
 * @since 1.0
 */
public class CodecUtil {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CodecUtil.class);

	public static final String DEFAUTL_UTF8 = "UTF-8";

	/**
	 * 将URL编码
	 * 
	 * @param source
	 *            源字符串
	 * @param enc
	 *            编码格式
	 * @return
	 */
	public static String encodeURL(String source, String enc) {
		String target;
		try {
			target = URLEncoder.encode(source, enc);
		} catch (Exception e) {
			LOGGER.error("encode url failure ", e);
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * 将URL编码 默认UTF-8
	 * 
	 * @param source
	 *            源字符串
	 * @return
	 */
	public static String encodeURL(String source) {
		return encodeURL(source, DEFAUTL_UTF8);
	}

	/**
	 * 将URL 解码
	 * 
	 * @param source
	 *            解码URL串
	 * @param enc
	 *            解码格式
	 * @return
	 */
	public static String decodeURL(String source, String enc) {
		String target;
		try {
			target = URLDecoder.decode(source, enc);
		} catch (Exception e) {
			LOGGER.error("decode url failure ", e);
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * 将URL 解码 默认使用UTF-8解码
	 * 
	 * @param source
	 *            解码URL串
	 * @return
	 */
	public static String decodeURL(String source) {
		return decodeURL(source, DEFAUTL_UTF8);
	}
}
