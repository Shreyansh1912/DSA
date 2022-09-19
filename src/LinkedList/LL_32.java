public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) 
            return head;
        
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        
        while(fastPtr.next != null && fastPtr.next.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        ListNode rightHalf = slowPtr.next;
        slowPtr.next = null;
        
        ListNode leftHalf = head;
        
        ListNode leftList = sortList(leftHalf);
        ListNode rightList = sortList(rightHalf);
        
        return mergeTwoList(leftList, rightList);
    }
    
    public ListNode mergeTwoList(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(-1);
        ListNode result = dummyNode;
        
        ListNode p1 = list1;
        ListNode p2 = list2;
        
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                ListNode newNode = new ListNode(p1.val);
                result.next = newNode;
                result = result.next;
                p1 = p1.next;
            }else{
                ListNode newNode = new ListNode(p2.val);
                result.next = newNode;
                result = result.next;
                p2 = p2.next;
            }
        }
        if(p1 != null)
            result.next = p1;
        
        if(p2 != null)
            result.next = p2;
        
     return dummyNode.next;   
    }
}
