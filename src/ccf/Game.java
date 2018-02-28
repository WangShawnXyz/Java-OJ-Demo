package ccf;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        Queue q = new LinkedList();
        for (int i = 1; i <= n; i ++){
            q.offer(i);
        }
        int counter = 0;
        while (q.size() > 1){
            counter ++;
            if (counter % k == 0 || counter % 10 == k) {
                q.poll();
            }else{
                q.offer((int)q.poll());
            }

        }
        System.out.println((int)q.poll());
    }
}
