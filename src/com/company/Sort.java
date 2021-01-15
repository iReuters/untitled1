package com.company;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int size = 80000;
        int[] arr = new int[size] ;
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        Sort sort = new Sort();
        long start = System.currentTimeMillis();
        sort.bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0);

    }

    private void bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
            flag = false;
        }
    }

    private void selectSort(int[] arr) {

    }

}
