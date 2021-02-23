package code2020.Feb29;

import java.util.ArrayList;
import java.util.List;

public class commonChars1002 {
    // 纪录每个String的字符个数 然后曲min添加即可
    public List<String> commonChars(String[] A) {
        List<String> strings = new ArrayList<>();
        int[][] cnt = new int[A.length][256];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length(); j++){
                cnt[i][A[i].charAt(j)]++;
            }
        }
        for(int i = 'a'; i <= 'z'; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < A.length; j++){
                min = Math.min(min, cnt[j][i]);
            }
            if(min != 0){
                for(int k = 0; k < min; k++){
                    strings.add(Character.toString((char) i));
                }
            }
        }
        return strings;
    }
}
