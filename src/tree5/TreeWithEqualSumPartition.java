package tree5;

import tree1.BinaryTree;
import tree1.BinaryTreeNode;

import java.util.Stack;

import static tree1.BinaryTree.preorderTraversal;

public class TreeWithEqualSumPartition {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.push(16);
        tree.push(36);
        tree.push(30);
        tree.push(23);
        tree.push(13);
        tree.push(12);
        tree.push(10);
        BinaryTreeNode node = tree.convertList2Binary(tree.root);
        System.out.println("=== Preorder Traversal ===");
        preorderTraversal(node);

        System.out.println();
        System.out.println("===== Total Sum ======");
        long x = totalSum(node);
        System.out.println(x);
        int partitionedSum = checkEqualPartitionSum(node, x);
        System.out.println(partitionedSum);

    }

    static boolean ans = false;

    public static int checkEqualPartitionSum(BinaryTreeNode root, long totalSum){
        if(root == null)
            return 0;
        int leftSum = checkEqualPartitionSum(root.left,totalSum);
        int rightSum = checkEqualPartitionSum(root.right, totalSum);
        if(leftSum == totalSum/2 || rightSum == totalSum/2)
            ans = true;
        return (leftSum + rightSum + root.data);
    }

    public static long totalSum(BinaryTreeNode root){
        if(root == null)
            return 0L;
        long sum = 0L;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        BinaryTreeNode node;
        while(!stack.isEmpty()){
            node = stack.pop();
            sum = sum+node.data;
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
        return sum;
    }
}
