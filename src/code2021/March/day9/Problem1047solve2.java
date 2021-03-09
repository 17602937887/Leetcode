/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day9;

import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * 用栈搞一下
 *
 * @author chenhang
 * @created 2021/3/9
 */
public class Problem1047solve2 {

    public static void main(String[] args) {
        String abbaca = new Problem1047solve2().removeDuplicates("abbaca");
        System.out.println(abbaca);
    }

    public String removeDuplicates(String S) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char nowChar = S.charAt(i);
            if (!stack.isEmpty() && S.charAt(stack.peek()) == nowChar) {
                stack.pop();
            } else {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(S.charAt(stack.pop()));
        }
        return sb.reverse().toString();
    }
}