package HeadFirstOffer;

import java.util.Stack;

public class QueueImplementByTwoStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args){
        QueueImplementByTwoStack s = new QueueImplementByTwoStack();
//        s.push(1);
        for (int i = 0; i < 10; i ++){
            s.push(i);
//            System.out.println(s.pop());
        }
        for (int i = 0; i < 10; i ++){
            System.out.println(s.pop());
        }
//        System.out.println(s.pop());
    }
}