package com.captain.demo.concurrency;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;

import static java.lang.System.*;

/**
 * @author Captain Wang
 * @time2020/7/5
 */
public class ThreadTest  {
    private Thread thread;
    private Runnable runnable;
    private Callable callable;

    public ThreadTest() {

    }
    public Thread getThread() {
        return thread;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public Callable getCallable() {
        return callable;
    }

    void setAll() {
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                out.println("Hello Thread"+Thread.currentThread().getName());
                Thread.currentThread().stop();
            }
        };

        runnable = () -> out.println("Hello Runnable"+Thread.currentThread().getName());

        callable = () -> {
            out.println("Hello Callable"+Thread.currentThread().getName());
            return null;
        };
    }

    public static void main(String[] args) throws Exception {
        ThreadTest threadTest = new ThreadTest();
        threadTest.setAll();
        threadTest.getThread().start();
        threadTest.getThread().join();
        threadTest.getRunnable().run();
        threadTest.getCallable().call();
    }
}
