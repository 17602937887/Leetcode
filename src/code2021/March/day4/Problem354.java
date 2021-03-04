/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day4;

import sun.applet.Main;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 *
 * @author chenhang
 * @created 2021/3/4
 */
public class Problem354 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 10};
        System.out.println(new Problem354().binarySearch(arr, 0, 3, 0));
        System.out.println(new Problem354().binarySearch(arr, 0, 3, 1));
        System.out.println(new Problem354().binarySearch(arr, 0, 3, 2));
        System.out.println(new Problem354().binarySearch(arr, 0, 3, 3));
        System.out.println(new Problem354().maxEnvelopes(new int[][]{{1,1}}));
    }

    /**
     * 思维 + DP
     * 这个题 宽和高不能调换  所以固定其中一个变量走另一个变量的LIS即可
     * 但是 如果考虑 可以对调宽和高 又该如何考虑呢?
     * @param envelopes 入参
     * @return 最大存放信封数量
     */
    @SuppressWarnings("all")
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, ((o1, o2) -> {
            // 如果宽不同 则按宽升序
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            // 宽相同的情况 按长度降序
            } else {
                return o2[1] - o1[1];
            }
        }));
        // 然后找一个长的LIS即可 这边可以n^2 也可以用nlogn的做法
        // n^2做法
//        int maxLen = 0;
//        int[] dp = new int[envelopes.length];
//        for (int i = 0; i < envelopes.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (envelopes[j][1] < envelopes[i][1]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            maxLen = Math.max(maxLen, dp[i]);
//        }
//        return maxLen;

        // nlogn做法
        int[] dp = new int[envelopes.length + 1];
        int[] arr = new int[envelopes.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = envelopes[i][1];
        }
        int maxLen = 1;
        dp[maxLen] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > dp[maxLen]) {
                dp[++maxLen] = arr[i];
            } else {
                int index = binarySearch(dp, 0, maxLen, arr[i]);
                dp[index] = arr[i];
            }
        }
        return maxLen;
    }

    /**
     * 二分找到val插入的下标 ( 即数组中 >= val值的最左位置
     * @param arr 数组
     * @param l 左边界
     * @param r 右边界
     * @param val 待查找的值
     * @return 下标位置
     */
    public int binarySearch(int[] arr, int l, int r, int val) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] >= val) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}