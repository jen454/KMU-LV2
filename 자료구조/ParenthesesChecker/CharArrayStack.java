package ParenthesesChecker;

public class CharArrayStack {
    int top = -1;
    int maxSize = 0;
    char[] elements;

    public CharArrayStack(int maxStackSize) {
        top = -1;
        elements = new char[maxStackSize];
    }

    public CharArrayStack() {}

    public boolean isFull() {
        return top >= elements.length-1;
    }

    public CharArrayStack add(char item) {
        if (isFull()) {
            throw new RuntimeException("Stack is full!");
        }
        top++;
        elements[top] = item;
        return this;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public char delete() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return elements[top--];
    }

    public CharArrayStack clear() {
        for (int i=0; i<elements.length; i++) {
            elements[i] = 0;
        }
        top = -1;
        return this;
    }
}
