package tree5;

import tree1.BinaryTree;
import tree1.BinaryTreeNode;

import static tree1.BinaryTree.preorderTraversal;

public class PathSumRootToLeaf {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.push(36);
        tree.push(30);
        tree.push(23);
        tree.push(13);
        tree.push(12);
        tree.push(10);
        BinaryTreeNode node = tree.convertList2Binary(tree.root);
        System.out.println("=== Preorder Traversal ===");
        preorderTraversal(node);

        int x = hasSum(node, 40);
        System.out.println();
        System.out.println("=== Check for Path sum ===");
        System.out.println(x);

        System.out.println();
        System.out.println("====== Invert a Binary tree ======");
        BinaryTreeNode invertedTree = invertBinaryTree(node);
        System.out.println("=== Preorder of inverted Binary Tree");
        preorderTraversal(invertedTree);
    }

    public static int hasSum(BinaryTreeNode root, int sum){
        boolean find = sum(root, 0, sum);
        return find?1:0;
    }

    public static boolean sum(BinaryTreeNode root, int currSum, int requiredSum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            currSum+=root.data;
            if(currSum == requiredSum)
                return true;
            return false;
        }
        int sum = currSum + root.data;
        return (sum(root.left, sum, requiredSum) || sum(root.right, sum, requiredSum));
    }

    public static BinaryTreeNode invertBinaryTree(BinaryTreeNode root){
        if(root == null)
            return null;
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
        return root;
    }
}
