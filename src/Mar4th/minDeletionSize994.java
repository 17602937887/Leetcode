package Mar4th;

public class minDeletionSize994 {
    public int minDeletionSize(String[] A) {
        if(A == null || A.length == 0)
            return 0;
        int ans = 0;
        for(int j = 0; j < A[0].length(); j++){
            boolean flag = false;
            for(int i = 1; i < A.length; i++){
                if(A[i].charAt(j) < A[i - 1].charAt(j)){
                    flag = true;
                    break;
                }
            }
            if(flag)
                ans++;
        }
        return ans;
    }
}
