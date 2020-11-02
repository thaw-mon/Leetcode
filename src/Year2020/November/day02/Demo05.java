package Year2020.November.day02;

import java.util.Arrays;
import java.util.Scanner;

public class Demo05 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
       // Demo05 demo05 = new Demo05();
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            for(int i=0;i<n;i++){
                String s = scanner.next();
                System.out.println(getMaxBeauty(s));
            }
        }
        scanner.close();
    }
    public static int getMaxBeauty(String word) {
        int[] count = new int[26];
        word = word.toLowerCase();
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        Arrays.sort(count); //从小到大排序
        int ret = 0;
        for (int i = 25; i >= 0; i--) {
            ret += count[i] * (i + 1);
        }
        return ret;
    }
}
