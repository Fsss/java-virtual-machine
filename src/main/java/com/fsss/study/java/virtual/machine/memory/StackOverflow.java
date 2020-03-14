package com.fsss.study.java.virtual.machine.memory;

/**
 * @author Fsss
 * @date 2020/3/14
 */
public class StackOverflow {

  private static int stackCount = 0;

  private static void recursion() {
    ++stackCount;
    recursion();
  }

  /** VM Args: -Xss128k */
  public static void main(String[] args) {
    try {
      StackOverflow.recursion();
    } catch (Throwable e) {
      System.out.println("stack count : " + StackOverflow.stackCount);
      throw e;
    }
  }
}
