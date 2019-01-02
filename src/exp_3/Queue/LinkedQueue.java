package exp_3.Queue;

import T_Single.Node;

public final class LinkedQueue<T> implements Queue<T> {
    private Node<T>front,rear;
    public LinkedQueue(){
        this.front=this.rear=null;
    }
    public boolean isEmpty(){
        return this.front==null&&this.rear==null;
    }
    public boolean add(T x){
        if (x==null)
            return false;
        Node<T>q=new Node<T>(x,null);
        if (this.front==null)
            this.front=q;
        else
            this.rear.next=q;
        this.rear=q;
        return true;
    }//x入队，成功返回true
    public T  peek(){
        return this.isEmpty()?null:this.front.data;

    }//返回队头
    public T poll(){
        if (isEmpty())
            return null;
        T x=this.front.data;
        this.front=this.front.next;
        if (this.front==null)
            this.rear=null;
        return x;
    }//出队
    public int size(){
        int i=1;
        while (this.front!=null){
            this.front=this.front.next;
            i++;
        }
        return i;
    }
    public String toString()
    {
        StringBuffer strbuf = new StringBuffer(this.getClass().getName()+"(");
        for (Node<T> p=this.front;  p!=null;  p=p.next)
            strbuf.append(p.data.toString()+",");
        strbuf.setCharAt(strbuf.length()-1, ')');
        return new String(strbuf);
    }
}
