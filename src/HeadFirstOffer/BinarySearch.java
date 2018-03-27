package HeadFirstOffer;

public class BinarySearch {
    public int binSearch(int[] A, int target){
        if (A == null) return -1;
        int left = 0, right = A.length-1;
        int bin = (left + right)/2;
        while (left <= right){
            if (A[bin] == target){
                return bin;
            }
            if (target < A[bin]){
                right = bin - 1;
            }else{
                left = bin + 1;
            }
            bin = (left + right)/2;
        }
        return -1;
    }
//    public int bi

    public static void main(String[] args) {
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i ++){
            arr[i] = i;
//            arr[i] = 5;
        }
        BinarySearch s = new BinarySearch();
        System.out.println(s.binSearch(arr, 0));
        System.out.println(s.binSearch(arr, 5));
        System.out.println(s.binSearch(arr, 10));
        System.out.println(s.binSearch(arr, 12));
        System.out.println(s.binSearch(null, 12));



    }
}
