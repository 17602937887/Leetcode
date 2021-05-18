/*
 * Copyright (c) 2021 hangcc.cn
 * All rights reserved.
 *
 */
package code2021.May.day18;

import java.util.Stack;

/**
 * 946. 验证栈序列
 *
 * @author chenhang
 * @created 2021/5/18
 */
public class Problem946 {
    public static void main(String[] args) {
        new Solution1().validateStackSequences(new int[]{0, 2, 1}, new int[]{0, 1, 2});
    }
}

class Solution1 {
    /**
     * 根据入栈序列来判断出栈序列是否合理
     * [由于题目保证了值不重复、如果值重复 可能得跑多次 有一次满足即可]直接模拟即可
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int right = 0;
        for (int i = 0; i < popped.length; i++) {
            if (i == 0) {
                for (int j = 0; j < pushed.length; j++) {
                    // 在入栈序列中找到第一个出栈的位置、 然后左侧的代表入栈了 右侧的代表还未入栈
                    if (pushed[j] == popped[i]) {
                        right = j + 1;
                        break;
                    } else {
                        stack.push(pushed[j]);
                    }
                }
            } else {
                // 等于栈顶值
                if (!stack.isEmpty() && stack.peek() == popped[i]) {
                    stack.pop();
                // 不等于栈顶值 或者栈为空 则入栈
                } else {
                    while (right < pushed.length) {
                        // 等于未入栈的第一个值 则代表入栈后立即出栈
                        if (popped[i] == pushed[right]) {
                            right++;
                            break;
                        }
                        stack.push(pushed[right++]);

                    }
                }
            }
        }
        return stack.isEmpty() && right == pushed.length;
    }
}