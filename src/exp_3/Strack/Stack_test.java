package exp_3.Strack;

import exp_3.Strack.Expression;
import exp_3.Strack.SeqStack;
import java.util.Scanner;
public class Stack_test {
    public static void main(String[] args) {
        //    (1)	栈-----基于顺序存储结构实现栈的基本操作
       String[] a1 = {"a", "b", "c", "d", "e"};
        SeqStack<String> stack01 = new SeqStack<String>(12);
        for (String a : a1)
            stack01.push(a);//依次入栈
        System.out.println("获取栈的个数："+stack01.size01());//获取栈的元素个数
       //System.out.println(stack01.peek());
        //for (int i = stack01.size01(); i > 0; i--) {
         //   System.out.println(stack01.pop());
        //}//依次出栈
        while (!stack01.isEmpty()){
            System.out.println(stack01.pop());
        }//出栈方法2
        System.out.println("判空："+stack01.isEmpty());//判断元素是否全部出栈
        System.out.println("输出："+stack01.toString());

//    a)	创建一个空栈
//    b)	清空栈
//    c)	入栈操作
//    d)	出栈操作
//    e)	打印栈中的所有元素（即从栈顶到栈底依次在屏幕输出栈中元素）
//    利用上述操作完成下面的算法：

//    f)	数值转换程序，可以实现十进制向任意进制数的转换。
        //SeqStack<Integer>int_stack=new SeqStack<Integer>(100);
        SeqStack<String>int_stack02=new SeqStack<String>(100);
        Scanner read = new Scanner(System.in);
        System.out.println("请输入需要转换的十进制数值(最高16进制)：");
        int num = read.nextInt();
       // int_stack.push(num);
        System.out.println("请输入目的进制：");
        Scanner read1 = new Scanner(System.in);
        int num2 = read1.nextInt();
        new SeqStack<Integer>().trans(num,num2,int_stack02);
        System.out.println();




//   *g)	计算算术表达式的值
        //使用已有的顺序站
        String infix="123+10*(45-50+20)/((35-25)*2+10)-11";
        Expression post01=new Expression();
        StringBuffer a=post01.toPostfix(infix);
        System.out.println(a);
        System.out.println(post01.toValue(a));
    }
}
