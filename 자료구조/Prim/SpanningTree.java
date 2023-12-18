package Prim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 이번 실습은 Graph 를 상속하여 Tree 구현하세요.
// Graph 에서 추가 수정이 필요한 경우 추가하기 바랍니다.
public class SpanningTree extends Graph {
    // size 는 정점의 개수
    int root;

    // Tree의 표현은 자유롭게 구성하기
    public SpanningTree(int size) {
        super(size);
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public int getRoot() {
        return this.root;
    }

    // 간선의 weight 합 추가
    public int weight() {
        int result = 0;
        for(Edge edge: getEdges()) {
            result += edge.getWeight();
        }
        return result;
    }

    public void print() {   // 인접 행렬 출력
        System.out.println("COST = " + this.weight());
//        List<Edge> edges = getEdges();
//        Collections.sort(edges);
        for(Edge edge: getEdges()) {
            System.out.println(edge);
        }
    }

    public void add(int start, int end, int weight) {
        // 간선 추가 함수 구현하기
        if ((0 <= start && start < this.size) && (0 <= end && end < this.size) && (weight >= 0) && this.matrix[start][end] == MAX) {
            this.matrix[start][end] = weight;
            if (!this.directed) this.matrix[end][start] = weight;
        }
    }
}

