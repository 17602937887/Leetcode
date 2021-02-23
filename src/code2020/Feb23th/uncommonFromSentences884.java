package code2020.Feb23th;

import java.util.ArrayList;
import java.util.HashMap;

public class uncommonFromSentences884 {
    // 定义两个HashMap 纪录每个单词出现的次数 当且仅当再当前句子中出现一次 而且再另一个句子中没出现 将其加入String数组;
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> ansA = new HashMap<>();
        HashMap<String, Integer> ansB = new HashMap<>();
        // 因为以空格为分隔 所以可以给每一个句子后面加一个空格 方便处理
        A = A + " ";
        // 还存在单词则不断添加
        while(A.indexOf(" ") > 0){
            // 截取出来每一个单词
            String word = A.substring(0, A.indexOf(" "));
            if(ansA.containsKey(word)){
                ansA.put(word, ansA.get(word) + 1);
            } else {
                ansA.put(word, 1);
            }
            // 更新句子
            if(A.indexOf(" ") != A.lastIndexOf(" ")){
                A = A.substring(A.indexOf(" ") + 1);
            } else {
                break;
            }
        }
        B = B + " ";
        // 还存在单词则不断添加
        while(B.indexOf(" ") > 0){
            // 截取出来每一个单词
            String word = B.substring(0, B.indexOf(" "));
            if(ansB.containsKey(word)){
                ansB.put(word, ansB.get(word) + 1);
            } else {
                ansB.put(word, 1);
            }
            // 更新句子
            if(B.indexOf(" ") != B.lastIndexOf(" ")){
                B = B.substring(B.indexOf(" ") + 1);
            } else {
                break;
            }
        }
        ArrayList<String> cnt = new ArrayList<>();
        for(String keyA : ansA.keySet()){
            if(ansA.get(keyA) == 1 && !ansB.containsKey(keyA)){
                cnt.add(keyA);
            }
        }
        for(String keyB : ansB.keySet()){
            if(ansB.get(keyB) == 1 && !ansA.containsKey(keyB)){
                cnt.add(keyB);
            }
        }
        String[] str = new String[cnt.size()];
        for(int i = 0; i < str.length; i++){
            str[i] = cnt.get(i);
        }
        return str;
    }
}
