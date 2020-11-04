package Year2020.November.day03;

import java.util.Scanner;

public class Demo04 {

    /**
     * 问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，
     * 线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。
     * 要求按顺序向数组赋值ABCDABCDABCD，ABCD的个数由线程函数1的参数指定。
     */

    private final static int THREAD_NUM = 4;
    private static char[] chs = new char[1032*THREAD_NUM];
    public static void main(String[] args) {
        createThreads();
        Scanner sc  = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(new String(chs).substring(0, n*THREAD_NUM));
        }
        sc.close();
    }

    //创建线程并进行调用
    private static void createThreads(){
        char ch = 'A';
        for(int i = 0; i < THREAD_NUM; i++){
            new Thread(new InnerThread(ch++, i)).start();
        }
    }

    //内部线程类
    private static class InnerThread implements Runnable{
        private char ch;
        private int index;
        public InnerThread(char ch, int index){
            this.ch = ch;
            this.index = index;
        }

        public void run() {
            while(this.index < chs.length){
                chs[this.index] = this.ch;
                this.index += THREAD_NUM;
            }
        }
    }
}
