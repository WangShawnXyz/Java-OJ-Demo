package HeadFirstOffer;

import java.util.HashMap;
import java.util.Map;

public class FrogJumpFloorII {
    /**
     * @desc:一只青蛙一次可以跳上1级台阶，
     * 也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @thinking:
     *  f(0) = 1
     *  f(1) = 1
     *  f(2) = f(2-2) + f(2-1)
     *  f(3) = f(3-3) + f(3-2) + f(3-1)
     *  ...
     *  f(i) = f(i-i) + f(i-i+1) + ... + f(i-2) + f(i-1)
     *  ...
     *  f(n-1) = f(n-n-1+1) + f(n-n-1+2) + f(n-n+3) + ... + f(n-1-2) + f(n-1-1)
     *         = f(0) + f(1) + f(2) + ... + f(n-2)
     *  f(n)   = f(0) + f(1) + f(2) + ... + f(n-2) + f(n-1)
     *         = 2 * f(n-1)
     * @param target
     * @return
     */
    protected Map<Integer, Integer> map = new HashMap<>();

    public FrogJumpFloorII() {
        map.put(0,1);
        map.put(1, 1);
    }

    public int opticalJumpFloorII(int target){
        int tmp;
        if (map.containsKey(target)){
            tmp = map.get(target);
        }else {
            tmp = 2 * opticalJumpFloorII(target-1);
            map.put(target, tmp);
        }
        return tmp;
    }
    public int JumpFloorII(int target) {
     if (target == 0) return 1;
     if (target == 1) return 1;
     return 2*JumpFloorII(target-1);
    }
    public static void main(String[] args) {
        FrogJumpFloorII m = new FrogJumpFloorII();
        for (int i = 0; i < 10; i ++){
            System.out.println(m.opticalJumpFloorII(i));
            System.out.println(m.JumpFloorII(i));
        }
    }
 }
