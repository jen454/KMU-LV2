package Postfix;

public class Charstack {
    int top = -1;
    int maxSize = 0;
    char[] elements;

    public Charstack(int maxStackSize){
        top = -1;
        this.maxSize = maxStackSize;
        elements = new char[maxStackSize];
    }

    public boolean isFull(){
        return top >= elements.length-1;
    }

    public Charstack add(char item){
        if(isFull()){
            throw new RuntimeException("Stack is full!");
        }
        top++;
        elements[top] = item;
        return this;
    }

    public boolean isEmpty(){
        return top < 0;
    }

    public char pop(){
        return delete();
    }

    public char delete(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty!");
        }
        return elements[top--];
    }

    public char peek(){
        if(isEmpty()) throw new RuntimeException("Stack is empty!");
        else return elements[top];
    }

    public void clear(){
        this.top = -1;
        this.elements = new char[this.maxSize];
    }
}