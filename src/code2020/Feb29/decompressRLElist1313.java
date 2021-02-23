package code2020.Feb29;

import java.util.ArrayList;

public class decompressRLElist1313 {
    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> integers = new ArrayList<>();
        for(int i = 0; i < nums.length; i += 2){
            for(int j = 0; j < nums[i]; j++){
                integers.add(nums[i + 1]);
            }
        }
        int[] a = new int[integers.size()];
        for(int i = 0; i < integers.size(); i++){
            a[i] = integers.get(i);
        }
        return a;
    }
}
