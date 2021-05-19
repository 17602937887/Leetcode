/*
 * Copyright (c) 2021 hangcc.cn
 * All rights reserved.
 *
 */
package code2021.May.day19;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 16.02. 单词频率
 *
 * @author chenhang
 * @created 2021/5/19
 */
public class Problem16_02 {
}

class WordsFrequency {

    private Map<String, Integer> map = new HashMap<>();

    public WordsFrequency(String[] book) {
        for (String val : book) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
    }

    public int get(String word) {
        return map.get(word);
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */