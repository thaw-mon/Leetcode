package Year2020.November.day03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Demo03 {


    /**
     * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，
     * 删除后如果链表中无节点则返回空指针。
     * 1 输入链表结点个数
     * 2 输入头结点的值
     * 3 按照格式插入各个结点
     * 4 输入要删除的结点的值
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Map<Integer, Integer> map = new HashMap<>(); //使用map临时代替链表
            Integer head = scanner.nextInt();
            map.put(head, null);
            for (int i = 1; i < n; i++) {
                int val = scanner.nextInt();
                int pre = scanner.nextInt();
                if (map.get(pre) == null) {
                    map.put(pre, val);
                    map.put(val, null);
                } else {
                    int mid = map.get(pre);
                    map.put(pre, val);
                    map.put(val, mid);
                }
            }
            //
            int node = scanner.nextInt(); //删除节点
            if (node == head) { //删除的是头节点
                head = map.get(head);
            } else {
                Integer p = head;
                while (map.get(p) != node) {
                    p = map.get(p);
                }
                int next = map.get(node);
                map.put(p, next);
            }
            map.remove(node);
            //从head开始打印节点
            if (head == null) { //空链表
                continue;
            }
            Integer p = head;
            while (p != null) {
                System.out.print(p + " ");
                p = map.get(p);
            }
            System.out.println();
        }
        scanner.close();
    }

}
