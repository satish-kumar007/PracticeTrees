package tree4;
/*
Q2. Distance between Nodes of BST
Solved
feature icon
Using hints except Complete Solution is Penalty free now
Use Hint
Problem Description

Given a binary search tree.
Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.

NOTE: Distance between two nodes is number of edges between them.



Problem Constraints

1 <= Number of nodes in binary tree <= 1000000

0 <= node values <= 109



Input Format

First argument is a root node of the binary tree, A.

Second argument is an integer B.

Third argument is an integer C.



Output Format

Return an integer denoting the distance between two nodes with given two keys B and C



Example Input

Input 1:


         5
       /   \
      2     8
     / \   / \
    1   4 6   11
 B = 2
 C = 11
Input 2:


         6
       /   \
      2     9
     / \   / \
    1   4 7   10
 B = 2
 C = 6


Example Output

Output 1:

 3
Output 2:

 1


Example Explanation

Explanation 1:

 Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.
Explanation 2:

 Path between 2 and 6 is: 2 -> 6. Distance will be 1
 */
import tree3.BinaryTreeNode;
import tree3.CreateBST;

public class DistanceBetweenNodes {

    public static int distanceBetweenNodes(BinaryTreeNode node, int num1, int num2){
        int temp=0;
        if(num1 > num2){
            temp=num1;
            num1=num2;
            num2=temp;
        }
        return distanceBetween2(node, num1, num2);
    }

    private static int distanceBetween2(BinaryTreeNode root, int a, int b) {
        if (root == null)
            return 0;
        if (root.data > a && root.data > b)
            return distanceBetween2(root.left, a, b);
        if (root.data < a && root.data < b)
            return distanceBetween2(root.right, a, b);
        if (root.data >= a && root.data <= b)
            return distanceFromRoot(root, a) + distanceFromRoot(root, b);
        return 0;
    }

    private static int distanceFromRoot(BinaryTreeNode root, int num) {
        if(root.data == num)
            return 0;
        else if(root.data > num)
            return 1 + distanceFromRoot(root.left, num);
        return 1 + distanceFromRoot(root.right, num);
    }

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
        System.out.println("==== Distance between 2 nodes in BST =====");
        int d = distanceBetweenNodes(bst.root, 7,90);
        System.out.println(d);

    }
}
