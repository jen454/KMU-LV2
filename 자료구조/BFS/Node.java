package BFS;

public class Node {
    int data;
    Node link;

    // ADT: Create
    public Node(int data) {
        this(data, null);
    }

    public Node(int data, Node link) {
        this.data = data;
        this.link = link;
    }

    public int getData() {
        return this.data;
    }

    public Node getLink() {
        return this.link;
    }

    public Node setLink(Node newLink) {
        Node oldLink = this.link; // 현재 링크가 가리키는 노드 7 6 5
        this.link = newLink; // 현재 링크를 인자에 연결
        return oldLink;
    }

    // 현재 노드의 다음 위치에 추가
    public Node insertAfter(int value) {
        Node newNode = new Node(value, this.link);
        this.link = newNode;
        return newNode;
    }
}