package tree2;

import tree1.BinaryTree;
import tree1.BinaryTreeNode;

import java.util.*;
import java.util.stream.Collectors;

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
        ArrayList<ArrayList<Integer>> solve = levelOrderTraversal(node);
        System.out.println(solve);

        System.out.println();
        System.out.println("=============== Using Array Traversal =================");
        levelOrderTraversalArray(node);

        System.out.println();
        System.out.println("=============== Using Array Traversal New Lines =================");
        levelOrderTraversalNewLines(node);

        System.out.println();
        System.out.println("=============== Right View of the Binary tree =================");
        rightViewOfBinaryTree(node);

        System.out.println();
        System.out.println("=============== Left View of the Binary tree =================");
        leftViewOfBinaryTree(node);

        System.out.println();
        System.out.println("=============== Vertical Traversing of the Binary tree =================");
        ArrayList<ArrayList<Integer>> verticalOrderTraversal = verticalOrderTraversal(node);
        System.out.println(verticalOrderTraversal);

        System.out.println();
        System.out.println("=============== Top view of Vertical Traversing of the Binary tree =================");
        ArrayList<ArrayList<Integer>> topView = verticalOrderTraversalTopView(node);
        System.out.println(topView);

        System.out.println();
        System.out.println("=============== Top view of Vertical Traversing of the Binary tree Additional Assignments =================");
        ArrayList<Integer> additional = topViewAdditionalAssignments(node);
        System.out.println(additional);
    }

    public static ArrayList<Integer> topViewAdditionalAssignments(BinaryTreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null)
            return ans;

        Queue<Pair> level = new LinkedList();

        level.add(new Pair(root, 0));
        HashMap <Integer,Integer> map = new HashMap();
        //Using Level order traversal to find the top view
        while (level.size() != 0) {
            Pair curr = level.peek();
            level.remove();
            if (map.get(curr.level) == null)
                map.put(curr.level, curr.node.data);

            if (curr.node.left != null) {
                level.add(new Pair(curr.node.left, curr.level - 1));
            }
            if (curr.node.right != null) {
                level.add(new Pair(curr.node.right, curr.level + 1));
            }
        }

        for (Map.Entry elem: map.entrySet()) {
            ans.add((int) elem.getValue());
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversalTopView(BinaryTreeNode root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> ar = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }

        TreeMap<Integer,ArrayList<Integer>> treeMap = new TreeMap();
        Queue <Pair> q = new LinkedList();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int nodeData = pair.node.data;
            int level = pair.level;
            ar = new ArrayList<>();
            if(treeMap.containsKey(level)){
                ar = treeMap.get(level);
                ar.add(nodeData);
            }else{
                ar.add(nodeData);
            }
            treeMap.put(level, ar);
            if(pair.node.left != null)
                q.offer(new Pair(pair.node.left, level-1));
            if(pair.node.right != null)
                q.offer(new Pair(pair.node.right, level+1));
        }

        for(Integer val : treeMap.keySet()){
            ArrayList<Integer> list = treeMap.get(val);
            ans.add(list);
        }
        List<String> firstElements = ans.stream()
                .map(x -> x.get(0).toString())
                .collect(Collectors.toList());
        System.out.println(firstElements);
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(BinaryTreeNode root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> ar = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }

        TreeMap<Integer,ArrayList<Integer>> treeMap = new TreeMap();
        Queue <Pair> q = new LinkedList();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int nodeData = pair.node.data;
            int level = pair.level;
            ar = new ArrayList<>();
            if(treeMap.containsKey(level)){
                ar = treeMap.get(level);
                ar.add(nodeData);
            }else{
                ar.add(nodeData);
            }
            treeMap.put(level, ar);
            if(pair.node.left != null)
                q.offer(new Pair(pair.node.left, level-1));
            if(pair.node.right != null)
                q.offer(new Pair(pair.node.right, level+1));
        }

        for(Integer val : treeMap.keySet()){
            ArrayList<Integer> list = treeMap.get(val);
            ans.add(list);
        }
        return ans;
    }

    public static void leftViewOfBinaryTree(BinaryTreeNode node){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if(node == null)
            return;
        queue.offer(node);
        //System.out.print(node.data+" ");
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                BinaryTreeNode treeNode = queue.poll();
                if(i==0)
                    System.out.print(treeNode.data+" ");
                if(treeNode.left != null)
                    queue.offer(treeNode.left);
                if(treeNode.right != null)
                    queue.offer(treeNode.right);
            }
        }
    }

    public static void rightViewOfBinaryTree(BinaryTreeNode node){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if(node == null)
            return;
        queue.offer(node);
        //System.out.print(node.data+" ");
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                BinaryTreeNode treeNode = queue.poll();
                if(i==(n-1))
                    System.out.print(treeNode.data+" ");
                if(treeNode.left != null)
                    queue.offer(treeNode.left);
                if(treeNode.right != null)
                    queue.offer(treeNode.right);
            }
        }
    }

    public static void levelOrderTraversalNewLines(BinaryTreeNode node){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if(node == null)
            return;
        queue.offer(node);
        while(queue.size()>0){
            int n = queue.size();
            for(int i=0;i<n;i++){
                BinaryTreeNode treeNode = queue.poll();
                System.out.print(treeNode.data+" ");
                if(treeNode.left != null)
                    queue.offer(treeNode.left);
                if(treeNode.right != null)
                    queue.offer(treeNode.right);
            }
            System.out.println();
        }
    }

    public static void levelOrderTraversalArray(BinaryTreeNode node){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if(node == null)
            return;
        queue.offer(node);
        BinaryTreeNode treeNode = null;
        while(!queue.isEmpty()){
            treeNode = queue.poll();
            System.out.print(treeNode.data+" ");
            if(treeNode.left != null)
                queue.offer(treeNode.left);
            if(treeNode.right != null)
                queue.offer(treeNode.right);
        }
    }

    public static ArrayList<ArrayList<Integer>> levelOrderTraversal(BinaryTreeNode A) {
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
