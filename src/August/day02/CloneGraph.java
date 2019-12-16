package August.day02;

import java.util.*;

/**
 * @题目 ：133. 克隆图
 * @Data: 19/8/06
 * @题目描述： 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
 * @题目地址： https://leetcode-cn.com/problems/clone-graph/
 * @示例1: ######
 * @示例2: ###
 **/

public class CloneGraph {
    public static void main(String[] args) {
        Node node1 = new Node(1, new LinkedList<>());
        Node node2 = new Node(2, new LinkedList<>());
        Node node3 = new Node(3, new LinkedList<>());
        Node node4 = new Node(4, new LinkedList<>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        System.out.println(new CloneGraph().cloneGraph(node1));
    }

    //可以采用深度遍历或层次遍历的方法
    //最开始使用Map<Node,boolean>写法作为判断节点是否访问，导致很难处理clone节点的邻居节点
    //采用MAP<node,node>则保留原节点和clone节点的映射，很好处理clone节点的邻居节点了
    //递归深度遍历写法
    private Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node copy = new Node(node.val, new ArrayList<>());
        map.put(node, copy);
        for (Node neighbors : node.neighbors) {
            if (map.containsKey(neighbors)) {
                copy.neighbors.add(map.get(neighbors));
            } else {
                copy.neighbors.add(cloneGraph(neighbors));
            }
        }
        return copy;
    }
}
