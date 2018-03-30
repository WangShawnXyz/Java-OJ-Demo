package HeadFirstOffer;

import java.util.ArrayList;

public class ClockPrint {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null) return null;
        ArrayList<Integer> res = new ArrayList<>();
        int up = 0, down = matrix.length-1;
        int left = 0, right = matrix[0].length-1;

        while (up <= down && left <= right){
            for (int i = left; i <= right; i ++) //从左到右
                res.add(matrix[up][i]);
            for (int i = up + 1; i <= down; i ++)   //从上到下
                res.add(matrix[i][right]);
            if (up != down)
                for (int i = right-1; i >= left && up < down; i --)// 从右到左
                    res.add(matrix[down][i]);
            if (left != right)
                for (int i = down-1; i > up; i --)   //从下到上
                    res.add(matrix[i][left]);
            left ++; up ++;
            right --; down --;
        }
        return res;
    }

    public static void main(String[] args) {
        ClockPrint s = new ClockPrint();
//        int[][] matrix = new int[4][];
//        matrix[0] = new int[]{1, 2, 3, 4};
//        matrix[1] = new int[]{5, 6, 7, 8};
//        matrix[2] = new int[]{9, 10, 11, 12};
//        matrix[3] = new int[]{13, 14, 15, 16};
        int[][] matrix = new int[1][];
        matrix[0] = new int[]{1, 2, 3, 4, 5};
        matrix[0] = new int[]{1};
        ArrayList<Integer> res = s.printMatrix(matrix);
        for (int i = 0; i < res.size(); i ++){
            System.out.print(res.get(i) + " ");
        }
    }
}
