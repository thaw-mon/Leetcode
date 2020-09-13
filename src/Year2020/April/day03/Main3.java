package Year2020.April.day03;

import java.util.Scanner;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N, K;
        N = in.nextInt();
        K = in.nextInt();
        String str = in.next();
        char[] arr = str.toCharArray();
        int[] nums = new int[10]; //记录不同字符0-9的数量
        int[] lossLuck = new int[10]; //记录将对应字符修改为K种损失的幸运
        for (int i = 0; i < N; i++) {
            nums[arr[i] - '0']++;
        }
        //1. 获取修改对应字符幸运损失最小值
        int minLossLuck = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            //将字符i修改为K类字符
            int loss = K - nums[i];
            int luck = 0;
            int l = i - 1, r = i + 1;
            while (loss > 0) {
                //1.向左寻找
                if (l >= 0) {
                    luck += Math.min(loss, nums[l]) * (i - l);
                    loss -= nums[l];
                    l--;
                }
                //2.向右寻找
                if (r < 10 && loss > 0) {
                    luck += Math.min(loss, nums[r]) * (r - i);
                    loss -= nums[r];
                    r++;
                }
            }
            lossLuck[i] = luck;
            minLossLuck = Math.min(luck, minLossLuck);
        }
        //2. 判定修改那个字符loss幸运值最小(可能存在多种字符的情形)
        Stack<Integer> minLossIndex = new Stack<>();
        for (int i = 0; i < 10; i++) {
            if (lossLuck[i] == minLossLuck) minLossIndex.push(i);
        }
        Stack<String> minLossString = new Stack<>();
        //3. 判定对应minLossIndex对应的最小字符
        while (!minLossIndex.isEmpty()) {
            int[] replaceNum = new int[10]; //表示对应修改方案
            int index = minLossIndex.pop();
            //获取对应的修改方案
            int loss = K - nums[index];
            int l = index - 1, r = index + 1;
            while (loss > 0) {
                //1.向右寻找 优先向右这样会使得最后字符字典序更小
                if (r < 10) {
                    replaceNum[r] = Math.min(loss, nums[r]);
                    loss -= nums[r];
                    r++;
                }
                //2.向左寻找
                if (l >= 0 && loss > 0) {
                    replaceNum[l] = Math.min(loss, nums[l]);
                    loss -= nums[l];
                    l--;
                }
            }
            char[] tempChars = new char[N];
            int[] numCount = new int[10]; //记录不同字符0-9的数量
            //获取最后修改的字符串
            //如何两个相同字符中要修改一个 : 增大修改 修改后面的 减小修改则为修改前面的
            for (int i = 0; i < N; i++) {
                //判定当前字符是否要修改
                char temp = arr[i];
                if (replaceNum[temp - '0'] > 0) {
                    char indexChar = Character.forDigit(index, 10);
                    //增大修改
                    if (indexChar - temp > 0) {
                        if (replaceNum[temp - '0'] + numCount[temp - '0'] == nums[temp - '0']) {
                            replaceNum[temp - '0']--;
                            temp = indexChar;
                        }
                    } else {
                        //减小修改 先修改前面的因此直接修改
                        replaceNum[temp - '0']--;
                        temp = indexChar;
                    }
                }
                numCount[temp - '0']++; //对应字符计数加一
                tempChars[i] = temp;
            }
            String strReplace = new String(tempChars);
            minLossString.add(strReplace);
        }

        //4.从Stack中找到最小字典序的str
        String minString = minLossString.pop();
        while (!minLossString.isEmpty()) {
            String tempStr = minLossString.pop();
            if (tempStr.compareTo(minString) < 0) {
                minString = tempStr;
            }
        }

        System.out.println(minLossLuck);
        System.out.println(minString);
    }
}
