package Mar5th;

public class numSmallerByFrequency1170 {
    public static int fun(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        char min = s.charAt(0);
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) < min)
                min = s.charAt(i);
        }
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == min)
                ans++;
        }
        return ans;
    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] word = new int[words.length];
        for(int i = 0; i < words.length; i++){
            word[i] = fun(words[i]);
        }
        int[] a = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int val = fun(queries[i]);
            for(int j = 0; j < word.length; j++){
                if(val < word[j])
                    a[i]++;
            }
        }
        return a;
    }
}
