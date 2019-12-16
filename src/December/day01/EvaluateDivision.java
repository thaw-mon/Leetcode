package December.day01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @题目 ： 399. Evaluate Division
 * @Data 19/12/02
 * @题目描述： Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 * @题目链接： 链接：https://leetcode-cn.com/problems/evaluate-division
 * @示例1: ######
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * <p>
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 * <p>
 * According to the example above:
 * <p>
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *  
 * <p>
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 * @示例2: ######
 * @示例3: ###
 */

public class EvaluateDivision {

    //思路：把等式画成拓扑图
    //注意等式中的 a/a 虽然结果测试的用例中没有
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Integer> map = new HashMap<>();
        int start = 0;

        String s1,s2;
        for (int i = 0; i < equations.size(); i++) {
            s1 = equations.get(i).get(0);
            s2= equations.get(i).get(1);
            if(!map.containsKey(s1)) map.put(s1,start++);
            if(!map.containsKey(s2)) map.put(s2,start++);

        }
        //定义二维数组
        double[][] dp = new double[start][start] ;
        for (int i = 0; i < equations.size(); i++) {
            s1 = equations.get(i).get(0);
            s2= equations.get(i).get(1);
            dp[map.get(s1)][map.get(s2)] = values[i];
            dp[map.get(s2)][map.get(s1)] = 1.0 / values[i];
        }

        double[] res = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            s1 = queries.get(i).get(0);
            s2= queries.get(i).get(1);
            if(!map.containsKey(s1) || !map.containsKey(s2)){
                res[i] = -1.0;
                continue;
            }
            boolean[] visited = new boolean[start-1];
            res[i] = dfs(dp,map.get(s1),map.get(s2),visited);
        }
        return res;
    }


    private double dfs( double[][] dp, int start,int end,boolean []visited){
        double res = 0.0;
        if(dp[start][end] > 0) return dp[start][end];
        for(int i=0;i<dp.length;i++){
            if(dp[start][i] > 0 && !visited[i]){
                visited[i] = true;
                res = dp[start][i] * dfs(dp,i,end,visited);
                visited[i] = false;
                if(res > 0) break;
            }
        }
        return res>0?res:-1.0;
    }
}
