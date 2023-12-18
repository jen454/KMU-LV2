package Lamda_and_Random;

import java.util.Random;
public class RandomArray {
    public static int[] sum;
    static void accumulatedSum(int[] a) {
        sum = new int[a.length];

        for(int i=0; i<a.length; i++) {
            sum[i] = a[0];
        }
        for (int i=1; i<a.length; i++) {
            sum[i] = sum[i - 1] + a[i];
        }
        System.out.print("sum = " + "[");
        for (int i=0; i<sum.length; i++) {
            System.out.print(sum[i]);
            if (i<sum.length-1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println();
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] value = new int[5];
        for (int i=0; i<value.length; i++) {
            value[i] = rand.nextInt(5+i);
        }
        accumulatedSum(value);

    }
}
