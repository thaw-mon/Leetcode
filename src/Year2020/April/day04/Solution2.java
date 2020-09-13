package Year2020.April.day04;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), M = in.nextInt(); //分别为职业数目和玩家数目
        char[][] plays = new char[N][M]; //表示每个职业每个玩家的名字（每个玩家由一个字母表示）
        for (int i = 0; i < N; i++) {
            String tmp = in.next();
            plays[i] = tmp.toCharArray();
        }
        Stack<String> question = new Stack<>();//表示玩家的要求
        //格式为 i j X p q 表示 plays[i][j] X plays[p][q] (X 为Y、N，即为yes or no)
        while (true) {
            StringBuilder tmp = new StringBuilder(in.next());
            for (int i = 0; i < 4; i++) {
                tmp.append(" ").append(in.next());
            }
            if (tmp.toString().equals("0 0 N 0 0")) {
                break;
            }
            question.push(tmp.toString());
        }
        //2.使用递归方式
        Solution2 solution2 = new Solution2();
        int[][] used = new int[N][M]; //初始化为-1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                used[i][j] = -1;
            }
        }
        Character[][] answer = new Character[M][N];
        solution2.Combine(plays, question, used, answer);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < answer[i].length; j++)
                System.out.print(answer[i][j]);
            System.out.println(); //换行
        }

    }

    public boolean Combine(char[][] plays, Stack<String> question, int[][] used, Character[][] answer) {
        //要求全部满足，返回true
        if (question.isEmpty()) {
            //把剩余未使用字符进行填充
            for (int i = 0; i < answer.length; i++) {
                for (int j = 0; j < answer[i].length; j++) {
                    //需要填充
                    if (answer[i][j] == null) {
                        for (int k = 0; k < used[j].length; k++) {
                            if (used[j][k] == -1) {
                                answer[i][j] = plays[j][k];
                                used[j][k] = i;
                                break;
                            }
                        }
                    }
                }
            }
            return true;
        }
        //1.解析要求
        String ques = question.pop();
        // i j X p q (结果是减1为初始节点) （i,p表示职业位置 j,q表示对于职业的成员位置）
        int i = ques.charAt(0) - '1';
        int j = ques.charAt(2) - '1';
        char c = ques.charAt(4);
        int p = ques.charAt(6) - '1';
        int q = ques.charAt(8) - '1';
        //2. 判定c为yes or no
        boolean flag = false;
        //组队请求
        if (c == 'Y') {
            //2-1 判定玩家是否已经使用了
            if (used[i][j] >= 0 && used[p][q] >= 0) {
                //判定是否符合要求
                if (used[i][j] == used[p][q]) {
                    flag = Combine(plays, question, used, answer);
                }
            } else if (used[i][j] >= 0) {
                int current = used[i][j];
                used[p][q] = current;
                answer[current][p] = plays[p][q];
                flag = Combine(plays, question, used, answer);
                if (!flag) {
                    used[p][q] = -1;
                    answer[current][p] = null;
                }
            } else if (used[p][q] >= 0) {
                int current = used[p][q];
                used[i][j] = current;
                answer[current][i] = plays[i][j];
                flag = Combine(plays, question, used, answer);
                if (!flag) {
                    used[i][j] = -1;
                    answer[current][i] = null;
                }
            } else {
                //两个用户都未使用：遍历获取初始位置
                //获取answer 第i个职业和第p个职业位置都为 null
                for (int m = 0; m < answer.length; m++) {
                    if (answer[m][i] == null && answer[m][p] == null) {
                        answer[m][i] = plays[i][j];
                        used[i][j] = m;
                        answer[m][p] = plays[p][q];
                        used[p][q] = m;
                        flag = Combine(plays, question, used, answer);
                        if (!flag) {
                            answer[m][i] = null;
                            used[i][j] = -1;
                            answer[m][p] = null;
                            used[p][q] = -1;
                        }
                    }
                }
            }
        } else {
            //不组队请求 麻烦一点可能存在多种假设
            if (used[i][j] >= 0) {
                int current = used[i][j];
                //对应职业还未使用
                if (answer[current][p] == null) {
                    for (int m = 0; m < plays[p].length; m++) {
                        //该职业对应用户已经使用或者属于q
                        if (used[p][m] >= 0 || m == q) {
                            continue;
                        }
                        used[p][m] = current;
                        answer[current][p] = plays[p][m];
                        flag = Combine(plays, question, used, answer);
                        if (flag) break;
                        used[p][m] = -1;
                        answer[current][p] = null;
                    }
                }
            } else if (used[p][q] >= 0) {
                int current = used[p][q];
                //对应职业还未使用
                if (answer[current][i] == null) {
                    for (int m = 0; m < plays[i].length; m++) {
                        //该职业对应用户已经使用或者属于q
                        if (used[p][m] >= 0 || m == j) {
                            continue;
                        }
                        used[i][m] = current;
                        answer[current][i] = plays[i][m];
                        flag = Combine(plays, question, used, answer);
                        if (flag) break;
                        used[i][m] = -1;
                        answer[current][i] = null;
                    }
                }
            } else {
                //两个职业都未使用(创建新行还是使用未使用的行:遍历)
                for (int m1 = 0; m1 < answer.length; m1++) {
                    if (answer[m1][i] != null) continue;
                    for (int m2 = 0; m2 < answer.length; m2++) {
                        if (answer[m2][p] != null || m1 == m2) continue;
                        answer[m1][i] = plays[i][j];
                        used[i][j] = m1;
                        answer[m2][p] = plays[p][q];
                        used[p][q] = m2;
                        flag = Combine(plays, question, used, answer);
                        if (flag) break;
                        answer[m1][i] = null;
                        used[i][j] = -1;
                        answer[m2][p] = null;
                        used[p][q] = -1;
                    }
                }
            }

        }
        if (!flag) question.push(ques); //复原
        return flag;
    }
}
