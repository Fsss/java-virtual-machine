package com.fsss.study.java.virtual.machine.classloading;

/**
 * @author Fsss
 * @date 2020/3/2
 */
public class ClassInitMethod {

  static class ForwardReference {
    static {
      i = 0;
      // illegal forward reference
      // System.out.println(i);
    }

    static int i = 1;
  }

  static class InitOrder {
    static int A = 1;

    static {
      A = 2;
    }
  }

  static class DeadLoopClass {
    static {
      if (true) {
        System.out.println(Thread.currentThread() + "init DeadLoopClass");
        while (true) {}
      }
    }
  }

  public static void main(String[] args) {
    // <clinit> 方法静态语句是按源码编写顺序收集
    System.out.println(InitOrder.A);

    // jvm 必须保证类的 <clinit> 方法的执行是线程安全的
    Runnable script =
        new Runnable() {
          public void run() {
            System.out.println(Thread.currentThread() + "start");
            DeadLoopClass deadLoopClass = new DeadLoopClass();
            System.out.println(Thread.currentThread() + "run over");
          }
        };
    Thread thread1 = new Thread(script);
    Thread thread2 = new Thread(script);
    thread1.start();
    thread2.start();
  }
}
