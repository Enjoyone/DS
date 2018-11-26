package T_Single;

public class Sorted<T extends Comparable<? super T>> extends SingleList<T>{
    public Sorted(){
        super();
    }
    public Sorted(T[] values){
        super();
        for (int i = 0; i < values.length; i++) {
            this.insert(values[i]);
        }
    }
    public Sorted(Sorted<T> list){
        super(list);
    }
    public Sorted(SingleList<T>list){
        super();
        //int i=1;
        for (Node<T>p=list.head.next;p!=null;p=p.next){
            this.insert(p.data);
        }
    }
    public Node<T>insert(T x){
        Node<T>front=this.head,p=front.next;
        while (p!=null&&x.compareTo(p.data)>0){
            front=p;
            p=p.next;
        }
        front.next=new Node<T>(x,p);
        return front.next;
    }
    public Node<T> search1(T key)
    {
        for (Node<T> p=this.head.next;  p!=null && key.compareTo(p.data)>=0;  p=p.next)
        {
//            System.out.print(p.data+"？");
            if (key.compareTo(p.data)==0)                  //由compareTo()提供比较对象大小和相等的依据
                return p;
        }
//        System.out.println();
        return null;
    }

    public T remove(T key)
    {
        Node<T> front=this.head, p=front.next;             //front是p的前驱结点
        while (p!=null && key.compareTo(p.data)>0)         //查找与key相等元素结点（p指向）
        {
            front = p;
            p = p.next;
        }
        if (p!=null && key.compareTo(p.data)==0)           //若查找成功，删除p结点，返回被删除元素
        {
            front.next = p.next;                           //删除p结点
            return p.data;
        }
        return null;
    }






}
