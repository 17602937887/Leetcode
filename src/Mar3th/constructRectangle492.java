package Mar3th;

public class constructRectangle492 {
    public int[] constructRectangle(int area) {
        int[] a = new int[2];
        for(int i = 1; i <= Math.sqrt(area); i++){
            if(area % i == 0){
                a[0] = area / i;
                a[1] = i;
            }
        }
        return a;
    }
}
