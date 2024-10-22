package Tree;

public class Question {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        TreeNode n = TreeNode.createTree(arr, 0);
        System.out.println(TreeNode.levelOrder(n));
    }
}
