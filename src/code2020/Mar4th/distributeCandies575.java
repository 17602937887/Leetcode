package code2020.Mar4th;

import java.util.HashSet;

public class distributeCandies575 {
    public int distributeCandies(int[] candies) {
        int k = candies.length / 2;
        HashSet<Integer> a = new HashSet<>();
        for(int i = 0; i < candies.length; i++){
            a.add(candies[i]);
        }
        if(a.size() >= k){
            return k;
        } else {
            return a.size();
        }
    }
}
