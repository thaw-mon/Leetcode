package November.day11;


/**
 * @题目 ： 393. UTF-8 Validation
 * @Data 19/11/30
 * @题目描述： A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 * <p>
 * For 1-byte character, the first bit is a 0, followed by its unicode code.
 * For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
 * @题目链接： 链接：https://leetcode-cn.com/problems/utf-8-validation
 * @示例1: ######
 * data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
 * <p>
 * Return true.
 * It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
 * @示例2: ######
 * data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
 * <p>
 * Return false.
 * The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
 * The next byte is a continuation byte which starts with 10 and that's correct.
 * But the second continuation byte does not start with 10, so it is invalid.
 * @示例3: ###
 */

public class UTF8Validation {

    //1. UTF-8 中的一个字符可能的长度为 1 到 4 字节
    //2.输入可能存在多个UTF-8编码:位运算
    public boolean validUtf8(int[] data) {
        int[] bits = new int[]{0x7F, 0xBF, 0xDF, 0xEF, 0xF7};
        int n = data.length;
        //获取data的八位数字
        int i = 0;
        while (i < n) {
            //1.获取首个八位字符
            int tmp = data[i] & 0xFF;
            //2，判断该UTF-8是几个字节的
            int j = 0;
            for (; j <= 4; j++) {
                if (tmp <= bits[j])
                    break;
            }
            //首字母错误编码
            if (j == 1 || j > 4)
                return false;
            //去除本身计算的字符
            if (j > 0) j -= 1;
            //后续字符长度不够
            if (i + j >= n)
                return false;
            //判断剩余字符是否符合条件 10开头
            for (int k = i + 1; k <= i + j; k++) {
                tmp = data[k] & 0xFF;
                if (tmp <= 0x7F || tmp > 0xBF)
                    return false;
            }
            i += j + 1;
        }
        return true;
    }

    //优雅的写法
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/utf-8-validation/solution/utf-8-bian-ma-yan-zheng-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean validUtf82(int[] data) {

        // Number of bytes in the current UTF-8 character
        int numberOfBytesToProcess = 0;

        // Masks to check two most significant bits in a byte.
        int mask1 = 1 << 7;
        int mask2 = 1 << 6;

        // For each integer in the data array.
        for(int i = 0; i < data.length; i++) {
            // If this is the case then we are to start processing a new UTF-8 character.
            if (numberOfBytesToProcess == 0) {
                int mask = 1 << 7;
                while ((mask & data[i]) != 0) {
                    numberOfBytesToProcess += 1;
                    mask = mask >> 1;
                }

                // 1 byte characters
                if (numberOfBytesToProcess == 0) {
                    continue;
                }

                // Invalid scenarios according to the rules of the problem.
                if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) {
                    return false;
                }

            } else {

                // data[i] should have most significant bit set and
                // second most significant bit unset. So, we use the two masks
                // to make sure this is the case.
                if (!((data[i] & mask1) != 0 && (mask2 & data[i]) == 0)) {
                    return false;
                }
            }

            // We reduce the number of bytes to process by 1 after each integer.
            numberOfBytesToProcess -= 1;
        }

        // This is for the case where we might not have the complete data for
        // a particular UTF-8 character.
        return numberOfBytesToProcess == 0;
    }


}
