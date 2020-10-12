package Year2020.October.day06;

public class Demo01 {

    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int n = matrix.length;
        if (str.length == 0) return true;
        if (matrix.length < str.length) return false;
        boolean[][] visited = new boolean[rows][cols];
        //1.获取首字符的全部起始节点
        for (int i = 0; i < n; i++) {
            if (matrix[i] == str[0]) {
                //判定是否符合添加
                if (getPath(matrix, rows, cols, str, i, 0, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean getPath(char[] matrix, int rows, int cols, char[] str, int start, int index, boolean[][] visited) {

        int i = start / cols;
        int j = start % cols;
        if (matrix[start] == str[index])
            visited[i][j] = true;
        else
            return false;
        if (index == str.length - 1) return true; //字符匹配成功

        //进行上下左右尝试
        boolean ret = false;
        if (i - 1 >= 0 && !visited[i - 1][j]) {
            ret = getPath(matrix, rows, cols, str, (i - 1) * cols + j, index + 1, visited);
        }
        if (!ret && i + 1 < rows && !(visited[i + 1][j])) {
            ret = getPath(matrix, rows, cols, str, (i + 1) * cols + j, index + 1, visited);
        }
        if (!ret && j - 1 >= 0 && !visited[i][j - 1]) {
            ret = getPath(matrix, rows, cols, str, i * cols + j - 1, index + 1, visited);
        }
        if (!ret && j + 1 < cols && !visited[i][j + 1]) {
            ret = getPath(matrix, rows, cols, str, i * cols + j + 1, index + 1, visited);
        }
        visited[i][j] = false; //复原
        return ret;
    }

    public static void main(String[] args) {
        String matrix = "AAAAAAAAAAAA";
        String str = "AAAAAAAAAAAA";
        Demo01 demo01 = new Demo01();
        boolean ret = demo01.hasPath(matrix.toCharArray(), 3, 4, str.toCharArray());
        System.out.println(ret);
    }
}


//"ABCESFCSADEE",3,4,"ABCB"
//ABCE
//SFCS
//ADEE