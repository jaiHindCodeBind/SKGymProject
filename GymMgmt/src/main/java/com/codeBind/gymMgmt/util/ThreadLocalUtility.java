package com.codeBind.gymMgmt.util;

import java.util.HashMap;
import java.util.Map;


public class ThreadLocalUtility {
		private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();
		public static void setThreadLocalMap(Map<String, Object> map) {
			threadLocal.set(map);
		}
		public static Map<String, Object> getThreadLocalMap() {
			return threadLocal.get();
		}
//	}

    /**
     * Method to add objects to threadlocal
     * @param key key used to store objects in thread local
     * @param value the object being added to thread local
     */
	public static void addToThreadLocal(final String key, final Object value) {
		Map<String, Object> map = getThreadLocalMap();

		if (map == null) {
			map = new HashMap<String, Object>();
			setThreadLocalMap(map);
		}

		map.put(key, value);
	}

    /**
     * Method to retreive objects from threadlocal
     * @param key key used to store
     * @return object from threadlocal
     */
	public static Object getFromThreadLocal(final String key) {
		final Map<String, Object> map = getThreadLocalMap();
		Object returnValue = null;

		if (map != null) {
			returnValue = map.get(key);
		}
		return returnValue;
	}

	public static void removeFromThreadLocal(final String... keys) {
		Map<String, Object> map = getThreadLocalMap();

		if (map == null) {
			map = new HashMap<String, Object>();
			setThreadLocalMap(map);
		}

		for (String key : keys) {
			map.remove(key);
		}
	}
}

