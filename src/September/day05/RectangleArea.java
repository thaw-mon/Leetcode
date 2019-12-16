package September.day05;

/**
 * @题目 ： 222. Count Complete Tree Nodes
 * @Data 19/9/07
 * @题目描述： Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * @题目地址： 链接：https://leetcode-cn.com/problems/rectangle-area
 * @示例1: ######
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 * @示例2: ###
 * @示例3: ###
 */

public class RectangleArea {
    //求两个矩形重叠后的总面积
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //矩形1的面积
        int Area1 = (C - A) * (D - B);

        //矩形2的面积
        int Area2 = (G - E) * (H - F);

        //重叠部分的面积
        int x1 = Math.max(A, E);
        int x2 = Math.min(C, G);
        int y1 = Math.max(B, F);
        int y2 = Math.min(D, H);
        int s;
        if (x1 >= x2 || y1 >= y2)
            s = 0;
        else
            s = (x2 - x1) * (y2 - y1);
        //重叠矩形的面积
        return Area1 + Area2 - s;
    }
}
