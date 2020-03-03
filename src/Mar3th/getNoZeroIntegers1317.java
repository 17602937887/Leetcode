package Mar3th;

public class getNoZeroIntegers1317 {

    public static boolean check(int n){
        while(n != 0){
            if(n % 10 == 0)
                return false;
            n /=  10;
        }
        return true;
    }

    public int[] getNoZeroIntegers(int n) {
        int[] a = new int[2];
        for(int i = 1; i < n - 1; i++){
            if(check(i) && check(n - i)){
                a[0] = i;
                a[1] = n - i;
                return a;
            }
        }
        return a;
    }
}
