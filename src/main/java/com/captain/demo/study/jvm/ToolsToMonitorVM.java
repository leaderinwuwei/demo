package com.captain.demo.study.jvm;

import java.util.Map;

/**
 * @author Captain Wang
 * @time2020/8/11
 */
public class ToolsToMonitorVM {
    public static void main(String[] args) {
        for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
            Thread thread = (Thread) stackTrace.getKey();
            StackTraceElement[] stack = (StackTraceElement[]) stackTrace.getValue();
            if (thread.equals(Thread.currentThread())) {
                continue;
            }
            System.out.print("\n线程：" + thread.getName() + "\n");
            for (StackTraceElement element : stack) {
                System.out.print("\t" + element + "\n");
            }
        }
    }
}
