package medium;

import util.TreeNode;

/**
 * 
 * @Title  Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * @Description 
 * Given inorder and postorder traversal of a tree, construct the binary tree.

	Note:
	You may assume that duplicates do not exist in the tree.
 */
public class T106 {

	public static void main(String[] args) {
		T106 t106=new T106();
		int []inorder={3,2,1};
		int []postorder={3,2,1};
		t106.mid(t106.buildTree(inorder, postorder));
		
	}
	public void mid(TreeNode root){
		if(root==null) return;
		mid(root.left);
		System.out.println(root.val);
		mid(root.right);
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root=createTree(inorder, postorder, 0,0, postorder.length);
		return root;
    }
	private TreeNode createTree(int[] inorder, int[] postorder,int iStart,int pStart,int size) {
		if(size<=0) return null;
		int val=postorder[pStart+size-1];
        TreeNode root=new TreeNode(val);
        int k=iStart;
        while(inorder[k++]!=val)
        	;
        k--;
        int leftSize=k-iStart;
        root.left=createTree(inorder, postorder,iStart,pStart,leftSize);
        root.right=createTree(inorder, postorder, iStart+leftSize+1,pStart+leftSize, size-leftSize-1);
        return root;
	}
}
