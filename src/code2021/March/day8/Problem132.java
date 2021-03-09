/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 132. 分割回文串 II
 *
 * 跑了一下二进制枚举就过了
 * @author chenhang
 * @created 2021/3/8
 */
public class Problem132 {

    public static void main(String[] args) {
        String s = "leet";
        System.out.println(new Problem132().minCut(s));;
    }

    public int minCut(String s) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < (1 << 12); i++) {
            int count = count(i);
            if (map.get(count) == null) {
                map.put(count, new ArrayList<>());
            }
            map.get(count).add(i);
        }
        int len = s.length();
        for (int i = 0; i < 12; i++) {
            for (Integer val : map.get(i)) {
                int pre = 0;
                boolean flag = true;
                for (int j = 0; j < len; j++) {
                    if (((val >> j) & 1) == 1) {
                        String tmpStr = s.substring(pre, j + 1);
                        if (!isPalindrome(tmpStr)) {
                            flag = false;
                            break;
                        } else {
                            pre = j + 1;
                        }
                    }
                }
                if (flag) {
                    String substring = s.substring(pre);
                    if (substring.length() == 0) {
                        return count(i);
                    } else if (isPalindrome(substring)){
                        return count(i);
                    }
                }
            }
        }
        return 0;
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

    public int count(int n) {
        int ans = 0;
        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }
}