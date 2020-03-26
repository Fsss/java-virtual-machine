package com.fsss.study.java.virtual.machine.memory;


/**
 * @author Fsss
 * @date 2020/3/27
 */
public class BigObjectIntoOldGeneration {

  private static final int _1MB = 1024 * 1024;

  /**
   * VM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
   * -XX:PretenureSizeThreshold=3145728 (只对 Serial 和 ParNew 收集器有效)
   */
  public static void main(String[] args) {
    byte[] allocation = new byte[4 * _1MB];
  }
}
