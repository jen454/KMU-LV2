package CircularLinkedList;

// 수정할 필요가 없습니다.
@FunctionalInterface
public interface Visitor<T> {
    void visit(Node<T> node);
}