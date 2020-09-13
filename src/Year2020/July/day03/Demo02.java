package Year2020.July.day03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Title : 某互联网公司一年一度的春招开始了，一共有 n 名面试者入选。每名面试者都会提交一份简历，公司会根据提供的简历资料产生一个预估的能力值，数值越大代表越有可能通过面试。
 * 小 A 和小 B 负责审核面试者，他们均有所有面试者的简历，并且将各自根据面试者能力值从大到小的顺序浏览。由于简历事先被打乱过，能力值相同的简历的出现顺序是从它们的全排列中等可能地取一个。现在给定 n 名面试者的能力值 scores，设 X 代表小 A 和小 B 的浏览顺序中出现在同一位置的简历数，求 X 的期望
 * @Date : 2020/07/13
 * @思路 ：判断去重后数字个数
 */
public class Demo02 {

    //不用排序直接用插入Set后判断长度
    public int expectNumber(int[] scores) {
        Arrays.sort(scores);
        int n = scores.length;
        if (n == 0) return 0;
        int count = 1;
        int preNum = scores[0];
        for (int i = 1; i < n; i++) {
            if (scores[i] == preNum) continue;
            count++;
            preNum = scores[i];
        }
        return count;
    }
}
