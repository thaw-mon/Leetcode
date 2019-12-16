package July.day02;

/**
 * @题目 ：67. 二进制求和
 * @题目描述： 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * @Date:19/7/2
 * @示例 1: 输入: a = "11", b = "1"
 * 输出: "100"
 * @示例 2: 输入: a = "1010", b = "1011"
 * 输出: "10101"
 **/

public class AddBinary {

    public static void main(String[] args) {
        String a = "100";
        String b = "110010";
        System.out.println(new AddBinary().addBinary(a,b));

    }

    public String addBinary(String a, String b) {
        int a1 = a.length();
        int b1 = b.length();
        int n = Math.min(a1, b1);
        StringBuilder res = new StringBuilder();
        int i = 0;
        int carryFlag = 0;
        while (i<n) {
           int r1 = a.charAt(a1-1-i) -'0' + b.charAt(b1-1-i) -'0' + carryFlag;
            carryFlag = r1 / 2;
            res.insert(0,r1%2);
            i++;
        }
        while (a1 > n){
            int r1 = a.charAt(a1-n-1) -'0' + carryFlag;
            carryFlag = r1 / 2;
            res.insert(0,r1%2);
            a1--;
        }
        while (b1 > n){
            int r1 = b.charAt(b1-n-1) -'0' + carryFlag;
            carryFlag = r1 / 2;
            res.insert(0,r1%2);
            b1--;
        }
        if(carryFlag==1){
            res.insert(0,1);
        }
        return res.toString();
    }
}
