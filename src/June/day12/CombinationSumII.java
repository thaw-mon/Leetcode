package June.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @题目 ：39. 组合总和
 * @题目描述： 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * @说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * @Date:19/6/24
 * @示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * @示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 */

//和1区别不大-->注意去重
public class CombinationSumII {

    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        new CombinationSumII().combinationSum2(candidates,target);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }

    //采用回溯算法-->可以增加剪枝
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            getSumList(candidates,target,sum+candidates[i],i+1,tmpList);
            //去重==>注意越界判断
            while (i+1 < candidates.length && candidates[i]==candidates[i+1]){
                i++;
            }
        }
    }
}
