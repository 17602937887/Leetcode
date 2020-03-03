package Mar3th;

public class convertInteger {
    public static int convertInteger(int A, int B) {
        int ans = 0;
        for(int i = 0; i < 32 && (A != 0 || B != 0); i++){
            if((A & 1) != (B & 1))
                ans++;
            A >>= 1;
            B >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        convertInteger(29, 15);
    }
}
