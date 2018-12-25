package exp_3;

import exp_3.Queue.LinkedQueue;
import exp_3.Queue.Queue;
import exp_3.Strack.Expression;
import exp_3.Strack.SeqStack;
import java.util.Scanner;

public class Total_Test {
    public static void main(String[] args) {
        //    (1)	栈-----基于顺序存储结构实现栈的基本操作
        //String[] a1 = {"a", "b", "c", "d", "e"};
        //SeqStack<String> stack01 = new SeqStack<String>(12);
        //for (String a : a1)
        //    stack01.push(a);//依次入栈
        //System.out.println(stack01.size01());//获取栈的元素个数
//      System.out.println(stack01.peek());
        //for (int i = stack01.size01(); i > 0; i--) {
        //    System.out.println(stack01.pop());
        //}//依次出栈
        //while (!stack01.isEmpty()){
        //    System.out.println(stack01.pop());
        //}//出栈方法2
        //System.out.println(stack01.isEmpty());//判断元素是否全部出栈
        //System.out.println(stack01.toString());

//    a)	创建一个空栈
//    b)	清空栈
//    c)	入栈操作
//    d)	出栈操作
//    e)	打印栈中的所有元素（即从栈顶到栈底依次在屏幕输出栈中元素）
//    利用上述操作完成下面的算法：

//    f)	数值转换程序，可以实现十进制向任意进制数的转换。
        /*SeqStack<Integer>int_stack=new SeqStack<Integer>(100);
        Scanner read = new Scanner(System.in);
        System.out.println("请输入需要转换的十进制数值：");
        int num = read.nextInt();
        //int_stack.push(num);
        System.out.println("请输入目的进制：");
        Scanner read1 = new Scanner(System.in);
        int num2 = read1.nextInt();
        new SeqStack<Integer>().trans(num,num2,int_stack);
        System.out.println();
*/

//   *g)	计算算术表达式的值
        //使用已有的顺序站
        /*String infix="123+10*(45-50+20)/((35-25)*2+10)-11";
        Expression post01=new Expression();
        System.out.println("2");
        StringBuffer a=post01.toPostfix(infix);
        System.out.println(a);
        System.out.println("1");
        System.out.println(post01.toValue(a));*/



//2）队列
//    以链表实现队列，请实现队列的以下操作：
//    a)	队列初始化
       /* LinkedQueue<Integer>queue=new LinkedQueue<Integer>();
        System.out.println("判空：");
        System.out.println(queue.isEmpty());
        System.out.println("1入队：");
        queue.add(1);
        System.out.println("判空：");
        System.out.println(queue.isEmpty());
        System.out.println("出队：");
        System.out.println(queue.poll());

        for (int i = 0; i < 5; i++) {
            Integer intobj = new Integer(i);
            queue.add(intobj);
        }
        System.out.println(queue.toString());

        System.out.println("三个元素依次出队：");
        int h=0;
        while (!queue.isEmpty()&&h<3) {
            System.out.print(queue.poll() + " ");
            h++;
        }
        System.out.println("状态及判空：");
        System.out.println(queue.isEmpty());
        System.out.println(queue.toString());
        System.out.println("剩余两个出队：");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println("状态及判空：");
        if (!queue.isEmpty())
            System.out.println(queue.toString());
        else System.out.println(queue.isEmpty());
        System.out.println();
*/
//    b)	判断队列状态
//    c)	入队
//    d)	出队
//    e)	打印队列中的所有元素（即从队头到队尾依次在屏幕输出栈中元素）
//    利用上述算法完成下面的各操作，并在每一操作后输出队列状态。
//    f)	5个元素逐一入队，入队后输出队列状态：5个元素
//    g)	3个元素出队　　　  状态：２个元素
//    h)	再２个元素出队　　状态：队空


        /*编程判断一个字符串是否是回文。回文是指一个字符序列以中间字符为基准两边字符完全相同，
        如字符序列“ACBDEDBCA”。 提示:利用(1)、（2）中已经实现的栈和队列。
         */
        /*LinkedQueue<Character>palindrome=new LinkedQueue<>();
        SeqStack<Character>paliindrome2=new SeqStack<>();
        String a="ACBDEDBCA";
        int n=a.length();
        int j=0;
        for (int i = 0; i < n/2; i++) {
            palindrome.add(a.charAt(i));
        }
        for (int i = n/2+1; i <n ; i++) {
            paliindrome2.push(a.charAt(i));
        }

        while (!palindrome.isEmpty()&&!paliindrome2.isEmpty()){
            if (palindrome.poll()==paliindrome2.pop())
                j++;
        }
        if (j==n/2)
            System.out.println(a+"\t"+"是回文");
        else
            System.out.println(a+"\t"+"不是回文");
*/

        /*while (!palindrome.isEmpty()) {
            System.out.println(palindrome.poll());
        }
        while (!paliindrome2.isEmpty()) {
            System.out.println(paliindrome2.pop());
        }*/


        /*采用基于稀疏矩阵的三元组压缩存储方法，实现m×n矩阵的快速转置，
        该算法的时间复杂度为O(n+t)（t位非零元素个数）
        */





//        (5) 实现二叉链表存储的二叉树的基本操作和简单应用。
//        a）	根据先序遍历创建一棵二叉树
//        b）	以凹入方式打印输出一棵二叉树

//        c）	二叉树判空
//        d）	计算二叉树中叶子结点的数目
//        e）	求二叉树的高度
//        f）	求二叉树的结点数


//        g）	实现二叉树的中序遍历，输出按中序遍历的结点序列。（要求用非递归算法，将右子树根结点入栈）
//*h）	实现二叉树的后序遍历，输出按后序遍历的结点序列。







//        i）	在二叉树中查找元素值为k的结点
//                *j）	删除二叉树中以元素值为k的结点作为根的子树（要求以某种遍历方式一个一个删除结点，并输出删除次序）
//        提示：
//        1）用先序递归过程建立二叉树 (存储结构：二叉链表)
//        输入数据按先序遍历所得序列输入，当某结点左子树或右子树为空时，输入‘*’号，如输入123**4**5**得到的二叉树为：
//        创建 时，输入 1 2 3 * * * 5 4 * * 6 * *
//        2）按凹入表方式输出该二叉树，并用l表示左孩子，r表示右孩子。
//        1
//        l2
//                l3
//        r4
//                r5










//        (6)排序与查找
//        a)	随机产生20个0—100之间的整数，允许有重复
//        b)	分别利用直接插入排序、直接选择排序、快速排序对这20个数进行排序（递增递减均可），并统计在各种排序方法中关键字的比较次数，最后输出各类排序方法的排序结果及关键字的比较次数。

//        c)	用折半查找法在前面的已排好序的数据表上查找，是否有此数，如有，输出其序号。如没有，在屏幕给出提示信息。


    }
}
