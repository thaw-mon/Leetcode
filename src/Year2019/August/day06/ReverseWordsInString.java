package Year2019.August.day06;

import java.util.Date;

/**
 * @题目 ：151. 翻转字符串里的单词
 * @Data: 19/8/11
 * @题目描述： 给定一个字符串，逐个翻转字符串中的每个单词。
 * @题目地址： https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @示例1: ######
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * @示例2: ###
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * @示例3: ###
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 **/

public class ReverseWordsInString {

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(new ReverseWordsInString().reverseWords(s));

        //TODO 简单测试insert和append效率问题
        String demo = "1221sd";
        Date startTime = new Date();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.insert(0,demo);

        }
        Date endTime = new Date();

        System.out.println("insert 100000 loop:" + (endTime.getTime() - startTime.getTime()));

        startTime = new Date();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb1.append(demo);
        }
        endTime = new Date();
        System.out.println("append 100000 loop:" + (endTime.getTime() - startTime.getTime()));

        //TODO 结论：相同情形下append效率远高于insert

    }

    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        if (n == 0) return s;
        int start = -1, end = -1, i = 0;
        while (i < n) {
            //去除开头的空格 -->指向单词的第一个字母
            while (i < n && s.charAt(i) == ' ') i++;
            start = i;
            //遍历到单词结尾的下一个空格字符
            while (i < n && s.charAt(i) != ' ') i++;
            end = i;
            if (start == end) break;
            res.insert(0, s.substring(start, end));
            res.insert(0, " ");
            i++;
        }
        //开头多了一个空格
        res.delete(0, 1);
        return res.toString();
    }

    //作者：_zhangheng
    //    链接：https://leetcode-cn.com/problems/two-sum/solution/2-ms-ji-bai-100-java-yong-hu-by-_zhangheng/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //大佬的优化算法-->感觉差不多啊，都是使用了StringBuffer或StringBuilder 难道是insert效率低于append吗
    public String reverseWords2(String s) {
        if (null == s || s.length() == 0)
            return "";
        final char[] c = s.toCharArray();
        final int len = c.length;
        int i = len - 1;

        while (i >= 0 && c[i] == ' ') i--;

        int left = i + 1;
        int right = i + 1;
        StringBuffer sb = new StringBuffer(i + 1);


        for (; i >= 0; i--) {
            if (c[i] == ' ') {
                if (right != left) sb.append(c, left, right - left).append(" ");
                left = i;
                right = i;
                continue;
            }
            left = i;
        }
        if (right != left)
            return sb.append(c, left, right - left).toString();
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }


}
