package tree2;

import tree1.BinaryTreeNode;
import tree1.ListNode;

public class Pair {
    public BinaryTreeNode node;
    public int level;

    public Pair(BinaryTreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
