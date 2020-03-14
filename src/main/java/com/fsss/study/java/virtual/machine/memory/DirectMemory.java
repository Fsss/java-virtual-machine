package com.fsss.study.java.virtual.machine.memory;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * @author Fsss
 * @date 2020/3/14
 */
public class DirectMemory {

  private static final int _1MB = 1024 * 1024;

  /** VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M */
  public static void main(String[] args) throws Exception {

    Field unsafeField = Unsafe.class.getDeclaredFields()[0];
    unsafeField.setAccessible(true);
    Unsafe unsafe = (Unsafe) unsafeField.get(null);
    while (true) {
      unsafe.allocateMemory(_1MB);
    }
  }
}
