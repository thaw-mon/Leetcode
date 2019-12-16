package July.day02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @题目 ：68. 文本左右对齐
 * @题目描述： 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * @说明: 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * @Date:19/7/2
 * @示例 1: 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * @示例 2: 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * @示例3： 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 * "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 **/

public class TextJustification {

    public static void main(String[] args) {
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        List<String> ans = new TextJustification().fullJustify(words, maxWidth);
        for (String str : ans) {
            System.out.println(str + "   size is " + str.length());
        }
    }

    //1. 由于LeetCode的Java版本没有repeat函数，需要简单修改一下
    //2. 关于空格不均匀情况的,需要从左到右把不均匀剩余的空格一个个的填充，而不是都填充在第一个空格处
    // eg:  max = 20 "Science  is  what we"  基础空格:5 空格位:3 分配 2 2 1 错误分配 3 1 1
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while (i < n) {
            int size = words[i].length();
            int j = i + 1;
            while (size <= maxWidth && j < n) {
                if (size + 1 + words[j].length() > maxWidth) {
                    break;
                }
                size += 1 + words[j].length();
                j++;
            }
            //合并数组[i,j)
            //这行只有一个元素
            if (j - i == 1) {
                String str = words[i] + Collections.nCopies(maxWidth - words[i].length(),' ');
                res.add(str);
                i = j;
                continue;
            }
            //最后一行左对齐
            if (j == n) {
                StringBuilder str = new StringBuilder(words[i]);
                for (int k = i + 1; k < j; k++) {
                    str.append(" ").append(words[k]);
                }
                int leftSpace = maxWidth - str.length();
//                for(int k = 0; k < leftSpace; k++){
//                    str.append(" ");
//                }
                //
                str.append(Collections.nCopies(leftSpace,' '));
                res.add(str.toString());
                break;
            }
            //空格位数 j-i-1
            int space = (maxWidth - size) / (j - i - 1) + 1;
            //不均匀空格数  [i,firstSpace)
            int firstSpace = (maxWidth - size) % (j - i - 1) + i;

            StringBuilder str = new StringBuilder();
            while (i < j) {
                str.append(words[i]);
                //最后一个字符后面没有空格
                if (i == j - 1) {
                    i++;
                    break;
                }
                //前面几个字符多一个空格
                if (i < firstSpace) {
                    str.append(" ");
                }
                //
                str.append(Collections.nCopies(space,' '));
                i++;
            }
        res.add(str.toString());
        // i = j
    }
        return res;
}

}
