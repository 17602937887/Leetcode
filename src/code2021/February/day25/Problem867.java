/*
 * Copyright (c) 2021 hangcc.cn
 * All rights reserved.
 *
 */
package code2021.February.day25;

/**
 * 867. 转置矩阵
 * 简单题 直接做即可
 * @author chenhang
 * @created 2021/2/25
 */
public class Problem867 {
    public int[][] transpose(int[][] matrix) {
        if (matrix == null) {
            return matrix;
        }
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] result = new int[y][x];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }
}