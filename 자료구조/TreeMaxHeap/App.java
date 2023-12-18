package TreeMaxHeap;

import java.util.Scanner;

public class App {

    public static void traverseHeap(MaxHeap heap) {
        System.out.print("Pre-Order : ");
        heap.preOrder();
        System.out.println();
        System.out.print("In-Order : ");
        heap.inOrder();
        System.out.println();
        System.out.print("Post-Order : ");
        heap.postOrder();
        System.out.println();
    }

    public static void removeElements(MaxHeap heap) {
        System.out.print("Output : ");
        while(!heap.isEmpty()) {
            int data = heap.remove();
            System.out.print(data);
            System.out.print(" ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        // 예제 수행하기
        int[] example = {23, 39, 7, 20, 14, 15, 46, 66, 75, 49, 32};

        // Test
        // 예제 힙 생성
        MaxHeap heap = new MaxHeap(example.length);
        for(int element: example) {
            heap.insert(element);
        }

        traverseHeap(heap);
        removeElements(heap);



        // 키보드로 테스트 케이스 입력받기
        Scanner input = new Scanner(System.in);
        // 데이터 개수 입력
        int n = input.nextInt();
        heap = new MaxHeap(n);
        for(int i=0;i<n;i++) {
            // 키에서 입력 받아 힙에 삽입
            heap.insert( input.nextInt() );
        }

        traverseHeap(heap);
        removeElements(heap);
    }
}
