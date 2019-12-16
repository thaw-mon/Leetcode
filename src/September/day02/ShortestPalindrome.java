package September.day02;

/**
 * @题目 ： 214. Shortest Palindrome
 * @Data 19/9/03
 * @题目描述： Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * @题目地址： 链接：https://leetcode-cn.com/problems/shortest-palindrome
 * @示例1: ######
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * @示例2: ###
 * Input: "abcd"
 * Output: "dcbabcd"
 * @示例3: ###
 */

public class ShortestPalindrome {


    //在s前面添加字符串，使其变成回文串。
    // 显然，增加字符串的最大长度为s.length.最短为0，即为s本身就是回文串
    //假设增加字符串为 t  t + s 为回文串（t.length <= s.length）
    //可设 m = t.length n = s.length
    //要使得m尽可能的短，就需要 n-m尽可能的长。
    //问题就等价于求在s.subString(0,i)的最大回文串
    //TODO 结果超时了
    public String shortestPalindrome(String s) {
        int n = s.length();
        // n < 2 本身一定是回文
        if (n < 2) return s;
        //最大回文串的长度
        int len = 0;
        //求s从0开始的最大回文子串
        for (int i = n; i > 0; i--) {
            if (isPalindrome(s.substring(0, i))) {
                len = i;
                break;
            }
        }
        if (len == n) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(len)).reverse().append(s);
        return sb.toString();
    }

    //判断回文的方法可以优化
    private boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    //采用双指针法和递归思想，优化了回文串的判断
    public String shortestPalindrome2(String s) {
        int n = s.length();
        // n < 2 本身一定是回文
        if (n < 2) return s;
        int i = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j))
                i++;
        }

        if (i == n) return s;

        // res = s[n,i] + function(s[0,i]) + s[i,n]
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(i)).reverse().append(shortestPalindrome2(s.substring(0, i))).append(s.substring(i));
        return sb.toString();
    }


    //3. 经典KMP算法
//    作者：LeetCode
//        链接：https://leetcode-cn.com/problems/shortest-palindrome/solution/zui-duan-hui-wen-chuan-by-leetcode/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public String shortestPalindrome3(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        String s_new = s + "#" + rev;
        int n_new = s_new.length();
        int[] f = new int[n_new];
        //
        for (int i = 1; i < n_new; i++) {
            int t = f[i - 1];
            while (t > 0 && s_new.charAt(i) != s_new.charAt(t))
                t = f[t - 1];
            if (s_new.charAt(i) == s_new.charAt(t))
                ++t;
            f[i] = t;
        }

        return rev.substring(0, n - f[n_new - 1]) + s;
    }

}
