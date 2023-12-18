package Maze;

public class Position {
    int row;
    int col;
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public boolean equals(int row, int col) {
        return this.row == row && this.col == col;
    }
    public boolean equals(Position p) {
        return this.equals(p.row, p.col);
    }
    public void set(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public String toString() {
        return "(" + this.row + "," + this.col + ")";
    }
    public int getRow() {return this.row;}
    public int getCol() {return this.col;}
}
