package exp_3.Sparse_Matrix;

//行的单链表存储的矩阵类

import T_Single.Node;
import T_Single.PolySingle;
import T_Single.Sorted;
import T_seq.SeqList;

public class LinkedMatrix {
    private int rows,columns;
    SeqList<PolySingle<Triple>> rowlist;/*行指针顺序表，元素---多项式排序单链表*/
    public LinkedMatrix(int m,int n){
        if (m>0&&n>0){
            this.rows=m;
            this.columns=n;
            this.rowlist=new SeqList<PolySingle<Triple>>();
            for (int i=0;i<m;i++)
                this.rowlist.append(new PolySingle<Triple>());//表尾插入
        }
        else throw new IllegalArgumentException("行列数均！<=0");
    }//m*n矩阵

    public LinkedMatrix(int m){
        this(m,m);
    }//m*m矩阵

    public LinkedMatrix(int m,int n,Triple[]tris){
        this(m,n);
        for (int i=0;i<tris.length;i++)
            this.set(tris[i]);

    }//右tris提供元素

    public int getRows()                                   //返回矩阵行数。方法体省略
    {
        return this.rows;
    }
    public int getColumns()                                //返回矩阵列数。方法体省略
    {
        return this.columns;
    }

    //（2） 返回矩阵元素
    //返回矩阵第i行第j列元素。若i、j越界，则抛出序号越界异常。查找算法比较三元组大小
    public int get(int i, int j)
    {
        if (i>=0 && i<this.rows && j>=0 && j<this.columns)
        {
            //在第i行排序单链表中顺序查找三元组(i,j,0)，比较三元组大小
            Node<Triple> find=this.rowlist.get(i).search1(new Triple(i,j,0));
            return (find!=null) ? find.data.value : 0;     //若查找成功，返回元素值，否则返回0
        }
        throw new IndexOutOfBoundsException("i="+i+"，j="+j);
    }

    public void set(int i,int j,int x){
        this.set(new Triple(i,j,x));
    }
    public void set(Triple tri){
        int i=tri.row,j=tri.column;
        if (j>0&&i<this.rows&&j>=0&&j<this.columns){
            Sorted<Triple>link=this.rowlist.get(i);//获取第i行排序单链表
            if (tri.value==0)
                link.remove(tri);
            else
            {
                Node<Triple>find=link.search1(tri);//需要使用sorted（排序单链表的方法
                if (find!=null)
                    find.data.value=tri.value;
                else
                    link.insert(tri);
            }
        }
        else new IndexOutOfBoundsException("");
    }
    public String toString(){
        String str="";
        for (int i=0;i<this.rowlist.size();i++)
            str+=i+"->"+this.rowlist.get(i).toString()+"\n";
        return str;
    }
    public void printMatrix(){
        System.out.println("矩阵"+this.getClass().getName()+"("+rows+"*"+columns+"):");
        for (int i = 0; i < this.rowlist.size(); i++) {//==this.rows
            Node<Triple>p=this.rowlist.get(i).head.next;
            for (int j = 0; j < this.columns; j++)
                if (p!=null&&j==p.data.column){
                    System.out.print(String.format("%4d",p.data.value));
                    p=p.next;
                }
                else
                    System.out.print(String.format("%4d",0));
            System.out.println();
        }
    }

    public void transpose(){
        this.printMatrix();
        System.out.println("该矩阵转置为：");
        for (int i = 0; i < this.columns; i++) {
            for (int j = 0; j < this.rows; j++) {
                System.out.format("%4d",this.get(j,i));//格式
            }
            System.out.println();
        }



    }




}
