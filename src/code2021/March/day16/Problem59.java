/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day16;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 *
 * @author chenhang
 * @created 2021/3/16
 */
public class Problem59 {
    public static void main(String[] args) {
        int[][] arrs = new Solution().generateMatrix(3);
        for (int[] arr : arrs) {
            System.out.println(Arrays.toString(arr));
        }
    }
}

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        boolean[][] vis = new boolean[n][n];
        int[][] go = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int val = 1;
        int to = 0;
        int x = 0, y = 0;
        while (val <= n * n) {
            arr[x][y] = val++;
            vis[x][y] = true;
            int tmpX = x + go[to][0];
            int tmpY = y + go[to][1];
            if (checkEffective(tmpX, tmpY, vis)) {
                x = tmpX;
                y = tmpY;
            } else {
                to = (to + 1) % 4;
                x += go[to][0];
                y += go[to][1];
            }
        }
        return arr;
    }

    private boolean checkEffective(int x, int y, boolean[][] vis) {
        return x >= 0 && x < vis.length && y >= 0 && y < vis[0].length && !vis[x][y];
    }
}