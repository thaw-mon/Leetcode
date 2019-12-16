package June.day17;

/**
 * @题目 ：58. 最后一个单词的长度
 * @题目描述： 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * @Date:19/6/29
 * @示例 1: 输入: "Hello World"
 * 输出: 5
 **/
public class LastWordLength {

    public static void main(String[] args) {
        String s = "      qweqq 23  ";
        System.out.println(new LastWordLength().lengthOfLastWord(s));
    }

    //最开始写错了,以为是求最大单词的长度，实际上是求最后一个单词的长度。
    public int lengthOfLastWord(String s) {
        int res = 0;
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                res = count == 0 ? res : count;
                count = 0;
                continue;
            }
            count++;
        }
        if (count != 0) {
            res = count;
        }

        return res;
    }

    //大佬优化策略：从后往前找
//    作者：ichengchao
//    链接：https://leetcode-cn.com/problems/two-sum/solution/zhi-xing-yong-shi-1-ms-zai-length-of-last-wordde-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int lengthOfLastWord2(String s) {
        int start = -1;
        int end = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && end == -1) {
                end = i;
                start = i;
            } else if (s.charAt(i) == ' ' && end != -1) {
                start = i + 1;
                break;
            } else if (s.charAt(i) != ' ' && end != -1) {
                start = i;
            }
        }
        if (end == -1) {
            return 0;
        }
        return end - start + 1;
    }

    //在大佬基础上简化
    public int lengthOfLastWord3(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            //找到最后一个单词
            if (s.charAt(i) != ' ') {
                //找到下一个空格
                while (i >= 0 && s.charAt(i) != ' ') {
                    res++;
                    i--;
                }
                break;
            }
        }
        return res;
    }

}
