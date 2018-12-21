package com.example.demo1.view.pai_xu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.demo1.R;

/**
 * Created by yida on 2018/11/5.
 */
public class PaiXuActivity extends AppCompatActivity implements View.OnClickListener {

    private String mString = "";
    private TextView mTextView;
    private Button mButton;

    int[] arr = new int[]{5, 2, 9, 6, 7, 8, 55, 39, 98, 26, 75, 66};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paixu);
        mTextView = findViewById(R.id.textView3);
        mButton = findViewById(R.id.button2);

        mButton.setOnClickListener(this);

        setOnPai();
    }

    /**
     * 排序方法
     */
    private void setOnPai() {
        // maoPao(); // 冒泡排序
//        selectionSort(); // 选择排序
//        insertionSort();
//        shellSort();
        mergeSort();



    }

    /**
     * 归并排序 ( Merge Sort )
     *
     * 归并排序是建立在归并操作上的一种有效的排序算法, 该算法是采用分治法( Divide and Conquer ) 的一个非常经典的应用,
     * 将已有序的子序列合并, 得到完全有序的序列, 即先使每个子序列有序, 再使子序列段间有序,
     * 若将两个有序表合并成一个有序表, 称为 2- 路归井
     *
     *
     * 把长度为 n 的输入序列分成两个长度为 n/2 的子序列
     * 对这两个子序列分别采用归并排序
     * 将两个排序好的子序列合并成一个最终的排序序列
     */
    private void mergeSort() {

        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length-1, temp);
        printArr();
    }

    public void sort(int[] ar, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) / 2;
            sort(ar, left, mid, temp);              // 左边归并排序, 使得左子序列有序
            sort(ar, mid + 1, right, temp);   // 右边归并排序, 使得右子序列有序
            merge(ar, left, mid, right, temp);      // 将两个有序子数组合并操作
        }
    }

    private void merge(int ar[], int left, int mid, int right, int temp[]) {
        int i = left;       // 左序列指针
        int j = mid + 1;    // 右序列指针
        int t = 0;          // 临时数组指针
        while(i < mid && j <= right) {
            if (ar[i] <= ar[j]) {
                temp[t++] = ar[i++];
            } else {
                temp[t++] = ar[j++];
            }
        }
        // 将左边剩余元素填充进temp中
        while (i <= mid) {
            temp[t++] = ar[i++];
        }
        // 将右序列剩余元素填充进temp中
        while (j <= right) {
            temp[t++] = ar[j++];
        }
        t = 0;
        // 将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }

    }


    /**
     * 希尔排序
     *
     * 第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，
     * 它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
     */
    private void shellSort() {
//        int len = arr.length;
//        int temp;
//        int gap = 1;
//        while (gap < len / 3) {
//            gap = gap * 3 + 1;
//        }


//        int l, m, n, gap = arr.length;
//        for (gap = arr.length/2; gap > 0; gap /= 2) { //    /= :  它的作用是每次将当前的数字缩小 2倍, gap = gap / 2;
//            for (int l = 0; l < gap; l++) {
//                for (int m = l + gap; m < arr.length; m += gap) {
//                    if (arr[m] < arr[m - gap]) {
//                        int temp = arr[m];
//                        for (int n = m - gap; n >= 0 && arr[n] > temp; n -= gap) {
//                            arr[n + gap] = arr[n];
//                        }
//
//                    }
//                }
//            }
//
//        }


        if (arr == null || arr.length <= 1) {
            return;
        }
        // 增量
        int incrementNum = arr.length / 2;
        while (incrementNum >= 1) {
            for (int i = 0; i < arr.length; i++) {
                // 进行插入排序
                for (int j = i; j < arr.length - incrementNum; j += incrementNum) {
                    if (arr[j] > arr[j + incrementNum]) {
                        int temple = arr[j];
                        arr[j] = arr[j + incrementNum];
                        arr[j + incrementNum] = temple;
                    }
                }
            }
            // 设置新的增量
            incrementNum = incrementNum / 2;
        }

        printArr();
    }

    /**
     * 插入排序
     *
     * 插入排序 ( Insertion-Sort ) 的算法描述是一种简单直观的排序算法, 它的工作原理是通过构建有序序列,
     * 对于未排序数据, 在已排序序列中从后向前扫描, 找到相应位置并插入
     */
    private void insertionSort() {
        int len = arr.length;
        int preIndex, current;
        for (int i = 0; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        printArr();
    }


    /**
     * 选择排序
     *
     *选择排序(Selection-sort)是一种简单直观的排序算法。
     * 它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     *
     */
    private void selectionSort() {
        int len = arr.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) { // 寻找最小的值
                    minIndex = j;   // 保存最小数的索引
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
       printArr();
    }

    /**
     * 冒泡排序
     *
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，
     * 如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，
     * 也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     */
    private void maoPao() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
     printArr();
    }

    /**
     * 拼接数据
     */
    public void printArr() {
        String s = "";

        for (int num : arr) {
            s = num + "";
//            mString = s + ", " + mString;
            mString = mString + ", " + s;
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button2) {
            if (!mString.isEmpty()) {
                mTextView.setText(mString);
            }
        }
    }
}
