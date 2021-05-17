/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day23;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 *
 * @author chenhang
 * @created 2021/3/23
 */
public class Problem239 {
    public static void main(String[] args) {
        new Solution().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
        if (nums.length < k || k == 0) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                priorityQueue.add(nums[i]);
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if (i >= k - 1) {
                res[left] = priorityQueue.peek();
                if (map.get(nums[left]) == 1) {
                    map.remove(nums[left]);
                    priorityQueue.remove(nums[left]);
                } else {
                    map.put(nums[left], map.get(nums[left]) - 1);
                }
                left++;
            }
        }
        return res;
    }
}