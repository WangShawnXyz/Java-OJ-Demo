package newcoder.huawei;

import java.util.Scanner;

public class JumpedArray {
    public static int jump(int[] A) {
        if(A.length <= 1){
            return 0;
        }
        int i = 0,j = 0;
        int count = 0;
        while(i < A.length){
            if(i + A[i] >= A.length - 1){
                count++;
                return count;
            }
            int temp = Integer.MIN_VALUE;
            for(int k = i + 1;k <= i + A[i]; k++){
                if(temp < k + A[k]){
                    temp = k + A[k];
                    j = k;
                }
            }
            i = j;
            count++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0 ;i < n ;i++) {
            a[i] = sc.nextInt();
        }
        int step = 0;
        step = jump(a);
        System.out.println(step);
    }
}
