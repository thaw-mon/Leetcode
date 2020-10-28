package Year2020.October.day13;

import java.util.Scanner;

public class Demo03 {

    public static void main(String[] args){
        Demo03 demo03 = new Demo03();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String pass = scanner.next();
            char[] result = new char[pass.length()];
            demo03.Encrypt(pass.toCharArray(),result);
            String aucResult = scanner.next();
            char[] aucPass= new char[aucResult.length()];
            demo03.unEncrypt(aucResult.toCharArray(),aucPass);
        }
    }
    /**
     * 1、对输入的字符串进行加解密，并输出。
     * 2加密方法为：
     * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,
     * 如字母a时则替换为B；字母Z时则替换为a；
     * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
     * 其他字符不做变化。
     * <p>
     * 3、解密方法为加密的逆过程。
     */

    //1.加密
    void Encrypt(char aucPassword[], char aucResult[]) {
        int N = aucPassword.length;
        for (int i = 0; i < N; i++) {
            char c = aucPassword[i];
            //1.小写字母
            if (c >= 'a' && c <= 'z') {
                if (c == 'z') c = 'a';
                else c++;
                c -= 32;
                // aucResult[i] = c;
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'Z') c = 'A';
                else c++;
                c += 32;
            } else if (c >= '0' && c <= '9') {
                if (c == '9') c = '0';
                else c++;
            }
            aucResult[i] = c;
            if (aucPassword[i] == '\0') {
                break;
            }
        }
        System.out.println(aucResult);
    }

    //2.解密
    int unEncrypt(char result[], char password[]) {
        int N = result.length;
        for (int i = 0; i < N; i++) {
            char c = result[i];
            //1.小写字母
            if (c >= 'a' && c <= 'z') {
                if (c == 'a') c = 'z';
                else c--;
                c -= 32;
                // aucResult[i] = c;
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'A') c = 'Z';
                else c--;
                c += 32;
            } else if (c >= '0' && c <= '9') {
                if (c == '0') c = '9';
                else c--;
            }
            password[i] = c;
            if (result[i] == '\0') {
                break;
            }
        }
        System.out.println(password);
        return 1;
    }
}
