package Year2019.August.day02;

import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
