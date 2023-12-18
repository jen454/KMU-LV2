package CircularLinkedList;

// 수정할 필요가 없습니다.
@FunctionalInterface
public interface ItemComparator<T> {
    int compare(T lhs, T rhs);
}