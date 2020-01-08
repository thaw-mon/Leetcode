package January.day03;

/**
 * @题目 ：468. Validate IP Address
 * @Data 20/01/08
 * @题目描述： Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 * @题目链接： 链接：https://leetcode-cn.com/problems/validate-ip-address
 * @示例1: ######
 * Input: "172.16.254.1"
 * <p>
 * Output: "IPv4"
 * <p>
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * @示例2: ######
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * <p>
 * Output: "IPv6"
 * <p>
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * @示例3: ###
 * Input: "256.256.256.256"
 * <p>
 * Output: "Neither"
 * <p>
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 */

public class ValidateIPAddress {

    public static void main(String[] args) {
        String s = "12..33.4";
        //String s = "1.2.3.4.";  //结果有误
        System.out.println(new ValidateIPAddress().validIPAddress(s));
    }

    public String validIPAddress(String IP) {
        //1.判断是IPv4格式还是IPv6格式
        char[] ips = IP.toCharArray();
        int len = IP.length();
        int i = 0;
        if (IP.contains(".")) { //IPv4判断
            int count = 4;
            //1.首字母不为0 ，value 在 0-255之间
            while (i < len) {
                int j = i, temp = 0;
                //防止出现 a.e.b.c类型
                while (j < len && ips[j] != '.' && ips[j] >= '0' && ips[j] <= '9') {
                    temp *= 10;
                    temp += ips[j] - '0';
                    j++;
                }
                //错误ip
                if (j - i > 3 || i == j || temp > 255 || (ips[i] == '0' && j != i + 1) || (j < len && ips[j] != '.')) {
                    return "Neither";
                }
                count--;
                if (count == 0 && j < len) return "Neither";
                i = j + 1; //指向下一个num字符
            }
            if (count == 0) return "IPv4";

        } else if (IP.contains(":")) { //IPv6判断 （即，忽略 0 开头，忽略大小写）
            int count = 8; //8个16bit16进制
            //最长只有4位，可以小于4位
            while (i < len) {
                int j = i;
                //0000::
                while (j < len && ips[j] != ':') {
                    //判断ips[j]是否为有效字符
                    if ((ips[j] >= 'a' && ips[j] <= 'f') || (ips[j] >= 'A' && ips[j] <= 'F') || (ips[j] >= '0' && ips[j] <= '9')) {
                        j++;
                        continue;
                    }
                    return "Neither"; //错误字符
                }
                //长度判断 j指向的是:
                if (j - i > 4 || j == i) {
                    return "Neither";
                }
                count--;
                if (count == 0 && j < len) return "Neither";
                i = j + 1; //指向下一个num字符
            }
            if (count == 0) return "IPv6";
        }
        return "Neither";
    }
}
