package com.fsss.study.java.virtual.machine.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author Fsss
 * @date 2020/3/14
 */
public class MethodArea {

  private static class SuperObject {}

  /** VM Args: -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M */
  public static void main(String[] args) {
    int count = 0;
    while (true) {
      Enhancer enhancer = new Enhancer();
      enhancer.setSuperclass(SuperObject.class);
      enhancer.setUseCache(false);
      enhancer.setCallback(
          (MethodInterceptor)
              (object, method, objects, proxy) -> proxy.invokeSuper(object, objects));
      enhancer.create();
      System.out.println("count : " + ++count);
    }
  }
}
