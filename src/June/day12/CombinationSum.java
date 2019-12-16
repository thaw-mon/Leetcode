package June.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @题目 ：39. 组合总和
 * @题目描述： 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * @说明： 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * @Date:19/6/24
 * @示例 1: 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * @示例 2: 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 */

public class CombinationSum {
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        new CombinationSum().combinationSum(candidates,target);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }

    //采用回溯算法-->可以增加剪枝
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //1. 对candidates排序
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        getSumList(candidates,target,0,0,list);
        return res;
    }

    private void getSumList(int[] candidates, int target, int sum, int index,List<Integer> list) {
        if(sum==target){
            res.add(list);
            return;
        }
        if(sum > target){
            return;
        }
        for(int i=index; i<candidates.length;i++){
            List<Integer> tmpList = new ArrayList<>(list);
            tmpList.add(candidates[i]);
            //剪枝
            if(sum+candidates[i]>target){
                break;
            }
            getSumList(candidates,target,sum+candidates[i],i,tmpList);
        }
    }
}
