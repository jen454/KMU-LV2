package Treecircle;

public class App_Treecircle {
    // create() 를 구현하세요.
    static TreeNode create() {
        // (1) 터미널 노드들 생성
        TreeNode n1 = TreeNode.build(null, "B", null);
        TreeNode n2 = TreeNode.build(null, "C", null);
        TreeNode n3 = TreeNode.build(null,"A",null);
        TreeNode n4 = TreeNode.build(null, "D", null);
        TreeNode n5 = TreeNode.build(null, "E", null);

        // (2) Parent Node ~ Ancestors 구성
        TreeNode div = TreeNode.build(n1, "/", n2);
        TreeNode plus = TreeNode.build(n3, "+", div);
        TreeNode minus = TreeNode.build(n4, "-", n5);

        // (3) Root 노드 반환
        TreeNode Root = TreeNode.build(plus, "*", minus);
        return Root;
    }
    public static void main(String[] args) {
        TreeNode tree = create();

        System.out.print("PRE-ORDER  :");
        tree.preOrder(tree);
        System.out.println();

        System.out.print("IN-ORDER   :");
        tree.inOrder(tree);
        System.out.println();

        System.out.print("POST-ORDER :");
        tree.postOrder(tree);
        System.out.println();
    }
}