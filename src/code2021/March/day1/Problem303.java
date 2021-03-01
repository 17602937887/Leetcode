/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day1;

/**
 * 前缀和板子题
 *
 * @author chenhang
 * @created 2021/3/1
 */
public class Problem303 {

    private int[] nums;
    private int[] sum;

    public Problem303(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sum[j];
        } else {
            return sum[j] - sum[i - 1];
        }
    }
}