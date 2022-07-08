package LinkedList;

 class ListNode {
      int val;
      ListNode next;
       ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class LL_01 {
    public ListNode reverseList(ListNode head) {
        ListNode dummyNode = null;

        while(head != null){
            ListNode next = head.next;
            head.next = dummyNode;
            dummyNode = head;
            head = next;
        }
        return dummyNode;
    }
}
