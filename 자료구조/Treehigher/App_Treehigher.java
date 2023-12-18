package Treehigher;

import java.util.Deque;
import java.util.LinkedList;

public class App_Treehigher {
    // create() 를 구현하세요.
    static TreeNode create() {
        // (1) Terminal Node
        TreeNode n25 = TreeNode.build(null, 25, null);
        TreeNode n45 = TreeNode.build(null, 45, null);

        // (2) Parent Node ~ Ancestors 구성
        TreeNode n43 = TreeNode.build(null, 43, n45);
        TreeNode n50 = TreeNode.build(n43, 50, null);
        TreeNode n30 = TreeNode.build(n25, 30, n50);

        // thread
        TreeNode head = TreeNode.build(n30, 0, null);
        head.right = head;

        n25.left = head; n25.right = n30; n25.LT = n25.RT = true;

        n43.left = n30; n43.LT = true;

        n50.right = head; n50.RT = true;

        n45.left = n43; n45.right = n50; n45.LT = n45.RT = true;
        // (3) Root 노드 반환
        return n30;
    }

    public static void main(String[] args) {
        Deque<Integer> array = new LinkedList<>();
        TreeNode tree = create();
        Visitor visitor = (data) -> {
            array.add(data);
        };

        System.out.print("Higher than 50: ");
        tree.higher(45, visitor);
        if (array.isEmpty()) System.out.println("null");
        else System.out.println(array);
    }
}