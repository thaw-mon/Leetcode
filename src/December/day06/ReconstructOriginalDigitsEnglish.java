package December.day06;

/**
 * @题目 ：423. Reconstruct Original Digits from English
 * @Data 19/12/12
 * @题目描述： Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 *
 * @题目链接： 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/
 * @示例1: ######
 * Input: "owoztneoer"
 *
 * Output: "012"
 * @示例2: ######
 * Input: "fviefuro"
 *
 * Output: "45"
 * @示例3: ###
 */

public class ReconstructOriginalDigitsEnglish {

    public String originalDigits(String s) {
        int[] num = new int[26];
        for (char c : s.toCharArray()) {
            num[c - 'a']++;
        }
        int[] digits = new int[10];
        //一级： z:0, w:2,u:4,x:6,g:1;
        if(num['z'-'a'] > 0){
            digits[0] = num['z'-'a'];
            num['e'-'a']-= num['z'-'a'];
            num['r'-'a']-= num['z'-'a'];
            num['o'-'a']-= num['z'-'a'];
            num['z'-'a'] = 0;
        }
        if(num['w'-'a'] > 0){
            digits[2] = num['w'-'a'];
            num['t'-'a']-= num['w'-'a'];
            num['o'-'a']-= num['w'-'a'];
            num['w'-'a'] = 0;
        }
        if(num['u'-'a'] > 0){
            digits[4] = num['u'-'a'];
            num['f'-'a']-= num['u'-'a'];
            num['o'-'a']-= num['u'-'a'];
            num['r'-'a']-= num['u'-'a'];
            num['u'-'a'] = 0;
        }
        if(num['x'-'a'] > 0){
            digits[6] = num['x'-'a'];
            num['s'-'a']-= num['x'-'a'];
            num['i'-'a']-= num['x'-'a'];
            num['x'-'a'] = 0;
        }
        if(num['g'-'a'] > 0){
            digits[8] = num['g'-'a'];
            num['e'-'a']-= num['g'-'a'];
            num['i'-'a']-= num['g'-'a'];
            num['h'-'a']-= num['g'-'a'];
            num['t'-'a']-= num['g'-'a'];
            num['g'-'a'] = 0;
        }
        //2级:   o:1, t:3,f:5,s:7
        if(num['o'-'a'] > 0){
            digits[1] = num['o'-'a'];
            num['n'-'a']-= num['o'-'a'];
            num['e'-'a']-= num['o'-'a'];
            num['o'-'a'] = 0;
        }
        if(num['t'-'a'] > 0){
            digits[3] = num['t'-'a'];
            num['h'-'a']-= num['t'-'a'];
            num['r'-'a']-= num['t'-'a'];
            num['e'-'a']-= 2 * num['t'-'a'];
            num['t'-'a'] = 0;
        }
        if(num['f'-'a'] > 0){
            digits[5] = num['f'-'a'];
            num['i'-'a']-= num['f'-'a'];
            num['v'-'a']-= num['f'-'a'];
            num['e'-'a']-= num['f'-'a'];
            num['f'-'a'] = 0;
        }
        if(num['s'-'a'] > 0){
            digits[7] = num['s'-'a'];
            num['e'-'a']-= 2 * num['s'-'a'];
            num['v'-'a']-= num['s'-'a'];
            num['n'-'a']-= num['s'-'a'];
            num['s'-'a'] = 0;
        }
        //3级： i：9
        if(num['i'-'a'] > 0){
            digits[9] = num['i'-'a'];
            num['n'-'a']-= 2 * num['i'-'a'];
            num['e'-'a']-= num['i'-'a'];
            num['i'-'a'] = 0;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<10;i++){
            if(digits[i] > 0){
                while (digits[i] > 0){
                    sb.append(i);
                    digits[i]--;
                }
            }
        }
        return sb.toString();
    }
}
