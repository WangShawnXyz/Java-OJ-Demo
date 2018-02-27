package newcoder.leetcode;


/**
 *
 * 题目描述

 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are+,-,*,/. Each operand may be an integer or another expression.

 Some examples:

 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 */

import java.util.Stack;

public class EvaluateReversePolishNotation {


    public int evalRPN(String[] tokens) {
        Stack<Integer> S = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++){
//            if ('0'<= tokens[i].charAt(0) && tokens[i].charAt(0) <= '9'){
            try {
                int num = Integer.parseInt(tokens[i]);
                S.push(num);
            }catch (Exception e){
                int num2 = S.pop();
                int num1 = S.pop();
                int res = 0;
                try {
                    switch (tokens[i]){
                        case "+": res = num1 + num2; break;
                        case "-": res = num1 - num2; break;
                        case "*": res = num1 * num2; break;
                        case "/": res = num1 / num2; break;
                    }
                } catch (Exception e1){
                    return 0;
                }

                S.push(res);
            }
        }

        return S.pop();
    }

    public static void main(String[] args){
        String[][] s = new String[5][];
        String[] s1 = {"2", "1", "+", "3", "*"};
        String[] s2 = {"3", "0", "/"};
        String[] s3 = {"0", "3", "/"};
        String[] s4 = {"3", "0", "/"};
        String[] s5 = {"3", "-4", "+"};
        s[0] = s1;
        s[1] = s2;
        s[2] = s3;
        s[3] = s4;
        s[4] = s5;

        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
        for (int i = 0; i < s.length; i ++){
            System.out.println(e.evalRPN(s[i]));

        }
//        String i = "123";
//        System.out.println(Integer.parseInt(i));
    }

}
