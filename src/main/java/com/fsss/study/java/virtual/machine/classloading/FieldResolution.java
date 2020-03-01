package com.fsss.study.java.virtual.machine.classloading;

/**
 * @author Fsss
 * @date 2020/3/1
 */
public class FieldResolution {

    interface Interface0 {
        int A = 0;
    }

    static class Parent {
        public static int A = 1;
    }

    static class Sub extends Parent implements Interface0 {
        public static int A = 2;
    }

    public static void main(String[] args) {
        // VM 类加载时对字段解析会找到第一个 A 字段符号引用
        // 如果注释掉 Sub 中的 `public static int A = 2;` Oracle 的 javac 编译器会提示“The field Sub.A is ambiguous”
        // 因为可以同时在 Sub 的父类和接口中查找到多个 A 符号
        System.out.println(Sub.A);
    }
}
