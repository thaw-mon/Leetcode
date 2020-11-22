package Year2020.November.day10;

import java.util.Scanner;

public class Demo04 {
    /**
     * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
     * 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如：4 4 4 4-joker JOKER。
     * 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR。
     * （1）输入每手牌可能是个子、对子、顺子（连续5张）、三个、炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
     * （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）；
     * （3）大小规则跟大家平时了解的常见规则相同，个子、对子、三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
     * （4）输入的两手牌不会出现相等的情况。
     */
    public String pokeCompare(String s1, String s2) {
        //1.判断poke的类型
        int type1 = getPokeType(s1), type2 = getPokeType(s2);
        if (type1 == type2) {
            //可比较类型
            return compare(s1, s2);
        } else if (type1 == 4 || type1 == 5 || type2 == 4 || type2 == 5) {
            //类型不相同,返回数字大的
            return type1 > type2 ? s1 : s2;
        }
        return "ERROR";
    }

    /**
     * 获取输入牌的类型：个子(0),对子(1),顺子(2),三个(3),炸弹(4),对王(5)
     *
     * @param s
     * @return
     */
    public int getPokeType(String s) {
        String[] arr = s.split("\\s");
        if (arr.length == 1) return 0;
        else if (arr.length == 5) return 2;
        else if (arr.length == 3) return 3;
        else if (arr.length == 4) return 4;
        else {
            if(arr[0].equals("joker")) return 5;
            else return 1;
        }
    }

    public String compare(String s1, String s2) {
        // String[] arr1 = s1.split("\\s");
        // String[] arr2 = s2.split("\\s");
        char c1 = s1.charAt(0), c2 = s2.charAt(0);
        int value1 = 0, value2 = 0;
        value1 = getValue(c1);
        value2 = getValue(c2);

        return value1 > value2 ? s1 : s2;
    }

    private int getValue(char c1) {
        int value1;
        if (c1 >= '3' && c1 <= '9') value1 = c1 - '0';
        else if (c1 == '1') value1 = 10;
        else if (c1 == 'J') value1 = 11;
        else if (c1 == 'Q') value1 = 12;
        else if (c1 == 'K') value1 = 13;
        else if (c1 == 'A') value1 = 14;
        else value1 = 15;
        return value1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Demo04 demo04 = new Demo04();
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] arr = s.split("-");
            System.out.println(demo04.pokeCompare(arr[0], arr[1]));
        }
        scanner.close();
    }
}
