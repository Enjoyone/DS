package exp_3.Sparse_Matrix;

import T_Single.Addible;

//稀疏矩阵非零元素三元组类

public class Triple implements Comparable<Triple>, Addible<Triple> {
    int row,column,value;/*行，列，值*/

    public Triple(int row,int column,int value){
        if (row>=0&&column>=0){
            this.row=row;
            this.column=column;
            this.value=value;
        }
        else throw new IllegalArgumentException("行列不能为负");
    }

    public Triple(Triple tri){
        this(tri.row,tri.column,tri.value);
    }

    public String toString(){
        return "("+row+","+column+","+value+")";
    }

    public int compareTo(Triple tri){/*行列比较，与元素值无关*/
        if (this.row==tri.row&&this.column==tri.column)
            return 0;
        return (this.row<tri.row||this.row==tri.row&&this.column<tri.column)?-1:1;
    }


    public boolean equals(Object obj)            /*行，列，值均进行比较-----两个矩阵是否想等*/
    {
        if (this==obj)
            return true;
        if (!(obj instanceof Triple))
            return false;
        Triple tri = (Triple)obj;
        return this.row==tri.row && this.column==tri.column && this.value==tri.value;
    }/*  ???  */

    public void add(Triple x){
        if (this.compareTo(x)==0)
            this.value+=x.value;
        else throw new IllegalArgumentException("指数不同，不能相加");

    }
    public void substraction(Triple x){

    }    //减法(此题不用)
    public boolean removable(){/*不存储0元素*/
        return this.value==0;
    }
    public Triple toSymmetry(){/*对称位置元素*/
        return new Triple(this.column,this.row,this.value);
    }

}
