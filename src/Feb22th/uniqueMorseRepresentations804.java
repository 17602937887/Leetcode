package Feb22th;

import java.util.HashSet;

public class uniqueMorseRepresentations804 {
    // 按题意模拟即可 用HashSet判重
    public int uniqueMorseRepresentations(String[] words) {
        String[] s = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            StringBuilder buff = new StringBuilder();
            for(int j = 0; j < words[i].length(); j++){
                buff.append(s[words[i].charAt(j) - 'a']);
            }
            set.add(buff.toString());
        }
        return set.size();
    }
}
