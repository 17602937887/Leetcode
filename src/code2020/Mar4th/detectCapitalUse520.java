package code2020.Mar4th;

public class detectCapitalUse520 {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() == 0){
            return false;
        }
        if(word.equals(word.toLowerCase()) || word.equals(word.toUpperCase())){
            return true;
        }
        StringBuilder sb = new StringBuilder(word.toLowerCase());
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        if(sb.toString().equals(word))
            return true;
        return false;
    }
}
