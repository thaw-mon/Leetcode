package August.day05;

//import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ：149. 直线上最多的点数
 * @Data: 19/8/10
 * @题目描述： 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * @题目地址： https://leetcode-cn.com/problems/max-points-on-a-line/
 * @示例1: ######
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * @示例2: ###
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 **/

public class MaxPointsOnLine {

    public static void main(String[] args) {
        int[][] point = new int[3][2];
        point[0][0] = 1;
        point[0][1] = 1;
        point[1][0] = 2;
        point[1][1] = 2;
        point[2][0] = 3;
        point[2][1] = 3;
//        point[3][0] = 1;
//        point[3][1] = 2;
        System.out.println(new MaxPointsOnLine().maxPoints(point));

        Line l1 = new Line(1,2);
        Line l2 = new Line(2,1);
        System.out.println(l1.equals(l2));
        System.out.println(l1.hashCode());
        System.out.println(l2.hashCode());

    }


    //斜率和b值可能为小数
    // k = y / x;
    static class Line {
        public int y;
        public int x;

        //        public int b;
        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        //
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Line line = (Line) obj;
            return line.x == x && line.y == y;
        }

        @Override
        public int hashCode() {
            return x * y;
        }


    }

    //暴力法  -->
    // 当类作为Map的key时，相同值的类作为key时不同的,
    // 需要把类换成Pair或者重载hashcodeh额equals方法
    public int maxPoints(int[][] points) {
        //点的数目
        Map<Line, Integer> map = new HashMap<>();
        int n = points.length;
        if (n < 3) return n;
        int res = 1;
        for (int i = 0; i < n; i++) {
            int samePoint = 1;
            int ans_i = 1;
            map.clear();
            for (int j = i + 1; j < n; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                //同一个点
                if (x == 0 && y == 0) {
                    samePoint++;
                    continue;
                }
                int c = gcd(x, y);
                Line line = new Line(x / c, y / c);
                int value = map.getOrDefault(line, 0);
                //line表示斜率k value+1表示该斜率上的点（不包括i点）
                map.put(line, value + 1);
                ans_i = Math.max(value + 1, ans_i);
            }
            res = Math.max(res, ans_i + samePoint);
        }
        return res;
    }

    //    作者：powcai
//    链接：https://leetcode-cn.com/problems/two-sum/solution/yong-xie-lu-by-powcai/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //思路在于把斜率转换为String存储下来，String作为key是很好匹配的
    public int maxPoints2(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;
        if (n == 1) return 1;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            Map<String, Integer> slope = new HashMap<>();
            int repeat = 0;
            int tmp_max = 0;
            for (int j = i + 1; j < n; j++) {
                int dy = points[i][1] - points[j][1];
                int dx = points[i][0] - points[j][0];
                if (dy == 0 && dx == 0) {
                    repeat++;
                    continue;
                }
                int g = gcd(dy, dx);
                if (g != 0) {
                    dy /= g;
                    dx /= g;
                }
                String tmp = String.valueOf(dy) + "/" + String.valueOf(dx);
                slope.put(tmp, slope.getOrDefault(tmp, 0) + 1);
                tmp_max = Math.max(tmp_max, slope.get(tmp));
            }
            res = Math.max(res, repeat + tmp_max + 1);
        }
        return res;
    }


    //gcd(a,0) == a
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
