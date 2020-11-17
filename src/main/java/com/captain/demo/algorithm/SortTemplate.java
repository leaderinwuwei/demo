package com.captain.demo.algorithm;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * @author Captain Wang
 * @time 2020/9/1
 */
public class SortTemplate<T extends Comparable<? super T>> {

    //归并排序辅助数组
    private T[] newMergeComparables;

    public void selectSort(T[] comparables) {
        for (int i = 0; i < comparables.length; i++) {
            for (int j = i + 1; j < comparables.length; j++) {
                if (comparables[i].compareTo(comparables[j]) > 0) {
                    this.exchange(comparables, i, j);
                }
            }
        }
        System.out.println(isSorted(comparables));
    }

    public void insertSort(T[] comparables) {
        for (int i = 1; i < comparables.length; i++) {
            //终止条件终止循环
            for (int j = i; j > 0 && comparables[j].compareTo(comparables[j - 1]) < 0; j--) {
                this.exchange(comparables, j, j - 1);
            }
        }
        System.out.println(isSorted(comparables));
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
        System.out.println(isSorted(comparables));
    }

    @SuppressWarnings("unchecked")
    public void mergeDownSort(T[] comparables) {
        newMergeComparables = (T[]) Array.newInstance(Comparable.class, comparables.length);
        mergeDownSortLimit(comparables, 0, comparables.length - 1);
        System.out.println(isSorted(comparables));
    }

    @SuppressWarnings("unchecked")
    public void mergeUpSort(T[] comparables) {
        int length = comparables.length;
        newMergeComparables = (T[]) Array.newInstance(Comparable.class, length);
        for (int size = 1; size < length; size = size + size) {
            for (int start = 0; start < length - size; start += size + size) {
                merge(comparables, start, start + size - 1, Math.min(start + size + size - 1, length - 1));
            }
        }
        System.out.println(isSorted(comparables));
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
            System.arraycopy(comparables, left, newMergeComparables, left, right + 1 - left);
        }
        for (int k = left; k <= right; k++) {
            if (i > middle) {
                comparables[k] = newMergeComparables[j++];
            } else if (j > right) {
                comparables[k] = newMergeComparables[i++];
            } else if (newMergeComparables[j].compareTo(newMergeComparables[i]) < 0) {
                comparables[k] = newMergeComparables[j++];
            } else {
                comparables[k] = newMergeComparables[i++];
            }
        }
    }

    public void quickSort(T[] comparables) {
        quickSort(comparables, 0, comparables.length - 1);
        System.out.println(isSorted(comparables));
    }

    private void quickSort(T[] comparables, int left, int right) {
        if (right > left) {
            int pivotIndex = partition(comparables, left, right);
            quickSort(comparables, left, pivotIndex - 1);
            quickSort(comparables, pivotIndex + 1, right);
        }
    }

    private int partition(T[] comparables, int left, int right) {
        T pivotValue = comparables[left];
        while (left < right) {
            while (left < right && comparables[right].compareTo(pivotValue) >= 0) {
                right--;
            }
            comparables[left] = comparables[right];
            while (left < right && comparables[left].compareTo(pivotValue) <= 0) {
                left++;
            }
            comparables[right] = comparables[left];
        }
        comparables[left] = pivotValue;
        return left;
    }

    private void exchange(T[] comparables, int i, int j) {
        T comparable = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = comparable;
    }

    private void show(T[] comparables) {
        for (T comparable : comparables) {
            System.out.print(comparable + "\n");
        }
    }

    private boolean isSorted(T[] comparables) {
        for (int i = 1; i < comparables.length; i++) {
            if (comparables[i].compareTo(comparables[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

}
