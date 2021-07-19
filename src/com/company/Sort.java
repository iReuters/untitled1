package com.company;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int size = 5;
//        int[] arr = new int[size] ;
        int[] arr = new int[] {5, 1, 0, 4, 3};
//        for (int i = 0; i < size; i++) {
//            arr[i] = (int) (Math.random() * 1000);
//        }
        Sort sort = new Sort();
        long start = System.currentTimeMillis();
        //sort.bubbleSort(arr);
        sort.insertSort(arr);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0);
        System.out.println(Arrays.toString(arr));
        
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
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    private void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
