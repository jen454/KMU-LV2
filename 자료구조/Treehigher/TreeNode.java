package Treehigher;

public class TreeNode {
    // 트리 노드를 구현하세요.
    protected int data;
    protected TreeNode left;
    protected TreeNode right;
    boolean LT = false;
    boolean RT = false;

    public static TreeNode build(TreeNode L, int data, TreeNode R) {
        TreeNode temp = new TreeNode();
        temp.data = data;
        temp.left = L;
        temp.right = R;
        return temp;
    }

    public void higher(int data, Visitor visitor) {
        // 구현하기
        TreeNode p = this;
        while (p.data != 0) {
            if (p.LT == false) {
                p.LT = true;
                p = p.left;
                if (p.LT == true) {
                    if (p.data > data) {
                        visitor.visit(p.data);
                    }
                    p = p.right;
                }
            }
            else {
                if (p.data > data) {
                    visitor.visit(p.data);
                }
                p = p.right;
            }
        }
        // 1. 주어진 데이터보다 작은 것 중에 가장 큰 값을 찾는다.
        // 2. 해당 값보다 큰 노드를 모두 찾는다.
        // 3. 찾은 데이터는 visitor를 통해 방문하게 한다.
        // visitor.visit(value)
    }
}