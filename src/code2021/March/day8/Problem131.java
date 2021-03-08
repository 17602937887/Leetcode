/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day8;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 *
 * 跑了一下二进制枚举就过了
 * @author chenhang
 * @created 2021/3/8
 */
public class Problem131 {

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> partition = new Problem131().partition(s);
        for (List<String> item : partition) {
            System.out.println(item);
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int len = s.length();
        for (int i = 0; i < (1 << (len - 1)); i++) {
            int pre = 0;
            boolean flag = true;
            List<String> tmpList = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (((i >> j) & 1) == 1) {
                    String tmpStr = s.substring(pre, j + 1);
                    if (!isPalindrome(tmpStr)) {
                        flag = false;
                        break;
                    } else {
                        pre = j + 1;
                        tmpList.add(tmpStr);
                    }
                }
            }
            if (flag) {
                String substring = s.substring(pre);
                if (substring.length() == 0) {
                    result.add(tmpList);
                    // System.out.println("i = " + i + " list = " + tmpList);
                } else if (isPalindrome(substring)){
                    tmpList.add(substring);
                    result.add(tmpList);
                    // System.out.println("i = " + i + " list = " + tmpList);
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}