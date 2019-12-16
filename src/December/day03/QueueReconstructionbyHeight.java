package December.day03;

import java.util.*;

/**
 * @题目 ：406. Queue Reconstruction by Height
 * @Data 19/12/05
 * @题目描述： Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * @题目链接： 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * @示例1: ######
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * @示例2: ######
 * @示例3: ###
 */

public class QueueReconstructionbyHeight {
    public static void main(String[] args){
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] res = new QueueReconstructionbyHeight().reconstructQueue(people);
        for (int i= 0; i<res.length;i++)
            System.out.println(res[i][0] +": " + res[i][1]);
    }
    public int[][] reconstructQueue(int[][] people) {

        //1.先按照升高降序,k值升序排列
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        queue.addAll(Arrays.asList(people));
        //2. 从前到后依次插入列表
        List<int[]> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            list.add(temp[1], temp);
        }
        list.toArray(people);
        return people;
    }
}
