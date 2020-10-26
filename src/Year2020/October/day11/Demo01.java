package Year2020.October.day11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Demo01 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(scanner.next());
        }
        //Demo01 demo01 = new Demo01()
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for(int i=0;i<N;i++){
            System.out.println(list.get(i));
        }
    }
    /**
     * 给定n个字符串，请对n个字符串按照字典序排列。
     */

    public List<String> sortString(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }
}
