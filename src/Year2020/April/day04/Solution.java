package Year2020.April.day04;

public class Solution {

    public static void main(String[] args){
        String s1 = "25";
        String s2 = "15";
        System.out.println(new Solution().add(s1,s2));
    }
    /**
     * 接收两个表示9进制数的字符串，返回表示它们相加后的9进制数的字符串
     *
     * @param num1 string字符串 第一个加数
     * @param num2 string字符串 第二个加数
     * @return string字符串
     */
    public String add(String num1, String num2) {
        // write code here
        //1.把num拆分为整数和小数部分
        String[] n1 = num1.split("\\.");
        String[] n2 = num2.split("\\.");
        //2.判定是否存在小数部分
        String lessOne = "0.x";
        if (n1.length > 1 && n2.length > 1) {
            lessOne = addLessOne(n1[1], n2[1]);
        } else if (n1.length > 1 || n2.length > 1) {
            String tmp = n1.length > 1 ? n1[1] : n2[1];
            lessOne = "0." + tmp;
        }
        //3.获取整数部分求和
        String moreOne = addInteger(n1[0], n2[0]);
        String[] n3 = lessOne.split("\\.");
        //4.整数加一
        if (n3[0].equals("1")) {
            moreOne = addInteger(moreOne, "1");
        }
        //返回结果
        String ret = moreOne;
        //存在小数部分
        if(!n3[1].equals("x")){
            ret += "." + n3[1];
        }
        return ret;
    }

    /**
     * 对整数进行9进制加法 ： 向右对齐
     * 25 + 15 = 41
     *
     * @param s1
     * @param s2
     * @return
     */
    public String addInteger(String s1, String s2) {
        int n1 = s1.length() - 1, n2 = s2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0; //表示进位
        int c1 = 0, c2 = 0;
        while (n1 >= 0 || n2 >= 0) {
            c1 = n1 >= 0 ? s1.charAt(n1--) - '0' : 0;
            c2 = n2 >= 0 ? s2.charAt(n2--) - '0' : 0;
            int current = c1 + c2 + carry;
            sb.append(current % 9);
            carry = 0; //进位清空
            //获取进位
            if (current > 8) {
                carry = 1;
            }
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }

    /**
     * 对小数进行加法 ： 向左对齐
     *
     * @param s1
     * @param s2
     * @return
     */
    public String addLessOne(String s1, String s2) {
        int n1 = s1.length() - 1, n2 = s2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0; //表示进位
        int c1 = 0, c2 = 0;
        int n = Math.max(n1, n2);
        while (n >= 0) {
            c1 = n1 == n ? s1.charAt(n1--) - '0' : 0;
            c2 = n2 == n ? s2.charAt(n2--) - '0' : 0;
            int current = c1 + c2 + carry;
            sb.append(current % 9);
            carry = 0; //进位清空
            //获取进位
            if (current > 8) {
                carry = 1;
            }
            n--;
        }
        sb.append(".").append(carry);
        return sb.reverse().toString();
    }
}
