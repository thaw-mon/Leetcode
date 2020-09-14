package Year2020.September.day07;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class Demo03 {

    /**
     * 牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。
     * 现在，重复执行以下步骤，直到显示所有卡牌为止：
     * 从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
     * 如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
     * 如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
     * <p>
     * 返回能以递增顺序显示卡牌的牌组顺序。
     *
     * @param deck
     * @return
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        //1.现对数组进行排序
        Arrays.sort(deck);
        //2.按照原理反过来操作 数组不太好移动操作
        //2. 分析原理找规律 : 每隔一个插入递增数据
        boolean[] flag = new boolean[deck.length];
        int[] ret = new int[deck.length];
        int current = 0;
        //缺点是越到后面越慢，因为没有空位置了
        //TODO 优化策略使用循环链表记录空位置
        for (int i = 0; i < deck.length; i++) {
            ret[current] = deck[i];
            flag[current] = true;
            //current向前移动两个位置
            if (i == deck.length - 1) break;
            int count = 0;
            while (count < 2) {
                current++;
                current %= deck.length;
                if (!flag[current]) count++; //当前位置位null
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {17, 13, 11, 2, 3, 5, 7};
        System.out.println(new Demo03().deckRevealedIncreasing(arr));
    }

}
