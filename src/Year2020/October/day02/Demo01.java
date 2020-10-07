package Year2020.October.day02;

public class Demo01 {

    /**
     * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
     * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
     *
     * @param numbers
     * @return
     */
    public boolean isContinuous(int[] numbers) {
        //判断numbers是否可以组成顺子
        int n = numbers.length;
        if (n == 0 || n > 14) return false;
        int[] bucket = new int[14]; //数字范围为 0--13
        for (int num : numbers) {
            bucket[num]++;
        }
        //然后判断bucket是否为连续的
        int randNum = bucket[0]; //代表大小王的数目

        boolean flag = false;
        for (int i = 1; i < bucket.length; i++) {
            if (bucket[i] > 1) return false;
            if (bucket[i] == 1) {
                flag = true;
                n--;
            } else if (flag) {
                if (randNum > 0) {
                    randNum--;
                    n--;
                } else return false;
            }
            if (n == randNum) break;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Demo01().isContinuous(new int[]{}));

    }
}
