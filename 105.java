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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = search(inorder,rootVal);
        int [] preLeft = Arrays.copyOfRange(preorder,1,rootIdx+1);
        int [] preRight = Arrays.copyOfRange(preorder,rootIdx+1,preorder.length);
        int [] inLeft =Arrays.copyOfRange(inorder,0,rootIdx);
        int [] inRight =Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);
        
        return root;
    }
    
    public int search(int[] inorder,  int value){
        int i=0;
        for(i=0;i<=inorder.length;i++){
            if(inorder[i] == value){
                return i;
            }
        }
        return i;
    }
}