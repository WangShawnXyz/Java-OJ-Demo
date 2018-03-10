package ccf;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BorrowClassroomKey {
    static int maxTime = 0;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i ++){
            arr[i] = i + 1;
        }
        List<Teacher> teachers = new ArrayList<Teacher>();
        List<Integer> keys = new ArrayList<Integer>();
        for (int i = 0; i < K; i ++){
            teachers.add(new Teacher(in.nextInt(), in.nextInt(), in.nextInt()));
        }

        int time = 0;
        while (time <= maxTime){
            returnKey(time, teachers, arr, keys);
            borrowKey(time, teachers, arr);
            time ++;
        }
        for (int i = 0; i < arr.length; i ++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void returnKey(int time, List<Teacher> teachers,
                                 int[] arr, List<Integer> keys){
        keys.clear();
        for (int i = 0; i < teachers.size(); i ++){
            Teacher t = teachers.get(i);
            if (t.end == time){
                keys.add(t.keyNum);
            }
        }
        if (keys.isEmpty()){
            return;
        }else {
            for (int i = 0; i < keys.size()-1; i ++){
//                boolean flag = true;
                for (int j = 0; j  < keys.size()-i-1; j ++){
                    if (keys.get(j) > keys.get(j+1)){
                        Integer tmp = keys.get(j);
                        keys.set(j, keys.get(j+1));
                        keys.set(j+1, tmp);
                    }
                }
            }
            //还钥匙
            for (int i = 0, j = 0; i < arr.length; i ++){
                if (arr[i] == 0){
                    arr[i] = keys.get(j);
                    if (j == keys.size()-1){
                        break;
                    }else {
                        j ++;
                    }
                }
            }
        }
    }
    public static void borrowKey(int time, List<Teacher> teachers,
                                 int[] arr){

        for (int i = 0; i < teachers.size(); i ++){
            if (time == teachers.get(i).start){
                for (int j = 0; j < arr.length; j ++){
                    if (teachers.get(i).keyNum == arr[j]){
                        arr[j] = 0;
                        break;
                    }
                }
            }
        }

    }
    static class Teacher{
        int keyNum;
        int start;
        int succ;
        int end;

        public Teacher(int keyNum, int start, int succ) {
            this.keyNum = keyNum;
            this.start = start;
            this.succ = succ;
            this.end = start + succ;
            if (this.end > maxTime){
                maxTime = this.end;
            }
        }


    }
}