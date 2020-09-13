package Year2020.April.day11;

import java.util.*;

public class Demo01 {

    // 本题为考试单行多行输入输出规范示例，无需提交，不计分。
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> operator = new HashMap<>();
        operator.put("PUSH", 1);
        operator.put("TOP", 2);
        operator.put("POP", 3);
        operator.put("SIZE", 4);
        operator.put("CLEAR", 5);


        int n = in.nextInt(); //表示输入数据数目
        for (int i = 0; i < n; i++) {
            int opNum = in.nextInt(); //表示输入操作数目
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < opNum; j++) {
                String op = in.next();
                switch (operator.get(op)) {
                    case 1:
                        queue.add(in.nextInt());
                        break;
                    case 2:
                        if (queue.isEmpty()) {
                            System.out.println("-1");
                        } else
                            queue.peek();
                        break;
                    case 3:
                        if (queue.isEmpty()) {
                            System.out.println("-1");
                        } else
                            System.out.println(queue.poll());
                        break;
                    case 4:
                        System.out.println(queue.size());
                        break;
                    case 5:
                        queue.clear();
                        break;
                    default:
                        break;
                }
            }
        }

    }
}
