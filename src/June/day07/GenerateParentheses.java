package June.day07;

import java.util.ArrayList;
import java.util.List;

/**
 * @Data 19/6/6
 * @题目描述： 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 *  思路：简单使用递归和回溯思想
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

    //1. 递归法  优化策略，把StringBuilder换成栈
    public List<String> generateParenthesis(int n) {
        List<String> res =  new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        Parenthesis(res,n,stringBuilder,0,0);

        return res;
    }
    void Parenthesis(List<String> stringList,int n,StringBuilder stringBuilder,int left , int right){
        if(right==n){
            stringList.add(stringBuilder.toString());
            return;
        }
        if(left>right){
            Parenthesis( stringList,n, stringBuilder.append(')'), left ,  right+1);
            stringBuilder.deleteCharAt(left+right);
            if(left+1 <= n){
                Parenthesis( stringList,n, stringBuilder.append('('), left + 1 ,  right);
                stringBuilder.deleteCharAt(left+right);
            }

        } else {
            Parenthesis( stringList,n, stringBuilder.append('('), left + 1 ,  right);
            stringBuilder.deleteCharAt(left+right);
        }
    }


    //官方标准答案1
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/gua-hao-sheng-cheng-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//    思路和我的一样，但写的更简洁，可以学习一下
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    //官方标准答案2 ：闭合数
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/gua-hao-sheng-cheng-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//    时间复杂度和空间复杂度都和1一样，但是更简洁
//    思路：为了枚举某些内容，我们通常希望将其表示为更容易计算的不相交子集的总和。
//    考虑有效括号序列 S 的 闭包数：至少存在 index >= 0，使得 S[0], S[1], ..., S[2*index+1]是有效的。
//    显然，每个括号序列都有一个唯一的闭包号。 我们可以尝试单独列举它们。

    public List<String> generateParenthesis3(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis3(c))
                    for (String right: generateParenthesis3(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }





}
