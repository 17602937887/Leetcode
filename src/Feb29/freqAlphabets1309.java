package Feb29;

public class freqAlphabets1309 {
    public static String freqAlphabets(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int start = 0;
        while(start < s.length()){
            int val = (s.charAt(start) - '0');
            if(start + 1 < s.length()){
               val = val * 10 + (s.charAt(start + 1) - '0');
            }
            //代表以#结尾
            if(val <= 26 && start + 2 < s.length() && s.charAt(start + 2) == '#'){
                stringBuilder.append(Character.toString(val + 'a' - 1));
                start += 3;
            } else {
                stringBuilder.append(Character.toString(s.charAt(start) - '0' + 'a' - 1));
                start++;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
    }
}
