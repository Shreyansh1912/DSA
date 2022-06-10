package Binary_Search_Tree;
class TreeNode {
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

public class BST_01{
    public TreeNode searchBST(TreeNode root, int val) {

        if(root == null) return null;

        if(root.val == val) return root;

        if(root.val > val) return searchBST(root.left, val);

        return searchBST(root.right, val);            // TC : o(logN)
    }
}
