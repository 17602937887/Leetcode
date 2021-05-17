/*
 * Copyright (c) 2021 hangcc.cn
 * All rights reserved.
 *
 */
package code2021.May.day17;

/**
 * 最长回文子串
 *
 * @author chenhang
 * @created 2021/5/17
 */
public class Problem5 {
}

class Solution {
    public String longestPalindrome(String s) {
        for (int len = s.length(); len >= 1; len--) {
            for (int start = 0; start + len <= s.length(); start++) {
                String subString = s.substring(start, start + len);
                if (checkPalindrome(subString)) {
                    return subString;
                }
            }
        }
        return null;
    }

    public boolean checkPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}