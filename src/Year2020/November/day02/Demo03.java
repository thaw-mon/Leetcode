package Year2020.November.day02;

import java.util.*;

public class Demo03 {

    public List<int[]> minPath = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Demo03 demo03 = new Demo03();
        while (scanner.hasNext()) {
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            int[][] matrix = new int[row][column];
            for (int i = 0; i < row; i++)
                for (int j = 0; j < column; j++)
                    matrix[i][j] = scanner.nextInt();

            boolean[][] visited = new boolean[row][column];

            List<int[]> path = new ArrayList<>();
            demo03.dp(matrix, 0, 0, path, visited);
            demo03.printPath();
        }
    }

    /*public void initPath(){
        minPath =
    }*/
    public void printPath() {
        for (int[] node : minPath) {
            System.out.println("(" + node[0] + "," + node[1] + ")");
        }
        minPath.clear();
    }

    /**
     * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10）
     * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
     * 输出最短路径
     */


    public void dp(int[][] matrix, int x, int y, List<int[]> path, boolean[][] visited) {
        visited[x][y] = true;
        path.add(new int[]{x, y});

        int row = matrix.length, column = matrix[0].length;
        if (x == row - 1 && y == column - 1) {
            //到达目的地 : 判定当前路径和历史路径长短
            if (minPath.isEmpty() || minPath.size() > path.size()) {
                //minPath = path; //Error 这是引用，存在问题
                minPath = new LinkedList<>(path);
            }
            visited[x][y] = false;
            path.remove(path.size() - 1);
            return;
        }

        if (x + 1 < row && matrix[x + 1][y] == 0 && !visited[x + 1][y]) {
            dp(matrix, x + 1, y, path, visited);
        }
        if (x - 1 >= 0 && matrix[x - 1][y] == 0 && !visited[x - 1][y]) {
            dp(matrix, x - 1, y, path, visited);
        }
        if (y + 1 < column && matrix[x][y + 1] == 0 && !visited[x][y + 1]) {
            dp(matrix, x, y + 1, path, visited);
        }
        if (y - 1 >= 0 && matrix[x][y - 1] == 0 && !visited[x][y - 1]) {
            dp(matrix, x, y - 1, path, visited);
        }

        visited[x][y] = false;
        path.remove(path.size() - 1);

    }
}
