package HeadFirstOffer;

public class SetOddBeforeEven {
    public void reOrderArray(int [] array) {
        int len = array.length;
        int[] ordered = new int[len];
        int i = 0, j = len - 1;
        for (int k = 0, l = len-1; k < len; k ++, l --){
            if (array[l] % 2 == 0){
                ordered[j] = array[l];
                j --;
            }
            if (array[k] % 2 == 1){
                ordered[i] = array[k];
                i ++;
            }
        }
        for (int k = 0; k < ordered.length; k ++){
            array[k] = ordered[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i ++){
            arr[i] = i;
        }
        SetOddBeforeEven s = new SetOddBeforeEven();
        s.reOrderArray(arr);
        for (int i = 0; i < arr.length; i ++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
