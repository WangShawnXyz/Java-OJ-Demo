package HeadFirstOffer;

/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
import java.util.ArrayList;
import java.util.List;

public class PrintListFromTailToHead {
    private ArrayList<Integer> arr = new ArrayList<>();
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null){
            printListFromTailToHead(listNode.next);
            arr.add(listNode.val);
        }
        return arr;
    }

    public static void main(String[] args){
        ListNode Head = new ListNode(-1);
        ListNode head = Head;
        for (int i = 0; i < 10; i ++){
            head.next = new ListNode(i);
            head = head.next;
        }
        PrintListFromTailToHead s = new PrintListFromTailToHead();
        List arr = s.printListFromTailToHead(Head);
        for (int i = 0; i < arr.size(); i ++ ){
            System.out.println(arr.get(i));
        }
    }
}