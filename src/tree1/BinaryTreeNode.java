package tree1;

public class BinaryTreeNode{
    public int data;
    public BinaryTreeNode left =null;
    public BinaryTreeNode right = null;
    public BinaryTreeNode next=null;// for next pointer tree
    public BinaryTreeNode(int data){
        this.data = data;
        left = null;
        right = null;
        next = null;//for next pointer tree
    }
}
