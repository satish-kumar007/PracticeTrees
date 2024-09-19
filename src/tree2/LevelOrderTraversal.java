package tree2;

import tree1.BinaryTree;
import tree1.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.push(36);
        tree.push(30);
        tree.push(23);
        tree.push(13);
        tree.push(12);
        tree.push(10);
        BinaryTreeNode node = tree.convertList2Binary(tree.root);
        ArrayList<ArrayList<Integer>> solve = solve(node);
        System.out.println(solve);

    }

    public static ArrayList<ArrayList<Integer>> solve(BinaryTreeNode A) {
        Queue<BinaryTreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> internalList = new ArrayList<>();;
        if(A == null)
            return null;
        q.add(A);
        q.add(null);
        BinaryTreeNode node;
        while(q.size() > 0){
            node = q.remove();
            if (node == null && q.isEmpty()) {
                list.add(new ArrayList<>(internalList));
                break;
            }
            if (node == null) {
                list.add(new ArrayList<>(internalList));
                internalList.clear();
                q.add(null);
                continue;
            }
            internalList.add(node.data);
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }
        return list;
    }

}
