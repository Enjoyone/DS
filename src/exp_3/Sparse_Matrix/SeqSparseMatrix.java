package exp_3.Sparse_Matrix;

//行的单链表存储的矩阵类


import java.util.Arrays;

public class SeqSparseMatrix {
    private int rows, columns; //矩阵行数、列数
    private SeqList2<Triple> list; //稀疏矩阵三元组顺序表

    public SeqSparseMatrix(int rows, int columns) //构造rows行columns列零矩阵
    {
        if (rows<=0 || columns<=0)
            throw new IllegalArgumentException("矩阵行数或列数非正数。"); //抛出无效参数异常
        this.rows = rows;
        this.columns = columns;
        this.list = new SeqList2<Triple>();
    }
    //构造rows行columns列矩阵，由三元组数组elems提供矩阵初值
    public SeqSparseMatrix(int rows, int columns, Triple[] elems)
    {
        this(rows, columns);
        for (int i=0; i<elems.length; i++)
            this.set(elems[i]); //按行主序插入一个元素的三元组
    }


    // 输出矩阵
    public String toString()                               //返回稀疏矩阵三元组行的单链表描述字符串
    {
        String str="";
        for (int i=0; i<this.list.size(); i++)         //循环次数为行指针顺序表长度
            str += i+" -> "+this.list.get(i).toString()+"\n";//获得第i行排序单链表的描述字符串
        return str;
    }

//输出：
    public void print(SeqSparseMatrix mat2){
        System.out.println("矩阵"+this.getClass().getName()+"（"+rows+"×"+columns+"）：");
        for (int i=0; i<this.rows; i++)
        {
            for (int j=0; j<this.columns; j++)
                System.out.print(String.format("%4d", this.get(i,j)));
            System.out.println();
        }

    }
    //返回矩阵第i行第j列元素，排序顺序表的顺序查找算法，O(n)
    public int get(int i, int j)
    {
        if (i<0 || i>=rows || j<0 || j>=columns)
            throw new IndexOutOfBoundsException("矩阵元素的行或列序号越界");
        Triple item = new Triple(i,j,0);
        int k=0;
        Triple elem = this.list.get(k);
        while (k<this.list.size()&& item.compareTo(elem)>=0) //在排序顺序表list中顺序查找item对象
        {
            if (item.compareTo(elem)==0) //只比较三元组元素位置，即elem.row==i && elem.column==j
                return elem.value; //查找到(i,j)，返回矩阵元素
            k++; //item“大”时向后走
            elem = this.list.get(k);
        }
        return 0; //没有找到时返回0
    }
    public void set(Triple elem) //以三元组设置矩阵元素
    {this.set(elem.row, elem.column, elem.value); }
    //设置矩阵第row行第column列的元素值为value，按行主序在排序顺序表list中更改或插入一个元素的三元组，O(n)
    public void set(int row, int column, int value)
    {
        if (value==0) return; //不存储值为0元素
        if (row>=this.rows || column>=this.columns)
            throw new IllegalArgumentException("三元组的行或列序号越界");
        Triple elem = new Triple(row,column,value);
        int i=0;
        while (i<this.list.size()) //查找elem对象插入位置
        {
            Triple item = this.list.get(i);
            if (elem.compareTo(item)==0) //elem存在
            {this.list.set(i, elem); return; }
            if (elem.compareTo(item)>=0)
                i++; //elem较“大”时向后走
            else break;
        }
        this.list.insert(i, elem); //插入elem对象
    }
    public SeqSparseMatrix plus(SeqSparseMatrix smat)
    {
        if (this.rows!=smat.rows || this.columns!=smat.columns)
            throw new IllegalArgumentException("两个矩阵阶数不同，不能相加");
        SeqSparseMatrix smatc=new SeqSparseMatrix(this.rows, this.columns); //构造零矩阵
        int i=0, j=0;
        while (i<this.list.size() && j<smat.list.size())//分别遍历两个矩阵的顺序表
        {
            Triple elema = this.list.get(i);
            Triple elemb = smat.list.get(j);
            if (elema.compareTo(elemb)==0) {
                if (elema.value+elemb.value!=0) smatc.list.append(new Triple(elema.row, elema.column, elema.value+elemb.value));
                i++; j++;
            }
            else if (elema.compareTo(elemb)<0) //将较小三元组复制添加到smatc顺序表最后
            {
                smatc.list.append(new Triple(elema)); //复制elema元素执行Triple拷贝构造方法
                i++;
            }
            else
            {
                smatc.list.append(new Triple(elemb));
                j++;
            }
        }
        while (i<this.list.size()) //将当前矩阵顺序表的剩余三元组复制添加到smatc顺序表最后
            smatc.list.append(new Triple(this.list.get(i++)));
        while (j<smat.list.size()) smatc.list.append(new Triple(smat.list.get(j++)));
        return smatc; //返回对象引用
    }

    public void fasttranstri(SeqSparseMatrix M) {
        Triple[]ele=new Triple[M.list.n];
        int k=0;
        for (int i = 0 ;i < M.columns; i++) {//rows
            for (int j = 0; j < M.rows; j++) {
                if (k<M.list.n)
                    ele[k]=new Triple(i,j,i+j+1);
                k++;
            }
        }

        SeqSparseMatrix T=new SeqSparseMatrix(M.columns,M.rows,ele);
        int tu=M.list.n;
        int col,q;
        //System.out.println(T.list.n);
        //for (int i = 0; i < T.list.n; i++) {
        //    System.out.println(T.list.get(i));
        //}
        //System.out.println(M.rows);
        //System.out.println( list.get(0));

        int num[]=new int[M.columns];    //所在列的非0元素的个数
        int pos[]=new int[M.list.n];        //M中第一个非0元素在T的位置

        if (tu>0) {
            for( col=0;col<M.columns;col++)
                num[col]=0;

            //System.out.println(list.get(6).column);
            for(int t=0;t<=M.columns;t++){
                for (int i = 0; i <M.list.n; i++) {
                    if (list.get(i).column == t)     //每个triple的列
                        num[t]++;
                }
            }
            //System.out.println(Arrays.toString(num));//正确

            //pos[1]=1;//各列第一个非0元素在T的位置
            //for(col=2;col<=M.columns;++col)
            //    pos[col]=pos[col-1]+num[col-1];

            for (col=2;col<=M.columns;col++)
                pos[col]=pos[col-1]+num[col-1];

            /*for(p=1;p<=M.list.n;++p) {
                col=M.data[p].j;
                q=pos[col];
                T.data[q].i=M.data[p].j;
                T.data[q].j=M.data[p].i;
                T.data[q].e=M.data[p].e;
                ++pos[col];
            }*/
            //System.out.println("qw"+T.list.get(0).column);
            for (int i = 0; i <M.list.n; i++) {
                col=M.list.get(i).column;
                q=pos[col];
                T.list.get(q).row=M.list.get(i).column;
                T.list.get(q).column=M.list.get(i).row;
                T.list.get(q).value=M.list.get(i).value;
                pos[col]++;
            }
            //System.out.println();
        }
        System.out.println("转置后：");
        T.print(T);
    }//转置时间复杂度为 O(nu+tu+nu+tu)=O(tu+nu)。


}