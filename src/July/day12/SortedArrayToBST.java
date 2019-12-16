package July.day12;

/**
 * @题目 ：108. 将有序数组转换为二叉搜索树
 * @题目描述： 给将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * @示例 2: ###
 **/
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length - 1);
    }

    // 递归实现构造平衡二叉树
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode lnode = helper(nums, left, mid - 1);
        TreeNode rnode = helper(nums, mid + 1, right);
        root.left = lnode;
        root.right = rnode;

        return root;
    }
}
