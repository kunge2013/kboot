package org.kframe.mvc.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangkun
 * @date 2020/9/29 14:45
 * @description: 对象 构造工厂
 */
public interface Creator<T> {

    static class CreatorInner {
        static final Map<Class, Creator> creatorCacheMap = new HashMap<>();

        static {
            /*创建对象*/
            creatorCacheMap.put(Object.class, p -> new Object());
        }
    }

    /**
     * 自动构造
     * @param params
     * @return
     */
    public T create(Object... params);

    public  static <T> Creator<T> create(Class<T> clazz) {
       try {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        final String name = clazz.getClass().getName();
         return (Creator) loader.loadClass(name.replace('/', '.')).getDeclaredConstructor().newInstance();
        } catch (Throwable ex) {
           throw new RuntimeException("creator error", ex);
        }

    }
}
