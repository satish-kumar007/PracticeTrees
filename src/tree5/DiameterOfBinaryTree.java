package tree5;

import tree1.BinaryTree;
import tree1.BinaryTreeNode;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.push(7);
        tree.push(16);
        tree.push(36);
        tree.push(30);
        tree.push(23);
        tree.push(13);
        tree.push(12);
        tree.push(10);
        BinaryTreeNode node = tree.convertList2Binary(tree.root);

        System.out.println();
        System.out.println("===== Diameter of Binary Tree ====== ");
        int diameter1 = getDiameter(node);
        System.out.println(diameter1);
    }

    static int diameter;
    public static int getDiameter(BinaryTreeNode root){
        diameter = 0;
        heightOfTree(root);
        return diameter;
    }
    public static int heightOfTree(BinaryTreeNode root){
        if(root == null)
            return -1;
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        int currDiameter = lh + rh + 2;
        diameter = Math.max(diameter,currDiameter);
        return Math.max(lh,rh)+1;
    }
}
