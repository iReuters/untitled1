package com.company;

public class SparseArray {
    public static void main(String[] args) {
        int[][] array = new int[5][6];
        array[2][3] = 5;
        array[3][5] = 2;
        array[1][3] = 3;
        array[1][4] = 8;
        showArray(array);
        System.out.println( );
        showArray(arrayToSparse(array));
        System.out.println();
        showArray(sparseToArray(arrayToSparse(array)));
    }

    public static int[][] arrayToSparse(int[][] array) {
        int count = 0;
        int num = 1;
        for (int[] i: array) {
            for (int j: i) {
                if (0 != j)
                    count++;
            }
        }
        int[][] sparseArray = new int[count + 1][3];
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = count;
        for (int i=0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (0 != array[i][j]) {
                    sparseArray[num][0] = i;
                    sparseArray[num][1] = j;
                    sparseArray[num][2] = array[i][j];
                    num++;
                }
            }
        }
        return sparseArray;
    }

    public static int[][] sparseToArray(int[][] sparseArray) {
        int height = sparseArray[0][0];
        int width = sparseArray[0][1];
        int[][] array = new int[height][width];
        for (int i = 1; i < sparseArray.length; i++) {
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return array;
    }

    public static void showArray(int[][] array) {
        for (int[] i: array) {
            for (int j: i) {
                System.out.printf("%d\t", j);
            }
            System.out.println();
        }
    }
}
