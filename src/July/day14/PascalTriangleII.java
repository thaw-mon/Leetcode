package July.day14;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @题目 ：119. 杨辉三角 II
 * @Data: 19/7/17
 * @题目描述： 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * @示例 1：
 * 输入: 3
 * 输出: [1,3,3,1]
 * @示例 2: ###
 **/

public class PascalTriangleII {
    public static void main(String[] args) {
        int n = 3300;
        Date start = new Date();
        System.out.println(new PascalTriangleII().getRow(n));
        Date end = new Date();
        System.out.println(end.getTime()-start.getTime());
        start = new Date();
        System.out.println(new PascalTriangleII().getRow2(n));
        end = new Date();
        System.out.println(end.getTime()-start.getTime());

    }

    //一层层递推写法
    //注意 rowIndex = 0 是第一行而非空
    //每次都重新new了一个 list导致时间很慢
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        res = row;
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> preRow = new ArrayList<>(res);
            for (int j = 1; j < res.size(); j++) {
                row.set(j, preRow.get(j) + preRow.get(j - 1));
            }
            row.add(1);
            res = row;
        }
        return res;
    }

    //优化1-->只new一个Array不断递增
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j >= 1; j--)
                res.set(j, res.get(j) + res.get(j - 1));
            res.add(1);
        }
        return res;
    }

    //终极优化-->找到递推公式
//     作者：a-lan-ruo-2
//        链接：https://leetcode-cn.com/problems/two-sum/solution/yang-hui-san-jiao-de-tong-xiang-gong-shi-by-a-lan-/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<Integer> getRow3(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>(rowIndex+1);
        long nk = 1;
        for(int i = 0; i <= rowIndex; i++){
            res.add((int)nk);
            nk = nk * (rowIndex - i) / (i + 1);
        }
        return res;
    }

}
