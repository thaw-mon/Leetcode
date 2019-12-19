package December.day09;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @题目 ：437. Path Sum III
 * @Data 19/12/19
 * @题目描述： You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * @题目链接： 链接：https://leetcode-cn.com/problems/path-sum-iii
 * @示例1: ######
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * <p>
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * @示例2: ######
 * @示例3: ###
 */

public class PathSumIII {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //找出和等于sum的路径的数量:
    // 采取后续遍历的思路：每次判断以当前节点为最后节点的路径是否存在和等于sum
    public int pathSum(TreeNode root, int sum) {
        //1.获取从根节点到叶子节点的全部路径 ：采用DFS方法
        List<Integer> path = new ArrayList<>(); //记录从root节点到叶子节点的路径
        //迭代的DFS
        Stack<TreeNode> stack = new Stack<>();
        TreeNode visited = null; //记录上一次访问的节点
        int res = 0; //计数器：计算路径的数目
        while (!stack.isEmpty() || root != null) {
            //获最左子树的位置
            while (root != null) {
                path.add(root.val);
                stack.add(root);
                root = root.left;
            }
            root = stack.peek(); //先不出栈,防止该节点存在右子树
            if (root.right != null && root.right != visited) {  //节点存在右子树
                root = root.right;
            } else {
                //当前节点为叶子节点或者其子节点已经全部访问过了
                root = stack.pop();
                //visit node(判断以该节点结尾的路径是否存在和为sum)
                res += countRightPath(path, sum);
                path.remove(path.size() - 1); //删除访问过的节点
                visited = root; //记录上一次访问节点
                root = null;  //该结点的左右子树都已出栈，所以要继续出栈，访问其父结点
            }
        }
        return res;
    }

    //注意：由于path中存在负数,因此计数器不是递增的
    private int countRightPath(List<Integer> path, int sum) {
        int res = 0;
        //从path最后一个节点开始访问
        int currentValue = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            currentValue += path.get(i);
            if (currentValue == sum)
                res++;
        }
        return res;
    }
}
