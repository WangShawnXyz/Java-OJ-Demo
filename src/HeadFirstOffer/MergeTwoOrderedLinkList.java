package HeadFirstOffer;

public class MergeTwoOrderedLinkList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode HEAD = new ListNode(0);
        ListNode tmp = HEAD;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                tmp.next = list1;
                list1 = list1.next;
            }else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        while (list1 != null){
            tmp.next = list1;
            list1 = list1.next;
            tmp = tmp.next;
        }
        while (list2 != null){
            tmp.next = list2;
            list2 = list2.next;
            tmp = tmp.next;
        }
        return HEAD.next;
    }

    public static void main(String[] args) {
        MergeTwoOrderedLinkList s = new MergeTwoOrderedLinkList();
        ListNode h1 = new ListNode(-1);
        ListNode h2 = new ListNode(-2);
        ListNode t1, t2, H1 = h1, H2 = h2;
        for (int i = 0; i < 20; i ++){
            if(i % 2 == 0){
                t1 = new ListNode(i);
                h1.next = t1;
                h1 = h1.next;
            }else {
                t2 = new ListNode(i);
                h2.next = t2;
                h2 = h2.next;
            }
        }
//        h1 = s.Merge(H1, H2); //常见数据
//        h1 = s.Merge(H1, null);
//        h1 = s.Merge(null, H2);
        h1 = s.Merge(null, null);


        while (h1 != null){
            System.out.println(h1.val + " ");
            h1 = h1.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
