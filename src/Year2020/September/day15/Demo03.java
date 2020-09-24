package Year2020.September.day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo03 {

    class Park {
        public int id;
        public int locX;
        public int locY;
        public int w;
        public int h;
        public int px;
        public int py;

        Map<Integer, Integer> distance;

        Park(int _id, int _locX, int _locY, int _w, int _h, int _px, int _py) {
            id = _id;
            locX = _locX;
            locY = _locY;
            w = _w;
            h = _h;
            px = _px;
            py = _py;
            distance = new HashMap<>();
        }
    }

    public static void main(String[] args) {

//        System.out.println(ans);
    }

    public void parkQuestion() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        Park[] parks = new Park[n + 2];
        int id, locX, locY, w, h, px, py;
        for (int i = 0; i < n + 2; i++) {
            id = sc.nextInt();
            locX = sc.nextInt();
            locY = sc.nextInt();
            w = sc.nextInt();
            h = sc.nextInt();
            px = sc.nextInt();
            py = sc.nextInt();
            parks[i] = new Park(id, locX, locY, w, h, px, py);
        }
        int from = sc.nextInt();
        int to = sc.nextInt();
        //计数从from 到to的最短距离 : 迪杰斯特拉算法
        //思路：
        // 1.计算公园互相直达的距离
        //1-1 如何判定两个公园是否是可以直达的 --> 判定两个矩阵是否是相邻的
        // 2.选择from点,使用迪杰斯特拉算法计算 form to的最短距离
    }

    //默认排序 从小到达，从 x 到 y
    boolean isReachable(Park p1, Park p2) {
        //1.垂直方向相邻

        //2.水平方向相邻
        return true;
    }

    //
    public void getParkDistance(Park[] parks) {

    }
}
