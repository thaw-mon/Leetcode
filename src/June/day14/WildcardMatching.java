package June.day14;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @题目 ：44. 通配符匹配
 * @题目描述： 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功
 * @Date:19/6/26
 * @说明: s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * @示例 1: 输入:    s = "aa"    p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * @示例 2: 输入:   s = "aa"     p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * <p>
 */

public class WildcardMatching {
    public static void main(String[] args) {
        String s = "abbb";
        String p = "a?*";
        System.out.println(new WildcardMatching().isMatch2(s, p));
    }

    //暴力法-->超时
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen == 0 && pLen == 0) {
            return true;
        }
        if (pLen == 1 && p.charAt(0) == '*') {
            return true;
        }
        int i = 0, j = 0;
        while (i < sLen && j < pLen) {
            // p[j]=='*' 直接跳出
            if (p.charAt(j) == '*') {
                break;
            }
            if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                j++;
                i++;
            } else {
                //不匹配
                return false;
            }
        }
        //p[j] == '*'
        if (j < pLen && p.charAt(j) == '*') {
            //
            if (j + 1 == pLen) {
                return true;
            }
            while (i <= sLen) {
                if (isMatch(s.substring(i, sLen), p.substring(j + 1, pLen))) {
                    return true;
                }
                i++;
            }
        }
        return i == sLen && j == pLen;
    }

    //思路2：动态规划 array[i][j]表示 s到i和p到j是否匹配
    //array[0][0] = true; array[1][0] = false array[0][1] = p[j]==*?true:false;
    //array[i][j]:分情况讨论
    // s[i]==p[j] || p[j] =?  ans = array[i-1][j-1];
    // p[j] = * ans = array[i-1][j] || a[i][j];
    public boolean isMatch2(String s, String p) {
        int sn = s.length();
        int pn = p.length();
        Boolean[][] array = new Boolean[sn + 1][pn + 1];
        array[0][0] = true;
        //初始化array[i][0]
        for (int i = 1; i <= sn; i++) {
            array[i][0] = false;
        }
        //初始化 array[0][j]
        for (int j = 1; j <= pn; j++) {
            array[0][j] = array[0][j - 1] && p.charAt(j-1) == '*';
        }
        for (int i = 1; i <= sn; i++) {
            for (int j = 1; j <= pn; j++) {
                if(p.charAt(j-1)=='*'){
                    array[i][j] = array[i][j-1] || array[i-1][j];
                } else if(p.charAt(j-1)=='?'){
                    array[i][j] = array[i-1][j-1];
                }else {
                    if(p.charAt(j-1)==s.charAt(i-1)){
                        array[i][j] = array[i-1][j-1];
                    }else{
                        array[i][j] = false;
                    }
                }
            }
        }
        return array[sn][pn];
    }

    //思路3：双指针匹配法
//    作者：windliang
//    链接：https://leetcode-cn.com/problems/two-sum/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-9/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    boolean isMatch3(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        //遍历整个字符串
        while (s < str.length()){
            // 一对一匹配，两指针同时后移。
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // 碰到 *，假设它匹配空串，并且用 startIdx 记录 * 的位置，记录当前字符串的位置，p 后移
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // 当前字符不匹配，并且也没有 *，回退
            // p 回到 * 的下一个位置
            // match 更新到下一个位置
            // s 回到更新后的 match
            // 这步代表用 * 匹配了一个字符
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //字符不匹配，也没有 *，返回 false
            else return false;
        }

        //将末尾多余的 * 直接匹配空串 例如 text = ab, pattern = a*******
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }


}
