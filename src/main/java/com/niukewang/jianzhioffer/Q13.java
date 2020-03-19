package com.niukewang.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author JACKPOT
 */
public class Q13 {
    public static void main(String[] args) {
        Q13 q13 = new Q13();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node3;
        node3.left = node2;
        node1.right = node5;
        node5.left = node4;
        node5.right = node6;
        node4.left = node7;
        List<Integer> integers = q13.ergodicTree(node1);
        System.out.println(integers);
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null){
            return false;
        }
        return isSubtree(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }

    public boolean isSubtree(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.val==root2.val){
            return isSubtree(root1.left,root2.left)&&isSubtree(root1.right,root2.right);
        }
        return false;
    }

    public List<Integer> ergodicTree(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        int rootVal = root.val;
        resultList.add(rootVal);
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return resultList;
        }
        List<Integer> leftList = ergodicTree(left);
        List<Integer> rightList = ergodicTree(right);
        resultList.addAll(leftList);
        resultList.addAll(rightList);
        return resultList;
    }
}

