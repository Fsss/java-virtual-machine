package com.fsss.study.java.virtual.machine.classloading;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Fsss
 * @date 2020/3/5
 */
public class DynamicProxyTest {

  interface IHello {
    /** say hello */
    void sayHello();
  }

  static class Hello implements IHello {

    @Override
    public void sayHello() {
      System.out.println("hello world");
    }
  }

  static class DynamicProxy implements InvocationHandler {

    Object originObject;

    Object bind(Object originObject) {
      this.originObject = originObject;
      return Proxy.newProxyInstance(
          originObject.getClass().getClassLoader(), originObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      // $Proxy0.invoke(this, toString, null) -> invoke 调用 proxy.toString() 死循环
      // System.out.println(proxy); => System.out.println(proxy.toString());
      System.out.println(proxy.getClass());
      System.out.println("welcome");
      return method.invoke(this.originObject, args);
    }
  }

  public static void main(String[] args) {
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    IHello hello = (IHello) new DynamicProxy().bind(new Hello());
    hello.sayHello();
  }
}
