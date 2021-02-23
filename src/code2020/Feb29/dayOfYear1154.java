package code2020.Feb29;

public class dayOfYear1154 {
    // 提取日期 然后判断是否是闰年 是闰年且月份大于2月则补上一天 否则就直接累加前面所有月的天数 加上当前天即可
    public  static int dayOfYear(String date) {
        int[] ans = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = 0, month = 0, day = 0;
        String[] split = date.split("-");
        year = Integer.parseInt(split[0]);
        month = Integer.parseInt(split[1]);
        day = Integer.parseInt(split[2]);
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
