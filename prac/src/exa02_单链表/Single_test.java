package exa02_单链表;

public class Single_test{
    public static void main(String[] args) {
        Link<Double> l2 = new Link<Double>();
        l2.insertHead(10.0);
        l2.insertHead(20.0);
        l2.insertHead(30.0);
        l2.insertTail(11.0);
        l2.insertTail(22.0);
        l2.insertTail(33.0);
        l2.insert(12.0, 3);
        l2.insert(23.0, 3);
        l2.insert(34.0, 3);
        System.out.println();
        System.out.println(l2.getLength());
        l2.delete(22.0);
        l2.print();
    }
}
