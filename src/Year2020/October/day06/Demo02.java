package Year2020.October.day06;

import java.util.LinkedList;
import java.util.Queue;

public class Demo02 {

    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
     * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * 请问该机器人能够达到多少个格子?
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0) return 0;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] node = queue.poll();
                //add 上下左右
                if (!visited[node[0]][node[1]]) {
                    visited[node[0]][node[1]] = true;
                    count++;
                    //top
                    if (node[0] - 1 >= 0 && fitNumber(node[0] - 1, node[1], threshold)) {
                        queue.add(new int[]{node[0] - 1, node[1]});
                    }
                    //bottom
                    if (node[0] + 1 < rows && fitNumber(node[0] + 1, node[1], threshold)) {
                        queue.add(new int[]{node[0] + 1, node[1]});
                    }

                    //left
                    if (node[1] - 1 >= 0 && fitNumber(node[0], node[1] - 1, threshold)) {
                        queue.add(new int[]{node[0], node[1] - 1});
                    }
                    //right
                    if (node[1] + 1 < cols && fitNumber(node[0], node[1] + 1, threshold)) {
                        queue.add(new int[]{node[0], node[1] + 1});
                    }
                }
            }
        }
        return count;
    }

    private boolean fitNumber(int x, int y, int k) {
        int ret = 0;
        while (x > 0) {
            ret += (x % 10);
            x /= 10;
        }
        while (y > 0) {
            ret += (y % 10);
            y /= 10;
        }
        return ret <= k;
    }

}
