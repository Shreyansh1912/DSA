/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return reverseList(addTwoNumbersInReverse(reverseList(l1), reverseList(l2)));
    }
    public ListNode reverseList(ListNode head) {
        //TC: O(N), SC: O(1)
        
        ListNode current = head;
        ListNode prev = null;
        ListNode tempNode = null;
        
        while(current != null){
            tempNode = current.next;
            current.next = prev;
            prev = current;
            current = tempNode;
            
        }
        return prev;
    }
    
    public ListNode addTwoNumbersInReverse(ListNode l1, ListNode l2) {
        //Tc: O(m+n) SC: O(max(m,n))
        ListNode dummyNode = new ListNode(-1);
        ListNode result = dummyNode;
        int carry=0;
        
        while(l1 != null && l2 != null){
            int currentVal = l1.val + l2.val + carry;
            carry = currentVal / 10;
            
            ListNode newNode = new ListNode(currentVal % 10);
            result.next = newNode;
            
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int currentVal = l1.val + carry;
            carry = currentVal / 10;
            ListNode newNode = new ListNode(currentVal%10);
            result.next = newNode;
            result = result.next;
            l1=l1.next;
        }
        while(l2 != null){
            int currentVal = l2.val + carry;
            carry = currentVal / 10;
            ListNode newNode = new ListNode(currentVal%10);
            result.next = newNode;
            result = result.next;
            l2=l2.next;
        }
        if(carry == 1) 
            result.next = new ListNode(1);
        
        return dummyNode.next;
        
    }
}
