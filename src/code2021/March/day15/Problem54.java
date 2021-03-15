/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * @author chenhang
 * @created 2021/3/15
 */
public class Problem54 {
    public static void main(String[] args) {
        List<Integer> integers = new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(integers);
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }
        // 是否访问过
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        // 右 下 左 上 方向
        int[][] go = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // result
        List<Integer> result = new ArrayList<>();
        // 控制方向
        int to = 0;
        // 起始点
        int x = 0, y = 0;
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            result.add(matrix[x][y]);
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
        return result;
    }

    /**
     * 判断这个点是否是没有访问过 且 没有出界
     * @return
     */
    private boolean checkEffective(int x, int y, boolean[][] vis) {
        int lenX = vis.length;
        int lenY = vis[0].length;
        return x >= 0 && x < lenX && y >= 0 && y < lenY && !vis[x][y];
    }
}