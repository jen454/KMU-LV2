package Prim;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SpanningTreeBuilder {
    public SpanningTree build(Graph graph, int source) {
        // 구현하기
        // source 의 경우 시작점으로 시작하는 경우 사용
        // 그렇지 않은 경우, 첫 번째 SpanningTree의 속하는 정점 중에 선택
        int size = graph.getSize();
        SpanningTree tree = new SpanningTree(size);
        boolean[] visit = new boolean[size];
        visit[source] = true;
        Queue<Integer> pq = new LinkedList<>();

        pq.add(source);
        while(!pq.isEmpty()) {
            int vertex = pq.remove();
            visit[vertex] = true;
            int next = -1;
            int weight = 999;
            for (int i=0; i<size; i++) {
                if (visit[i]) {
                    for (int j=0; j<size; j++) {
                        if (graph.matrix[i][j] < 999 && visit[j] == false) {
                            if (graph.matrix[i][j] < weight) {
                                next = j;
                                weight = graph.matrix[i][j];
                            }
                        }
                    }
                }
            }
            if (next == -1) break;
            tree.add(vertex, next, weight);
            pq.add(next);
        }
        return tree;
    }
}


