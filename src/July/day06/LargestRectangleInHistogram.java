package July.day06;

import java.util.Stack;

/**
 * @题目 ：84. 柱状图中最大的矩形
 * @题目描述： 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @Date:19/7/8
 * @示例 1: 输入: [2,1,5,6,2,3]
 * 输出: 10
 * @示例 2: ####
 **/

public class LargestRectangleInHistogram {

    //矩形高度由柱子间最短的决定
//
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //1. 暴力法  --》超时
    public int largestRectangleArea(int[] heights) {
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minheight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minheight = Math.min(minheight, heights[j]);
                maxarea = Math.max(maxarea, minheight * (j - i + 1));
            }
        }
        return maxarea;

    }

    //2.分治策略  ==>勉强通过
    //思想:找到最小的柱子，那么最大面积要么为 最小柱子*宽度 或者左边最大面积  或者右边最大面积
    public int largestRectangleArea2(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    public int calculateArea(int[] heights, int start, int end) {
        if (start > end) return 0;
        int minIndex = start;
        for (int i = start; i <= end; i++)
            if (heights[i] < heights[minIndex])
                minIndex = i;
        int leftMax = calculateArea(heights, start, minIndex - 1);
        int rightMax = calculateArea(heights, minIndex + 1, end);
        int currenMax = heights[minIndex] * (end - start + 1);
        return Math.max(currenMax, Math.max(leftMax, rightMax));
    }

    //3.使用堆栈
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int largestRectangleArea3(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  //维护递增栈
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            //进来的值小于栈顶值
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxarea;

    }
}
