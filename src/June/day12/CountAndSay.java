package June.day12;

/**
 * @题目 ：38. 报数
 * @题目描述： 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 * @Date:19/6/24
 * @示例 1: 输入: 1
 * 输出: "1"
 * @示例 2: 输入: 4
 * 输出: "1211"
 * <p>
 */
public class CountAndSay {

    public static void main(String[] args) {
        int num = 10;
        System.out.println(new CountAndSay().countAndSay(num));
    }
    //规则：当前数 == 前一个数进行报数输出
    public String countAndSay(int n) {
        String numStr = "1";
        for (int i = 2; i <= n; i++) {
            numStr = getNext(numStr);
        }
        return numStr;
    }

    private String getNext(String num) {
        StringBuilder s = new StringBuilder();
        int length = num.length();
        int i = 0;
        int j = 0;
        int size = 0;
        while (i < length) {
            j = i + 1;
            while (j < length && num.charAt(i) == num.charAt(j)) {
                j++;
            }
            size = j - i;
            s.append(size).append(num.charAt(i));
            i = j;
        }
        return s.toString();
    }
}
