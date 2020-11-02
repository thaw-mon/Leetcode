package Year2020.November.day02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Demo04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Demo04 demo04 = new Demo04();
        int[][] matrix = new int[9][9];
        while (scanner.hasNext()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            if(demo04.getSudoKuAnswer(matrix, 0))
                demo04.printMatrix(matrix);
            else {
                System.out.println("error");
            }
        }

    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(matrix[i][matrix[i].length - 1]);
        }
    }

    /**
     * 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。
     * 玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，并且满足每一行、每一列、每一个粗线宫内的数字均含1-9，并且不重复。
     * 输入：
     * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
     * 输出：
     * 完整的9X9盘面数组
     */

    public boolean getSudoKuAnswer(int[][] matrix, int index) {
        //1.通过Stack记录修改的位置
        //0.找到数字为0的位置
        if (index == 81) {
            //递归终止条件
            return true;
        }
        while (index < 81) {
            if (matrix[index / 9][index % 9] == 0) {
                int x = index / 9, y = index % 9;
                //select Fit Number
                List<Integer> fitNum = getFitNum(matrix, x, y);
                if (fitNum.isEmpty()) {
                    return false;
                }
                for (int val : fitNum) {
                    matrix[x][y] = val;
                    // stack.push(new int[]{x, y});
                    if (getSudoKuAnswer(matrix, index + 1)) {
                        return true;
                    }
                    // stack.pop();
                }
                //当前0值无法填充回溯
                matrix[x][y] = 0;
                return false;
            }
            index++;
        }
        return true;
    }

    public List<Integer> getFitNum(int[][] matrix, int x, int y) {
        int[] visited = new int[10];
        //1.满足行为1-9
        for (int i = 0; i < 9; i++) {
            visited[matrix[i][y]]++;
        }
        //2.满足列为1-9
        for (int j = 0; j < 9; j++) {
            visited[matrix[x][j]]++;
        }
        //3.满足当前子模块为1-9
        int x1 = x / 3;
        int y1 = y / 3;
        for (int i = x1 * 3; i < (x1 + 1) * 3; i++) {
            for (int j = y1 * 3; j < (y1 + 1) * 3; j++) {
                visited[matrix[i][j]]++;
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (visited[i] == 0) {
                ret.add(i);
            }
        }
        return ret;
    }
}
