package tree5;

import tree1.BinaryTreeNode;

public class SumTree {

    public static int checkForSumTree(BinaryTreeNode root){
        if(root == null)
            return 1;
        if(root.left == null && root.right == null)
            return 1;
        return 0;
    }
}
