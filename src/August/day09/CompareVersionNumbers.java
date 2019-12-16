package August.day09;

/**
 * @题目 ：165. Compare Version Numbers
 * @Data: 19/8/15
 * @题目描述： Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.
 * @题目地址： 链接：https://leetcode-cn.com/problems/compare-version-numbers
 * @示例1: ######
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * @示例2: ###
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * @示例3: ###
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 * <p>
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
 * <p>
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
 **/

public class CompareVersionNumbers {

    public static void main(String[] args) {
        String s1 = "7";
        String s2 = "7.2";
        System.out.println(new CompareVersionNumbers().compareVersion(s1,s2));

    }

    public int compareVersion(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        int i = 0, j = 0;
        int next_i, next_j;
        int result = 0;
        while (i < len1 && j < len2) {
            //获取下一个.的位置
            next_i = version1.indexOf(".", i);
            next_j = version2.indexOf(".", j);

            if (next_i == -1)
                next_i = len1;
            if (next_j == -1)
                next_j = len2;
            //比较两个字符串的大小
            result = compareNumStr(version1.substring(i, next_i), version2.substring(j, next_j));
            if (result != 0)
                return result;
            i = next_i + 1;
            j = next_j + 1;
        }

        while (i < len1) {
            next_i = version1.indexOf(".", i);
            if (next_i == -1)
                next_i = len1;
            result = compareNumStr(version1.substring(i, next_i), "0");
            if (result != 0)
                return result;
            i = next_i + 1;
        }

        while (j < len2) {
            next_j = version2.indexOf(".", j);
            if (next_j == -1)
                next_j = len2;
            result = compareNumStr( "0",version2.substring(j, next_j));
            if (result != 0)
                return result;
            j = next_j + 1;

        }
        return result;
    }

    //比较连个数字串的大小
    private int compareNumStr(String s1, String s2) {
        int res = 0;
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        if (n1 > n2) res = 1;
        else if (n1 < n2) res = -1;
        return res;
    }
}
