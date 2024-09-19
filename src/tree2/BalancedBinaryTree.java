package tree2;

import tree1.BinaryTreeNode;

public class BalancedBinaryTree {
    public static void main(String[] args) {

    }

    public static int height(BinaryTreeNode root){
        if(root == null)
            return -1;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight)+1;
    }

    public int isBalanced(BinaryTreeNode A) {
        int balanced = 1;
        if(A == null)
            return 0;
        int leftHeight = isBalanced(A.left);
        int rightHeight = isBalanced(A.right);
        if(Math.abs(leftHeight - rightHeight) > 1)
            balanced = 0;
        return Math.max(leftHeight, rightHeight)+1;
    }
}
