package org.example.task;

public class TaskTreeNode {

    public static void orderTree(TreeNode node) {
        if (node == null) return;
        orderTree(node.right);
        orderTree(node.left);
        System.out.println(node.val);
    }

    //114. Flatten Binary Tree to Linked List
    TreeNode previous = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = previous;
        root.left = null;
        previous = root;
    }

    //2236. Root Equals Sum of Children
    boolean result = true;
    public boolean checkTree(TreeNode root) {

        if ((root == null) || ((root.right == null) && (root.left == null))) {
            return true;
        }
        checkTree(root.right);
        checkTree(root.left);
        if (root.val == root.right.val+root.left.val) {
            return result;
        }
        result = false;
        return false;
    }

    //938. Range Sum of BST
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return sum;
        }
        if ((root.val >= low) && (root.val <= high)) {
            sum += root.val;
        }
        rangeSumBST(root.right, low, high);
        rangeSumBST(root.left, low, high);
        return sum;
    }
}
