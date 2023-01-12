package org.example.task;


import java.time.LocalTime;

public class Run {
    public static void main(String[] args) {


/*        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.left.left = new TreeNode(3);
        tree1.left.right = new TreeNode(4);
        tree1.right = new TreeNode(5);
        tree1.right.right = new TreeNode(6);*/

/*        TreeNode tree1 = new TreeNode(15);
        tree1.left = new TreeNode(10);
        tree1.right = new TreeNode(5);
        tree1.left.left = new TreeNode(8);
        tree1.left.right = new TreeNode(2);
        tree1.right.left = new TreeNode(3);
        tree1.right.right = new TreeNode(1);*/

/*        TreeNode tree1 = new TreeNode(10);
        tree1.left = new TreeNode(5);
        tree1.left.left = new TreeNode(3);
        tree1.left.right = new TreeNode(7);
        tree1.left.left.left = new TreeNode(1);
        tree1.left.right.left = new TreeNode(6);
        tree1.right = new TreeNode(15);
        tree1.right.left = new TreeNode(13);
        tree1.right.right = new TreeNode(18);*/

/*        TreeNode tree1 = new TreeNode(2);
        tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(3);
        tree1.right.left = new TreeNode(0);
        tree1.right.right = new TreeNode(1);*/

        TreeNode tree2 = new TreeNode(3);
        tree2.right = new TreeNode(20);
        tree2.left = new TreeNode(9);
        tree2.right.right = new TreeNode(7);
        tree2.right.left = new TreeNode(15);

        TreeNode tree3 = new TreeNode(2);
        tree3.right = new TreeNode(3);
        tree3.right.right = new TreeNode(4);
        tree3.right.right.right = new TreeNode(5);
        tree3.right.right.right.right = new TreeNode(6);

        TreeNode tree4 = new TreeNode(1);
        tree4.right = new TreeNode(2);
        tree4.right.right = new TreeNode(3);

        TaskTreeNode taskTreeNode = new TaskTreeNode();
        System.out.println(taskTreeNode.minDepth(tree3));


/*        TreeNode treeNode = new TreeNode(1);

        TreeNode tree3 = new TreeNode(2);
        tree3.left = new TreeNode(4);
        tree3.right = new TreeNode(5);

        TreeNode tree1 = new TreeNode(1);
        tree1.left = tree3;
        tree1.right = new TreeNode(3);


        TreeNode tree2 = tree1;

        System.out.println(treeNode.getTargetCopy(tree1, tree2, tree3).val);*/
    }
}
