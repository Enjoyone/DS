package T_Single;
//多项式类
public class Polynomial
{
    private PolySingle<TermX> list;                    //多项式排序单链表，TermX表示一元多项式的一项

    public Polynomial()                                    //构造方法
    {
        this.list = new PolySingle<TermX>();           //创建空单链表，执行排序单链表默认构造方法
    }
    public Polynomial(TermX terms[])                       //构造方法，由项数组指定多项式各项值
    {
        this.list = new PolySingle<TermX>(terms);
    }


    public Polynomial(Polynomial poly)                     //深度拷贝构造方法，复制所有结点和对象
    {
        this();                                            //创建空单链表，只有头结点
        Node<TermX> rear = this.list.head;
        for (Node<TermX> p=poly.list.head.next;  p!=null;  p=p.next) //p遍历poly单链表
        {
            rear.next = new Node<TermX>(new TermX(p.data), null);    //复制结点，复制对象
            rear = rear.next;
        }
    }

    public String toString()                               //返回多项式
    {
        String str="";
        for (Node<TermX> p=this.list.head.next;  p!=null;  p=p.next)
            str+=p.data.toString();
        return str;
    }

    public void subs01(Polynomial poly)
    {
        this.list.substraction01(poly.list);
    }
    public Polynomial union(Polynomial poly)
    {
        Polynomial polyc=new Polynomial(this);             //深拷贝，复制所有结点和对象
        polyc.subs01(poly);
        return polyc;
    }
}
