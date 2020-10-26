package Year2020.October.day11;

import sun.jvm.hotspot.tools.soql.SOQL;

import java.util.*;

public class Demo03 {
    static class Product implements Comparable<Product> {
        public int No;
        public int value;
        public int p;
        public int q;
        public boolean isVisited;

        Product(int v, int _p, int _q) {
            value = v;
            p = _p;
            q = _q;
            No = -1;
            isVisited = false;
        }

        public int compareTo(Product obj) {    //compareTo()方法实现排序功能
            if (this.p != obj.p) {        //首先判断两个值是否相等
                return obj.p - this.p;    //结果为正，实现降序排列
            } else if (this.q != obj.q) {
                return (this.q - obj.q);
            } else {
                return value - obj.value;
            }
        }

    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Demo03 demo03 = new Demo03();
        int N = scanner.nextInt(), m = scanner.nextInt();
        Map<Integer, Product> map = new HashMap<>();
        Product[] products = new Product[m];
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            products[i] = new Product(v, p, q);
            products[i].No = i + 1;
            map.put(i + 1, products[i]);
        }
        Arrays.sort(products);
        //思路，首选p值大的，其次，经可能把N用尽，每个product只能选择一次
        int ans = demo03.dp(products, map, 0, N, 0);
        System.out.println(ans);
    }

    //算法结果超时了
    private int dp(Product[] products, Map<Integer, Product> map, int index, int Value, int currentVal) {

        if (index == products.length || Value == 0) {
            return currentVal;
        }
        int ret = currentVal;
        //
        for (int i = index; i < products.length; i++) {
            Product son = products[i];
            if (son.isVisited || son.value > Value) continue;
            //选择当前值
            if (son.q == 0 || map.get(son.q).isVisited) {
                son.isVisited = true;
                int answer = dp(products, map, i + 1, Value - son.value, currentVal + son.value * son.p);
                ret = Math.max(ret, answer);
                son.isVisited = false;
            } else {
                //判定前驱节点是否选择了，未选择是否可以选择
                Product parent = map.get(son.q);
                if (parent.value + son.value <= Value) {
                    parent.isVisited = true;
                    son.isVisited = true;
                    int answer = dp(products, map, i + 1, Value - (son.value + parent.value), currentVal + son.value * son.p + parent.value * parent.p);
                    ret = Math.max(ret, answer);
                    son.isVisited = false;
                    parent.isVisited = false;
                }
            }
        }

        return ret;
    }

    //思路：转换为背包问题
    static class Product2 {
        public int value;
        public int p;
        public int q;
        public List<Product2> subProduct;

        Product2(int v, int _p, int _q) {
            value = v;
            p = _p;
            q = _q;
            subProduct = new ArrayList<>();
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       // Demo03 demo03 = new Demo03();
        int N = scanner.nextInt(), m = scanner.nextInt();
        Product2[] products = new Product2[m + 1];
        for (int i = 1; i <= m; i++) {
            int v = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            products[i] = new Product2(v, p, q);
            if (q > 0) {
                products[q].subProduct.add(products[i]);
            }
        }
        int[][] dp = new int[m + 1][N + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= N; j++) {
                //分类讨论
                if (products[i].q > 0) { //附件默认跳过
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                    int sumValue = products[i].value, sumDp = sumValue * products[i].p;
                    //当前为主件
                    //1. only 主件
                    if (j >= sumValue)
                        dp[i][j] = Math.max(dp[i - 1][j - sumValue] + sumDp,dp[i][j]);
                    if (products[i].subProduct.isEmpty()) continue;
                    //2 增加任一附件
                    for (Product2 product : products[i].subProduct) {
                        int subValue = products[i].value + product.value;
                        if (j >= subValue)
                            dp[i][j] = Math.max(dp[i - 1][j - subValue] + (products[i].value * products[i].p + product.value * product.p),dp[i][j]);
                        sumValue += product.value;
                        sumDp += product.value * product.p;
                    }
                    //3 增加全部附件
                    if (j >= sumValue)
                        dp[i][j] = Math.max(dp[i - 1][j - sumValue] + sumDp,dp[i][j]);

                }
            }
        }
        System.out.println(dp[m][N]);
    }

}
