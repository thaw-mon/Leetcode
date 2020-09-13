package Year2020.April.day06;

import java.util.*;

public class Demo03 {

    public boolean carPooling(int[][] trips, int capacity) {
        //1.对trip进行排序按照 先起始位置后终止位置从小到大排序
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[2] - o2[2];
                return o1[1] - o2[1];
            }
        });
        //2.开始接客了
        int passenger = 0;
        Map<Integer, List<Integer>> mapIndex = new TreeMap<>(); //记录终止位置的索引 从小到大排序
        for (int i = 0; i < trips.length; i++) {
            int[] temp = trips[i]; //获取第i个地方乘客信息
            List<Integer> removeMapKey = new ArrayList<>();
            for (int place : mapIndex.keySet()) { //获取已经上车乘客的终点信息
                if (place > temp[1]) break;
                //当前位置乘客下车
                for (int index : mapIndex.get(place))
                    passenger -= trips[index][0];
                removeMapKey.add(place);
                //mapIndex.remove(place);  //这里删除 又使用keySet迭代会产生null指针异常
            }
            for(int key : removeMapKey){
                mapIndex.remove(key);
            }
            passenger += temp[0]; //当前乘客上车
            if (!mapIndex.containsKey(temp[2])) mapIndex.put(temp[2], new ArrayList<>());
            mapIndex.get(temp[2]).add(i);
            if (passenger > capacity) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        System.out.println(new Demo03().carPooling(trips, 11));
    }
}
