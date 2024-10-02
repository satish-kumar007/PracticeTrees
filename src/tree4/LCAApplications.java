package tree4;

import tree1.BinaryTree;
import tree3.BinaryTreeNode;
import tree3.CreateBST;

import java.util.ArrayList;

public class LCAApplications {
    public static void main(String[] args) {
        CreateBST bst = new CreateBST();

        bst.insert(45);
        bst.insert(10);
        bst.insert(7);
        bst.insert(12);
        bst.insert(90);
        bst.insert(50);
        bst.inOrderTraversalBST(bst.root);

        System.out.println();
        System.out.println("==== Kth Smallest Node in BST =====");
        int kth = findKthSmallestNode(bst.root, 3);
        System.out.println(kth);

        System.out.println();
        System.out.println("==== Kth Largest Node in BST =====");
        int Lth = findKthLargestNode(bst.root, 3);
        System.out.println(Lth);


        System.out.println();
        BinaryTree tree = new BinaryTree();
        tree.push(36);
        tree.push(30);
        tree.push(23);
        tree.push(13);
        tree.push(12);
        tree.push(10);
        tree1.BinaryTreeNode node = tree.convertList2Binary(tree.root);
        System.out.println("=== Preorder Traversal of Binary Tree ===");
        BinaryTree.preorderTraversal(node);

        System.out.println();
        System.out.println("====== Node to root path ===== ");
        nodeToRootPath(node, 30);

        System.out.println();
        System.out.println("==== LCA of 2 nodes in BST");
        int x = lcaInBST(bst.root, 7, 90);
        System.out.println(x);
        int x1 = lcaInBST(bst.root, 90, 7);
        System.out.println(x1);

        System.out.println();
        System.out.println("==== LCA of 2 nodes in Unordered Binary Tree");
        int k = lowestCommonAncestorBinaryTree(node, 23,36);
        System.out.println(k);


    }



    public static int lowestCommonAncestorBinaryTree(tree1.BinaryTreeNode root, int val1, int val2){
        ArrayList<Integer> p1 = nodeToRootPath(root, val1);
        ArrayList<Integer> p2 = nodeToRootPath(root, val2);
        int i = p1.size()-1;
        int j = p2.size()-1;
        while(i >= 0 && j >= 0 && p1.get(i) == p2.get(j)){
            i--;
            j--;
        }
        return p1.get(i+1);
    }

    public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode root, int val){
        if(root==null)
            return new ArrayList<>();
        if(root.data > val){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            return list;
        }
        ArrayList<Integer> nodeToLeftPath = nodeToRootPath(root.left, val);
        if(nodeToLeftPath.size() != 0){
            nodeToLeftPath.add(root.data);
            return nodeToLeftPath;
        }
        ArrayList<Integer> nodeToRightPath = nodeToRootPath(root.right, val);
        if(nodeToRightPath.size() != 0){
            nodeToRightPath.add(root.data);
            return nodeToRightPath;
        }
        return new ArrayList<>();

    }

    public static int lcaInBST(BinaryTreeNode root, int element1, int element2){
        if(root == null)
            return -1;
        if(root.data > element1 && root.data > element2){
            return lcaInBST(root.left, element1, element2);
        }
        if(root.data < element1 && root.data < element2){
            return lcaInBST(root.right, element1, element2);
        }
        return root.data;
    }

    public static ArrayList<Integer> nodeToRootPath(tree1.BinaryTreeNode root, int value){
        ArrayList<Integer> list = new ArrayList<>();
        nodeToRoot(root, value, list);
        System.out.println(list);
        return list;
    }

    private static boolean nodeToRoot(tree1.BinaryTreeNode root, int value, ArrayList<Integer> list) {
        if(root == null)
            return false;
        if(root.data == value){
            list.add(root.data);
            return true;
        }
        if(nodeToRoot(root.left, value, list) || nodeToRoot(root.right, value, list)){
            list.add(root.data);
            return true;
        }else{
            return false;
        }
    }

    static int count;
    static int ans;
    public static int findKthSmallestNode(BinaryTreeNode root, int k){
        count=0;
        ans=0;
        traverseToK(root, k);
        return ans;
    }

    private static void traverseToK(BinaryTreeNode root, int k) {
        if(root == null)
            return;
        traverseToK(root.left, k);
        count++;
        if(count == k){
            ans = root.data;
            return;
        }
        traverseToK(root.right, k);
    }

    static int countL;
    static int ansL;
    public static int findKthLargestNode(BinaryTreeNode root, int k){
        countL=0;
        ansL=0;
        travelToFindL(root, k);
        return ansL;
    }

    private static void travelToFindL(BinaryTreeNode root, int k) {
        if(root == null)
            return;
        travelToFindL(root.right, k);
        countL++;
        if(countL == k){
            ansL = root.data;
            return;
        }
        travelToFindL(root.left, k);
    }
}
