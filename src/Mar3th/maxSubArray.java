package Mar3th;

public class maxSubArray {
    public int maxSubArray(int[] nums) {
        final int INF = Integer.MAX_VALUE;
        int max = 0, tmp_max = 0;
        for(int i = 0; i < nums.length; i++){
            tmp_max += nums[i];
            if(tmp_max > max){
                max = tmp_max;
            }
            if (tmp_max < 0){
                tmp_max = 0;
            }
        }
        if(max == 0){
            max = -INF;
            for(int i = 0; i < nums.length; i++){
                max = Math.max(max, nums[i]);
            }
        }
        return max;
    }
}
