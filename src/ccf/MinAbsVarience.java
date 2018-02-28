package ccf;

import java.util.Scanner;

public class MinAbsVarience {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i ++){
            a[i] = in.nextInt();
        }
        int min = 99999;
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j ++){
                if(i == j) {
                    continue;
                }
                min = Math.min(min, Math.abs(a[i] - a[j]));
            }
        }

        System.out.println(min);
    }
}
