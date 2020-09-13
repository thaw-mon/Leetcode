package Year2019.July.day11;

import java.util.HashMap;

/**
 * @题目 ：105. 从前序与中序遍历序列构造二叉树
 * @题目描述： 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * @示例 1: 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * @示例 2: ###
 **/

public class BuildTree {

    //先序遍历 根左右  中序遍历  左根右
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int left1, int right1, int[] inorder, int left2, int right2) {
        if (left1 > right1 || left2 > right2)
            return null;

        int val = preorder[left1];
        TreeNode root = new TreeNode(val);

        //通过val查询inorder
        int index = 0;
        for (int i = left2; i <= right2; i++)
            if (inorder[i] == val) {
                index = i;
                break;
            }
        root.left = helper(preorder, left1 + 1, left1 + index - left2, inorder, left2, index - 1);
        root.right = helper(preorder, left1 + index - left2 + 1, right1, inorder, index + 1, right2);
        return root;
    }

    //思路一样，但是使用map优化
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/cong-qian-xu-he-zhong-xu-bian-li-xu-lie-gou-zao-er/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // if there is no elements to construct subtrees
        if (in_left == in_right)
            return null;

        // pick up pre_idx element as a root
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        // root splits inorder list
        // into left and right subtrees
        int index = idx_map.get(root_val);

        // recursion
        pre_idx++;
        // build left subtree
        root.left = helper(in_left, index);
        // build right subtree
        root.right = helper(index + 1, in_right);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);
        return helper(0, inorder.length);
    }

}
