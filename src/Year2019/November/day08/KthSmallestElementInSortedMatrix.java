package Year2019.November.day08;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @题目 ： 378. Kth Smallest Element in a Sorted Matrix
 * @Data 19/11/19
 * @题目描述： Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * @题目链接： 链链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * @示例1: ######
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 * @示例2: ######
 * @示例3: ###
 */

public class KthSmallestElementInSortedMatrix {

    class Node {
        Node(int f, int s, int v) {
            first = f;
            second = s;
            val = v;
        }

        public int first;
        public int second;
        public int val;
    }

    //思路1：按排序遍历矩阵（设置优先队列）
    //优化：采用二分法查找
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        if (row == 0) return 0;
        int column = matrix[0].length;
        if (column == 0) return 0;
        //设置一个访问矩阵
        int[][] visited = new int[row][column];
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });
        queue.add(new Node(0, 0, matrix[0][0]));
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            k--;
            if (k == 0) return tmp.val;
            if (tmp.first + 1 < row && visited[tmp.first + 1][tmp.second] == 0) {
                queue.add(new Node(tmp.first + 1, tmp.second, matrix[tmp.first + 1][tmp.second]));
                visited[tmp.first + 1][tmp.second] = 1;
            }
            if (tmp.second + 1 < column && visited[tmp.first][tmp.second + 1] == 0) {
                queue.add(new Node(tmp.first, tmp.second + 1, matrix[tmp.first][tmp.second + 1]));
                visited[tmp.first][tmp.second + 1] = 1;
            }
        }
        return 0;
    }
}
