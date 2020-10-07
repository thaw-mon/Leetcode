package Year2020.October.day02;

public class Demo03 {

    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * (1+n) * n / 2 == (1 + n) * n >> 1 无法解决乘法
     * 思路使用短路原理
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        boolean x = (n > 1) && ((n += Sum_Solution(n - 1)) > 0); // bool x只是为了不报错
        return n;
    }
}
