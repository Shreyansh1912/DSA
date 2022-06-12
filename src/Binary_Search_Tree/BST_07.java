/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        
        if(root == null)
            return null;                             //inorder traversal and after that convert sorted array to BST
        
        addLeftSubTree(root, stack);
        
        while(!stack.isEmpty())
        {
            TreeNode currentNode = stack.pop();
            answer.add(currentNode.val);
        
        if(currentNode.right != null)
            addLeftSubTree(currentNode.right, stack);
        }  
        return arrayToBST(answer, 0, answer.size()-1);
    }
        private void addLeftSubTree(TreeNode currentNode, Stack<TreeNode> stack){
            stack.push(currentNode);
            while(currentNode.left != null){
                stack.push(currentNode.left);
                currentNode = currentNode.left;
            }
            return;
        }
        
    
    private TreeNode arrayToBST(List<Integer> nums, int start, int end){
        if(start > end)
           return null;
           
        int mid = start + (end - start) / 2;
        
        TreeNode newNode = new TreeNode(nums.get(mid), null, null);
        
        newNode.left = arrayToBST(nums, start, mid-1);
        newNode.right = arrayToBST(nums, mid+1, end);
        
        return newNode;
}
}
