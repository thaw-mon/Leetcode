package Year2020.September.day02;

import java.util.ArrayList;
import java.util.List;

public class Demo02 {

    /**
     * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
     *
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //使用DFS遍历操作
        int N = rooms.size();
        boolean[] flag = new boolean[N];
        flag[0] = true;
        DFS(rooms, 0, flag);
        boolean ret = true;
        for (boolean v : flag) {
            ret &= v;
        }
        return ret;
    }

    private void DFS(List<List<Integer>> rooms, int index, boolean[] flag) {

        List<Integer> room = rooms.get(index);
        for (Integer num : room) {
            if (flag[num]) continue; //访问过
            flag[num] = true;
            DFS(rooms, num, flag);
        }
    }

    public static void main(String[] args) {
        // [[1],[2],[3],[]]
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        room1.add(1);
        List<Integer> room2 = new ArrayList<>();
        room2.add(2);
        List<Integer> room3 = new ArrayList<>();
        room3.add(3);
        List<Integer> room4 = new ArrayList<>();

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);

        System.out.println(new Demo02().canVisitAllRooms(rooms));
    }
}
