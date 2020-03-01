package com.fsss.study.java.virtual.machine.classloading;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Fsss
 * @date 2020/3/2
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(fileName);
                    if (inputStream == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException exception) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object object = myClassLoader.loadClass("com.fsss.study.java.virtual.machine.classloading.ClassLoaderTest")
                .newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof com.fsss.study.java.virtual.machine.classloading.ClassLoaderTest);
    }
}
