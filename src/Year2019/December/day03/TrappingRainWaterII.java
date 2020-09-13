package Year2019.December.day03;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @题目 ：407. Trapping Rain Water II
 * @Data 19/12/05
 * @题目描述： SGiven an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.
 *
 *  
 *
 * Note:
 *
 * Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
 *
 *
 * @题目链接：  链接：https://leetcode-cn.com/problems/trapping-rain-water-ii
 * @示例1: ######
 * Given the following 3x6 height map:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 *
 * Return 4.
 *
 * @示例2: ######
 * @示例3: ###
 */


public class TrappingRainWaterII {
//     作者：JachinDu2018
//    链接：https://leetcode-cn.com/problems/trapping-rain-water-ii/solution/java-you-xian-dui-lie-bfs-by-jachindu2018/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class TrapNode{
        int height;
        int row;
        int col;

        public TrapNode(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }
    }
//     作者：JachinDu2018
//    链接：https://leetcode-cn.com/problems/trapping-rain-water-ii/solution/java-you-xian-dui-lie-bfs-by-jachindu2018/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //从外围遍历到内围
    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        if (rows == 0) {
            return 0;
        }
        int cols = heightMap[0].length;
        int[][] visited = new int[rows][cols];
        Queue<TrapNode> priorityQueue = new PriorityQueue<>(new Comparator<TrapNode>() {
            @Override
            public int compare(TrapNode o1, TrapNode o2) {
                return o1.height - o2.height;
            }
        });

        for (int i = 0; i < rows; i++) {
            priorityQueue.add(new TrapNode(heightMap[i][0],i,0));
            priorityQueue.add(new TrapNode(heightMap[i][cols - 1], i, cols - 1));
            visited[i][0] = 1;
            visited[i][cols - 1] = 1;
        }
        for (int j = 1; j < cols - 1; j++) {
            priorityQueue.add(new TrapNode(heightMap[0][j], 0, j));
            priorityQueue.add(new TrapNode(heightMap[rows - 1][j], rows - 1, j));
            visited[0][j] = 1;
            visited[rows - 1][j] = 1;
        }

        int currMinBound = Integer.MIN_VALUE;
        int total = 0;
        while (priorityQueue.size() != 0) {
            TrapNode node = priorityQueue.poll();
            currMinBound = Math.max(node.height, currMinBound);
            if (node.row > 0 && visited[node.row - 1][node.col] == 0) {
                priorityQueue.add(new TrapNode(heightMap[node.row - 1][node.col], node.row - 1, node.col));
                visited[node.row - 1][node.col] = 1;
                if (heightMap[node.row - 1][node.col] < currMinBound) {
                    total += (currMinBound - heightMap[node.row - 1][node.col]);
                }
            }
            if (node.row < rows - 1 && visited[node.row + 1][node.col] == 0) {
                priorityQueue.add(new TrapNode(heightMap[node.row + 1][node.col], node.row + 1, node.col));
                visited[node.row + 1][node.col] = 1;
                if (heightMap[node.row + 1][node.col] < currMinBound) {
                    total += (currMinBound - heightMap[node.row + 1][node.col]);
                }
            }

            if (node.col > 0 && visited[node.row][node.col - 1] == 0) {
                priorityQueue.add(new TrapNode(heightMap[node.row][node.col - 1], node.row, node.col - 1));
                visited[node.row][node.col - 1] = 1;
                if (heightMap[node.row][node.col - 1] < currMinBound) {
                    total += (currMinBound - heightMap[node.row][node.col - 1]);
                }
            }
            if (node.col < cols - 1 && visited[node.row][node.col + 1] == 0) {
                priorityQueue.add(new TrapNode(heightMap[node.row][node.col + 1], node.row, node.col + 1));
                visited[node.row][node.col + 1] = 1;
                if (heightMap[node.row][node.col + 1] < currMinBound) {
                    total += (currMinBound - heightMap[node.row][node.col + 1]);
                }
            }

        }
        return total;
    }


}
