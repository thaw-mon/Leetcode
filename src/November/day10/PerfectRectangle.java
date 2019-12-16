package November.day10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @题目 ： 391. Perfect Rectangle
 * @Data 19/11/29
 * @题目描述： Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.
 * <p>
 * Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).
 * @题目链接： 链接：https://leetcode-cn.com/problems/perfect-rectangle
 * @示例1: ######
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [3,2,4,4],
 * [1,3,2,4],
 * [2,3,3,4]
 * ]
 * <p>
 * Return true. All 5 rectangles together form an exact cover of a rectangular region.
 * @示例2: ######
 * rectangles = [
 * [1,1,2,3],
 * [1,3,2,4],
 * [3,1,4,2],
 * [3,2,4,4]
 * ]
 * <p>
 * Return false. Because there is a gap between the two rectangular regions.
 * @示例3: ###
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [3,2,4,4]
 * ]
 * <p>
 * Return false. Because there is a gap in the top center.
 * <p>
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [2,2,4,4]
 * ]
 * <p>
 * Return false. Because two of the rectangles overlap with each other.
 */


public class PerfectRectangle {

    public static void main(String[] args) {
        int[][] rectangles = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        System.out.println(new PerfectRectangle().isRectangleCover(rectangles));
    }

    //完美矩形：注意不能有重叠也不能有缺失。
    //笨方法：找到左上方和右下方，一个个判断。
    public boolean isRectangleCover(int[][] rectangles) {

        int n = rectangles.length;
        List<int[]> nodes = new ArrayList<>();
        int area = 0;
        //1.获取小矩形的四个顶点
        for (int i = 0; i < n; i++) {
            area += (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);
            //left down
            nodes.add(new int[]{rectangles[i][0], rectangles[i][1]});
            //right top
            nodes.add(new int[]{rectangles[i][2], rectangles[i][3]});
            //left top
            nodes.add(new int[]{rectangles[i][2], rectangles[i][1]});
            //right top
            nodes.add(new int[]{rectangles[i][0], rectangles[i][3]});
        }
        nodes.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            int j = i;
            for (; j < nodes.size(); j++) {
                if (nodes.get(i)[0] != nodes.get(j)[0] || nodes.get(i)[1] != nodes.get(j)[1])
                    break;
            }
            int len = j - i;
            if(len % 2 == 1)
                res.add(nodes.get(i));
            i = j-1;
        }
        if (res.size() == 4 && isRectange(res)) {
            //rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]
            return (res.get(3)[1] - res.get(0)[1]) * (res.get(3)[0] - res.get(0)[0]) == area;
        }
        return false;
    }

    private boolean isRectange(List<int[]> nodes) {
        int[][] node = new int[4][];
        for (int i = 0; i < 4; i++) {
            node[i] = nodes.get(i);
        }
        return node[0][0] == node[1][0] && node[0][1] == node[2][1] && node[1][1] == node[3][1] && node[2][0] == node[3][0];
    }
}
