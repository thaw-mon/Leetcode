package Year2020.September.day11;

public class Demo05 {

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
     * TODO 注意:空序列要返回false
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length ==0) return false;
        //后序遍历 left right root
        //二叉搜索树 left  < root < right
        return dp(sequence, 0, sequence.length - 1);
    }

    private boolean dp(int[] sequence, int left, int right) {
        if (left >= right) return true;

        int root = sequence[right];
        int leftEnd = left, rightStart = right - 1;
        for (; leftEnd < right; leftEnd++) {
            if (sequence[leftEnd] > root) break;
        }
        //left Tree = [left, leftEnd)
        for (; rightStart >= left; rightStart--) {
            if (sequence[rightStart] < root) break;
        }
        //right Tree (rightTree,Right)
        if (leftEnd != rightStart + 1) return false;
        //进行DP操作

        return dp(sequence, left, leftEnd - 1) && dp(sequence, rightStart + 1, right - 1);

    }

    public static void main(String[] args) {
        int[] s = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(new Demo05().VerifySquenceOfBST(s));
    }
}
