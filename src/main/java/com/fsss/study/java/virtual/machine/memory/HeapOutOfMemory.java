package com.fsss.study.java.virtual.machine.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fsss
 * @date 2020/3/14
 */
public class HeapOutOfMemory {

  private static class Animal {}

  /**
   * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError 设置 OutOfMemoryError 时自动执行堆转储，生成
   * java_pid_xxx.hprof，然后使用 jhat 进行分析
   */
  public static void main(String[] args) {
    List<Animal> list = new ArrayList<>();
    while (true) {
      list.add(new Animal());
    }
  }
}
