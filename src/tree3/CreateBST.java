package tree3;

public class CreateBST {
    public BinaryTreeNode root;

    public void insert(int data)  {
        root = insertInBST(root, data);
    }

    public BinaryTreeNode insertInBST(BinaryTreeNode root, int data) {
        if (root == null) {
            root = new BinaryTreeNode(data);
            return root;
        }
        if (data < root.data)
            root.left = insertInBST(root.left, data);
        else if (data > root.data)
            root.right = insertInBST(root.right, data);
        return root;
    }

    public static void inOrderTraversalBST(BinaryTreeNode node){
        if(node == null)
            return;
        inOrderTraversalBST(node.left);
        System.out.print(node.data+" ");
        inOrderTraversalBST(node.right);
    }

    public static BinaryTreeNode constructBSTUsingSortedArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        return helperMethod(arr, start, end);
    }

    private static BinaryTreeNode helperMethod(int[] arr, int start, int end) {
        if(start > end)
            return null;
        if(start == end)
            return new BinaryTreeNode(arr[start]);
        int rootIndex = (start+end)/2;
        BinaryTreeNode root = new BinaryTreeNode(arr[rootIndex]);
        root.left = helperMethod(arr, start, rootIndex-1);
        root.right = helperMethod(arr, rootIndex+1, end);
        return root;
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
        System.out.println(searchK(bst.root,12));
        System.out.println(searchK(bst.root,67));

        System.out.println();
        System.out.println("=== Smallest Element IN BST === ");
        findSmallest(bst.root);

        System.out.println();
        System.out.println("=== Greatest Element IN BST === ");
        findGreatest(bst.root);

        System.out.println();
        System.out.println("=== Delete Element IN BST === ");
        BinaryTreeNode deleteNodeBST = deleteNodeBST(bst.root, 12);
        inOrderTraversalBST(deleteNodeBST);

        int[] arr = {23,34,45,67,89,100,123,145,156,234,400};
        System.out.println();
        System.out.println("=== Constrict BST Using Sorted Array === ");
        BinaryTreeNode constructBSTUsingSortedArray = constructBSTUsingSortedArray(arr);
        inOrderTraversalBST(constructBSTUsingSortedArray);

        System.out.println();
        System.out.println();
        System.out.println("Valid BST Check 1 valid, 0 Not valid:: "+validBSTCheck(constructBSTUsingSortedArray));

        System.out.println();
        System.out.println("=== Preorder check for BST ==== ");
        int[] A = {4,10,5,8};
        int[] B = {1,5,6,4};

        boolean b1 = preOrderToBSTPreOrderCheck(A);
        boolean b2 = preOrderToBSTPreOrderCheck(B);
        System.out.println(b1);
        System.out.println(b2);

        System.out.println();
        System.out.println("===== Elements in the Range count. =====");
        int ans = getBSTNodesInRange(constructBSTUsingSortedArray, 45, 156);
        System.out.println(ans);
    }

    static int count=0;
    public static int getBSTNodesInRange(BinaryTreeNode node, int start, int end){
        count = 0;
        traverseForRange(node, start, end);
        return count;
    }

    private static void traverseForRange(BinaryTreeNode node, int start, int end) {
        if(node == null)
            return;
        if(node.data >= start && node.data <= end)
            count++;
        traverseForRange(node.left, start, end);
        traverseForRange(node.right,start,end);
    }

    public static boolean preOrderToBSTPreOrderCheck(int[] A) {
        int n = A.length;
        if (n <= 2) {
            return true;
        }
        int leftPart = Integer.MIN_VALUE;
        int rightPart = Integer.MAX_VALUE;
        int root = A[0];
        for (int i=1;i<n;i++) {
            if(A[i] > root)
                leftPart = root;
            else
                rightPart = root;

            if (A[i] < leftPart || A[i] > rightPart) {
                return false;
            }
            root = A[i];
        }
        return true;
    }

    public static int validBSTCheck(BinaryTreeNode root){
        if(isBSTValid(root, Long.MIN_VALUE, Long.MAX_VALUE))
            return 1;
        return 0;
    }

    private static boolean isBSTValid(BinaryTreeNode root, long minValue, long maxValue) {
        if(root == null)
            return true;
        if(root.data > minValue && root.data < maxValue){
            boolean left = isBSTValid(root.left, minValue, root.data);
            boolean right = isBSTValid(root.right, root.data, maxValue);
            return (left && right);
        }else
            return false;
    }

    public static boolean searchK(BinaryTreeNode node, int value){
        if(node == null)
            return false;
        if(node.data == value)
            return true;
        else if(node.data > value)
            return searchK(node.left, value);
        else
            return searchK(node.right, value);
    }

    public static BinaryTreeNode findSmallest(BinaryTreeNode node){
        if(node == null)
            return null;
        BinaryTreeNode temp = node;
        /*if(temp.left != null){
            temp = findSmallest(temp.left); == Using recursion
        }*/
        while(temp.left != null){
            temp = temp.left;
        }
        System.out.println(temp.data);
        return temp;
    }

    public static BinaryTreeNode findGreatest(BinaryTreeNode root){
        if(root == null){
            return null;
        }
        BinaryTreeNode temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        System.out.println(temp.data);
        return temp;
    }

    public static BinaryTreeNode deleteNodeBST(BinaryTreeNode root, int value){
        if(root == null)
            return root;
        if(value < root.data)
            root.left = deleteNodeBST(root.left, value);
        else if(value > root.data)
            root.right = deleteNodeBST(root.right, value);
        else{
            //If node has one child
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            //Node has 2 children, find the MIN value
            root.data = getMinValue(root.right);
            root.right = deleteNodeBST(root.right, root.data);
        }
        return root;
    }

    private static int getMinValue(BinaryTreeNode root) {
        int minval = root.data;
        //find minval
        while (root.left != null)  {
            minval = root.left.data;
            root = root.left;
        }
        return minval;
    }
}
