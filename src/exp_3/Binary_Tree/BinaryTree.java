package exp_3.Binary_Tree;

import exp_3.Queue.LinkedQueue;
import exp_3.Strack.SeqStack;
/*二叉树类*/
public class BinaryTree<T> {
    public BinaryNode<T>root;

    public BinaryTree(){
        this.root=null;
    }

    public String toString()                               //返回先根次序遍历二叉树所有结点的描述字符串
    {
        return toString(this.root);
    }
    private String toString(BinaryNode<T> p)               //返回先根次序遍历以p为根的子树描述字符串，递归方法
    {
        if (p==null)
            return "∧";                                    //输出空子树标记
        return p.data.toString()+" " + toString(p.left) + toString(p.right);
    }

    public int size()       /*结点数*/                               //返回二叉树的结点数
    {
        return size2(root);
    }
    public int size2(BinaryNode<T> p)                       //返回以p结点为根的子树的结点数
    {
        if (p==null)
            return 0;
        return 1+size2(p.left)+size2(p.right);
    }


    public int height()                                    //返回二叉树的高度
    {
        return height2(root);
    }
    public int height2(BinaryNode<T> p)                     //返回以p结点为根的子树高度，后根次序遍历
    {
        if (p==null)
            return 0;
        int lh = height2(p.left);                           //返回左子树的高度
        int rh = height2(p.right);                          //返回右子树的高度
        return (lh>=rh) ? lh+1 : rh+1;                     //当前子树高度为较高子树的高度加1
    }



    //叶子结点数目
    public int leafsize() {
        LinkedQueue<BinaryNode<T>> queue1 = new LinkedQueue<>();
        SeqStack<BinaryNode<T>> stack1 = new SeqStack<>();
        BinaryNode<T> p = this.root;
        while (p != null || !stack1.isEmpty()) {//p非空或栈非空时
            if (p != null) {
                //System.out.print(p.data + " ");              //访问结点
                stack1.push(p);//p结点入栈
                queue1.add(p);
                p = p.left;                                  //进入左子树
            } else                                           //p为空且栈非空时
            {
                p = stack1.pop();                             //p指向出栈结点
                p = p.right;          //进入右子树
            }
        }
        int n=0;
        while (!queue1.isEmpty()){
           p= queue1.poll();
           if (p.isLeaf())
               n++;
        }

        return n;
    }


    public boolean isEmpty(){
        return this.root==null;
    }

    //BinaryTree声明一下重载
    public BinaryNode<T>insert(T x){
        return this.root=new BinaryNode<T>(x,this.root,null);
    }
    public BinaryNode<T>insert(BinaryNode<T>parent,T x,boolean leftChild){
        if (x==null)
            return null;
        if (leftChild)
            return parent.left=new BinaryNode<T>(x,parent.left,null );
        return parent.left=new BinaryNode<T>(x,null,parent.right);

    }

    public void remove(BinaryNode<T>parent,boolean leftChild){
        if (leftChild)
            parent.left=null;
        else parent.right=null;

    }

    public void clear(){
        this.root=null;
    }

    /*先序遍历---递归*/
    public void preorder(){
        preorder1(this.root);
        System.out.println();
    }
    private void preorder1(BinaryNode<T>p){
        if (p==null)
            System.out.print("∧"+" ");
        if (p!=null){
            System.out.print(p.data.toString()+" ");
            preorder1(p.left);
            preorder1(p.right);
        }
    }


    public void NOpreorder()                         //先根次序遍历二叉树的非递归算法
    {
        System.out.print("先根次序遍历（非递归）：  ");
        SeqStack<BinaryNode<T>> stack = new SeqStack<BinaryNode<T>>(); //创建空栈
        BinaryNode<T> p = this.root;
        while (p != null || !stack.isEmpty()) {//p非空或栈非空时
            if (p != null) {
                System.out.print(p.data + " ");              //访问结点
                stack.push(p);                             //p结点入栈
                p = p.left;                                  //进入左子树
            }
            else                                           //p为空且栈非空时
            {
                System.out.print("∧ ");
                p = stack.pop();                             //p指向出栈结点
                p = p.right;          //进入右子树
                if (p == null && stack.isEmpty())
                    System.out.print("∧ ");
            }
            /*最后出现栈为空，但是没有判断完！*/
            System.out.print("");
        }
        System.out.println();
    }
    /*中序遍历---非递归*/
    public void NOinorder()                         //中根次序遍历二叉树的非递归算法
    {
        System.out.print("中根次序遍历（非递归）：  ");
        SeqStack<BinaryNode<T>> stack = new SeqStack<BinaryNode<T>>();   //创建一个空栈
        BinaryNode<T> p = this.root;
        while (p!=null || !stack.isEmpty())                //p非空或栈非空时
            if (p!=null)
            {
                stack.push(p);                             //p结点入栈
                p=p.left;                                  //进入左子树
            }
            else                                           //p为空且栈非空时
            {
                p=stack.pop();                             //p指向出栈结点
                System.out.print(p.data+" ");              //访问结点
                p=p.right;                                 //进入右子树
            }
        System.out.println();
    }
    /*后序遍历*/
    public void postorder()                                //输出后根次序遍历序列
    {
        System.out.print("后根次序遍历二叉树：(递归)  ");
        postorder(this.root);
        System.out.println();
    }
    private void postorder(BinaryNode<T> p)                //后根次序遍历以p结点为根的子树，递归方法
    {
        if (p!=null)
        {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data.toString()+" ");       //后访问当前结点元素
        }
    }



    public BinaryTree(T[] prelist)                         //以标明空子树的先根遍历序列构造二叉树
    {
        this.root = create(prelist);
    }



    //以从i开始的标明空子树的先根序列，创建一棵以prelist[i]为根的子树，返回根结点，递归方法
    private int i=0;
    private BinaryNode<T> create(T[] prelist)
    {
        BinaryNode<T> p = null;
        if (i<prelist.length)
        {
            T elem=prelist[i];
            i++;
            if (elem!=null)                                //不能elem!="∧"，因为T不一定是String
            {
                p = new BinaryNode<T>(elem);               //创建叶子结点
                p.left = create(prelist);                  //创建p的左子树，递归调用，实际参数与形式参数相同
                p.right = create(prelist);                 //创建p的右子树，递归调用，实际参数与形式参数相同
            }
        }
        return p;
    }

    public String toString02(){
        return "树的横向凹入表示：\n"+toString01("",root,"");
    }
    private String toString01(String x,BinaryNode<T>p,String tab){
        if (p==null)
            return "";
        return tab+x.toString()+p.data.toString()+"\n"+toString01("l",p.left,tab+"\t")+toString01("r",p.right,tab);

    }





}
