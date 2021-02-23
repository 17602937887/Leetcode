package code2020.Feb21th;

public class validMountainArray941 {
    public boolean validMountainArray(int[] A) {
        // 如果数组为空 或者 < 3 则必然不能一升一降
        if(A == null || A.length == 0 || A.length < 3)
            return false;

        //开头或 结尾不满足条件 则为false
        if (A[0] > A[1] || A[A.length - 2] < A[A.length - 1]){
            return false;
        }
        // 找到k为第一个下降的点
        int k = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i] == A[i - 1]){
                return false;
            } else if(A[i] < A[i - 1]){
                k = i;
                break;
            }
        }

        // 如果k后面满足全部下降为true 否则为false
       for(int i = k; i < A.length; i++){
            if(A[i] >= A[i - 1])
                return false;
        }

        return true;
    }
}
