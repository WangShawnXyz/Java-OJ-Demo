package HeadFirstOffer;

/**
 * 题目描述
 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 每一次只能向左，右，上，下四个方向移动一格，
 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，
 机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RobotTraversalMaze {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows*cols; i ++) visited[i] = false;
        return movingCountCore(threshold, rows, cols, 0, 0, visited, 0);
    }
    int movingCountCore(int threshold, int rows, int cols,
                               int row, int col, boolean[] visited, int count){
        if (row >= 0 && row < rows && col >= 0 && col < cols &&
                visited[row * cols + col] == false && check(threshold, row, col)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row + 1, col, visited, count)
                    + movingCountCore(threshold, rows, cols, row - 1, col, visited, count)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited, count)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited, count);
        }
        return count;
    }
    boolean check(int threshold, int row, int col){
        if (getDigitSum(row) + getDigitSum(col) > threshold)
            return false;
        else
            return true;
    }
    int getDigitSum(int num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        RobotTraversalMaze s = new RobotTraversalMaze();
        int count = s.movingCount(15, 10, 1);
        System.out.println(count);
    }
}
