package ArrayLinearList;

public class ArrayLinearList {
    private int N;
    private int size;
    private int increment;
    private int[] itemList;

    public ArrayLinearList() {
        N = -1;
        size = 50;
        increment = 10;
        itemList = new int[size];
    }
    public boolean isEmpty() {
        if (itemList.length == 0) return true;
        else return false;
    }
    public void insert(int x) {
        int pos = 0;
        if (N == size - 1) { // 공백 0
            size += increment;
            int[] newItemList = new int[size];
            for (int i=0; i<this.itemList.length; i++) {
                newItemList[i] = this.itemList[i];
            }
            this.itemList = newItemList;
        }
        if (N==-1) {
            N++;
            itemList[N] = x;
        } else { //공백 != 0
            for (int i=0; i<=N; i++) {
                if (x > itemList[i]) pos++;
            }
            for (int i=pos+1; i>pos; i--) {
                itemList[i] = itemList[i-1];
            }
            itemList[pos] = x;
            N++;
        }
    }
    public void delete(int x) {
        if (isEmpty()) {
            System.out.println("List is Empty");
        }
        else {
            int loc = -1;
            for (int i=0; i<=N; i++) {
                if (x == itemList[i]) loc = i;
            }
            if (loc == -1) System.out.println("삭제할 원소 " + x + "가 없습니다.");
            else {
                for (int i=loc; i<N; i++) {
                    itemList[i] = itemList[i+1];
                }
                N--;
            }
        }
    }
    public void print() {
        for (int i=0; i<N; i++) {
            System.out.println(this.itemList[i] + ", ");
        }
        System.out.println(itemList[N]);
    }
}



