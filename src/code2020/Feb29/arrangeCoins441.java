package code2020.Feb29;

public class arrangeCoins441 {
    // 主要坑在了 累加溢出导致超时
    public int arrangeCoins(int n) {
        long sum = 0;
        for(int i = 1; ; i++){
            sum += i;
            if(sum > n)
                return i - 1;
        }
    }
}
