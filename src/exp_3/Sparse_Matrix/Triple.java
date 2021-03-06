package exp_3.Sparse_Matrix;

import T_Single.Addible;

//稀疏矩阵非零元素三元组类

public class Triple implements Comparable<Triple>,Addible<Triple> {

        int row, column, value; //行号，列号，元素值，默认访问权限
public Triple(int row, int column, int value)
        {
            if (row<0 || column<0)
                throw new IllegalArgumentException("稀疏矩阵元素三元组的行/列序号非正数。");
            this.row = row;
            this.column = column;
            this.value = value;
        }
public Triple(Triple elem) //拷贝构造方法，复制一个三元组
        { this(elem.row, elem.column, elem.value); }
        public String toString() //返回三元组描述字符串
        {
            return "("+row+","+column+","+value+")";
        }
    public boolean equals(Object obj) //两个三元组比较是否相等，比较位置和元素值
    {
        if (!(obj instanceof Triple))
            return false;
        Triple elem = (Triple)obj;
        return this.row==elem.row && this.column==elem.column && this.value==elem.value;
    }
    //根据三元组位置比较两个三元组的大小，与元素值无关，约定三元组排序次序
    public int compareTo(Triple elem)
    {
        if (this.row<elem.row || this.row==elem.row && this.column<elem.column)
            return -1; //当前三元组对象小
        if (this.row==elem.row && this.column==elem.column)
            return 0; //相等，与equals()方法含义不同
        return 1; //当前三元组对象大
    }
    public void add(Triple term) //加法，＋=运算符作用
    {
        if (this.compareTo(term)==0)
            this.value += term.value;
        else
            throw new IllegalArgumentException("两项的指数不同，不能相加。");
    }
    public boolean removable() //约定删除元素条件
    {
        return this.value==0; //不存储值为0的元素
    }
    public Triple toSymmetry() //返回对称位置矩阵元素的三元组，转置矩阵用
    {
        return new Triple(this.column, this.row, this.value);
    }
    public void substraction(Triple a){

    }//  此题不用
}