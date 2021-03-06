/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day6;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 *
 * @author chenhang
 * @created 2021/3/6
 */
public class Problem506 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 4};
        Solution solution = new Solution();
        arr = solution.nextGreaterElements(arr);
        System.out.println(Arrays.toString(arr));
    }
}

/**
 * 1. 直接做想不到好的解决方案，暴力冲了一发就过了？？？ 离谱 这讲道理要卡掉暴力啊
 * <p>
 * 2.题解是单调栈. 确实 单调栈是解决(第一次、最近位置)的大多数情况的套路
 */
@SuppressWarnings("all")
class Solution {
    // 暴力 n^2
//    public int[] nextGreaterElements(int[] nums) {
//        int len = nums.length;
//        int[] result = new int[len];
//        for (int i = 0; i < len; i++) {
//            boolean flag = false;
//            for (int j = i + 1; j % len != i; j++) {
//                if (nums[j % len] > nums[i]) {
//                    flag = true;
//                    result[i] = nums[j % len];
//                    break;
//                }
//            }
//            if (!flag) {
//                result[i] = -1;
//            }
//        }
//        return result;
//    }

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * len - 1; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek() % len]) {
                result[stack.pop() % len] = nums[i % len];
            }
            stack.push(i % len);
        }
        return result;
    }
}