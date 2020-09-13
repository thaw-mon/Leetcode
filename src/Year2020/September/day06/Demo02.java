package Year2020.September.day06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo02 {

    class PreNode {
        public int val;
        Set<PreNode> nextNodeList;

        PreNode(int val) {
            this.val = val;
            nextNodeList = new HashSet<>();
        }
    }

    /**
     * 给你课程总数 n 和一个直接先修课程数对列表 prerequisite 和一个查询对列表 queries 。
     * 对于每个查询对 queries[i] ，请判断 queries[i][0] 是否是 queries[i][1] 的先修课程。
     *
     * @param n
     * @param prerequisites
     * @param queries
     * @return
     */
    //直接采用遍历树法会超时了     添加记忆化全部前驱节点
    //2.采用dp[i][j]记录i-j是否时可达的
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] isReachAble = new boolean[n][n]; //记录节点i,j是否可达
        int len = prerequisites.length;
        for (int i = 0; i < len; i++) {
            int[] tmp = prerequisites[i];
            isReachAble[tmp[0]][tmp[1]] = true;
            //获取可达tmp[0]的节点和tmp[1]可达的节点
            List<Integer> start = new ArrayList<>();
            start.add(tmp[0]);
            List<Integer> end = new ArrayList<>();
            end.add(tmp[1]);
            for (int j = 0; j < n; j++) {
                if (isReachAble[j][tmp[0]]) start.add(j);
                if (isReachAble[tmp[1]][j]) end.add(j);
            }
            //start-end 都是可达的
            for (Integer s : start) {
                for (Integer e : end) {
                    isReachAble[s][e] = true;
                }
            }
        }

        //判定查询结构
        List<Boolean> ret = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            ret.add(isReachAble[queries[i][0]][queries[i][1]]);
        }
        return ret;
    }

    private boolean findNextNode(PreNode start, PreNode target, Set<Integer> record) {
        if (start.nextNodeList.isEmpty()) return false;
        for (PreNode pre : start.nextNodeList) {
            record.add(pre.val);
            if (pre.val == target.val) return true;
            if (findNextNode(pre, target, record)) return true;
        }
        return false;
    }
}
