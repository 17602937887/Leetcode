/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day6;

import java.util.Arrays;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 * 单调栈O(n)解决
 *
 * @author chenhang
 * @created 2021/3/6
 */
public class Problem496 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 4};
        int[] nums2 = new int[]{1, 2, 3, 4};
        int[] result = new Solution496().nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}

class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int[] map = new int[10010];
        Arrays.fill(map, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map[stack.pop()] = nums2[i];
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map[nums1[i]];
        }
        return result;
    }
}