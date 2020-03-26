package com.fsss.study.java.virtual.machine.memory;

/**
 * @author Fsss
 * @date 2020/3/27
 */
public class MinorGarbageCollection {

  private static final int _1MB = 1024 * 1024;

  /**
   * VM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 堆空间
   * 20M，新生代分配 10M，老年代 10M，新生代比例 8:1:1
   */
  public static void main(String[] args) {
    byte[] allocation1, allocation2, allocation3;
    allocation1 = new byte[2 * _1MB];
    allocation2 = new byte[2 * _1MB];
    allocation3 = new byte[4 * _1MB];
  }
}
