package code2020.Feb21th;

import java.util.ArrayList;

public class isUgly263 {
    // 找出num的因子 判断最大素因子是否大于5
    public boolean isUgly(int num) {
        // 小于1肯定不成立
        if (num < 1)
            return false;
        //存储num的所有素因子
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            // 某个素因子大于5直接结束
            if (i > 5)
                return false;
            if (num % i == 0) {
                a.add(i);
                while (num % i == 0) {
                    num /= i;
                }
            }
        }
        // 最后的一个可能素因子
        if (num > 1)
            a.add(num);
        int Max = 0;
        for (int i = 0; i < a.size(); i++) {
            Max = Math.max(Max, a.get(i));
        }
        if (Max > 5)
            return false;
        return true;
    }
}
