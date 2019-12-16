package July.day16;

/**
 * @题目 ：124. 二叉树中的最大路径和
 * @Data: 19/7/30
 * @题目描述： 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * @示例1: ######
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * 输出: 6
 * @示例2: ###
 * 输入: [-10,9,20,null,null,15,7]
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出: 42
 **/

public class BinaryTreeMaximumPathSum {

    private int maxValue = 0;

    public static void main(String[] args) {

    }

    //思路，包括当前节点的最大值为 左子树(小于0默认为0) + 右子树(小于0默认为0) + 当前节点
    public int maxPathSum(TreeNode root) {
        //有点小问题，当只有一个root节点时 例如 [-3] 会返回0 但是需要返回-3
        //改进maxValue初始为0产生的问题
        if (root != null)
            maxValue = root.val;
        maxCurrentSum(root);
        return maxValue;
    }

    //包含当前节点的最大值-->采取递归写法
    //存在问题，当left 和 right 都大于0时，上一层节点则会产生回路，而不再是路径。
    // [5,4,8,11,null,13,4,7,2,null,null,null,1]
    private int maxCurrentSum(TreeNode root) {
        if (root == null) return 0;
        int value = root.val;
        int leftValue = maxCurrentSum(root.left);
        int rightValue = maxCurrentSum(root.right);
        //形成环路节点
        if (leftValue > 0 && rightValue > 0) {
            int tmp = value+leftValue+rightValue;
            maxValue = Math.max(tmp,maxValue);
            value += Math.max(leftValue,rightValue);
        }else {
            //无环路节点
            if (leftValue > 0) value += leftValue;
            if (rightValue > 0) value += rightValue;
            maxValue = Math.max(value,maxValue);
        }

        return value;
    }
}
