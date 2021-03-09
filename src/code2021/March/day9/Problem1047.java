/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day9;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * 暴力跑一下就过了
 *
 * @author chenhang
 * @created 2021/3/9
 */
public class Problem1047 {

    public static void main(String[] args) {
        String abbaca = new Problem1047().removeDuplicates("abbaca");
        System.out.println(abbaca);
    }

    public String removeDuplicates(String S) {
        while (!checkNoHasDuplicates(S)) {
            char preChar = '#';
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                char nowChar = S.charAt(i);
                if (nowChar == preChar) {
                    sb.deleteCharAt(sb.length() - 1);
                    if (sb.length() == 0) {
                        preChar = '#';
                    } else {
                        preChar = sb.charAt(sb.length() - 1);
                    }
                } else {
                    sb.append(nowChar);
                    preChar = nowChar;
                }
            }
            S = sb.toString();
        }
        return S;
    }

    public boolean checkNoHasDuplicates(String str) {
        if (str.length() <= 1) {
            return true;
        }
        char preChar = '#';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == preChar) {
                return false;
            } else {
                preChar = str.charAt(i);
            }
        }
        return true;
    }
}