package October.day11;

import java.util.Stack;

/**
 * @题目 ： 331. Verify Preorder Serialization of a Binary Tree
 * @Data 19/10/21
 * @题目描述： GOne way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 * @题目链接： 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 * @示例1: ######
 * Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * @示例2: ######
 * Input: "1,#"
 * Output: false
 * @示例3: ###
 * Input: "9,#,#,1"
 * Output: false
 */

public class VerifyPreorderSerializationBinaryTree {
    public static void main(String[] args) {
        String s = "9,#,#,#";
        System.out.println(new VerifyPreorderSerializationBinaryTree().isValidSerialization(s));
    }

    //验证二叉树是否是前序遍历输出的结果 DFS
    //使用栈的写法，很麻烦
    public boolean isValidSerialization(String preorder) {
        String[] str_s = preorder.split(",");
        int n = str_s.length;
        int[] array = new int[n];
        array[0] = -1;
        int p = 0;
        for (int i = 0; i < str_s.length; i++) {
            //null
            if (str_s[i].equals("#")) {
                array[p]++;
                while (array[p] == 2) {
                    array[p--] = 0;
                    if (p < 0) return false;
                }
            } else {
                array[p]++;
                if (array[p] > 2)
                    return false;
                p++;
            }
            // System.out.println(str_s[i]);
        }
        return p == 0 && array[p] == 0;
    }

    //其他思路：
//    空节点当作树的叶子节点。
//- 树的特征：当遍历完整棵二叉树时，叶子节点的数目总是比非叶子节点的数目多1。
//- 从数组开头遍历，在遍历的过程中判断应保证非叶子节点的数目countNode不小于叶子节点的数目countNone。
//- 当遍历到最后一个位置时，需要保证最后一个元素为空，否则，该数组不可能是一个二叉树的前序序列化。
//- 另外，叶节点的数目不可能小于2
//
//作者：1718zhangyq
//链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/bu-zhong-gou-xun-zhao-jie-dian-zhi-jian-de-guan-xi/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean isValidSerialization2(String preorder) {
        String[] str_s = preorder.split(",");
        int countNone = 0, countNode = 0;
        for (int i = 0; i < str_s.length - 1; i++) {
            if (str_s[i].equals("#"))
                countNone += 1;
            else
                countNode += 1;
            if (countNode < countNone)
                return false;
        }
//      将空看作叶节点，不可能存在少于1个叶节点的树结构。
//      另外，若该数组是一个二叉树序列，则当遍历到倒数第二个节点时，叶节点和非叶子节点的数目一定相同。
        if (countNode != countNone) return false;
        return str_s[str_s.length - 1].equals("#");
    }
}
