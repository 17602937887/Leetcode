/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day3;

/**
 * 338. 比特位计数
 *
 * @author chenhang
 * @created 2021/3/3
 */
public class Problem338 {
    /**
     * 简单dp 直接做即可
     * @param num 数值
     * @return 答案
     */
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        if (num == 0) {
            return dp;
        } if(num == 1) {
            dp[1] = 1;
        } else {
            dp[1] = 1;
            int pre = 0;
            for (int i = 2; i <= num; i++) {
                if (check(i)) {
                    dp[i] = 1;
                    pre = i;
                } else {
                    dp[i] = dp[pre] + dp[i - pre];
                }
            }
        }
        return dp;
    }

    /**
     * check给的参数是否是2的幂
     * @param n 入参
     * @return 结果
     */
    public boolean check(int n) {
        return (n & (n - 1)) == 0;
    }
}