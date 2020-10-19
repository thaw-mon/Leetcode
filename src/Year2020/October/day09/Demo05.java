package Year2020.October.day09;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Demo05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            if (!map.containsKey(key)) {
                map.put(key, value);
            } else
                map.put(key, map.get(key) + value);
        }
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }

    /**
     * 数据表记录包含表索引和数值（int范围的整数），
     * 请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
     */
    public Map<Integer, Integer> getMap(int[][] array) {
        int n = array.length;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int key = array[i][0];
            if (!map.containsKey(key)) {
                map.put(key, array[i][0]);
            } else
                map.put(key, map.get(key) + array[i][1]);
        }
        return map;
    }
}
