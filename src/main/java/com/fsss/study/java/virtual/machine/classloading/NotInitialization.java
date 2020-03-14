package com.fsss.study.java.virtual.machine.classloading;

/**
 * @author Fsss
 * @date 2020/3/1
 */
public class NotInitialization {

  private static class SuperClass {

    static int value = 10;

    static {
      System.out.println("SuperClass init");
    }
  }

  private static class SubClass extends SuperClass {

    static {
      System.out.println("SubClass init");
    }
  }

  private static class ConstClass {

    static final String HELLO_WORLD = "hello world";

    public static final SuperClass SUPER_CLASS = null;

    static {
      System.out.println("ConstClass init");
    }
  }

  public static void main(String[] args) {
    // case 1
    // 通过子类引用父类的静态字段不会导致子类初始化
    System.out.println(SubClass.value);

    // case 2
    // 通过数组定义来引用类，不会触发此类的初始化
    // 实际上触发的是 [com.fsss.study.java.virtual.machine.classloading.NotInitialization.SubClass 的初始化
    // 这是由虚拟机自动生成的、直接继承于 java.lang.Object 的子类，创建动作由字节码指令 newarray 触发
    SubClass[] subClasses = new SubClass[10];

    // case 3
    // 常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类
    // 常量：final 修饰的基础类型和 String 类型
    System.out.println(ConstClass.HELLO_WORLD);
  }
}
