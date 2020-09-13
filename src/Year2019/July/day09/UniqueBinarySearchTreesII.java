package Year2019.July.day09;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：95. 不同的二叉搜索树 II
 * @题目描述： 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * @Date: 19/7/10
 * @示例 1: 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * @示例 2: ####
 **/

public class UniqueBinarySearchTreesII {

    public static void main(String[] args){
        List<TreeNode> res = new ArrayList<>();
        int n = 3;
        res = new UniqueBinarySearchTreesII().generateTrees(n);
        System.out.println(res);
    }

    //所有的二叉树的 左节点 <= 根节点 <= 右节点
    //递归思路
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n < 1)
            return res;
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            for (TreeNode lt : left)
                for (TreeNode rt : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lt;
                    root.right = rt;
                    res.add(root);
                }
        }
        return res;
    }
}
