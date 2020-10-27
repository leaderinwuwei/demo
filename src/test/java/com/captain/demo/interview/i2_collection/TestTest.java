package com.captain.demo.interview.i2_collection;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Captain Wang
 * @time 2020/9/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTest {

    @Test
    public void binarySort() {
        Object[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int lo = 0;
        for (int start = 1; start < a.length; start++) {
            Comparable pivot = (Comparable) a[start];

            int left = lo;
            int right = start;
            while (left < right) {
                // 二分插入排序获取中值
                int mid = (left + right) >>> 1;
                if (pivot.compareTo(a[mid]) < 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int n = start - left;
            switch (n) {
                case 2:
                    a[left + 2] = a[left + 1];
                case 1:
                    a[left + 1] = a[left];
                    break;
                default:
                    System.arraycopy(a, left, a, left + 1, n);
            }
            a[left] = pivot;
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    @Test
    public void dddd() {
        int i = 1;
        if (i == 1) {
            System.out.println(1);
        }else if (i > 0) {
            System.out.println(2);
        }else {
            System.out.println(3);
        }
    }

    @Test
    public void aaa() {
        long bb = 0,cc = 0,dd = 0;
        int cyl = 100000;
        int size = 10;
        for (int j = 0;j<cyl;j++) {
            List<Integer> aaa = new ArrayList<>();
            List<Integer> bbb = new ArrayList<>();
            List<Integer> ccc = new ArrayList<>();
            List<Integer> ddd = new ArrayList<>();
            for (int i = 0;i<size;i++) {
                aaa.add(RandomUtils.nextInt());
            }
            long cur = System.currentTimeMillis();
            for (int i = 0;i<size;i++) {
                bbb.add(aaa.get(i).hashCode() % 16);
            }
            long b = System.currentTimeMillis() - cur;
            bb = bb+ b;
            for (int i = 0;i<size;i++) {
                ccc.add(aaa.get(i).hashCode() & 15);
            }
            long c = System.currentTimeMillis() - b - cur;
            cc = cc + c;
            for (int i = 0;i<size;i++) {
                ddd.add((aaa.get(i).hashCode() ^ (16 >>> 16)) & 15);
            }
            long d = System.currentTimeMillis() - c - b - cur;
            dd = dd + d;
        }
        System.out.println("结果是取模使用{"+bb/cyl+"}按位与使用{"+cc/cyl+"}异或按位与{"+dd/cyl+"}");
        System.out.println("结果是取模使用{"+bb+"}按位与使用{"+cc+"}异或按位与{"+dd+"}");

    }

}