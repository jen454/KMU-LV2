package UseArray2;

public class UseArray2 {
    static void print(int[][] a, String name) {
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a[i].length; j++) {
                System.out.print(name + "[" + i + "] = ");
                System.out.println(a[i][j]);
            }
        }
        System.out.println();
    }
}
