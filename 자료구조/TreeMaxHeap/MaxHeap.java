package TreeMaxHeap;

import java.util.ArrayList;

public class MaxHeap {
    int[] elements;
    int n; // 현재 삽입된 원소의 수

    public MaxHeap(int size) {
        this.elements = new int[size+1];
        this.n = 0;
    }

    public boolean isFull() {
        // 구현하기
        if (this.n == this.elements.length-1) return true;
        else return false;
    }

    public boolean isEmpty() {
        // 구현하기
        if (this.n > 0) return false;
        else return true;
    }

    public int size() {
        // 저장한 원소의 개수
        return this.n;
    }

    public int capacity() {
        // 저장할 수 있는 원소의 개수
        return this.elements.length - 1;
    }

    public boolean insert(int data) {
        int ptr;
        if( this.isFull() ) {
            return false;
        }
        // 구현하기
        ptr = ++this.n;
        if (ptr < this.elements.length) {
            while ((ptr!=1) && (data > this.elements[ptr/2])) {
                this.elements[ptr] = this.elements[ptr/2];
                ptr /= 2;
            }
            this.elements[ptr] = data;
        }
        return false;
    }

    public int remove() {
        int parent, child;
        int item, temp;
        if( this.isEmpty() ) {
            throw new RuntimeException("데이터가 없습니다.");
        }
        // 구현하기
        item = this.elements[1];
        temp = this.elements[n--];
        parent = 1; child = 2;
        while (child <= n) {
            if (child < n && (this.elements[child] < this.elements[child+1])) child++;
            if (temp >= this.elements[child]) break;
            this.elements[parent] = this.elements[child];
            parent = child;
            child *= 2;
        }
        this.elements[parent] = temp;
        return item;
    }

    public void preOrder() {
        // PRE-ORDER 출력 구현하기
        // 한 줄(행)에 출력한다.
        // 값과 값은 공백으로 구분한다.
        int last = 1;
        while ((last*2) <= this.size()) {
            System.out.print(this.elements[last]); System.out.print(" ");
            last *= 2;
        }
        System.out.print(this.elements[last]); System.out.print(" ");
        for (int i=last; i>1; i/=2) {
            if (i+1 <= this.size()) {
                System.out.print(this.elements[i+1]); System.out.print(" ");
                if ((i+1)*2 <= this.size()) {
                    System.out.print(this.elements[(i+1)*2]); System.out.print(" ");
                }
                if ((i+1)*2+1 <= this.size()) {
                    System.out.print(this.elements[(i+1)*2+1]); System.out.print(" ");
                }
            }
        }
    }

    public void inOrder() {
        // IN-ORDER 출력 구현하기
        // 한 줄(행)에 출력한다.
        // 값과 값은 공백으로 구분한다.
        int last = 1;
        while ((last*2) <= this.size()) last *= 2;
        System.out.print(this.elements[last]); System.out.print(" ");
        for (int i=last; i>1; i/=2) {
            System.out.print(this.elements[i/2]); System.out.print(" ");
            if (i+1 <= this.size()) {
                if ((i+1)*2 <= this.size()) {
                    System.out.print(this.elements[(i+1)*2]); System.out.print(" ");
                }
                System.out.print(this.elements[i+1]); System.out.print(" ");
                if ((i+1)*2+1 <= this.size()) {
                    System.out.print(this.elements[(i+1)*2+1]); System.out.print(" ");
                }
            }
        }
    }

    public void postOrder() {
        // POST-ORDER 출력 구현하기
        // 한 줄(행)에 출력한다.
        // 값과 값은 공백으로 구분한다.
        int last = 1;
        while ((last*2) <= this.size()) last *= 2;
        System.out.print(this.elements[last]); System.out.print(" ");
        for (int i=last; i>1; i/=2) {
            if (i+1 <= this.size()) {
                if ((i+1)*2 <= this.size()) {
                    System.out.print(this.elements[(i+1)*2]); System.out.print(" ");
                }
                if ((i+1)*2+1 <= this.size()) {
                    System.out.print(this.elements[(i+1)*2+1]); System.out.print(" ");
                }
                System.out.print(this.elements[i+1]); System.out.print(" ");
                System.out.print(this.elements[i/2]); System.out.print(" ");
            }
        }
    }
}