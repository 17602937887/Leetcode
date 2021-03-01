/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day1;

/**
 * 直接做即可
 *
 * @author chenhang
 * @created 2021/3/1
 */
public class Problem23 {
    /**
     * 一般做法
     * @param nums
     * @param val
     * @return
     */
    @SuppressWarnings("all")
//    public int removeElement(int[] nums, int val) {
//        int findIndex = 0;
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == val) {
//                findIndex = Math.max(findIndex, i + 1);
//                for (int j = findIndex; j < nums.length; j++) {
//                    if (nums[j] != val) {
//                        nums[i] ^= nums[j];
//                        nums[j] ^= nums[i];
//                        nums[i] ^= nums[j];
//                        break;
//                    }
//                }
//            }
//        }
//        for (int num : nums) {
//            if (num != val) {
//                count++;
//            }
//        }
//        return count;
//    }

    /**
     * 优化
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }
}