package December.day10;

/**
 * @题目 ：443. String Compression
 * @Data 19/12/21
 * @题目描述： Given an array of characters, compress it in-place.
 * <p>
 * The length after compression must always be smaller than or equal to the original array.
 * <p>
 * Every element of the array should be a character (not int) of length 1.
 * <p>
 * After you are done modifying the input array in-place, return the new length of the array.
 * <p>
 *  
 * Follow up:
 * Could you solve it using only O(1) extra space?
 * @题目链接： 链接：https://leetcode-cn.com/problems/string-compression
 * @示例1: ######
 * Input:
 * ["a","a","b","b","c","c","c"]
 * <p>
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * <p>
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * @示例2: ######
 * Input:
 * ["a"]
 * <p>
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * <p>
 * Explanation:
 * Nothing is replaced.
 * @示例3: ###
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * <p>
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * <p>
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 */

public class StringCompression {

    public static void main(String[] args){
        String str = "bbbbbbbbbbbb";
        System.out.println(new StringCompression().compress(str.toCharArray()));
    }

    //把字符压缩,如果存在重复字符 那么就以字符+数字的形式进行表示
    //eg aaabccdd == a3bc2d2 注意只有一个字符的不需要写数字1 (要进行原地修改字符)
    public int compress(char[] chars) {
        if (chars.length < 2) return chars.length;
        char pre = chars[0];   //记录之前的字符
        int index = 0; //记录之前修改字符的位置
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            int j = i;
            while (j < chars.length && pre == chars[j]) {
                j++;
            }
            //判断重复字符长度和位数
            int len = j - i, bit = 0;
            if (len == 1) { //长度为1的情形
                chars[index++] = pre;
                pre = j < chars.length ? chars[j] : ' ';
                continue;
            }
            int temp = len;
            while (temp > 0) {
                bit++;
                temp /= 10;
            }
            chars[index++] = pre;
            for (int k = index + bit - 1; k >= index; k--) {
                chars[k] = (char) ('0' + (len % 10));
                len /= 10;
            }
            i = j - 1;
            pre = j < chars.length ? chars[j] : ' ';
            index = index + bit;
        }
        return index;
    }

    //思路是一样的，可以看细节问题
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/string-compression/solution/ya-suo-zi-fu-chuan-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int compress2(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    //这里要加一个 ""是为了形成String
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }


}
