package Year2020.January.Test;

public class exam1 {

    public static void main(String[] args){
        System.out.println(new exam1().champagneTower(2,1,1));
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    //使用递归策略

    int maxLen = 0; //使用全局变量定义最大长度(节点长度)
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int len = helper(root);
        return maxLen - 1;
    }
    //功能：返回以root为节点的路径最大值
    private int helper(TreeNode root){
        if(root == null) return 0;
        //1.获取左右子树长度
        int left = helper(root.left);
        int right = helper(root.right);
        if(left + right + 1 > maxLen) maxLen = left + right + 1;
        return Math.max(left,right) + 1;
    }


    //使用数学方法进行计算
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row+2][query_row+2];
        dp[0][0]=(double)poured;
        for(int i=0;i<=query_row;i++){
            for(int j=0;j<=i;j++){
                if(dp[i][j] > 1){
                    dp[i+1][j] += (dp[i][j] - 1) / 2.0;
                    dp[i+1][j+1] += (dp[i][j] - 1) / 2.0;
                }
            }
        }
        if(dp[query_row][query_glass]<1.0)
            return dp[query_row][query_glass];
        return 1.0;
    }
}
