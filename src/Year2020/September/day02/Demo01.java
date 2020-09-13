package Year2020.September.day02;

public class Demo01 {

    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * num1 和num2 的长度都小于 5100
     * num1 和num2 都只包含数字 0-9
     * num1 和num2 都不包含任何前导零
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n1 = num1.length(), n2 = num2.length();
        //从后往前进行加法
        int carryNumber = 0,currentNum = 0; //进位

        while (n1 > 0 && n2 > 0) {
            n1--;
            n2--;
            currentNum = num1.charAt(n1) -'0' + num2.charAt(n2) - '0' + carryNumber;
            carryNumber = 0;
            if(currentNum > 10){
                carryNumber = currentNum / 10;
            }
            currentNum %= 10;
            sb.append(currentNum);
        }
        while (n1 > 0){
            n1--;
            currentNum = num1.charAt(n1) -'0' +  carryNumber;
            carryNumber = 0;
            if(currentNum >= 10){
                carryNumber = currentNum / 10;
            }
            currentNum %= 10;
            sb.append(currentNum);
        }
        while (n2 > 0){
            n2--;
            currentNum =  num2.charAt(n2) -'0' +  carryNumber;
            carryNumber = 0;
            if(currentNum >= 10){
                carryNumber = currentNum / 10;
            }
            currentNum %= 10;
            sb.append(currentNum);
        }
        if(carryNumber > 0){
            sb.append(carryNumber);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        String s1 = "1";
        String s2 = "9";
        System.out.println(new Demo01().addStrings(s1,s2));
    }
}
