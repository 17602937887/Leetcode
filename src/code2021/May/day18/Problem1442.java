/*
 * Copyright (c) 2021 hangcc.cn
 * All rights reserved.
 *
 */
package code2021.May.day18;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 *
 * @author chenhang
 * @created 2021/5/18
 */
public class Problem1442 {
}

class Solution {
    /**
     * a = arr[i] ^ arr[i + 1] ^ ..... arr[j - 1]
     * b = arr[j] ^ arr[j + 1] ^ ..... arr[k]
     * 其实就是找对符合 i ~ j - 1 异或值 等于 j ~ k的异或值的数量
     * 1、现想法是arr.length < 300 那么 n ^ 3的复杂度也是可以接受的、 但是每次计算一串一串异或又会有O(n)的复杂度 整体就变成了 n ^ 4的复杂度了
     * 考虑可以预处理一个二维数组 代表i到j的异或值 这样 询问就变为了O(1)了
     *
     * @param arr
     * @return
     */
    public int countTriplets(int[] arr) {
        int ans = 0;
        int len = arr.length;
        int[][] val = new int[len][len];
        // 预处理异或数组
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                // 如果长度为1 则异或值为自身 否则为val[i][j - 1] ^ arr[j];
                if (i == j) {
                    val[i][j] = arr[i];
                } else {
                    val[i][j] = val[i][j - 1] ^ arr[j];
                }
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j; k < len; k++) {
                    if (val[i][j - 1] == val[j][k]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 看了题解、可以用前缀和搞一下、这样可以优化掉一层 变为N^2
     *
     * @param arr
     * @return
     */
    public int betterCountTriplets(int[] arr) {
        int len = arr.length;
        int ans = 0;
        // val[i] 代表前i项的异或值是多少
        int[] val = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            val[i] = val[i - 1] ^ arr[i - 1];
        }
        // val[i] ^ val[j] => (arr[0] ^ arr[1] ^ arr[2] .... ^ arr[i - 1]) ^ (arr[0] ^ arr[1] ^ arr[2] .... ^ arr[i - 1] ^ arr[i] ^ ... arr[j - 1])
        // => arr[i] ^ arr[i + 1] ^ .... ^ arr[j - 1]
        // a = arr[i] ^ arr[i + 1] ^ ..... arr[j - 1] = val[i] ^ val[j]
        // b = arr[j] ^ arr[j + 1] ^ ..... arr[k] = val[j] ^ val[k + 1]
        // 考虑到都有一个val[j]、 所以当 val[i] = val[k + 1]的时候、所有的val[j]都是满足的
        for (int i = 0; i < len; i++) {
            for (int k = i + 1; k < len; k++) {
                for (int j = i + 1; j <= k; j++) {
                    if (val[i] == val[k + 1]) {
                        ans += (k - j + 1);
                        break;
                    } else if ((val[i] ^ val[j]) == (val[j] ^ val[k + 1])) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public int better2CountTriplets(int[] arr) {
        int len = arr.length;
        int ans = 0;
        // val[i] 代表前i项的异或值是多少
        int[] val = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            val[i] = val[i - 1] ^ arr[i - 1];
        }
        // val[i] ^ val[j] => (arr[0] ^ arr[1] ^ arr[2] .... ^ arr[i - 1]) ^ (arr[0] ^ arr[1] ^ arr[2] .... ^ arr[i - 1] ^ arr[i] ^ ... arr[j - 1])
        // => arr[i] ^ arr[i + 1] ^ .... ^ arr[j - 1]
        // a = arr[i] ^ arr[i + 1] ^ ..... arr[j - 1] = val[i] ^ val[j]
        // b = arr[j] ^ arr[j + 1] ^ ..... arr[k] = val[j] ^ val[k + 1]
        // 考虑到都有一个val[j]、 所以当 val[i] = val[k + 1]的时候、所有的val[j]都是满足的
        for (int i = 0; i < len; i++) {
            for (int k = i + 1; k < len; k++) {
                // 这里可以直接把j扔掉  因为对于 val[i] ^ val[j] == val[j] ^ val[k + 1]  对于同一个val[j]可以扔掉
                // 反证一下 如果a, b不同 然后都异或 c 得到相同的d。  但d ^ c是定值 所以a、b必定相同。
                if (val[i] == val[k + 1]) {
                    ans += (k - i);
                }
            }
        }
        return ans;
    }
}