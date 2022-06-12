public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
  }
 class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        
        TreeNode current = root;
        TreeNode prev = null;

        while(current != null){
            prev = current;

        if(current.val > val)
            current = current.left;

        else
            current = current.right;
       
    }
        if(prev.val > val)
            prev.left = new TreeNode(val);
        
        else
            prev.right = new TreeNode(val);
        
        return root;
        
    }     
}
