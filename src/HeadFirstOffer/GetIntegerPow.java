package HeadFirstOffer;

public class GetIntegerPow {
    public double Power(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return  base;
        double product = getPower(base, exponent);
        if (exponent < 0)
            product = 1 / product;
        return product;
    }
    double getPower(double base, int exponent){
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        if (exponent % 2 == 0){
            return Math.pow(getPower(base, exponent/2), 2);
        }else{
            return Math.pow(getPower(base, exponent/2), 2) * base;
        }
    }

    public static void main(String[] args) {
        GetIntegerPow g = new GetIntegerPow();
        System.out.println(g.Power(0, -3));
    }
}
