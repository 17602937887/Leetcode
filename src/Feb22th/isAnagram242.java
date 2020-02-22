package Feb22th;

public class isAnagram242 {
    // 存储每个ASCII码出现的次数, 遍历第二个不够则返回false 否则返回true
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null && t != null) return false;
        if(s != null && t == null) return false;
        if(s.length() != t.length()) return false;
        int[] ans = new int[256];
        for(int i = 0; i < s.length(); i++){
            ans[s.charAt(i)]++;
        }
        for(int i = 0; i < t.length(); i++){
            if(--ans[t.charAt(i)] < 0){
                return false;
            }
        }
        return true;
    }
}
