package com.company;

public class Maze {
    private final int size = 9;
    private final int[][] map = new int[size][size];
    public static void main(String[] args) {

        Maze maze = new Maze();
        maze.initMap();
        maze.print();
        System.out.println("走出迷宫的路径：");
        maze.findPath(1, maze.size - 2);
        maze.print();
    }
    //0：没走过 1：墙 2：已走过 3：走过，但不通
    private boolean findPath(int row, int column) {
        if (row >= size || column >= size) {
            return false;
        }
        if (map[size - 2][size - 1] == 2) {
            return true;
        }
        else {
            if (map[row][column] == 0) {
                map[row][column] = 2;

                if (findPath(row, column + 1)) {
                    return true;
                }
                else if (findPath(row + 1, column)) {
                    return true;
                }
                else if (findPath(row, column - 1)) {
                    return true;
                }
                else if (findPath(row - 1, column)) {
                    return true;
                }
                else {
                    map[row][column] = 3;
                    return false;
                }
            }
            else {
                return false;
            }
        }

    }

    private void initMap() {
        for (int i = 0; i < size; i++) {
            map[0][i] = 1;
            map[size - 1][i] = 1;
        }
        for (int i = 0; i < size; i++) {
            map[i][0] = 1;
            map[i][size - 1] = 1;
        }

        map[2][1] = 1;
        map[2][2] = 1;
        map[4][4] = 1;
        map[4][5] = 1;
        map[4][6] = 1;
        map[4][7] = 1;
        map[size - 2][size - 1] = 0;

    }

    private void print() {
        for (int[] array:
                map) {
            for (int i:
                    array) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }

}
