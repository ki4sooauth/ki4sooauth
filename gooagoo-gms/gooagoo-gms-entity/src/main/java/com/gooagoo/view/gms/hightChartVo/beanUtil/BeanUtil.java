package com.gooagoo.view.gms.hightChartVo.beanUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BeanUtil {

	private static final List<String> typeList = new ArrayList<String>();
	static {
		typeList.add("java.lang.Boolean");
		typeList.add("java.lang.Integer");
		typeList.add("java.lang.Float");
	}

	@SuppressWarnings("unchecked")
	public static String getToString(Object obj, boolean isBaseVo) {
		StringBuffer buffer = null;
		if (isBaseVo) {
			String name = obj.getClass().getSimpleName();
			byte[] bytes = name.getBytes();
			bytes[0] = (byte) ((char) bytes[0] + 32);
			buffer = new StringBuffer(new String(bytes) + ":{");
		} else {
			buffer = new StringBuffer("{");
		}
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		try {
			for (int i=0; i<declaredFields.length; i++) {
				Field field = declaredFields[i];
				field.setAccessible(true);
				Object object = field.get(obj);
				if (object != null) {
					String type = field.getType().getName();
					if ("java.lang.String".equals(type) && object instanceof String && (((String) object).contains("function") || ((String) object).contains("||") || ((String) object).contains("&&"))) {
						buffer.append(field.getName()).append(":").append("" + object + "").append(",");
					} else if ("java.lang.String".equals(type)) {
						buffer.append(field.getName()).append(":").append("'" + object + "'").append(",");
					} else if (typeList.contains(type)) {
						buffer.append(field.getName()).append(":").append("" + object + "").append(",");
					} else if ("java.util.List".equals(type)) {
						List<Object> list = (List<Object>) object;
						buffer.append(field.getName()).append(":[");
						for (Object object2 : list) {
							if (object2 instanceof String) {
								buffer.append("'" + object2 + "'");
							} else if (object2 instanceof List) {
								List<Object> tList = (List<Object>) object2;
								buffer.append("[");
								for (Object object3 : tList) {
									if (object3 instanceof String) {
										buffer.append("'" + object3 + "'");
									} else {
										buffer.append("" + object3 + "");
									}
									buffer.append(",");
								}
								buffer.replace(buffer.length() - 1, buffer.length(), "");
								buffer.append("]");
							} else {
								buffer.append("" + object2 + "");
							}
							buffer.append(",");
						}
						buffer.replace(buffer.length() - 1, buffer.length(), "");
						buffer.append("]");
						buffer.append(",");
					} else {
						buffer.append("" + object.toString() + "").append(",");
					}
				}
			}
			if (buffer.substring(buffer.length() - 1).equals(",")) {
				buffer.replace(buffer.length() - 1, buffer.length(), "");
			}
			buffer.append("}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

}
