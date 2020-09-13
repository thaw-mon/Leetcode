package Year2020.January.Test;

import java.util.*;

public class demo {
    public static void main(String[] args){
        int test = 1;
        int count = 0;
        // 1337  = 1 * 7 *191
        //f(1337) = 1337 * 6/ 7 * 190 /  191
        while (test < 1337){
            if(test % 7==0 || test % 191==0){
                test++;
                continue;
            }
            count++; //记录互质的数目
            test++;
        }
        System.out.println(1337 * 6 / 7 * 190 /  191);
        System.out.println(count);
    }
    public boolean hasGroupsSizeX(int[] deck) {
        //最简单的思路吧deck转换为map
        //1.获取数组长度
        int n = deck.length;

        Map<Integer, Integer> deckMaps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!deckMaps.containsKey(deck[i])) {
                deckMaps.put(deck[i], 0);
            }
            int value = deckMaps.get(deck[i]) + 1;
            deckMaps.put(deck[i], value);
        }
        //获取全部重复数字
        Set<Integer> values = new TreeSet<>();
        int minValue = Integer.MAX_VALUE;

        for(int key : deckMaps.keySet()){
            int value = deckMaps.get(key);
            if(value < minValue)
                minValue = value;
            values.add(value);
        }
        //找到最小的重复数目
        //3.判断最小重复数目是否大于2,且其他的可以被minValue的分解因子整除。
        if(minValue < 2) return false;
        //eg 6 9  k = 3
        //获取minValue的整数分解因子
        Set<Integer> Decomposition = divideInteger(minValue);
        for (int value : values) {
            //判断每个values是否存在相同的分解因子
            Set<Integer> temp = new TreeSet<>();
            for (int factor : Decomposition) {
                if (value % factor == 0)
                    temp.add(factor);
            }
            if (temp.isEmpty()) return false;
            Decomposition = temp;
        }
        return true;

    }

    //获取整数的全部分解因子(相同的去除)
    public Set<Integer> divideInteger(int value) {
        Set<Integer> res = new TreeSet<>();
        for (int i = 2; i <= value; i++) {
            while (value % i == 0) {
                value /= i;
                res.add(i);
            }
        }
        return res;
    }


    //求 a^b 对1337取模的结果（数学方法） 1337是个质数
    //a^b mod q
    //b组成了一个大整数
    //1337不是个质数，1 7 191 根据费马定理 f(1337) = 1140
    //如果a和 1337互质 a^f(1337) % 1337 == 1
    //不互质的话 考虑折半方法（改进十进制）的快速幂


    public int superPow(int a, int[] b) {
        //1.判断a是否与1337互质
        //2.把大整数b转换为 1140 * K + c

        return 0;
    }


    //判断哪些节点可以走到终点(没有出边的点)的
    //不能产生循环 例如 ==> 1-2-4-1
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length; //节点数目
        //1.获取终点数目集合
        return null;
    }
}
