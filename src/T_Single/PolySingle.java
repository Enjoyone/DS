package T_Single;
//多项式单链表类
//提供运算

public class PolySingle<T extends Comparable<? super T> & Addible<T>> extends Sorted<T> {

    public PolySingle()                                //构造方法
    {
        super();                                           //创建空单链表
    }
    public PolySingle(T terms[])                       //构造方法，由项数组指定多项式各项值
    {
        super(terms);
    }
    public PolySingle(PolySingle<T> list)          //拷贝构造方法
    {
        super(list);                                       //单链表深拷贝，复制所有结点，没有复制对象
    }
    public void substraction01(PolySingle<T> list)             //多项式相减
    {
        Node<T> front=this.head, p=front.next;
        Node<T> q=list.head.next;
        while (p!=null && q!=null)
            if (p.data.compareTo(q.data)==0)               //两项大小相同
            {
                p.data.substraction(q.data);                //相减
                if (p.data.removable())                    //相减后元素满足删除条件
                {                                          //removable()方法
                    front.next=p.next;                     //即直接删除
                    p=front.next;
                }
                else
                {
                    front = p;                             //front是p的前驱结点
                    p = p.next;
                }
                q = q.next;
            }
            else if (p.data.compareTo(q.data)<0)
            {
                front = p;
                p = p.next;
            }
            else
            {
                front.next = new Node<T>(q.data, p);  //复制q结点并插入到front结点之后
                q = q.next;
            }
        while (q!=null)                                    //将list单链表中剩余结点复制并插入到当前链表尾
        {
            front.next = new Node<T>(q.data, null);
            front = front.next;
            q = q.next;
        }
    }
}
