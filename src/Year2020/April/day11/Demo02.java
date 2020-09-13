package Year2020.April.day11;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Demo02 {

    static class Point {
        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static double getDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2.0) + Math.pow(a.y - b.y, 2.0));
    }

    //TODO 只通过10%
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#0.000");
        int m = in.nextInt(); //输入数据组数
        for (int i = 0; i < m; i++) {
            int n = in.nextInt();
            int x, y;
            Point[] A = new Point[n];
            Point[] B = new Point[n];
            for (int j = 0; j < n; j++) {
                x = in.nextInt();
                y = in.nextInt();
                A[j] = new Point(x, y);
            }
            for (int j = 0; j < n; j++) {
                x = in.nextInt();
                y = in.nextInt();
                B[j] = new Point(x, y);
            }
            //获取两点之间最短的距离
            double ret = Double.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ret = Math.min(getDistance(A[j], B[k]), ret);
                    if (Math.abs(ret - 0.0) < 0.000001)
                        break;
                }
            }
            System.out.println(df.format(ret));
        }
    }
}
