package util;

import java.util.LinkedList;
import java.util.Queue;

public class Util {

	/**
	 * 构建二叉树
	 * @param bfs 宽度优先遍历所得数组
	 * @return 树根
	 */
	public static TreeNode buildTree(Integer [] bfs){
		if(bfs.length==0) return null;
		Queue<TreeNode> queue=new LinkedList<>();
		TreeNode res=new TreeNode(bfs[0]);
		queue.offer(res);
		int i=1;
		while(!queue.isEmpty()){
			TreeNode root=queue.poll();
			if(i>=bfs.length) break;
			if(bfs[i++]!=null){
				root.left=new TreeNode(bfs[i-1]);
				queue.offer(root.left);
			}else
				root.left=null;
			if(i>=bfs.length) break;
			if(bfs[i++]!=null){
				root.right=new TreeNode(bfs[i-1]);
				queue.offer(root.right);
			}else
				root.right=null;
		}
		return res;
	}
	/**
	 * 中序遍历树
	 * @param root
	 */
	public static void midTrace(TreeNode root){
		if(root==null) return;
		midTrace(root.left);
		System.out.print(root.val+" ");
		midTrace(root.right);
	}
}
