package Feb29;

public class dayOfYear1154 {
    // 提取日期 然后判断是否是闰年 是闰年且月份大于2月则补上一天 否则就直接累加前面所有月的天数 加上当前天即可
    public  static int dayOfYear(String date) {
        int[] ans = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = 0, month = 0, day = 0;
        for(int i = 0; i < 4; i++){
            year = year * 10 + (date.charAt(i) - '0');
        }
        for(int i = 5; i < 7; i++){
            month = month * 10 + (date.charAt(i) - '0');
        }
        for(int i = 8; i < 10; i++){
            day = day * 10 + (date.charAt(i) - '0');
        }
        int cnt = 0;
        if((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && (month > 2)){
            cnt++;
        }
        for(int i = 1; i < month; i++){
            cnt += ans[i];
        }
        cnt += day;
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(dayOfYear("2016-02-29"));
    }
}
