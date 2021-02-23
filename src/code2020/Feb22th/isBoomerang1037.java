package code2020.Feb22th;

public class isBoomerang1037 {
    // 首先确保三个点不重叠, 然后判断两条直线的斜率是否相等即可 出发可能有精度误差 改乘法做
    public boolean isBoomerang(int[][] points) {
        // 循环走 第一个点
        for(int i = 0; i < 3; i++){
            // 循环走第二个点
            for(int j = i + 1; j < 3; j++){
                // 存在点重叠 直接返回 false;
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]){
                    return false;
                }
            }
        }

        // 设三个点为a,b,c. 如果 (by - ay) / (bx - ax) == (cy - by) / (cx - bx) 则代表在一条直线上;
        return (points[1][1] - points[0][1]) * (points[2][0] - points[1][0]) == (points[2][1] - points[1][1]) * (points[1][0] - points[0][0]);
    }
}
