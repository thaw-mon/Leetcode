package Year2020.October.day12;

import java.util.*;

public class Demo02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Demo02 demo02 = new Demo02();
        while (scanner.hasNext()) {
            int N_I = scanner.nextInt();
            int[] I = new int[N_I];
            for (int i = 0; i < N_I; i++) {
                I[i] = scanner.nextInt();
            }
            int N_R = scanner.nextInt();
            int[] R = new int[N_R];
            for (int i = 0; i < N_R; i++) {
                R[i] = scanner.nextInt();
            }
            Map<Integer, List<Integer>> map = new LinkedHashMap<>(); //r[i] {index list}
            int size = demo02.getRule(I, R, map);
            //打印结果
            demo02.print(size, map, I);
        }
    }

    public void print(int size, Map<Integer, List<Integer>> map, int[] I) {
        System.out.print(size);
        for (Integer key : map.keySet()) {
            //1.输出key
            System.out.print(" " + key);
            //2.输出list num
            List<Integer> list = map.get(key);
            System.out.print(" " + list.size());
            //3.输出序列号和对应的值
            for (Integer index : list) {
                System.out.print(" " + index + " " + I[index]);
            }
        }
        System.out.println(); //换行

    }

    /**
     * 一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；
     * 整数范围为0~0xFFFFFFFF，序列个数不限
     * 从R依次中取出R<i>，对I进行处理，找到满足条件的I<j>：
     * I<j>整数对应的数字需要连续包含R<i>对应的数字。
     * 比如R<i>为23，I<j>为231，那么I<j>包含了R<i>，条件满足 。
     */

    public int getRule(int[] I, int[] R, Map<Integer, List<Integer>> map) {
        //1.对R进行排序
        Arrays.sort(R);
        //2.判定I[j]是否包含R[i]
        // Map<Integer, List<Integer>> map = new LinkedHashMap<>(); //r[i] {index list}
        int cnt = 0;
        for (int i = 0; i < R.length; i++) {
            if (i > 0 && R[i] == R[i - 1]) continue;
            for (int j = 0; j < I.length; j++) {
                if (isContain(I[j], R[i])) {
                    if (!map.containsKey(R[i])) {
                        map.put(R[i], new ArrayList<>());
                        cnt += 2;
                    }
                    map.get(R[i]).add(j);
                    cnt += 2;
                }
            }
        }
        return cnt;
    }

    //判定origin是否包含了target
    private boolean isContain(int origin, int target) {
        if (origin < target) return false;
        if (origin == target) return true;
        //判定origin > target的情形
        //1.把target转换为数组类型
        List<Integer> num = new ArrayList<>();
        while (target > 0) {
            num.add(target % 10);
            target /= 10;
        }
        if (num.isEmpty()) num.add(0);
        int index = 0;
        while (origin > 0) {
            int left = origin % 10;
            if (left == num.get(index)) {
                index++;
                if (index == num.size()) break;
            } else {
                index = 0; //重新匹配
                if (left == num.get(index)) {
                    index++;
                    if (index == num.size()) break;
                }
            }
            origin /= 10;
        }
        return index == num.size();
    }

}
