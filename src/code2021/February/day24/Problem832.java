/*
 * Copyright (c) 2021 hangcc.cn
 * All rights reserved.
 *
 */
package code2021.February.day24;

/**
 * 832. 翻转图像
 *
 * @author chenhang
 * @created 2021/2/24
 */
public class Problem832 {
    // 没啥难度 直接写即可
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        for (int i = 0; i < A.length; i++) {
            int l = 0, r = A[i].length - 1;
            while (l < r) {
                A[i][l] ^= A[i][r];
                A[i][r] ^= A[i][l];
                A[i][l] ^= A[i][r];
                l++;
                r--;
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = 1 - A[i][j];
            }
        }
        return A;
    }
}