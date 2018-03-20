package HeadFirstOffer;

public class CountOneInBytes {
    public int countOneInBytes(int n){
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count ++;
        }
        return count;
    }
    public static void main(String[] args) {
        Integer i = 27;
        byte b = i.byteValue();
        String s = b + "";
        System.out.println(Integer.toBinaryString(i));
    }
}
