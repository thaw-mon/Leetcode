package Year2020.October.day05;


import java.util.LinkedList;
import java.util.Queue;

public class Demo02 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树
     */


    /**
     * 采取层序遍历树并序列化
     *
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append('#');
                    continue;
                }
                sb.append(node.val).append('!');
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        char nodeSymbol = '#', valSymbol = '!';
        if (str.length() == 0 || str.charAt(0) == nodeSymbol) return null;
        int index = 0;
        int end = str.indexOf(valSymbol, index); //指向value = !
        TreeNode root = new TreeNode(Integer.parseInt(str.substring(index, end)));
        index = end + 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                //get left Node
                if (str.charAt(index) == nodeSymbol) {
                    node.left = null;
                    index++;
                } else {
                    end = str.indexOf(valSymbol, index);
                    TreeNode left = new TreeNode(Integer.parseInt(str.substring(index, end)));
                    queue.add(left);
                    node.left = left;
                    index = end + 1;
                }
                //get right node
                if (str.charAt(index) == nodeSymbol) {
                    node.right = null;
                    index++;
                } else {
                    end = str.indexOf(valSymbol, index);
                    TreeNode right = new TreeNode(Integer.parseInt(str.substring(index, end)));
                    queue.add(right);
                    node.right = right;
                    index = end + 1;
                }
            }
        }
        return root;
    }

    public static void main(String[] args){
        new Demo02().test();
    }

    public void test(){
        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode p = root.left;
        p.left = new TreeNode(4);
        p.left.right = new TreeNode(5);
        p = root.right;
        p.left = new TreeNode(6);
        p.right = new TreeNode(7);
        p.right.left = new TreeNode(8);
        p.right.left.left = new TreeNode(9);

        String s = Serialize(root);
        System.out.println(s);

        TreeNode ret = Deserialize(s);

        System.out.println(ret);
    }
}
