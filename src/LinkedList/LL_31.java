class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode current = head;
                                       //BruteForce Approach --> TC: O(N), SC: O(N)
        while(current != null){
            
            if(seen.contains(current))
                return true;
            
            seen.add(current);
            current = current.next;
        }
        return false;
    }
}
