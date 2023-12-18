package Prim;

public class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    public Edge(int s, int e, int w) {
        this.start = s;
        this.end = e;
        this.weight = w;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public int getWeight() {
        return this.weight;
    }

    public int compareTo(Edge other) {
        int x = this.weight;
        int y = other.weight;

        return x - y; // 오름차순
    }

    public String toString() {
        return String.format("(E=<%d, %d>, W=%d)",
                this.start, this.end, this.weight
        );
    }
}
