package medium;

import java.util.HashMap;
import java.util.Map;


import util.TreeNode;
import util.Util;

/**
 * @Title House Robber III
 * @Description The thief has found himself a new place for his thievery again.
 *              There is only one entrance to this area, called the "root."
 *              Besides the root, each house has one and only one parent house.
 *              After a tour, the smart thief realized that "all houses in this
 *              place forms a binary tree". It will automatically contact the
 *              police if two directly-linked houses were broken into on the
 *              same night.
 * 
 *              Determine the maximum amount of money the thief can rob tonight
 *              without alerting the police.
 * 
 *              Example 1: 3 / \ 2 3 \ \ 3 1 Maximum amount of money the thief
 *              can rob = 3 + 3 + 1 = 7. Example 2: 3 / \ 4 5 / \ \ 1 3 1
 *              Maximum amount of money the thief can rob = 4 + 5 = 9.
 * @author Potato
 *
 */
public class T337 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=Util.buildTree(new Integer[]{3,4,5,1,3,1});
		Util.midTrace(root);
		T337 t337=new T337();
		System.out.println(t337.rob(root));
	}
	Map<TreeNode, Integer> cache1=new HashMap<>(); // canRob
	Map<TreeNode, Integer> cache2=new HashMap<>(); // can't rob
	public int rob(TreeNode root) {
		return subRob(root, true);
	}
	
	public int subRob(TreeNode root,boolean canRob){
		if(root==null) return 0;
		if(!canRob)
		{
			if(cache2.containsKey(root))
				return cache2.get(root);
			int res=subRob(root.left, true)+subRob(root.right, true);
			cache2.put(root, res);
			return res;
		}else {
			if(cache1.containsKey(root))
				return cache1.get(root);
			int rob=root.val+subRob(root.left, false)+subRob(root.right, false);
			int norob=subRob(root.left, true)+subRob(root.right, true);
			int res=rob>norob?rob:norob;
			cache1.put(root, res);
			return res;
		}
	}

}
