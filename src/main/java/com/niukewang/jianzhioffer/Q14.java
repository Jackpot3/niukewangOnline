package com.niukewang.jianzhioffer;
/***
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author JACKPOT
 */
public class Q14 {
    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        Mirror(left);
        Mirror(right);
    }
}
