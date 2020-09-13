package Year2020.March.day12;

public class Demo01 {

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        //负数不是回文数
        if(x < 0) return false;
        int palindrome = 0;
        int copyX = x;
        while (copyX > 0){
           int tmp = copyX % 10; //获取尾数
           palindrome *= 10;
           palindrome += tmp;
           copyX /= 10;
        }

        return x == palindrome;
    }
}
