package August.day16;

import java.util.*;

/**
 * @题目 ：207. Course Schedule
 * @Data 19/8/31
 * @题目描述： There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * @题目地址： 链接：https://leetcode-cn.com/problems/course-schedule
 * @示例1: ######
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * @示例2: ###
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * @示例3: ###
 */

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        new CourseSchedule().canFinish(numCourses, prerequisites);
    }

    //默认不会出现 [1,0,1]类似的情形
    //结果不对 3  [[1,0],[1,2],[0,1]]
    //TODO ERROR
    // 注意事项:题目理解错误了，prerequisites是由多个长度为2的数组构成的，而不存在[1,2,3,...]类型的数组
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) return true;
        int[] flag = new int[numCourses];
        int n = prerequisites.length;
        Map<Integer, List<Integer>> valueMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int len = prerequisites[i].length;
            int level = 1;
            for (int j = len - 1; j >= 0; j--) {
                int index = prerequisites[i][j];
                int value = Math.max(flag[index], level);
                //index对应层数加深
                if (value > flag[index]) {
                    if (valueMap.containsKey(flag[index]))
                        valueMap.get(flag[index]).remove((Integer) index);
                    flag[index] = value;
                    if (!valueMap.containsKey(value))
                        valueMap.put(value, new ArrayList<>());
                    valueMap.get(value).add((Integer) index);
                }
                level++;
            }
        }
        //判断是否存在没有安排的课程
        for (int num : flag) {
            if (num == 0)
                return false;
        }
        //把map的value从小到大遍历
        for (int key : valueMap.keySet()) {
            if (valueMap.get(key).isEmpty())
                return false;
        }
        return true;
    }


    //入度表（广度优先遍历）比较慢
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) return true;
        //入度表
        int[] inDegree = new int[numCourses];
        for (int[] arr : prerequisites) {
            inDegree[arr[0]]++;
        }
        //找到入度为0的节点
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0)
                queue.add(i);

        while (!queue.isEmpty()) {
            int val = queue.poll();
            numCourses--;
            for (int[] arr : prerequisites) {
                if (arr[1] == val) {
                    if (--inDegree[arr[0]] == 0)
                        queue.add(arr[0]);
                }
            }
        }
        return numCourses==0;
    }

    //DFS方法
//        作者：jyd
//    链接：https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean canFinish3(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites)
            adjacency[cp[1]][cp[0]] = 1;
        for(int i = 0; i < numCourses; i++){
            if(!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] adjacency, int[] flags, int i) {
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;
        for(int j = 0; j < adjacency.length; j++) {
            if(adjacency[i][j] == 1 && !dfs(adjacency, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }


}
