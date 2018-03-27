package HeadFirstOffer;

public class QuickSort {

    public void quickSort(int[] A, int l, int h){
        if (A == null) return;
        int p = h;
        if (h - l > 0){
            p = partition(A, l, h);
            quickSort(A, l, p - 1);
            quickSort(A, p + 1, h);
        }
    }

    int partition(int[] A, int l, int h){
        int p = h;  // 存中枢的位置
        int firsthigh = l;
        int i; //计数器
        for (i = l; i < h; i ++){
            if (A[i] < A[p]){
                swap(A, i, firsthigh);
                firsthigh ++;
            }
        }
        swap(A, firsthigh, p);
        return firsthigh;
    }
    void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] A = new int[20];
        int count = 20;
        for (int i = 0; i < 20; i ++ ){
            A[i] = count;
//            count --;
            count ++;
        }
        A = new int[1];
        A[0] = 1;
        s.quickSort(A, 0, A.length-1);
        for (int i = 0; i < A.length; i ++){
            System.out.print(A[i] + " ");
        }
    }
}
