package Feb21th;

public class isPalindrome125 {
    // 全部转小写 后 双指针判断即可

    public static boolean check(char s){
        return (s >= 'a' && s <= 'z') || (s >= '0' && s <= '9');
    }

    public  boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(!check(s.charAt(l))){
                l++;
            } else if(!check(s.charAt(r))){
                r--;
            } else{
                if(s.charAt(l) != s.charAt(r)){
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }
}
