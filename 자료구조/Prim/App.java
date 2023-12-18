package Prim;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫번째 입력은 정점의 개수
        // 정점은 0 ~ (numberOfVertex-1) 로 주어진다.
        int numberOfVertex = scanner.nextInt();

        // N개의 정점을 갖는 Graph 를 생성
        Graph g = new Graph(numberOfVertex);

        // 두번째 입력은 에지의 개수
        int numberOfEdges = scanner.nextInt();

        for(int i=0;i<numberOfEdges;i++) {
            // 에지는 시작정점과 종료정점, 그리고 가중치로 입력된다.
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int weight = scanner.nextInt();

            // 간선을 추가
            g.add(start, end, weight);
        }

        int source = scanner.nextInt();
        SpanningTreeBuilder builder = new SpanningTreeBuilder();
        SpanningTree tree = builder.build(g, source);
        tree.print();
    }
}