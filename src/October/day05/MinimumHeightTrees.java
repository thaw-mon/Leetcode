package October.day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @题目 ： 307. Range Sum Query - Mutable
 * @Data 19/10/11
 * @题目描述： For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * <p>
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * <p>
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * @题目地址： 链接：https://leetcode-cn.com/problems/minimum-height-trees
 * @示例1: ######
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * <p>
 * 0
 * |
 * 1
 * / \
 * 2   3
 * <p>
 * Output: [1]
 * @示例2: ######
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * <p>
 * 0  1  2
 * \ | /
 * 3
 * |
 * 4
 * |
 * 5
 * <p>
 * Output: [3, 4]
 * @示例3: ###
 */

public class MinimumHeightTrees {

    public static void main(String[] args) {

        int n = 6;
        int[][] edges = {{0,3},{1,3},{2,3},{4,3},{5,4}};
        List<Integer> res = new MinimumHeightTrees().findMinHeightTrees(n, edges);
        System.out.println(res);
    }

    private int minDepth = Integer.MAX_VALUE;
    private Map<Integer, List<Integer>> map = new HashMap<>();

    //DFS遍历
    //TODO 可以进行剪枝优化
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //1.把数组转换为hashMap
        int len = edges.length;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(edges[i][0])) {
                map.put(edges[i][0], new ArrayList<>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            if (!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], new ArrayList<>());
            }
            map.get(edges[i][1]).add(edges[i][0]);
        }
        //选择节点i进行DFS
        int[] depth = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] visit = new boolean[n];
            depth[i] = DFS(i, visit, 0);
            minDepth = Math.min(minDepth,depth[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (depth[i] == minDepth)
                res.add(i);
        }
        return res;
    }

    //这种方法艰难的通过了,但是特别慢
    int DFS(int node, boolean[] visit, int depth) {
        visit[node] = true;
        int res = depth;
        //当深度大于最下深度时不再遍历了
        if(depth > minDepth){
            return depth;
        }
        for (int nextNode : map.getOrDefault(node,new ArrayList<>())) {
            if (visit[nextNode])
                continue;
            res = Math.max(DFS(nextNode, visit, depth + 1), res);
            if(res > minDepth) break;
        }

        return res;
    }


    //其他大佬的思路：
//    每次总是删除“入度”个数最少的结点，因为树是无向无环图，
//    删除了它们以后，与之相连的结点的入度也相应地减少 1，直到最后剩下 1 个结点或者 2 个结点。
}
