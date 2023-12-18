package Maze;

public class App_Maze {
    public static void main(String[] args) {
        int[][] map1 = {
                {0,1,1,1},
                {0,0,0,0},
                {1,0,1,1},
                {0,0,0,0}
        };
        int[][] map2 = {
                {0,1,1,1},
                {0,1,0,0},
                {1,0,1,1},
                {0,0,0,0}
        };
        int[][] map3 = {
                {0,0,0,0},
                {1,0,1,0},
                {1,0,1,0},
                {0,0,0,0}
        };
        MazeSolver solver1 = new MazeSolver(map1, new Position(0,0), new Position(3,3));
        System.out.println(solver1.findExit());
        MazeSolver solver2 = new MazeSolver(map2, new Position(0,0), new Position(3,3));
        System.out.println(solver2.findExit());
        MazeSolver solver3 = new MazeSolver(map3, new Position(0,0), new Position(3,3));
        System.out.println(solver3.findExit());
    }
}
