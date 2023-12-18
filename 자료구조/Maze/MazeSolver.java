package Maze;

import java.util.Arrays;
class Stack {
    Position[] arr;
    int top;

    public Position[] toArray() {
        Position[] array = new Position[top + 1];
        for (int i = 0; i <= top; i++) {
            array[i] = arr[i];
        }
        return array;
    }

    public Stack(int capacity) {
        arr = new Position[capacity];
        top = -1;
    }

    public void push(Position position) {
        if (top == arr.length - 1) {
            throw new RuntimeException("Stack is full");
        }
        top++;
        arr[top] = position;
    }

    public Position pop() {
        if (top == -1) {
            throw new RuntimeException("Stack is empty");
        }

        return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class MazeSolver {
    int[][] map;
    Position start;
    Position end;
    Position current;
    Position check;
    Stack stack = new Stack(100);
    Stack pathstack = new Stack(100);
    Stack wrongstack = new Stack(100);
    boolean[][] isVisited;

    public MazeSolver(int[][] map, Position start, Position end) {
        this.map = map;
        this.start = start;
        this.end = end;
        this.current = new Position(start.getRow(), start.getCol());
        this.check = new Position(start.getRow(), start.getCol());
        this.stack = new Stack(map.length * map[0].length);
        this.pathstack = new Stack(map.length * map[0].length);
        this.wrongstack = new Stack(map.length * map[0].length);
        this.isVisited = new boolean[map.length][map[0].length];
    }

    public boolean canMove(int row, int col) {
        if (row >= this.map.length || row < 0) {
            return false;
        }
        if (col >= this.map[row].length || col < 0) {
            return false;
        }
        return this.map[row][col] == 0;
    }

    boolean findExit() {
        Position zero = new Position(current.getRow(), current.getCol());
        stack.push(zero);

        while (!stack.isEmpty()) {
            int cnt = 0;
            boolean backstep = false;
            Position[] pathArray;
            Position current = stack.pop();
            pathstack.push(current);
            isVisited[current.getRow()][current.getCol()] = true;

            if (current.equals(this.end)) {
                pathArray = pathstack.toArray();
                System.out.println(Arrays.toString(pathArray));
                return true;
            }

            Position next = new Position(current.getRow() - 1, current.getCol());
            if (canMove(next) && !isVisited[next.getRow()][next.getCol()]) {
                cnt++;
                backstep = true;
                isVisited[next.getRow()][next.getCol()] = true;
                stack.push(next);
            }

            next = new Position(current.getRow() + 1, current.getCol());
            if (canMove(next) && !isVisited[next.getRow()][next.getCol()]) {
                cnt++;
                backstep = true;
                isVisited[next.getRow()][next.getCol()] = true;
                stack.push(next);
            }

            next = new Position(current.getRow(), current.getCol() - 1);
            if (canMove(next) && !isVisited[next.getRow()][next.getCol()]) {
                cnt++;
                backstep = true;
                isVisited[next.getRow()][next.getCol()] = true;
                stack.push(next);
            }

            next = new Position(current.getRow(), current.getCol() + 1);
            if (canMove(next) && !isVisited[next.getRow()][next.getCol()]) {
                cnt++;
                backstep = true;
                isVisited[next.getRow()][next.getCol()] = true;
                stack.push(next);
            }

            if (cnt >= 2) check = next;

            if (!backstep) {
                Position wrong = pathstack.pop();
                while (!wrong.equals(check)) {
                    wrongstack.push(wrong);
                    wrong = pathstack.pop();
                }
                wrongstack.push(wrong);
            }
        }
        System.out.println("[]");
        return false;
    }

    public boolean canMove(Position p) {
        return this.canMove(p.getRow(), p.getCol());
    }
}
