package easy;

import util.TreeNode;

/**
 * @Title Sum of Left Leaves
 * @Description Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * @author Potato
 *
 */
public class T404 {

	public static void main(String[] args) {

	}

    public int sumOfLeftLeaves(TreeNode root) {
        return leftSum(root, false);
    }
    private int leftSum(TreeNode root,boolean isLeft){
    	if(root==null)
    		return 0;
    	if(isLeft && root.left==null && root.right==null)
    		return root.val;
    	return leftSum(root.left, true)+leftSum(root.right, false);
    }
}
