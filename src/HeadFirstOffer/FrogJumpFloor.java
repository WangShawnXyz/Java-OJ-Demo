package HeadFirstOffer;

public class FrogJumpFloor {
    /**
     *  0级台阶应该是有1中跳法
     *  1级台阶就一种跳法
     *  然后是斐波那契数列
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        int a = 0, b = 1, t;
        for (int i = 0; i <= target; i ++){
            t = a;
            a = a + b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        FrogJumpFloor s = new FrogJumpFloor();
        for (int i = 0; i < 10; i ++){
            System.out.println(i + " " + s.JumpFloor(i));
        }
    }
}