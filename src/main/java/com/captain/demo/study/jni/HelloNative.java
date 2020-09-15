package com.captain.demo.study.jni;

/**
 * @author Captain Wang
 * @time2020/7/10
 */
public class HelloNative {


    static {
        System.loadLibrary("HelloNative");
    }

    public static native void sayHello();

    public static void main(String[] args) {
        sayHello();
    }

}
