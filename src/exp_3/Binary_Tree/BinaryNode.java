package exp_3.Binary_Tree;

//结点类
public class BinaryNode<T>{
    public T data;
    public BinaryNode<T>left,right;//地址域
    public BinaryNode(T data,BinaryNode<T>left,BinaryNode<T>right){
        this.data=data;
        this.left=left;
        this.right=right;
    }
    public BinaryNode(T data){
        this(data,null,null);
    }//构造data的叶子结点
    public String ToString(){
        return this.data.toString();
    }
    public boolean isLeaf(){
        return this.left==null&&this.right==null;
    }//是否为叶子结点


}
