/*
 * Copyright (c) 2021 hangcc.cn
 * All rights reserved.
 *
 */
package code2021.February.day23;

import java.util.ArrayList;
import java.util.List;

/**
 * 在这里编写类的功能描述
 *
 * @author chenhang
 * @created 2021/2/23
 */
public class problem1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 前缀和数组 只保留为暴躁时期的用户和
        int[] sum = new int[customers.length];
        // 计算非暴躁时期的用户总和
        int notGrumpySumVal = 0;
        for (int i = 0; i < customers.length; i++) {
            // 老板为暴躁时期
            if (grumpy[i] == 1) {
                if (i == 0) {
                    sum[i] = customers[i];
                } else {
                    sum[i] = sum[i - 1] + customers[i];
                }
            } else {
                sum[i] = (i == 0) ? 0 : sum[i - 1];
                notGrumpySumVal += customers[i];
            }
        }
        // 存储老板为暴躁时期的下标值 后续二分
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 1) {
                arr.add(i);
            }
        }
        // 返回的结果值
        int result = notGrumpySumVal;
        // 跑每一个暴躁值 作为起点 给到x作为步长 二分寻找最大值
        for (int i = 0; i < arr.size(); i++) {
            int maxIndex = findMaxIndex(arr.get(i), X, arr);
            int grumpyVal = (i == 0) ? sum[arr.get(maxIndex)] : sum[arr.get(maxIndex)] - sum[arr.get(i) - 1];
            result = Math.max(result, notGrumpySumVal + grumpyVal);
        }
        return result;
    }

    public int findMaxIndex(int start, int step, List<Integer> arr) {
        // 以start为起点 step为步长 可以扩展到的最大下标 找到小于等于此下标的最右位置即为我们寻找的值
        int val = start + step - 1;
        int l = 0, r = arr.size() - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (arr.get(mid) <= val) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] customers = new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy = new int[]{0,1,0,1,0,1,0,1};
        int x = 3;
        int i = new problem1052().maxSatisfied(customers, grumpy, x);
        System.out.println(i);
    }
}