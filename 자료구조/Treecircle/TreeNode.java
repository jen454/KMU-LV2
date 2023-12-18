package Treecircle;

public class TreeNode {
    // 트리 노드를 구현하세요.
    private Object data;
    private TreeNode right;
    private TreeNode left;

    public static TreeNode build(TreeNode L, Object data, TreeNode R) {
        TreeNode temp = new TreeNode();
        temp.data = data;
        temp.left = L;
        temp.right = R;
        return temp;
    }

    public static void inOrder(TreeNode p) {
        // 구현하기
        if (p != null) {
            inOrder(p.left);
            System.out.print(p.data);
            inOrder(p.right);
        }
    }

    public static void preOrder(TreeNode p) {
        // 구현하기
        if (p != null) {
            System.out.print(p.data);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    public static void postOrder(TreeNode p) {
        // 구현하기
        if (p != null) {
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.data);
        }
    }
}