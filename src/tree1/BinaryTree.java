package tree1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public ListNode head;
    public BinaryTreeNode root;
    public void push(int new_data){
        ListNode new_node = new ListNode(new_data);
        new_node.next = head;
        head = new_node;
    }

    public BinaryTreeNode convertList2Binary(BinaryTreeNode node){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if (head == null){
            node = null;
            return null;
        }
        node = new BinaryTreeNode(head.data);
        queue.add(node);
        head = head.next;
        while (head != null){
            BinaryTreeNode parent = queue.peek();
            BinaryTreeNode pop = queue.poll();
            System.out.println(" ======= "+pop.data);
            BinaryTreeNode leftChild = null, rightChild = null;
            leftChild = new BinaryTreeNode(head.data);
            queue.add(leftChild);
            head = head.next;
            if (head != null){
                rightChild = new BinaryTreeNode(head.data);
                queue.add(rightChild);
                head = head.next;
            }
            parent.left = leftChild;
            parent.right = rightChild;
        }
        return node;
    }

    public static void preorderTraversal(BinaryTreeNode node){
        if(node == null)
            return;
        System.out.print(node.data+" ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public static void inorderTraversal(BinaryTreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public static ArrayList <Integer> preorderTraversalItr(BinaryTreeNode A) {
        ArrayList < Integer > res = new ArrayList < Integer > ();
        Stack <BinaryTreeNode> stack = new Stack < > ();
        if (A == null)
            return res;
        System.out.println("****** "+A.data);
        stack.push(A);
        BinaryTreeNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print("POP :: "+node.data+" ");
            res.add(node.data);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        System.out.println();
        return res;
    }

    public static ArrayList<Integer> itrInorderTraversal(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode curr = node;
        ArrayList<Integer> ans = new ArrayList<>();
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                ans.add(curr.data);
                curr = curr.right;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> postOrderTraversalItr(BinaryTreeNode node1){
        Stack<BinaryTreeNode> stack1 = new Stack();
        Stack<BinaryTreeNode> stack2 = new Stack();
        ArrayList<Integer> postorder = new ArrayList();
        BinaryTreeNode node;

        if(node1 == null)
            return null;
        stack1.push(node1);
        while(!stack1.isEmpty()){
            node = stack1.pop();
            stack2.push(node);
            if(node.left != null)
                stack1.push(node.left);
            if(node.right != null)
                stack1.push(node.right);
        }
        while(!stack2.isEmpty()){
            node = stack2.pop();
            postorder.add(node.data);
        }
        return postorder;
    }

    public static void postOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            inorderTraversal(node.right);
            System.out.print(node.data + " ");

        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.push(36);
        tree.push(30);
        tree.push(23);
        tree.push(13);
        tree.push(12);
        tree.push(10);
        BinaryTreeNode node = tree.convertList2Binary(tree.root);
        ArrayList<Integer> preorderTraversalItr = preorderTraversalItr(node);
        for(Integer i : preorderTraversalItr)
            System.out.print(i+" ");
        System.out.println();
        System.out.println("=== Preorder Traversal ===");
        preorderTraversal(node);


        System.out.println();
        System.out.println("=== Inorder Traversal ===");
        inorderTraversal(node);
        System.out.println();
        System.out.println("=== Inorder Traversal Iterative ===");
        ArrayList<Integer> list = itrInorderTraversal(node);
        for(Integer i : list)
            System.out.print(i+" ");
        System.out.println();
        System.out.println("=== Postorder Traversal ===");
        postOrderTraversal(node);
    }
}
