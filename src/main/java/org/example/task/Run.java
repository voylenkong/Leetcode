package org.example.task;


import java.time.LocalTime;

public class Run {
    public static void main(String[] args) {
        long time1 = LocalTime.now().getNano();
        System.out.println(Recursion.fib(40));
        System.out.println("recursion");
        System.out.println(LocalTime.now().getNano() - time1);




        long time2 = LocalTime.now().getNano();
        System.out.println(Recursion.fib2(40));
        System.out.println("cycle");
        System.out.println(LocalTime.now().getNano() - time2);


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
