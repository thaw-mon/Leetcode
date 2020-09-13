package Year2020.March.day01;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Demo03 {

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args){
        Codec codec = new Codec();
        Node root = new Node(1,new LinkedList<>());
        Node child1 = new Node(2,new LinkedList<>());
        Node child2 = new Node(3,new LinkedList<>());
        Node child3 = new Node(4,new LinkedList<>());
        child1.children.add(child3);
        root.children.add(child1);
        root.children.add(child2);
        Node root1 = new Node();
        System.out.println(root1.val);
        System.out.println(codec.serialize(root1));
        codec.deserialize(codec.serialize(root));

    }
    /**
     * 序列化是指将一个数据结构转化为位序列的过程，
     * 因此可以将其存储在文件中或内存缓冲区中，以便稍后在相同或不同的计算机环境中恢复结构。
     * 设计一个序列化和反序列化 N 叉树的算法。一个 N 叉树是指每个节点都有不超过 N 个孩子节点的有根树。
     * 序列化 / 反序列化算法的算法实现没有限制。
     * 你只需要保证 N 叉树可以被序列化为一个字符串并且该字符串可以被反序列化成原树结构即可。
     */
    static class Codec {

        // Encodes a tree to a single string.
        //[1,[2],[3]]
        public String serialize(Node root) {
            if (root == null) return null;
            //将树形结构改为字符串形式 ： 层次遍历法 + 递归
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(root.val).append(",");
            if(root.children != null){
                for (Node node : root.children) {
                    sb.append(serialize(node)).append(",");
                }
            }

            sb.append("]");
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data.length() == 0) return null;
            //1.获取root节点
            int index = data.indexOf(',');
            Node root = new Node(Integer.parseInt(data.substring(1, index)),new LinkedList<>());

            Stack<Integer> stack = new Stack<>();
            for (int i = index; i < data.length() -1; i++) {
                char tmp = data.charAt(i);
                if (tmp == '[')
                    stack.push(i); //记录[的起始位置
                else if (tmp == ']') { //可以优化 保存[和]的记录信息 ，一个用栈，一个用队列
                    //属于子节点的范围
                    if (stack.size() == 1) {
                        Node child = deserialize(data.substring(stack.peek(),i+1));
                        root.children.add(child);
                    }
                    stack.pop();
                }
            }
            return root;
        }
    }
}
