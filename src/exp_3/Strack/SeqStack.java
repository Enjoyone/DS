package exp_3.Strack;

import T_seq.SeqList;

public class SeqStack<T> implements Stack<T> {
    private SeqList<T>list;   //调用Seqlist来存储
    public SeqStack(int length){
        this.list=new SeqList<T>(length);//执行顺序表构造方法
    }
    public SeqStack(){
        this(64);
    }

    public  boolean isEmpty(){
        return this.list.isEmpty();
    }
     public void push(T x){
        this.list.insert(this.list.size(),x);

     }// 入栈
     public T peek(){
        return this.list.get(this.list.size()-1);
     }// 返回栈顶
     public T pop(){
        return list.remove(list.size()-1);
     }//出栈
    public int size01(){
        return this.list.size();
    }
    public T trans(int num,int y,SeqStack<String>A){//进制转化//y为目的进制

        int i=-1;
        int g=0;
        //System.out.println(A.toString());
        System.out.println("目标进制为：");
        if (y>2&&y<10){
            while (num!=0) {
                i=num%y;
                A.push(Integer.toString(i));
                num=num /y;
            }
            g=A.size01();
            while (g%3!=0){
                A.push("0");
                g++;
            }
            for (int k = A.size01(),h=1; k >0; k--,h++) {
                System.out.print(A.pop());
                if (h%3==0)
                    System.out.print("  ");
            }
        }
        if(y==2){
            while (num!=0) {
                i=num%y;
                A.push(Integer.toString(i));
                num=num /y;
            }
            g=A.size01();
            while (g%4!=0){
                A.push("0");
                g++;
            }
            for (int k = A.size01(),h=1; k >0; k--,h++) {
                System.out.print(A.pop());
                if (h%4==0)
                    System.out.print("  ");
            }
        }
        if (y>=10){
            //0、1、2、3、4、5、6、7、8、9、A、B、C、D、E、F
            while (num!=0) {
                i=num%y;
                switch (i){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:A.push(Integer.toString(i));break;
                    case 10:A.push("A");break;
                    case 11:A.push("B");break;
                    case 12:A.push("C");break;
                    case 13:A.push("D");break;
                    case 14:A.push("E");break;
                    case 15:A.push("F");break;
                }
                //A.push(i);
                num=num /y;
            }
            g=A.size01();
            while (g%4!=0){
                A.push("0");
                g++;
            }
            for (int k = A.size01(),h=1; k >0; k--,h++) {
                System.out.print(A.pop());
                if (h%4==0)
                    System.out.print("  ");
            }
        }

        return (T)A.pop();
    }

    public String toString()                               //返回栈所有元素的描述字符串，形式为“(,)”
    {
        return this.getClass().getName()+" "+this.list.toString();
    }
}
