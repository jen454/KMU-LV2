package BFS;

import java.util.LinkedList;
import java.util.Deque;

public class Graph {
    int size;
    Node[] heads;
    boolean directed;

    public Graph(int vertexes) {
        // 생성자를 구현하세요.
        this.size = vertexes;
        this.heads = new Node[vertexes];
        this.directed = false;
        // heads 초기화 주의 : 모든 정점은 시작 정점이 존재해야 함
        for (int i=0; i<vertexes; i++) {
            this.heads[i] = new Node(i);
        }
    }

    public Graph add(int start, int end) {
        // 간선을 추가하는 함수를 구현하세요.
        Node node = this.heads[start];
        while (node.getLink() != null) {
            node = node.link;
            if (node.getData() == end) return this;
        }
        if (node.getLink() == null && node.getData() != end) {
            node = this.heads[start];
            Node newnode = new Node(end);
            while (node.getLink() != null) {
                if (node.getLink().getData() > newnode.getData()) break;
                node = node.link;
            }
            if (node.getLink() != null) newnode.setLink(node.getLink());
            else node.setLink(newnode);
        }
        if (!directed) this.add(end, start);
        return this;
    }

    // 정점을 탐색하세요.
    // 정점의 번호가 낮은 것부터 방문하도록 합니다.
    public void bfs(int v, Visitor visitor) {
        Deque<Integer> deque = new LinkedList<>();
        boolean[] visited = new boolean[this.size];
        this.bfsInternal(v,visitor,visited,deque);
        // 정점의 방문은 visitor를 사용한다.
        // visitor.visit(정점 번호);
    }

    public void bfsInternal(int v, Visitor visitor, boolean[] visited, Deque<Integer> deque) {
        visited[v] = true;
        deque.addLast(v);
        while (!deque.isEmpty()) {
            int node = deque.removeFirst();
            visitor.visit(node);
            Node nextnode = this.heads[node].getLink();
            while (nextnode != null) {
                int next = nextnode.getData();
                if (!visited[next]) {
                    visited[next]= true;
                    deque.addLast(next);
                }
                nextnode = nextnode.getLink();
            }
        }
    }
}

