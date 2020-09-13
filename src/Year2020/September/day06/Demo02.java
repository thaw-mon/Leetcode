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
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        //0.构造n个节点并记录在数组中
        PreNode[] preNodes = new PreNode[n];
        Set<Integer>[] records = new Set[n]; //记录该节点的后继节点
        for (int i = 0; i < n; i++) {
            preNodes[i] = new PreNode(i);
            records[i] = new HashSet<>();
        }
        //1.根据prerequisites构建树结构
        int len = prerequisites.length;
        for (int i = 0; i < len; i++) {
            int[] tmp = prerequisites[i];
            preNodes[tmp[0]].nextNodeList.add(preNodes[tmp[1]]);
            records[tmp[1]].add(tmp[0]);
        }
        //判定查询结构
        List<Boolean> ret = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            //首先查记录
            if (records[queries[i][0]].contains(queries[i][1])) {
                ret.add(true);
                continue;
            }
            //根据前驱节点遍历寻找后继节点直到null
            ret.add(findNextNode(preNodes[queries[i][0]], preNodes[queries[i][1]],records));
        }

        return ret;
    }


    private boolean findNextNode(PreNode start, PreNode target,Set<Integer>[] records) {
        if (start.nextNodeList.isEmpty()) return false;
        for (PreNode pre : start.nextNodeList) {

            if (pre.val == target.val) return true;
            if (findNextNode(pre, target,records)) return true;
        }
        return false;
    }
}
