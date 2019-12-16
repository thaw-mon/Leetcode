package August.day10;

/**
 * @题目 ：168. Excel Sheet Column Title
 * @Data: 19/8/16
 * @题目描述： Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 1 -> A
 * 2 -> B
 * 3 -> CombineTwoTables
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * @题目地址： 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * @示例1: ######
 * Input: 1
 * Output: "A"
 * @示例2: ###
 * Input: 28
 * Output: "AB"
 * @示例3: ###
 * Input: 701
 * Output: "ZY"
 **/

public class ExcelSheetColumnTitle {

    public static void main(String[] args) {

        int n = 701;
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(n));
    }

    //实际上就是一个十进制转26进制问题
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        char c = 'A';
        while (n > 0) {
            //每一轮循环都需要吧n减少1
            n--;
            c = (char) ('A' + n % 26);
            res.append(c);
            n /= 26;
        }

        return res.reverse().toString();
    }
}
