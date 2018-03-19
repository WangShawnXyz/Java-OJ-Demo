package HeadFirstOffer;

public class ReverseLinkedListLocal {
    static class LinkedList{
        protected int val;
        protected LinkedList next;

        public LinkedList(int val) {
            this.val = val;
        }
    }
    public static LinkedList reverseLocal(LinkedList head){
        if (head == null) return null;
        if (head.next == null) return head;
        LinkedList prev, tmp, next;
        prev = null;
        tmp = head;
        next = tmp.next;
        while (next != null)
        {
            tmp.next = prev;
            prev = tmp;
            tmp = next;
            next = next.next;
        }
        tmp.next = prev;    //next指向空指针的时候while循环退出了，
                            // tmp指向倒数第一个元素， prev指向倒数第二个
                            //但是tmp的next还是指向最后的null，要手动反转一次
        return tmp;
    }
    public static void main(String[] args) {
        LinkedList HEAD, tmp;
        HEAD = new LinkedList(0);
        tmp = HEAD;
        for (int i = 1; i < 100; i ++){
            tmp.next = new LinkedList(i);
            tmp = tmp.next;
        }
        tmp = HEAD;
        while (tmp != null){
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
        HEAD = reverseLocal(HEAD);
        tmp = HEAD;
        while (tmp != null){
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
    }
}
