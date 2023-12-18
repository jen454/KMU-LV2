package ArrayLinearList;

public class App_ArrayLinearList extends ArrayLinearList {
    public static void main(String[] args) throws Exception{
        ArrayLinearList list1 = new ArrayLinearList();
        list1.insert(12);
        list1.insert(24);
        list1.insert(36);
        list1.insert(58);
        list1.insert(79);

        System.out.println("*** Show List after insert");
        list1.print();

        list1.delete(24);
        System.out.println("*** Show List after delete 24 **");
        list1.print();

        list1.delete(58);
        System.out.println("*** Show List after delete 58 **");
        list1.print();

        list1.delete(12);
        System.out.println("*** Show List after delete 12 **");
        list1.print();

        list1.delete(10);
        System.out.println("*** Show List after delete 10 **");
        list1.print();
    }


}
