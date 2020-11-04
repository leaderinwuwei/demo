package com.captain.demo.algorithm.primer;

import com.captain.demo.algorithm.SortTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author Captain Wang
 * @time 2020/9/1
 */
public class Test {

    public static void select(String sortName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long bef = System.currentTimeMillis();
        Integer[] integers = new Integer[15000];
        SortTemplate<Integer> sortTemplate = new SortTemplate<>();
        Random random = new Random();
        for (int i = 0; i < 15000; i++) {
            integers[i] = random.nextInt();
        }
        Method method = sortTemplate.getClass().getMethod(sortName, Comparable[].class);
        method.invoke(sortTemplate, (Object) integers);
        System.out.println(System.currentTimeMillis() - bef);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        select("selectSort");
        select("insertSort");
        select("shellSort");
        select("mergeDownSort");
        select("mergeUpSort");
        select("quickSort");
    }
}
