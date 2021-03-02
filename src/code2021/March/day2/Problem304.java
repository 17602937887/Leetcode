/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day2;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 *
 * @author chenhang
 * @created 2021/3/2
 */
public class Problem304 {
    public static void main(String[] args) {
        int[][] data = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}};
        NumMatrix numMatrix = new NumMatrix(data);
        System.out.println(numMatrix.sumRegion(0, 0, 1, 1));
    }
}

/**
 * 前缀和板子题 直接做即可
 */
class NumMatrix {

    private int[][] data;
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        this.data = matrix;
        sum = new int[matrix.length][matrix[0].length];
        // 初始化前缀和数组
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                if (i == 0 && j == 0) {
                    sum[i][j] = data[i][j];
                } else if(i == 0) {
                    sum[i][j] = sum[i][j - 1] + data[i][j];
                } else if (j == 0) {
                    sum[i][j] = sum[i - 1][j] + data[i][j];
                } else {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + data[i][j] - sum[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (data.length == 0 || data[0].length == 0) {
            return 0;
        }
        if (row1 == 0 && col1 == 0) {
            return sum[row2][col2];
        } else if(row1 == 0) {
            return sum[row2][col2] - sum[row2][col1 - 1];
        } else if(col1 == 0) {
            return sum[row2][col2] - sum[row1 - 1][col2];
        }
        return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */