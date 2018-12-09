package exp_3.Binary_Tree;

public class Tree<T> {
    public TreeNode<T> root;                     //根结点，树的父母孩子兄弟链表结点类型

    public Tree()                                //构造空树
    {
        this.root=null;
    }
    public boolean isEmpty()                     //判断是否空树
    {
        return this.root==null;
    }

    //3. 树的横向凹入表示法
    public String toString2()                     //返回树的横向凹入表示字符串，以先根次序遍历树
    {
        return "树的横向凹入表示： \n "+toString3(root,"");
    }
    //先根次序遍历以p为根的子树，tab指定缩进量，返回子树的横向凹入表示字符串，递归算法
    private String toString3(TreeNode<T> p, String tab)
    {
        if (p==null)
            return "";
        return tab+p.data.toString()+"\n" + toString3(p.child,tab+"\t") + toString3(p.sibling,tab);//递归调用
    }
    //【例6.6】   以树的横向凹入表示构造一棵城市树（森林）。

    //以下第4版教材未给出
    //树的先根和后根次序遍历算法
    public void preorder()                                 //输出树的先根次序遍历序列，算法同二叉树
    {
        System.out.print("树的先根次序遍历序列：  ");
        preorder(root);
        System.out.println();
    }
    private void preorder(TreeNode<T> p)                   //先根次序遍历以p为根的子树，递归算法
    {
        if (p!=null)
        {
            System.out.print(p.data+" ");
            preorder(p.child);                             //递归调用
            preorder(p.sibling);
        }
    }
    public void postorder()                                //输出树的后根次序遍历序列
    {
        System.out.print("树的后根次序遍历序列：  ");
        postorder(root);
        System.out.println();
    }
    private void postorder(TreeNode<T> p)                  //后根次序遍历以p为根的子树，递归算法，算法同二叉树的中根次序遍历
    {
        if (p!=null)
        {
            postorder(p.child);
            System.out.print(p.data+" ");
            postorder(p.sibling);
        }
    }

    public int size()                                      //返回树的结点个数，算法同二叉树
    {
        return size(root);
    }
    public int size(TreeNode<T> p)                         //返回以p结点为根的子树的结点个数
    {
        if (p==null)
            return 0;
        return 1+size(p.child)+size(p.sibling);
    }

    public Tree(Tree<T> tree)                              //拷贝构造方法，算法同三叉链表存储的二叉树
    {   this.root = copy(tree.root, null);
    }
    //深拷贝，复制以p根的子树，parent是复制子树的父母结点，返回新建子树的根结点
    public TreeNode<T> copy(TreeNode<T> p, TreeNode<T> parent)
    {
        if (p==null)
            return null;
        TreeNode<T> q = new TreeNode<T>(p.data, p.level, parent, null, null);
        q.child = copy(p.child, q);                        //复制孩子子树，递归调用
        q.sibling = copy(p.sibling, q);                    //复制兄弟子树，递归调用
        return q;                                          //返回建立子树的根结点
    }

    public TreeNode<T> insertRoot(T x)                     //插入元素x作为根结点，原根结点作为其孩子结点，返回插入结点
    {
        this.root = new TreeNode<T>(x, 1, null, this.root, null);
        if (this.root.child!=null)
        {
            this.root.child.parent = this.root;
            setLevel(this.root.child, this.root.level+1);  //设置以this.root.child为根子树的所有结点层次
        }
        return this.root;
    }

    protected void setLevel(TreeNode<T> p, int level)      //设置以p结点为根子树的所有结点层次
    {
        if (p!=null)
        {
            p.level = level;
            setLevel(p.child, level+1);                    //递归调用
            setLevel(p.sibling, level);                    //递归调用
        }
    }

    public void clear()                                    //删除树的所有结点
    {
        this.root = null;
    }

    public static Tree<String> create(String[] prelist)
    {
        Tree<String> tree = new Tree<String>();            //创建空树
        if (prelist.length==0)
            return tree;                                   //返回空树
        tree.root = new TreeNode<String>(prelist[0],1);    //创建根结点，层次为1
        TreeNode<String> p = tree.root;
        for (int i=1; i<prelist.length; i++)     //将prelist[i]插入作为森林中最后一棵子树的最后一个孩子
        {
            int n=0;
            while (n<prelist[i].length() && prelist[i].charAt(n)=='\t')
                n++;                             //统计prelist[i]串中'\t'前缀个数

            String str = prelist[i].substring(n);//结点元素，去除prelist[i]串中所有'\t'前缀
            if (n==p.level)                      //prelist[i]比p多一个'\t'前缀，插入作为p的第0个孩子
            {
                p.child = new TreeNode<String>(str, p.level+1, p, null, null);
                p = p.child;
            }
            else
            {
                while (n<p.level-1)              //prelist[i]比p的'\t'少，p向上寻找插入位置
                    p = p.parent;
                p.sibling = new TreeNode<String>(str, p.level, p.parent, null, null);//同层，插入作为p结点的下个兄弟
                p = p.sibling;
            }
        }
        return tree;
    }

}
