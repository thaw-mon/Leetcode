package June.day04;

/**
 * @Data 19/6/3
 * @题目描述： 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * @示例：
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int []height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater().maxArea(height));

    }

    //策略选择问题 两条线要尽可能远，同时保证线段尽可能长。两个线段中最短的决定了其长度
    //暴力法，两次循环 A[i][j] = min(height[i],height[j])* (j-i)
    public int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0; i <height.length ; i++) {
            for (int j = i+1; j < height.length; j++) {
                ans = Math.max(ans,Math.min(height[i],height[j]) * (j-i));
            }
        }
        return ans;
    }

    //官方解答： 双指针法
    public int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
