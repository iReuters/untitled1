package com.company;

public class EightQueen {
    private final int MAX = 17;
    private int count = 0;
    private final int[] map = new int[MAX];

    public static void main(String[] args) {
        EightQueen queen = new EightQueen();
        queen.check(0);
        System.out.println(queen.count);
    }

    private void check(int n) {
        if (n == MAX) {
            count++;
            print();
            return;
        }

        for (int i = 0; i < MAX; i++) {
            map[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (map[i] == map[n] || Math.abs(i - n) == Math.abs(map[i] - map[n])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (int i :
                map) {
            System.out.printf("%d ", i + 1);
        }
        System.out.println();
    }

}

