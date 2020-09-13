package Year2020.April.day12;

import java.util.HashMap;
import java.util.Map;

public class Demo03 {

    /**
     * 有一个二维平面地图，其中散布着 N 个推销点，编号 0 到 N-1，不存在三点共线的情况。
     *
     * @param points
     * @param direction
     * @return
     */
    public int[] visitOrder(int[][] points, String direction) {
        //给定方向进行移动 判定任意三个点的移动方向
        //1.如何判定第三个点的移动方向
        //2.要进行递归因此可以使用map记录之前的移动轨迹方向
        Map<String, Character> moveRecord = new HashMap<>();
        int n = points.length; //记录点的数目
        int[] path = new int[n];
        visitDp(points,path,new boolean[n],direction,0,moveRecord);
        return path;
    }

    public boolean visitDp(int[][] points, int[] path, boolean[] visited, String direction, int index, Map<String, Character> moveRecord) {
        //终止递归条件
        if (index == direction.length()) {
            return true;
        }
        //获取当前需要的移动方向
        char move = direction.charAt(index);
        if (index == 0) {
            //第一次递归情形 找到三个符合条件的点
            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points.length; j++) {
                    if (i == j) continue;
                    for (int k = 0; k < points.length; k++) {
                        if (k == i || k == j) continue;
                        //判定当前三个点是否符合条件
                        String str = i + "#" + j + "#" + k;
                        if (!moveRecord.containsKey(str)) {
                            moveRecord.put(str, moveDirection(points[i], points[j], points[k]));
                        }
                        //符合条件进入下一层递归
                        if (moveRecord.get(str) == move) {
                            visited[i] = true;
                            visited[j] = true;
                            visited[k] = true;
                            path[index] = i;
                            path[index + 1] = j;
                            path[index + 2] = k;
                            //递归成功
                            if (visitDp(points, path, visited, direction, index + 1, moveRecord)) {
                                return true;
                            }
                            visited[i] = false;
                            visited[j] = false;
                            visited[k] = false;
                        }
                    }
                }
            }
        } else {
            //队列中已经存在两个节点了
            int first = path[index];
            int second = path[index + 1];
            for (int i = 0; i < points.length; i++) {
                if (visited[i]) continue;
                //判定当前三个点是否符合条件
                String str = first + "#" + second + "#" + i;
                if (!moveRecord.containsKey(str)) {
                    moveRecord.put(str, moveDirection(points[first], points[second], points[i]));
                }
                //符合条件进入下一层递归
                if (moveRecord.get(str) == move) {
                    visited[i] = true;
                    path[index + 2] = i;
                    //递归成功
                    if (visitDp(points, path, visited, direction, index + 1, moveRecord)) {
                        return true;
                    }
                    visited[i] = false;
                }
            }
        }
        return false;
    }

    //判定从 s- m -e节点的移动方向
    //使用了叉积的定义
    private char moveDirection(int[] start, int[] mid, int[] end) {
        //S(P1,P2,P3)　= (x1-x3)*(y2-y3)-(y1-y3)*(x2-x3)
        int s = (start[0] - end[0]) * (mid[1] - end[1]) - (start[1] - end[1]) * (mid[0] - end[0]);

        return s > 0 ? 'L' : 'R';
    }
}
