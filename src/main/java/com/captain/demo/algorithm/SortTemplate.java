package com.captain.demo.algorithm;

import java.lang.reflect.Array;

/**
 * @author Captain Wang
 * @time 2020/9/1
 */
public class SortTemplate<T extends Comparable<? super T>> {

    //归并排序辅助数组
    private T[] newComparables;

    public void selectSort(T[] comparables) {
        for (int i = 0; i < comparables.length; i++) {
            for (int j = i + 1; j < comparables.length; j++) {
                if (comparables[i].compareTo(comparables[j]) > 0) {
                    this.exchange(comparables, i, j);
                }
            }
        }
    }

    public void insertSort(T[] comparables) {
        for (int i = 1; i < comparables.length; i++) {
            //终止条件终止循环
            for (int j = i; j > 0 && comparables[j].compareTo(comparables[j - 1]) < 0; j--) {
                this.exchange(comparables, j, j - 1);
            }
        }
    }

    public void shellSort(T[] comparables) {
        int h = 1;
        while (h < comparables.length) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < comparables.length; i++) {
                for (int j = i; j >= h && comparables[j].compareTo(comparables[j - h]) < 0; j -= h) {
                    this.exchange(comparables, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    @SuppressWarnings("unchecked")
    public void mergeDownSort(T[] comparables) {
        newComparables = (T[]) Array.newInstance(Comparable.class, comparables.length);
        mergeDownSortLimit(comparables, 0, comparables.length - 1);
    }

    @SuppressWarnings("unchecked")
    public void mergeUpSort(T[] comparables) {
        int length = comparables.length;
        newComparables = (T[]) Array.newInstance(Comparable.class, length);
        for (int size = 1; size < length; size = size + size) {
            for (int start = 0; start < length - size; start += size + size) {
                merge(comparables, start, start + size - 1, Math.min(start + size + size - 1, length - 1));
            }
        }
    }

    private void mergeDownSortLimit(T[] comparables, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeDownSortLimit(comparables, left, middle);
        mergeDownSortLimit(comparables, middle + 1, right);
        merge(comparables, left, middle, right);
    }

    private void merge(T[] comparables, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        if (right + 1 - left >= 0) {
            System.arraycopy(comparables, left, newComparables, left, right + 1 - left);
        }
        for (int k = left; k <= right; k++) {
            if (i > middle) {
                comparables[k] = newComparables[j++];
            } else if (j > right) {
                comparables[k] = newComparables[i++];
            } else if (newComparables[j].compareTo(newComparables[i]) < 0) {
                comparables[k] = newComparables[j++];
            } else {
                comparables[k] = newComparables[i++];
            }
        }
    }


    private void exchange(T[] comparables, int i, int j) {
        T comparable = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = comparable;
    }

    private void show(T[] comparables) {
        for (T comparable : comparables) {
            System.out.print(comparable + " ");
        }
    }

}
