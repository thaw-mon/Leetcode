package August.day02;

import java.util.Arrays;

/**
 * @题目 ：135. 分发糖果
 * @Data: 19/8/06
 * @题目描述： 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * @题目地址： https://leetcode-cn.com/problems/candy/
 * @示例1: ######
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * @示例2: ###
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 **/

public class Candy {

    //注意：相同评分可能糖果数目不一致
    //最蠢的办法:一个个的试错 虽然通过了，但是特别慢
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;
        int[] candies = new int[n];
        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            //初始化为1
            candies[i] = 1;
            //评分大于左侧
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            } else if (ratings[i - 1] > ratings[i] && candies[i - 1] == 1) {
                //评分小于左侧 但是左侧评分也为1
                int k = i - 1;
                while (k >= 0 && ratings[k] > ratings[k + 1] && candies[k] <= candies[k + 1]) {
                    candies[k] = candies[k + 1] + 1;
                    k--;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            res += candies[i];
        return res;
    }

    //在这种方法中，我们使用两个一维数组 left2right 和 right2left
    //作者：LeetCode
    //    链接：https://leetcode-cn.com/problems/two-sum/solution/fen-fa-tang-guo-by-leetcode/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int candy2(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        //从左到右遍历一遍更新数组left2right 用来存储每名学生只与左边邻居有关的所需糖果数。
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        //同理，从右到左遍历数组right2left 用来存储每名学生只与右边邻居有关的所需糖果数。
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }

    //上面的方法的空间优化
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/fen-fa-tang-guo-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int candy3(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }


    //进一步的空间优化，采取O(1)空间
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/fen-fa-tang-guo-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //计算1+2+...+n的和
    public int count(int n) {
        return (n * (n + 1)) / 2;
    }
    //R 1 2 3 4 5 3 2 1 2 6 5 4 3 3 2 1 1 3 3 3 4 2
    //CombineTwoTables 1 2 3 4 5 3 2 1 2 4 3 2 1 3 2 1 1 2 1 1 2 1
    public static void main(String[] args){
        int[] ratings = {1, 2, 3, 4, 5, 3, 2, 1, 2, 6, 5, 4, 3, 3, 2, 1, 1, 3, 3, 3, 4, 2};
        new Candy().candy4(ratings);
    }

    public int candy4(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int old_slope = 0;
        for (int i = 1; i < ratings.length; i++) {
            //new_slope 1代表升序 -1代表降序 0 代表相等
            int new_slope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
            //升转平 或 降转升平
            //每一次计算一座山型
            if ((old_slope > 0 && new_slope == 0) || (old_slope < 0 && new_slope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (new_slope > 0)
                up++;
            if (new_slope < 0)
                down++;
            if (new_slope == 0)
                candies++;

            old_slope = new_slope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }



}
