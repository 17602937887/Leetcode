package Feb21th;

public class validPalindrome680 {
    // 删除一个和增加一个是一样的操作
    // 所以遇到不等的 判断剩下的两个字串是否 回文即可
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s.substring(l, r)) || isPalindrome(s.substring(l + 1, r + 1));
            }
            l++;
            r--;
        }
        return true;
    }
}
