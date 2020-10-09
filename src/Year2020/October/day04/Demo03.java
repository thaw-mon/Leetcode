package Year2020.October.day04;

public class Demo03 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * left root right
     *
     * @param pNode
     * @return
     */
    //5 4 # 3 # 2
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //1.右子树存在，遍历右子树的最左节点
        if (pNode.right != null) {
            //中序遍历获取第一个节点
            TreeLinkNode ret = pNode.right;
            while (ret.left != null) {
                ret = ret.left;
            }
            return ret;
        }

        //2.右子树不存在，获取父节点，判断当前节点是父节点的左子树还是右子树
        TreeLinkNode parent = pNode.next;
        if(parent == null) return null;
        //2-1 左子树 返回父节点
        if (parent.left == pNode) {
            return parent;
        }
        //2-2 右子树 但会父节点的父节点迭代判定
        TreeLinkNode grandParent = parent.next;
        while (grandParent != null) {
            if (grandParent.left == parent) {
                return grandParent;
            }
            parent = grandParent;
            grandParent = grandParent.next;
        }
        return null;
    }

}
