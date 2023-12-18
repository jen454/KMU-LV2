package Lamda_and_Random;

public class LamdaPrintArray {
    public static void main(String[] args) {
        int[] a = new int[5];
        int[] b = {0,1,5,7,9};
        int[] c = new int[5];

        for (int i=0; i<a.length; i++) {
            a[i] = i*i-i;
            c[i] = a[i] + b[i];
        }

        LambdaArray la = (ar, nm) -> {
            System.out.print(nm + " = " + "[");
            for (int i=0; i<ar.length; i++) {
                System.out.print(ar[i]);
                if (i<ar.length-1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println();
        };
        la.print(a,"a");
        la.print(b,"b");
        la.print(c,"c");
    }
}

@FunctionalInterface
interface LambdaArray {
    void print(int[] a, String name);
}
