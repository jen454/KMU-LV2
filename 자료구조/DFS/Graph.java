package DFS;

public class Graph {
    // 멤버를 선언하세요.
    protected boolean directed;
    protected int size;
    protected int[][] edges;
    protected boolean[] visited;

    public Graph(int vertexes) {
        // 생성자를 구현하세요.
        this.size = vertexes;
        this.directed = false;
        this.edges = new int[vertexes][vertexes];
    }

    public Graph add(int start, int end) {
        // 간선을 추가하는 함수를 구현하세요.
        this.edges[start][end] = 1;
        if (!this.directed) this.edges[end][start] = 1;
        return this;
    }

    // 정점을 탐색하세요.
    // 정점의 번호가 낮은 것부터 방문하도록 합니다.
    public void dfs(int v, Visitor visitor) {
        // 정점의 방문은 visitor를 사용한다.
        // visitor.visit(정점 번호);
        this.visited = new boolean[this.size];
        dfsInternal(v,visitor);
    }
    public void dfsInternal(int v, Visitor visitor) {
        this.visited[v] = true;
        visitor.visit(v);
        for (int i=0; i<this.size; i++) {
            if (this.edges[v][i]!=0 && this.visited[i]==false) dfsInternal(i,visitor);
        }
    }
}
