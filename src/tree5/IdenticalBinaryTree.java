package tree5;

import tree1.BinaryTree;
import tree1.BinaryTreeNode;

public class IdenticalBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();

        tree1.push(13);
        tree1.push(12);
        tree1.push(10);
        BinaryTreeNode node1 = tree1.convertList2Binary(tree1.root);

        BinaryTree tree2 = new BinaryTree();
        tree2.push(13);
        tree2.push(12);
        tree2.push(10);
        BinaryTreeNode node2 = tree2.convertList2Binary(tree2.root);

        boolean b = isSame(node1, node2);
        System.out.println(b);
    }

    public static boolean isSame(BinaryTreeNode tree1, BinaryTreeNode tree2){
        if(tree1 == null && tree2 == null)
            return true;
        if(tree1 == null || tree2 == null)
            return false;
        return (tree1.data == tree2.data)
                && isSame(tree1.left, tree2.left)
                && isSame(tree1.right, tree2.right);
    }
}
