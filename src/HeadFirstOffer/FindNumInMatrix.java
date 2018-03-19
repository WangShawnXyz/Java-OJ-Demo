package HeadFirstOffer;

public class FindNumInMatrix {
    /**
     * 思路： 想找的元素一定在比他大的那个数左边
     *        所以先从最左上角开始找
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        if (array == null) return false;
        int width = array[0].length, height = array.length;
        int col = width-1, row = 0;
        while (col >= 0 && col < width && row >= 0 && row < height){
            if (target == array[row][col]) return true;
            else if (target < array[row][col]){
                col --;
            }else {
                row ++;
            }
        }
        return false;
    }
    public void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[i].length; j ++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        FindNumInMatrix s = new FindNumInMatrix();
//        int[][] matrix = new int[3][3];
//        int counter = 0;
//        for (int i = 0; i < matrix.length; i ++){
//            for (int j = 0; j < matrix[i].length; j ++){
//                matrix[i][j] = counter;
//                counter += 2;
//            }
//        }

        //7,[[1,2,8,9],[4,7,10,13]]
        int[][] matrix = new int[2][4];
        int[] line1 = {1, 2, 8, 9};
        matrix[0] = line1;
        int[] line2 = {4,7,10,13};
        matrix[1] = line2;
        s.print(matrix);
        boolean r = s.Find(7, matrix);
        System.out.println(r);
//        for (int i = 0; i < 17; i ++){
//            System.out.println(i + " " + s.Find(i, matrix));
//        }
    }
}
