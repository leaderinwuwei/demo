package com.captain.demo.study.jvm;

/**
 * @author Captain Wang
 * @time2020/8/5
 */
public class GCTest {
    public Object instance = null;

    private static final int ONE_MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * ONE_MB];

    public static void main(String[] args) {
        GCTest gcTest1 = new GCTest();
        GCTest gcTest2 = new GCTest();
        gcTest1.instance = gcTest2;
        gcTest2.instance = gcTest1;

//        List<String> list = new ArrayList<>();
//        try {
//            new Thread() {
//                @SneakyThrows
//                @Override
//                public void run() {
//                    while (true) {
//                        list.add(String.valueOf(this.hashCode()).intern());
//                        Thread.sleep(1);
//                    }
//                }
//            }.start();
//        }catch (Exception e) {
        gcTest2.bigSize = null;
        gcTest1.bigSize = null;
//            list.clear();
//        }
        while (true) {

        }
    }
}
