package December.day05;

import java.util.*;

/**
 * @题目 ：420. Strong Password Checker
 * @Data 19/12/10
 * @题目描述： A password is considered strong if below conditions are all met:
 * <p>
 * It has at least 6 characters and at most 20 characters.
 * It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
 * It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
 * Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.
 * <p>
 * Insertion, deletion or replace of any one character are all considered as one change.
 * @题目链接： 链接：https://leetcode-cn.com/problems/strong-password-checker
 * @示例1: ######
 * @示例2: ######
 * @示例3: ###
 */

public class StrongPasswordChecker {
    public static void main(String[] args) {
        String s = "AAAAA";
        System.out.println(new StrongPasswordChecker().strongPasswordChecker(s));
    }

    //判断是否是强字符，如果不是需要修改的次数
    //1.长度为6-20
    //2.至少包含一个小写字母,一个大写字母和一个数字。
    //3.同一字符不能连续出现三次
    //还是有问题
    public int strongPasswordChecker(String s) {
        int result = 0;
        int len = 0; //正数表示要删除的数目,负数表示要增加的数目
        if (s.length() < 6) len = s.length() - 6;
        if (s.length() > 20) len = s.length() - 20;
        int[] types = new int[3]; //表示不同类型字母数量 0: a-z 1 :A-Z 2: 0-9
        int flag = 0;
        int repeat = 0; //表示重复字母数量
        char preChar = 0;
        //同时判断2,3类条件
        int i = 0;
        //设置为优先队列
        Queue<Integer> repeatList = new PriorityQueue<>(); //表示可能使用删除或者增加操作，但是预先使用update的操作
        while (i < s.length()) {
            //判断第二类条件
            if (flag < 3) {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    if (types[0] == 0) {
                        types[0] = 1;
                        flag++;
                    }
                }
                if (c >= 'A' && c <= 'Z') {
                    if (types[1] == 0) {
                        types[1] = 1;
                        flag++;
                    }
                }
                if (c >= '0' && c <= '9') {
                    if (types[2] == 0) {
                        types[2] = 1;
                        flag++;
                    }
                }

            }

            if (repeat == 0) {
                preChar = s.charAt(i);
                repeat = 1;
                i++;
                continue;
            }
            //判断存在几个重复的字母:终止条件为第一个不能用前面字符的位置
            while (i < s.length() && s.charAt(i) == preChar) {
                repeat++;
                i++;
            }

            if (repeat >= 3) { //表示存在三个或以上的重复的字母
                //判断len大小
                int operatorNum = repeat / 3; //表示要增加的操作数
                repeatList.add(repeat);
                flag += operatorNum;
                result += operatorNum;
            }
            repeat = 0;
        }

        //计算重复的次数：
        //repeat: 3 4 5 6 7 8 9  n
        // del    1 2 3 4 5 6 9  n-2
        // update 1 1 1 2 2 2 3  n/3
        // add    1 1 2 2 3 3 4  (n-1)/2
        while (len != 0 && !repeatList.isEmpty()) {
            int temp = repeatList.poll();
            if (len > 0) {
                if (len >= temp - 2) {
                    len -= temp - 2;
                    result += (temp - 2 - temp / 3);
                    flag -= temp / 3;
                } else {
                    if (temp - len < 3) {
                        flag -= temp / 3;
                        result += (len - temp / 3);
                    } else {
                        flag -= temp / 3 + (temp - len) / 3;
                        result += (len + (temp - len) / 3 - temp / 3);
                    }
                    len = 0;
                }
            } else {
                // len < 0;
                if (temp < 5) {
                } else {
                    //temp = 5;
                    result += 1;
                    flag += 1;
                }
                len = 0;
            }
        }
        //前面完了后第三类一定符合条件
        if (flag < 3) {
            int temp = 3 - flag;
            result += temp;
            flag = 3;
            if (len < 0) {
                len += temp;
                if (len > 0) len = 0;
            }
        }

        //最后再判断一次长度,增删剩余长度
        if (len != 0) {
            result += len > 0 ? len : -len;
        }

        return result;
    }

    //大佬的正确答案
//    作者：chu-yun-xi-yi
//    链接：https://leetcode-cn.com/problems/strong-password-checker/solution/zhi-xing-1ms-ji-bai-100-javajie-ti-si-lu-by-chu-yu/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    /**
     * 记录连续出现的字符 起始和终止坐标
     */
    class SameChar {
        int st;
        int en;
        char c;

        SameChar(int st, int en, char c) {
            this.st = st;
            this.en = en;
            this.c = c;
        }

    }

    public int strongPasswordChecker2(String str) {
        // 统计小写字符
        int lowerCase = 0;
        // 统计大写字符
        int upwerCase = 0;
        // 统计数字
        int number = 0;
        // 统计连续字符出现的位置
        java.util.ArrayList<SameChar> sameChars = new java.util.ArrayList<SameChar>();
        char[] chars = str.toCharArray();
        if (chars.length == 0) {
            return 6;
        }
        // 记露连续出现的字符
        SameChar sameChar = new SameChar(0, 0, '\0');
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                lowerCase++;
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                upwerCase++;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                number++;
            }
            if (sameChar.c != chars[i]) {
                if (sameChar.en - sameChar.st >= 2) {
                    sameChars.add(new SameChar(sameChar.st, sameChar.en, sameChar.c));
                }
                sameChar.c = chars[i];
                sameChar.st = i;
                sameChar.en = i;
            } else {
                sameChar.en = i;
            }
        }
        if (sameChar.en - sameChar.st >= 2) {
            sameChars.add(new SameChar(sameChar.st, sameChar.en, sameChar.c));
        }
        // 缺失的类型. 只可能是1 or 2
        int needType = count0(lowerCase, upwerCase, number);
        // 连续的字符出现的要消除的个数 连续值-2
        int[] chages = new int[sameChars.size()];
        for (int j = 0; j < sameChars.size(); j++) {
            chages[j] = sameChars.get(j).en - sameChars.get(j).st - 1;
        }
        int res = 0;
        // 如果长度小于6 , 很简单 要补的字符和缺失的类型择大
        if (str.length() < 6) {
            return Integer.max(6 - str.length(), needType);
        }
        // 删除的时候 要有优先概念
        if (str.length() > 20) {
            int index = -1;
            while (needType > 0 && (index = find(chages, 0)) > -1) {
                chages[index] = Integer.max(chages[index] - 3, 0);
                res++;
                needType--;
            }
            int d = str.length() - 20;
            while (d > 0 && (index = find(chages, 1)) > -1) {
                d--;
                res++;
                chages[index]--;
            }
            int n = 0;
            for (int l = 0; l < chages.length; l++) {
                n += chages[l] % 3 == 0 ? chages[l] / 3 : chages[l] / 3 + 1;
            }
            return res + d + needType + n;
        }
        int n = 0;
        for (int l = 0; l < chages.length; l++) {
            n += chages[l] % 3 == 0 ? chages[l] / 3 : chages[l] / 3 + 1;
        }
        return Integer.max(n, needType);
    }

    private int count0(int... array) {
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                n++;
            }
        }
        return n;
    }

    private int find(int[] array, int n) {
        int n0 = -1;
        int n1 = -1;
        int n2 = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] % 3 == 0) {
                n0 = i;
            }
            if (array[i] > 0 && array[i] % 3 == 1) {
                n1 = i;
            }
            if (array[i] > 0 && array[i] % 3 == 2) {
                n2 = i;
            }
        }
        if (n == 0) {
            return n0 > -1 ? n0 : (n2 > -1 ? n2 : n1);
        }
        if (n == 1) {
            return n1 > -1 ? n1 : (n2 > -1 ? n2 : n0);
        }
        return -1;
    }


}
