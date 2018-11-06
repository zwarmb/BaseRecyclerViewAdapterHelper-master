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
        insertionSort();

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
