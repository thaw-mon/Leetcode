package Year2020.January.Test;

import java.util.*;

public class Main2 {


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        Scanner in = new Scanner(System.in);
        //读取输入
        List<String> str = new ArrayList<>();
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            str.add(in.next());
        }
        //把str转换为树形结构
        int index = 0, n = str.size();
        int level = 1;
        while (index < n) {
            //每层输出level个元素 [index,index+level)
            for (int i = level - 1; i > 0; i--) {
                System.out.print(str.get(index + i) + " ");
            }
            if(index + level >= n) //最后一层的元素
                System.out.println(str.get(index));
            else
                System.out.print(str.get(index) + " ");
            index += level;
            level <<= 1; //乘2操作
        }

    }
}
