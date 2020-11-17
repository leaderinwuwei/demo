package com.captain.demo.study.web;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Captain Wang
 * @time 2020/8/19
 */
public class Test {
    static void check(int a) {
        if (7 == a / 10 % 10 && a % 10 % 2 == 1) {
            System.out.println("就是你了" + a);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mRow = scanner.nextInt();
        int nLine = scanner.nextInt();
        if (10 < mRow && mRow < 1000 && 10 < nLine && nLine < 1000) {
            int[][] a = new int[mRow][nLine];
            int already = 0;
            int right = 0;
            int down = 0;
            int left = 0;
            int up = 0;
            int sm = 0;
            int sn = 0;
            int downFlag = nLine / 2;
            for (int i = 0; i < mRow * nLine; i++) {

                //向右转向
                if (sm == already && sn == already) {
                    right = 1;
                    down = 0;
                    left = 0;
                    up = 0;
                    sm = sm + 1;
                    a[sm][sn] = i + 1;
                    check(a[sm][sn]);
                    continue;
                }
                //向右
                if (sm < mRow - 1 - already && right == 1) {
                    sm = sm + 1;
                    a[sm][sn] = i + 1;
                    check(a[sm][sn]);
                    continue;
                }
                //向下转向
                if (sm == mRow - 1 - already && sn < downFlag && right == 1) {
                    right = 0;
                    down = 1;
                    left = 0;
                    up = 0;
                    sn = sn + 1;
                    a[sm][sn] = i + 1;
                    check(a[sm][sn]);
                    continue;
                }
                //向下
                if (sm == mRow - 1 - already && sn < nLine - 1 - already && down == 1) {
                    sn = sn + 1;
                    a[sm][sn] = i + 1;
                    check(a[sm][sn]);
                    continue;
                }
                //向左转向
                if (sm == mRow - 1 - already && sn == nLine - 1 - already && down == 1) {
                    down = 0;
                    left = 1;
                    up = 0;
                    sm = sm - 1;
                    a[sm][sn] = i + 1;
                    check(a[sm][sn]);
                    continue;
                }
                //向左
                if (sm > already && sn == nLine - 1 - already && left == 1) {
                    sm = sm - 1;
                    a[sm][sn] = i + 1;
                    check(a[sm][sn]);
                    continue;
                }
                //向上转向
                if (sm == already && sn == nLine - 1 - already && left == 1) {
                    left = 0;
                    up = 1;
                    sn = sn - 1;
                    a[sm][sn] = i + 1;
                    check(a[sm][sn]);
                    continue;
                }
                //向上
                if (sm == already && sn < nLine - 1 - already && up == 1) {
                    sn = sn - 1;
                    a[sm][sn] = i + 1;
                    check(a[sm][sn]);
                }


            }
        } else {
            int[][] b = {};
            System.out.print(Arrays.toString(b));
        }

    }
}
