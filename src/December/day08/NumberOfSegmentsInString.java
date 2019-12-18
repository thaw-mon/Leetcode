package December.day08;

/**
 * @题目 ：434. Number of Segments in a String
 * @Data 19/12/18
 * @题目描述： Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * <p>
 * Please note that the string does not contain any non-printable characters.
 * @题目链接： 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * @示例1: ######
 * Input: "Hello, my name is John"
 * Output: 5
 * @示例2: ######
 * @示例3: ###
 */

public class NumberOfSegmentsInString {
    //字符串中的单词数目：注意几个问题
    //1.字符串开头和结尾的空格 2. 单词间的空格可能不止是一个
    public int countSegments(String s) {
        int res = 0;
        boolean flag = true;
        int len = s.length(), i = 0;
        while (i < len) {
            //忽略空格，指向下一个单词
            while (i < len && s.charAt(i) == ' ') {
                i++;
                flag = true;
            }
            //当遇到第一个非空格字符时，res + 1
            if (i < len && flag) {
                res++;
                flag = false;
            }
            //遍历单词部分，指向下一个空格
            while (i < len && s.charAt(i) != ' ') {
                i++;
            }
        }
        //结果为空格数目+1
        return res;
    }

    //更优雅的写法(还可以使用内置trim函数和split函数)
//      作者：LeetCode
//    链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string/solution/zi-fu-chuan-zhong-de-dan-ci-shu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int countSegments2(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }

}
