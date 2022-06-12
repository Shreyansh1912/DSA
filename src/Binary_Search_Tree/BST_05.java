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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) 
            return null;
        
        if(root.val > key)
            root.left = deleteNode(root.left, key);
        
        else if(root.val < key)
            root.right = deleteNode(root.right, key);
        
        else{
            // case 1: if delete node is a leaf node
            if(root.left == null && root.right == null){
                root = null;
              return null; // set a null to a node because we return a root
             }
            
            if(root.left != null && root.right == null){ // case 2: if delete node is a node having 1 child . then node is either left,right
                root = root.left;
                  return root;
            }
            
            if(root.left == null && root.right != null){ // case 2: if delete node is a node having 1 child
                root = root.right;
            return root;
            }
            
            // case 3: delete a node having two childrens
            TreeNode subsNode = findMinNode(root.right);   // find a node whose value is just greater than delete node value therefore value is present on right subTree and value is minimum on rightSubtree which is on leftside
            root.val = subsNode.val;
            
            root.right = deleteNode(root.right, subsNode.val);
        }
        return root;
    }
       private TreeNode findMinNode(TreeNode current)
       {
           while(current.left != null)
               current = current.left;
           return current;
        
        }
}
