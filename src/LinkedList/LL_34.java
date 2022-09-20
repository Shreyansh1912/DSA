public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseLinkedListinKGroup(head, k);
    }
    private ListNode reverseLinkedListinKGroup(ListNode head, int k){
        
        if(head == null) 
            return null;
        
        //Boolean check = validate(head, k);
        ListNode lastNodeOfCurrentBatch = validate(head, k);
        
        if(lastNodeOfCurrentBatch != null)
        {
//             ListNode current = head;
//             int currentLength = 1;
            
//             while(current.next != null && currentLength < k){
//                 currentLength += 1;
//                 current = current.next;
//             }
            ListNode tempNode = lastNodeOfCurrentBatch.next;
            lastNodeOfCurrentBatch.next = null;
            
            ListNode reversedList = reverseLinkedList(head);
            head.next = reverseLinkedListinKGroup(tempNode, k);
            
            return reversedList;
        }else{
            return head;
        }
    }
    
     private ListNode validate(ListNode head, int k){
   // private boolean validate(ListNode head, int k){
        ListNode current = head;
        int currentLength = 1;
        
        while(current.next != null && currentLength < k){
                currentLength += 1;
                current = current.next;
            }
       // return currentLength == k;
        return currentLength == k ? current:null;
        }
    
    private ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        
        while(current != null){
            ListNode tempNode = current.next;
            current.next = prev;
            prev = current;
            current = tempNode;
        }
        return prev;
    }
}
