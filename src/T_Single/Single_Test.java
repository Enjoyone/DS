package T_Single;

public class Single_Test{
    public static void main(String[] args) {

        System.out.println("第一题--------");
        //单链表初始化
        System.out.println("a-------链表初始化：");
        String[]s1={"D","B","H","A","E","F","G","C"};
        SingleList<String>Single_01=new SingleList<String>(s1);
        System.out.println(Single_01.toString()+"\n");


        //在指定位置i处插入新元素x
        System.out.println("b------在i=3处插入“C”并返回插入元素且输出新表：");
        System.out.println(Single_01.insert(3,"C"));
        System.out.println(Single_01.toString()+"\n");

        //删除i位置的元素
        System.out.println("c------删除i=4的元素并返回");
        System.out.println(Single_01.remove(4));
        System.out.println(Single_01.toString()+"\n");

        //查找元素x的位置
        System.out.println("Strack------查找“C”位置：");
        System.out.println(Single_01.search("C")+"\n");


        //单链表判空
        System.out.println("e------判断是否为空：");
        System.out.println(Single_01.isEmpty()+"\n");

        //打印（在屏幕显示）单链表中的所有元素
        System.out.println("f------打印链表元素：");
        System.out.println(Single_01.toString()+"\n");

        //单链表的简单应用:
        System.out.println("第二题-------");
        //在1题单链表的基础上，创建有序单链表类。
        System.out.println("a------创建爱你有序单链表类：将1题排序输出");
        Sorted<String>p1=new Sorted<>(s1);
        p1.SequentialList(p1);
        System.out.println();


        //将x插入到单链表的适当位置上，以保持单链表中元素的有序性。
        System.out.println("b------将f插入到keep有序表中  ");
        String[]d1={"b","c","e","g"};
        Sorted<String>keep=new Sorted<>(d1);
        System.out.println(keep.toString());
        keep.insert("f");
        System.out.println(keep.toString()+"\n");


        //删除指定元素x
        System.out.println("c------从之前链表中删除B：");
        Single_01.DeleteX("B");
        System.out.println(Single_01.toString());
        System.out.println();


        //将单链表进行逆置。
        System.out.println("Strack------将单链表逆置：");
        System.out.println(Single_01.toString());
        new SingleList<String>().inversion(Single_01);
        System.out.println(Single_01.toString());
        System.out.println();

      //将两个有序单链表合并为一个有序单链表。
        System.out.println("e------将有序表str1和str2合并：");
        String[]b1={"A","D","F","H"};
        String[]b2={"B","C","E","G"};
        SingleList<String>str1=new SingleList<String>(b1);
        SingleList<String>str2=new SingleList<String>(b2);
        SingleList<String>str3=new SingleList<String>();
        System.out.println(str1.toString());
        System.out.println(str2.toString());
        str3.combineSingle(str1,str2);
        System.out.println();

        //一元多项式的基本运算
        System.out.println("第三题-------");
        //用有序单链表表示一元多项式，并实现以下基本运算：
        //一元多项式的建立
        System.out.println("a------输出一元多项式x1,x2:");
        TermX A1[]={new TermX(2,1),new TermX(2,3),new TermX(4,5),new TermX(6,7)};
        Polynomial x1=new Polynomial(A1);
        TermX B1[]={new TermX(9,1),new TermX(6,3),new TermX(8,5),new TermX(2,7)};
        Polynomial x2=new Polynomial(B1);
        System.out.println("x1="+x1.toString());
        System.out.println("x2="+x2.toString()+"\n");
        //一元多项式的减法运算
        System.out.println("b------执行减法：x3=x1-x2:");
        Polynomial x3=x1.union(x2);
        System.out.println("x3=x1-x2="+x3.toString());

    }
}