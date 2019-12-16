package July.day05;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于list的contains用法测试
 */
public class Test {

    public static void main(String[] args) {

        List<Integer[]> path = new ArrayList<>();
        path.add(new Integer[]{0,0});
        path.add(new Integer[]{0,1});
        path.add(new Integer[]{1,1});
        List<Integer> a = new ArrayList<>();
        a.add(0); a.add(1);
        List<Integer> b = new ArrayList<>();
        b.add(1); b.add(0);
        if(a.equals(b)){
            System.out.println("list equal");
        }
        Integer[] nextPath = new Integer[]{0,1};
        if(path.indexOf(nextPath)>=0){
            System.out.println("print right answer");
        }
        if(nextPath.equals(new Integer[]{0,1})){
            System.out.println("equal right");
        }
        if(path.contains(nextPath)){
            System.out.println("print right answer2");
        }
    }
}
