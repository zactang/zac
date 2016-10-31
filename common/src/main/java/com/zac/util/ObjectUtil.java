package com.zac.util;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * Object Tools
 * @author ZacTang
 *
 */
public final class ObjectUtil {
	/***
	 * Convert Object[] to VO
	 * @param data List<Object[]>
	 * @param clazz
	 * @param targetProperty Order ASC
	 * @return
	 */
	public static  <T>List<T> convertVO(List<Object[]> list, Class<T> clazz,String... targetProperty) {
		try {
			if (list != null && targetProperty.length > 0 && list.size() > 0) {
				List<T> dataList = new ArrayList<T>();
				if (!(list.get(0) instanceof Object[])) {
					String p = targetProperty[0];
					for (Object o : list) {
						T obj = (T) clazz.newInstance();
						Field fd = clazz.getDeclaredField(p);
						fd.setAccessible(true);
						fd.set(obj, o);
						dataList.add(obj);
					}

				} else {
					for (Object os : list) {
						Object[] oss = (Object[]) os;
						T obj = (T) clazz.newInstance();
						for (int i = 0; i < targetProperty.length; i++) {
							Field fd = clazz.getDeclaredField(targetProperty[i]);
							fd.setAccessible(true);
							if (oss[i] instanceof Number) {
								Number nb = (Number) oss[i];
								if (	   fd.getType().equals(Double.class)
										|| fd.getType().equals(double.class)) {
									fd.set(obj, nb.doubleValue());
								} else if (fd.getType().equals(byte.class)
										|| fd.getType().equals(Byte.class)) {
									fd.set(obj, nb.byteValue());
								} else if (fd.getType().equals(long.class)
										|| fd.getType().equals(Long.class)) {
									fd.set(obj, nb.longValue());
								} else if (fd.getType().equals(Float.class)
										||fd.getType().equals(float.class)) {
									fd.set(obj, nb.floatValue());
								} else if (fd.getType().equals(Integer.class)
										||fd.getType().equals(int.class)) {
									fd.set(obj, nb.intValue());
								} else if (fd.getType().equals(Boolean.class)
										|| fd.getType().equals(boolean.class)) {
									if (nb.intValue() == 1) {
										fd.set(obj, true);
									} else {
										fd.set(obj, false);
									}
								} else {
									fd.set(obj, nb);
								}
							} else {
								if (fd.getType().getSuperclass().getSimpleName().equalsIgnoreCase("enum")) {
									fd.set(obj,fd.getType().getDeclaredMethod(
															"valueOf",String.class).invoke(null, oss[i]));

								} else {
									fd.set(obj, oss[i]);
								}

							}
						}
						dataList.add(obj);

					}
				}

				
				return dataList;
			}
			return new ArrayList<T>();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
