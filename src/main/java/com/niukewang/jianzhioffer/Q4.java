package com.niukewang.jianzhioffer;

/***
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author JACKPOT
 */
public class Q4 {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 3, 5, 6};
        int[] in = {4, 2, 1, 5, 3, 6};
        TreeNode treeNode = solution(pre, in);
         System.out.println(treeNode);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        //得到此树的根节点
        if (pre.length==0){
            return null;
        }

        int root = pre[0];
        TreeNode treeNode = new TreeNode(root);
        //说明没有子节点了
        if (pre.length == 1) {
            return treeNode;
        }

        int[][] left = getLeft(pre, in);
        int[][] right = getRight(pre, in);

        treeNode.left = reConstructBinaryTree(left[0],left[1]);
        treeNode.right = reConstructBinaryTree(right[0],right[1]);

        return treeNode;

    }

    public static int[][] getLeft(int[] pre, int[] in) {

        int leftTreeLength = getRootIndexInIn(pre, in);
        int[] leftTreeIn = new int[leftTreeLength];
        int[] leftTreePre = new int[leftTreeLength];

        for (int i = 0; i < leftTreeLength; i++) {
            leftTreeIn[i] = in[i];
            leftTreePre[i] = pre[i + 1];
        }
        return new int[][]{leftTreePre, leftTreeIn};
    }

    public static int[][] getRight(int[] pre, int[] in) {

        int length = pre.length;
        int leftTreeLength = getRootIndexInIn(pre, in);
        int[] rightTreeIn = new int[length - leftTreeLength - 1];
        int[] rightTreePre = new int[length - leftTreeLength - 1];

        for (int i = 0; i < rightTreeIn.length; i++) {
            rightTreeIn[i] = in[leftTreeLength + i + 1];
            rightTreePre[i] = pre[leftTreeLength + 1 + i];
        }
        return new int[][]{rightTreePre, rightTreeIn};
    }

    private static int getRootIndexInIn(int[] pre, int[] in) {
        int root = pre[0];
        //得到遍历结果数组的长度
        int length = pre.length;
        int rootIndexInIn = 0;
        for (int i = 0; i < length; i++) {
            if (in[i] == root) {
                rootIndexInIn = i;
            }
        }
        return rootIndexInIn;
    }

    public static TreeNode solution(int[] pre, int[] in){
        if (pre.length==0){
            return null;
        }
        //得到此树的根节点
        int root = pre[0];
        TreeNode treeNode = new TreeNode(root);
        //说明没有子节点了
        if (pre.length == 1) {
            return treeNode;
        }
        //还有子节点的话获取左树和右树的前序以及中序遍历结果

        //得到遍历结果数组的长度 int length = in.length
        int length = pre.length;

        //得到根节点在中序遍历数组中的索引
        int rootIndexInIn = 0;
        for (int i = 0; i < length; i++) {
            if (in[i] == root) {
                rootIndexInIn = i;
            }
        }
        //根节点左边为左边的子树中序遍历的结果,右边为右边的子树中序遍历的结果
        int leftTreeLength = rootIndexInIn;
        int[] leftTreeIn = new int[leftTreeLength];
        int[] leftTreePre = new int[leftTreeLength];
        int[] rightTreeIn = new int[length - leftTreeLength - 1];
        int[] rightTreePre = new int[length - leftTreeLength - 1];

        //给左右节点的前中序遍历数组赋值
        for (int i = 0; i < leftTreeLength; i++) {
            leftTreeIn[i] = in[i];
            leftTreePre[i] = pre[i + 1];
        }
        for (int i = 0; i < rightTreeIn.length; i++) {
            rightTreeIn[i] = in[leftTreeLength + i + 1];
            rightTreePre[i] = pre[leftTreeLength + 1 + i];
        }
        //递归调用
        treeNode.left = reConstructBinaryTree(leftTreePre,leftTreeIn);
        treeNode.right = reConstructBinaryTree(rightTreePre,rightTreeIn);
        return treeNode;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
