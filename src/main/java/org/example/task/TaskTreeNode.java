package org.example.task;

import java.util.ArrayList;
import java.util.List;

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        if ((root.val >= low) && (root.val <= high)) {
            sum += root.val;
        }
        sum += rangeSumBST(root.right, low, high);
        sum += rangeSumBST(root.left, low, high);
        return sum;
    }

    //2331. Evaluate Boolean Binary Tree
    public boolean evaluateTree(TreeNode root) {
        int right = 0;
        int left = 0;
        if ((root.val == 2) || (root.val == 3)) {
            evaluateTree(root.right);
            right = root.right.val;
            evaluateTree(root.left);
            left = root.left.val;
            if (root.val == 2) {
                root.val = right | left;
            }
            if (root.val == 3) {
                root.val = right & left;
            }
        }
        return root.val != 0;
    }

    //104. Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        int rightDepth = 1;
        int leftDepth = 1;
        if (root == null) {
            return 0;
        }
        rightDepth += maxDepth(root.right);
        leftDepth += maxDepth(root.left);
        return Math.max(rightDepth, leftDepth);
    }

    //111. Minimum Depth of Binary Tree
    public int minDepth(TreeNode root) {
        int rightDepth = 1;
        int leftDepth = 1;
        if (root == null) {
            return 0;
        }
        rightDepth += minDepth(root.right);
        leftDepth += minDepth(root.left);
        if (((root.right != null) & (root.left !=null)) | ((root.right == null) & (root.left == null))) {
            return Math.min(rightDepth, leftDepth);
        } else {
            return Math.max(rightDepth, leftDepth);
        }
    }

    //700. Search in a Binary Search Tree
    public TreeNode searchBST(TreeNode root, int val) {
        if ((root == null) || (root.val == val)) {
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    //94. Binary Tree Inorder Traversal
    List<Integer> resultList = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return resultList;
        }
        inorderTraversal(root.left);
        resultList.add(root.val);
        inorderTraversal(root.right);
        return resultList;
    }

    //101. Symmetric Tree
    public boolean isSymmetric(TreeNode root) {
        return (root == null) || (isSymm(root.left, root.right));
    }

    public boolean isSymm(TreeNode left, TreeNode right) {
        if ((left == null) && (right == null)) {
            return true;
        }
        if ((left == null) || (right == null)) {
            return false;
        }
        if (left.val == right.val) {
            return isSymm(left.left, right.right) && isSymm(right.left, left.right);
        } else {
            return false;
        }
    }

}
