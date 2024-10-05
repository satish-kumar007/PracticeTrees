package tree5;

import tree1.BinaryTree;
import tree1.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static tree1.BinaryTree.preorderTraversal;


public class NextPointerBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.push(7);
        tree.push(6);
        tree.push(4);
        tree.push(3);
        tree.push(5);
        tree.push(2);
        tree.push(1);
        BinaryTreeNode node = tree.convertList2Binary(tree.root);
        System.out.println("=== Preorder Traversal ===");
        preorderTraversal(node);

        System.out.println();
        System.out.println();
        connectNodes(node);
    }

    public static void connectNodes(BinaryTreeNode root){
        if(root == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0) {
            int n = queue.size();
            //System.out.println("== "+n);
            for (int i = 0; i < n; i++) {
                BinaryTreeNode front = queue.poll();
                if (i == n - 1) {
                    front.next = null;
                } else {

                    front.next = queue.peek();
                }
                if (front.left != null)
                    queue.offer(front.left);
                if (front.right != null)
                    queue.offer(front.right);
                System.out.print(front.data+" ");
            }
        }

        return;
    }
}
