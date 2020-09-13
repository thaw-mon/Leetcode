package Year2020.March.day02;

public class Demo01 {

    public static void main(String[] args){
        String s = "abc";
        System.out.println(new Demo01().reverseOnlyLetters(s));
    }
    /**
     * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
     * @param S : 输入字符
     * @return ： 反转后的字符
     */
    public String reverseOnlyLetters(String S) {
        //1.把字符串转换为数组
        char [] array = S.toCharArray();
        int left = 0,right = array.length - 1;
        while (left < right){
            //判断字符是否是字母类型
            if(!isWord(array[left])){
                left++;
                continue;
            }
            if(!isWord(array[right])){
                right--;
                continue;
            }
            //两个都是字母类型则进行交换
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        return String.valueOf(array);
    }
    //判断字符是否属于字母
    public boolean isWord(char c){
        return  (c >= 'a' && c <='z') || (c >= 'A' && c <='Z');
    }
}
