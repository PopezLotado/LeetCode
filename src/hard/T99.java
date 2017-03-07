package hard;
/**
 * 
 * @Title Recover Binary Search Tree
 * 
 * @Description Two elements of a binary search tree (BST) are swapped by mistake.

	Recover the tree without changing its structure.

	Note:
	A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 *
 */
public class T99 {
	TreeNode first=null;
	TreeNode second=null;
    TreeNode last=new TreeNode(Integer.MIN_VALUE);
    boolean finished=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T99 t99=new T99();
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(2);
		root.right=new TreeNode(1);
		t99.mid(root);
		t99.recoverTree(root);
		t99.mid(root);
	}
	public void mid(TreeNode root){
		if(root==null) return;
		mid(root.left);
		System.out.println(root.val);
		mid(root.right);
	}
	public void recoverTree(TreeNode root) {
        midTrace(root);
        int t=first.val;
        first.val=second.val;
        second.val=t;
    }
	
	public void midTrace(TreeNode root){
		if(finished)
			return;
		if(root==null)
			return;
		midTrace(root.left);
		if(first==null && root.val<last.val){
			first=last;
			second=root;
		}
		if(second!=null && root.val<last.val && second!=root){
			second=root;
			finished=true;
		}
		last=root;
		midTrace(root.right);
	}
}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; left=null; right=null;}
}
