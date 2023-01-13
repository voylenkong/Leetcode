package org.example.task;


import java.time.LocalTime;

public class Run {
    public static void main(String[] args) {

        TreeNode tree2 = new TreeNode(4);
        tree2.right = new TreeNode(7);
        tree2.left = new TreeNode(2);
        tree2.left.right = new TreeNode(3);
        tree2.left.left = new TreeNode(1);

        TaskTreeNode taskTreeNode = new TaskTreeNode();
        System.out.println(taskTreeNode.searchBST(tree2, 2));



    }
}
