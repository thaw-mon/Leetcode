package December.day06;

/**
 * @题目 ：427. Construct Quad Tree
 * @Data 19/12/12
 * @题目描述： We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. The root node represents the whole grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same.
 * <p>
 * Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.
 * <p>
 * Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem better:
 * <p>
 * Given the 8 x 8 grid below, we want to construct the corresponding quad tree:
 * @题目链接： 链接：https://leetcode-cn.com/problems/construct-quad-tree
 * @示例1: ######
 * @示例2: ######
 * @示例3: ###
 */

public class ConstructQuadTree {
    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    ;

    //显然是要采用递归方法
    public Node construct(int[][] grid) {
        return helper(grid,0,0,grid.length,grid[0].length);
    }

    private Node helper(int[][] grid, int left, int top, int right, int bottom) {
        //1.判断从left_top 到 right_down区域全部的值是否相等
        int val = grid[top][left];
        boolean flag = true;
        for (int i = top; i < bottom; i++) {
            for (int j = left; j < right; j++) {
                if (grid[i][j] != val) {
                    flag = false;
                    break;
                }
            }
        }
        Node root = new Node();
        root.val = val > 0;
        //是叶子节点
        if (flag) {
            root.isLeaf = true;
        } else {
            int mid1 = (left + right) / 2;
            int mid2 = (top + bottom) /2;
            root.isLeaf = false;
            root.topLeft = helper(grid, left, top, mid1, mid2);
            root.topRight = helper(grid, mid1, top, right, mid2);
            root.bottomLeft = helper(grid, left, mid2, mid1, bottom);
            root.bottomRight = helper(grid, mid1, mid2, right, bottom);
        }
        return root;

    }
}
