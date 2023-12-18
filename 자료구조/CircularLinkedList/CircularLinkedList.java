package CircularLinkedList;

// 아래 코드에서 "구현" 이 필요한 부분을 구현하세요.
public class CircularLinkedList<T> {
    private Node<T> begin;
    private Node<T> end;

    public CircularLinkedList() {
        this.begin = new Node<T>();
        this.end = new Node<T>();
        this.begin.link = this.begin;
    }

    public boolean isEmpty() {
        return begin.link == begin;
    }

    private void traverse(Node<T> L, Visitor<T> visitor) {
        for (Node<T> p=L; p.link!=L; p=p.link) {
            visitor.visit(p);
        }
        if (L!=begin && L!=begin.link) {
            visitor.visit(L);
        }
        visitor.visit(end);
        if(this.end.data != null){
            visitor.visit(new Node<T>(null));
        }
    }

    public void traverse(Visitor<T> visitor) {
        this.traverse(this.begin.link, visitor);
    }

    private Node<T> search(Node<T> L, T data, ItemComparator<T> comparator) {
        Node<T> p = L;
        Node<T> found = L;
        while( p!=end && comparator.compare(p.data, data) <= 0) {
            found = p;
            p = p.link;
        }
        return found;
    }

    public Node<T> search(T data, ItemComparator<T> comparator) {
        return this.search(this.begin.link, data, comparator);
    }

    public Node<T> add(T data, ItemComparator<T> comparator) {
        Node<T> insert = new Node<T>(data);
        Node<T> pos;
        if( isEmpty() ) {
            pos = this.begin; // pos와 begin 같다
        } else {
            pos = this.search(this.begin.link, data, comparator);
        }
        insert.link = pos.link;
        pos.link = insert;
        return insert;
    }

    private Node<T> deleteSearch(Node<T> L, T data, ItemComparator<T> comparator) {
        Node<T> p = L;
        Node<T> found = L;
        while( p!=end && comparator.compare(p.data, data) != 0 ) {
            found = p; // Keep Current Node
            p = p.link; // Move Next Node
        }
        if( p == end ) return end;
        if( found == p ) return begin;
        return found;
    }

    public Node<T> deleteSearch(T data, ItemComparator<T> comparator) {
        return this.deleteSearch(this.begin.link, data, comparator);
    }

    public Node<T> delete(T data, ItemComparator<T> comparator) {
        Node<T> pos = null;
        Node<T> deleting = null;
        pos = this.deleteSearch(data, comparator);
        // begin 과 end 노드는 삭제할 수 없음
        if( pos == this.end || pos == this.begin ) {
            return null;
        }
        deleting = pos.link;
        pos.link = deleting.link;
        return pos;
    }
    public void invert() {
        if(isEmpty()) return;
        Node<T> invert = new Node<T>(null);
        invert.link = invert;
        Node<T> first = this.begin.link;
        this.begin.link = first.link;
        first.link = first;
        invert.link = first;
        Node<T> select = this.begin.link;
        while(select != begin) {
            this.begin.link = select.link;
            select.link = first.link;
            first.link = select;
            select = this.begin.link;
        }
        this.end = invert.link;
        this.begin.link = first.link;
    }

    public void concatenate(CircularLinkedList<T> other) {
        Node<T> arrA = this.begin;
        Node<T> arrB = other.begin;
        for (; arrA.link!=this.begin; arrA=arrA.link) {}
        for (; arrB.link!=other.begin; arrB=arrB.link) {}
        arrA.link = other.begin.link;
        other.begin.link = other.begin;
        arrB.link = this.begin;
    }
}