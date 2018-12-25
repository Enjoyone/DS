package exp_3;

import exp_3.Binary_Tree.BinaryTree;
import exp_3.Binary_Tree.Tree;
import exp_3.Binary_Tree.TreeNode;

public class BinaryTree_test {
    public static void main(String[] args) {
        String[] prelist={"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        BinaryTree<String>tree01=new BinaryTree<String>(prelist);
        System.out.println("先序："+tree01.toString());

        //System.out.print("先序递归：");
        //tree01.preorder();
        //tree01.NOpreorder();

        //System.out.println("二叉树判空:"+tree01.isEmpty());
        //System.out.println("二叉树的结点数:"+tree01.size());
        //System.out.println("二叉树的高度:"+tree01.height());
        //System.out.println("二叉树中叶子结点的数目:"+tree01.leafsize());


        //tree01.NOinorder();
        //tree01.postorder();

        String list1[]={"A","\tB","\t\tE","\t\tF","\tC","\tD","\t\tG","H","\tI","\t\tJ"};
        System.out.println("以凹入方式打印输出一棵二叉树:");
        Tree<String> tree =Tree.create(list1);      //以树的横向凹入表示法构造树（森林）
        tree.preorder();                                   //输出树的先根次序遍历序列
        tree.postorder();                                  //输出树的后根次序遍历序列
        System.out.print(tree.toString());


        //左右 l,r

















    }
}
