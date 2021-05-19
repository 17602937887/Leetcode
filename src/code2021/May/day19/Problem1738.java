/*
 * Copyright (c) 2021 hangcc.cn
 * All rights reserved.
 *
 */
package code2021.May.day19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1738. 找出第 K 大的异或坐标值
 *
 * @author chenhang
 * @created 2021/5/19
 */
public class Problem1738 {
}

class Solution {
    /**
     * 思路 数据范围不是很大 只有1000 所有N ^ 2的复杂度可以通过
     * 那么可以考虑类似于二维前缀和 搞出一个二维异或合数组  然后扔到一个数组中、可以O(nlogn)求topK 或者O(n)求topK
     * @param matrix
     * @param k
     * @return
     */
    public int kthLargestValue(int[][] matrix, int k) {
        // 个人习惯 n表示行 m表示列
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] val = new int[n][m];
        List<Integer> arr = new ArrayList<>(n * m);
        // 预处理数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    val[i][j] = matrix[i][j];
                } else if (i == 0) {
                    val[i][j] = val[i][j - 1] ^ matrix[i][j];
                } else if (j == 0) {
                    val[i][j] = val[i - 1][j] ^ matrix[i][j];
                } else {
                    // 这里类似于容斥 把多异或的补回去
                    val[i][j] = val[i - 1][j] ^ val[i][j - 1] ^ val[i - 1][j - 1] ^ matrix[i][j];
                }
                arr.add(val[i][j]);
            }
        }
        // 降序
        arr.sort((o1, o2) -> o2 - o1);
        return arr.get(k - 1);
    }
}