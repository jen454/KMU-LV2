package CircularLinkedList;

// 수정할 필요가 없습니다.
public class Node<T> {
    public T data;
    public Node<T> link;

    public Node() {
        this(null, null);
    }

    public Node(T data) {
        this(data, null);
    }

    public Node(T data, Node<T> link) {
        this.data = data;
        this.link = link;
    }

    public T getData() {
        return data;
    }

    public boolean isTerminal() {
        return this.link == null;
    }

    public boolean equals(Node<T> other) {
        // data 만 보고 비교
        // data가 null 인 경우 비교하지 않음 (false)
        // 링크는 비교하지 않음
        if(this.data == null || other.data == null) {
            return false;
        }
        return this.data.equals(other.data);
    }
}