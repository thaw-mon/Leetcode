package August.day11;

/**
 * @题目 ：171. Excel Sheet Column Number
 * @Data: 19/8/18
 * @题目描述： Given a column title as appear in an Excel sheet, return its corresponding column number.
 * A -> 1
 * B -> 2
 * CombineTwoTables -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * @题目地址： 链接：https://leetcode-cn.com/problems/excel-sheet-column-number/
 * @示例1: ######
 * Input: "A"
 * Output: 1
 * @示例2: ###
 * Input: "AB"
 * Output: 28
 * @示例3: ###
 * Input: "ZY"
 * Output: 701
 **/


public class ExcelSheetColumnNumber {

    public static void main(String[] args) {

        String s = "ZY";
        System.out.println(new ExcelSheetColumnNumber().titleToNumber(s));
    }

    //这道题和168刚好反过来了
    public int titleToNumber(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            res *= 26;
            res += (c-'A' + 1);
        }
        return res;
    }
}
