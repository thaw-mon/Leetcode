package Year2020.November.day08;

import java.util.*;

public class Demo03 {
    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int k = scanner.nextInt();
            int[] num = new int[k];
            for (int i = 0; i < k; i++) {
                num[i] = scanner.nextInt();
            }
            demo03.getSeq(num);
        }
        scanner.close();
    }

    /**
     * 给定一个正整数N代表火车数量，0<N<10，
     * 接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，
     * 火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
     * 要求以字典序排序输出火车出站的序列号。
     */
    public void getSeq(int[] trains) {

        List<List<Integer>> allResult = new ArrayList<>();
        getAllQueue(trains, new Stack<>(), 0, new ArrayList<>(), allResult);
        allResult.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int N = o1.size();
                for (int i = 0; i < N; i++) {
                    if (o1.get(i).equals(o2.get(i))) continue;
                    return o1.get(i) - o2.get(i);
                }
                return 0;
            }
        });
        for (List<Integer> result : allResult) {
            for (int i = 0; i < result.size(); i++) {
                if (i == result.size() - 1) {
                    System.out.println(result.get(i));
                } else System.out.print(result.get(i) + " ");
            }
        }

    }

    //获取全部复合条件的排列
    public void getAllQueue(int[] trains, Stack<Integer> stack, int index, List<Integer> num, List<List<Integer>> result) {
        if (index == trains.length) {
            //
            List<Integer> temp = new ArrayList<>(num);
            while (!stack.isEmpty()) {
                temp.add(stack.pop());
            }
            //对出栈数据复原
            for (int i = temp.size() - 1; i >= num.size(); i--) {
                stack.push(temp.get(i));
            }
            if (!result.contains(temp))
                result.add(temp);
            return;
        }
        //1.继续入栈
        stack.push(trains[index]);
        getAllQueue(trains, stack, index + 1, num, result);
        stack.pop();
        //2.进行出栈操作

        //每次递归完成如何进行恢复操作
        //2.当前出栈
        int k = stack.size();
        while (!stack.isEmpty()) {
            num.add(stack.pop());
            getAllQueue(trains, stack, index, num, result);
        }
        //复原操作
        for (int i = 1; i <= k; i++) {
            stack.push(num.get(num.size() - 1));
            num.remove(num.size() - 1);
        }

    }

}
