package Year2019.June.day05;

/**
 * @Data 19/6/4
 * @题目描述： 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @示例： 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {


        String[] s = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix1(s));

    }

    //注意，增加s =[]的条件判断
    public String longestCommonPrefix(String[] strs) {

        StringBuilder res = new StringBuilder();
        //增加s =[]的条件判断
        if(strs.length==0){
            return res.toString();
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char tmp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
               if(strs[j].length()<=i || strs[j].charAt(i)!=tmp){
                   return res.toString();
               }
            }
            res.append(tmp);
        }
        return res.toString();
    }
    //标准答案1 ： LSP(S1,S2,...,SN) = LSP(S1,LSP(S2,....LSP(SN-1,SN)))
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

}
