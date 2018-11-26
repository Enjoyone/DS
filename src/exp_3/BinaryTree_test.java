package exp_3;

import exp_3.Binary_Tree.BinaryTree;

public class BinaryTree_test {
    public static void main(String[] args) {
        String[] prelist={"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        BinaryTree<String>tree01=new BinaryTree<String >(prelist);
        System.out.println("先序："+tree01.toString());
        System.out.print("先序递归：");
        tree01.preorder();
        tree01.NOpreorder();
    }
}
