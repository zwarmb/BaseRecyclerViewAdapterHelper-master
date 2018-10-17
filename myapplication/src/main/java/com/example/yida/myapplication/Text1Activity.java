package com.example.yida.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yida on 2018/9/5.
 */

class Text1Activity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text1);






    }


    /**
     * 插入排序 时间复杂度o(N^2)
     * @param a
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a) {
        for (int i = 0; i < a.length; i++) {
            AnyType temp = a[i];
            int j = i - 1;
            while(j >= 0 && temp.compareTo(a[i]) < 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }


    /**
     * 二分插入排序 时间复杂度O(N^2) 因为插入排序的前i - 1个元素是排好序的
     * 所有将第i个元素插入到前面查到元素的时候 可以用二分查找法
     * @param a
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>> void BInsertSort(AnyType[] a) {
        for (int i = 0; i < a.length; i++) {
            int low = 0;
            AnyType temp = a[i];
            int high = i - 1;
            int position = 0;
            // 二分找不到时  low 的位置是大于key的最小元素, high是小于key的最大元素
            while (low <= high) {
                int mid = (low + high) / 2;
                if (a[mid].compareTo(temp) < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
                position = high;
                for (int j = i; j > position && j > 0; j--) {
                    a[j] = a[j - 1];
                }
                a[position + 1] = temp;
            }
        }
    }


    /**
     * 希尔排序 时间复杂度 (N^2) 利用增量序列 对用增量分组得到的序列进行插入排序
     * @param a
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>> void shellSort(AnyType[] a) {
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < a.length; j+= gap) {
                    AnyType temp = a[j];
                    if (temp.compareTo(a[j - gap]) < 0) {
                        int k = j - gap;
                        while (k >= 0 && a[k].compareTo(temp) > 0) {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = temp;
                    }
                }
            }
        }
    }
}
