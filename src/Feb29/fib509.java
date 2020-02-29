package Feb29;

public class fib509 {
    public int fib(int N) {
        int[] a = new int[110];
        a[0] = 0;
        a[1] = 1;
        for(int i = 2; i <= N; i++){
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[N];
    }
}
