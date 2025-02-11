import org.w3c.dom.Node;

public class CheckForBST {
    public static void main(String[] args) {
        
    }

    boolean helper(Node root, int min, int max){
        if(root == null) return true;
        if(root.data <= min || root.data >= max) return false;
        return helper(root.left, min, root.data) && helper(root.right, root.data, max);
    }
    boolean isBST(Node root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
