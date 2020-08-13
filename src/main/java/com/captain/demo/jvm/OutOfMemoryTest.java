package com.captain.demo.jvm;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Captain Wang
 * @time2020/8/3
 */
public class OutOfMemoryTest {
    int a = 1;

    void b() {
        a++;
        b();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        OutOfMemoryTest outOfMemoryTest = new OutOfMemoryTest();
//        outOfMemoryTest.b();
        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    list.add(String.valueOf(this.hashCode()).intern());
                    Thread.sleep(1);
                    System.out.println(list.size());
                }
            }
        }.start();
        while (true) {

        }
    }
}
