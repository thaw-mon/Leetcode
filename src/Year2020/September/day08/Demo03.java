package Year2020.September.day08;

public class Demo03 {

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        //定义三个变量
        int[] ret = new int[3];
        //初始化
        ret[0] = 0;
        ret[1] = 1;
        // ret[2] = 2;
        int p = 2; //指针指向待修改节点
        if (n < 2) return ret[n];
        for (int i = 2; i <= n; i++) {
            ret[p] = ret[(p + 1) % 3] + ret[(p + 2) % 3];
            p = (p + 1) % 3;
        }
        return ret[(p + 2) % 3];
    }

    public static void main(String[] args){
        System.out.println(new Demo03().Fibonacci(4));
    }
}
