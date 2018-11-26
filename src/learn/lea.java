package learn;

public class lea<T> extends Object {

    public Node<T> head;

    //public T data;
    //public SingleList<T>next;

    public lea() {
        this.head = new Node<>();
    }

    public lea(T[] values) {
        this();
        Node<T> rear = this.head;
        for (int i = 0; i < values.length; i++) {
            rear.next = new Node<T>(values[i], null);
            rear = rear.next;

        }
    }

    public String toString() {
        String str = this.getClass().getName() + "(";
        for (Node<T> p = this.head.next; p != null; p = p.next) {
            str += p.data.toString();
            if (p.next != null)
                str += ",";
        }
        return str + ")";
    }
    public void qwe(){
        Node<T>p=this.head.next;
        p=p.next;

        head=p.next;
        System.out.println(p);
        System.out.println(this.head.next.data);
    }

    public static void main(String[] args) {
        String[]a1={"a","b","c","Strack","e"};
        lea<String>test=new lea<>(a1);
        test.qwe();
        //System.out.println(test.toString());




    }
}