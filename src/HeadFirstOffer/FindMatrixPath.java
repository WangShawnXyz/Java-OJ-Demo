package HeadFirstOffer;

/**
 * 题目描述
 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，
 向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 路径不能再次进入该格子。
 */
public class FindMatrixPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        boolean[] vistied = new boolean[matrix.length];
        for (int i = 0; i < rows * cols; i ++){
            vistied[i] = false;
        }
        int curLength = 0;
        for (int i = 0; i < rows; i ++){
            for (int j = 0; j < cols; j ++){
                if(hasPathCore(matrix, rows, cols, i, j, curLength, str, vistied))
                    return true;
            }
        }
        return false;
    }
    public boolean hasPathCore(char[] matrix, int rows, int cols,
                               int row, int col, int curLength, char[] str,
                               boolean[] visited){
        //注意curLength是从0开始的，要+1才是字符串的长度
        if (curLength+1 > str.length) return true;//当前的递归深度比目标串长了就找到了
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row*cols + col] == str[curLength]
                && visited[row*cols + col] == false){
            visited[row*cols + col] = true;
            curLength ++;
            hasPath = hasPathCore(matrix, rows, cols, row + 1, col, curLength, str, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, curLength, str, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, curLength, str, visited)
                    || hasPathCore(matrix, rows, cols, row, col - 1, curLength, str, visited);
            if (!hasPath){
                curLength --;
                visited[row * cols + col] = false;
            }
        }

        return hasPath;
    }
    public static void main(String[] args) {
        String s = "wangshuoxyzwshua";
        char[] matrix = s.toCharArray();
        char[] target = new char[]{'w', 'a', 'n', 'g', 'o'};
        FindMatrixPath sl = new FindMatrixPath();
        System.out.println(sl.hasPath(matrix, 4, 4, target));
    }
}
