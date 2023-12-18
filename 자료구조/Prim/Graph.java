package Prim;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Graph {
    // 인접행렬 혹은 인접리스트로 구현하기
    // 무방향 그래프를 표현한다.
    // size 는 정점의 개수
    int[][] matrix;
    boolean directed;
    int size;
    final static int MAX = 999;

    public Graph(int size) {
        this.directed = false;
        this.size = size;
        this.matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.matrix[i][j] = MAX;
            }
        }
    }

    public void add(int start, int end, int weight) {
        // 간선 추가 함수 구현하기
        if ((0 <= start && start < this.size) && (0 <= end && end < this.size) && (weight >= 0)) {
            this.matrix[start][end] = weight;
            if (!this.directed) this.matrix[end][start] = weight;
        }
    }

    public int getWeight(int start, int end) {
        // 정점 start 와 정점 end 에 부속된 간선의 가중치 구하기
        int weight = 0;
        if ((0 <= start && start < this.size) && (0 <= end && end < this.size)) {
            weight = this.matrix[start][end];
        }
        return weight;
    }

    public int getSize() {
        return this.size;
    }

    public List<Edge> getEdges(int start) {
        // start를 시작 정점으로 하는 Edge들의 목록을 반환한다.
        List<Edge> edges = new ArrayList();

        for (int i = 0; i < this.size; i++) {
            int weight = getWeight(start, i);
            if (weight < MAX) {
                edges.add(new Edge(start, i, weight));
            }
        }
        return edges;
    }

    public List<Edge> getEdges() {
        List<Edge> all_edges = new ArrayList<>();
        boolean visited[] = new boolean[this.size];

        for (int v = 0; v < this.size; v++) {
            visited[v] = false;
        }

        for (int s = 0; s < this.size; s++) {
            List<Edge> e = this.getEdges(s);
            for (Edge edge : e) {
                if ( !visited[edge.getEnd()] ) {
                    all_edges.add(edge);
                    // visited[edge.getEnd()] = true;
                }
            }
            visited[s] = true;
        }
        return all_edges;
    }

    public void print() {   // 인접 행렬 출력
        System.out.println("SIZE = " + this.size);
        for (Edge edge : getEdges()) {
            System.out.println(edge);
        }
    }
}
