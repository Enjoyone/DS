package T_Single;

public class SingleList<T> extends Object implements List_Single<T>{

    public Node<T>head;

    //public T data;
    //public SingleList<T>next;

    public SingleList() {
        this.head=new Node<>();
    }

    public SingleList(T[] values) {
        this();
        Node<T>rear=this.head;
        for (int i=0;i<values.length;i++){
            rear.next=new Node<T>(values[i],null);
            rear=rear.next;
        }
    }

    /*public SingleList(T data,SingleList<T>next){
        this.data=data;
        this.next=next;
    }*/
    public boolean isEmpty() {
        return this.head.next==null;
    }

    public T get(int i) {
        Node<T>p=this.head.next;
        for (int j=0;p!=null&&j<i;j++)
            p=p.next;
        return (i>=0&&p!=null)?p.data:null;
    }

    public void set(int i,T x){
        if (x==null)
            return;
        Node<T>p=this.head.next;
        for (int j=0;p!=null&&j<i;j++)
            p=p.next;
        if (i>=0&&p!=null)
            p.data=x;
        else throw new IndexOutOfBoundsException(i+"");
   }

   public Node<T> insert(int i,T x){
        if (x==null)
            throw new NullPointerException("x==null");
        Node<T>front=this.head;
        for (int j=0;front.next!=null&&j<i;j++)
            front=front.next;
       front.next=new Node<T>(x,front.next);
       return front.next;

   }

   public int length(){
        int i=0;
        Node<T>p=this.head.next;
        while (p!=null){
            i++;
            p=p.next;
        }
        return i;
   }
   public void append(T x){
        insert(this.length(),x);
   }
    public T remove(int i){
       if (i>=0){
           Node<T>p=this.head;
           for (int j=0;p.next!=null&&j<i;j++)
               p=p.next;
           if (p.next!=null){
               T old=p.next.data;
               p.next=p.next.next;
               return old;
           }
       }
       return null;
    }
    public int search(T key) {
        Node<T>front=this.head;
        int n=0;
        for (int i=0;front!=null;i++){
            if (key.equals(front.next.data))
                return i;
            front=front.next;
        }
        return -1;
    }

    public void removeAll(){
        this.head.next=null;
    }
    public String toString(){
        String str=this.getClass().getName()+"(";
        for (Node<T>p=this.head.next;p!=null;p=p.next){
            str +=p.data.toString();
            if (p.next!=null)
                str+=",";
        }
        return str+")";
    }


    //创建有序链表类
//深拷贝

    public SingleList(SingleList<T>list){
        Node<T> rear=this.head;
        for (Node<T> p=list.head.next;  p!=null;  p=p.next)  //p遍历list单链表
        {
            rear.next = new Node<T>(p.data, null);        //复制结点尾插入到this单链表
            rear = rear.next;                             //指向this单链表尾
        }
    }
//排序
    public void SequentialList(SingleList<T> A){
        Node<T>front=A.head;
        Node<T>p=front.next;
        System.out.println(A.toString());
    }


    public T DeleteX(T key){
        int i=this.search(key);
        return this.remove(i);
    }

    //倒置
    public void inversion(SingleList<T> A){
        if(A==null||A.head.next==null||A.head.next.next==null)
            return;

        Node<T>p=A.head.next.next;//令p指向线性表中第2个元素a2
        A.head.next.next=null;//令线性表中第1个元素a1的next为空
        while(p!=null){
            Node<T>q=p.next;
            //将p插入头结点之后
            p.next=A.head.next;
            A.head.next=p;
            p=q;//继续访问下一个元素
        }
    }

    //合并
    public void combineSingle(SingleList<T> A,SingleList<T> B){
        SingleList<String>C=new SingleList<>();
        Node<T>p=A.head.next;
        Node<T>q=B.head.next;
        int k=1;
        int i=0,j=0;
        while (A!=null&&p!=null&&B!=null&&q!=null/*&&i<4&&j<4*/){
            if (((String )p.data).compareTo((String)q.data)<=0){
                C.insert(k++,(String)p.data);
                p=p.next;
                System.out.println(C.toString());
                //i++;
            }else {
                C.insert(k++,(String)q.data);
                q=q.next;
                //j++;
                System.out.println(C.toString());
            }
        }
        while (A!=null&&p!=null){
            C.insert(k++,(String)p.data);
            p=p.next;
        }
        while (B!=null&&q!=null){
            C.insert(k++,(String)q.data);
            q=q.next;
        }
        System.out.println(C.toString());
//方法2
        /*while (A!=null&&p!=null&&B!=null&&q!=null&&i<4&&j<4){
            while (((String )p.data).compareTo((String)q.data)<=0){
                C.insert(k++,(String)p.data);
                p=p.next;
                System.out.println(C.toString());
                i++;
                break;
            }
            while (((String )p.data).compareTo((String)q.data)>0){
                C.insert(k++,(String)q.data);
                q=q.next;
                j++;
                System.out.println(C.toString());
                break;
            }
        }
        while (A!=null&&p!=null){
            C.insert(k++,(String)p.data);
            p=p.next;
        }
        while (B!=null&&q!=null){
            C.insert(k++,(String)q.data);
            q=q.next;
        }
        System.out.println(C.toString());*/

    }

    //一元多项式的基本运算


}