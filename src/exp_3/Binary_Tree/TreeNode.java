package exp_3.Binary_Tree;

public class TreeNode<T> {
    public T data;
    public TreeNode<T>parent,child,sibling;//.....兄弟结点链
    public int level;
    public TreeNode(T data, int level, TreeNode<T> parent, TreeNode<T> child, TreeNode<T> sibling)
    {
        this.data = data;
        this.level = level;
        this.parent = parent;
        this.child = child;
        this.sibling = sibling;
    }
    public TreeNode(T data,int level)
    {
        this(data,level,null,null,null);
    }
    public String toString()                     //返回结点数据域的描述字符串
    {
        return this.data.toString();
    }

    public boolean isLeaf()                      //判断是否叶子结点
    {
        return this.child==null;
    }
}
