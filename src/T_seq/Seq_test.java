package T_seq;

public class Seq_test {


    public static void main(String[] args)
    {
        try {

            String[] s = {"A", "D", "B", "C", "G", "F", "E"};
            SeqList<String> list_seq = new SeqList<>(s);//初始化
            System.out.println("初始化：");
            System.out.println(list_seq.toString()+"\n");


            System.out.println("在i=3处，实则为数组第四个位置插入元素“H”后并输出 :");
            list_seq.insert(3,"H");
            System.out.println(list_seq.toString()+"\n");


            System.out.println("删除指定元素i=4:并输出已删除");
            System.out.println("删除元素："+list_seq.remove(4)+"\n");


            System.out.println("查找元素“G”，并返回位置");
            System.out.println("位置为："+list_seq.search("G")+"\n");


            System.out.println("判断是否为空");
            System.out.println(list_seq.isEmpty()+"\n");


            System.out.println("打印所有元素：");
            System.out.println(list_seq.toString()+"\n");


            System.out.println("删除递增有序顺序表中所有值大于mink且小于maxk的元素:");
            String[] s2 = {"A", "B", "C", "D", "E", "F", "G","H"};
            SeqList<String> list_seq02 = new SeqList<>(s2);
            System.out.println("删除前：");
            System.out.println(list_seq02.toString());
            System.out.println("删除B~F之间元素后：");
            list_seq02.removeMINtoMAX("B","F");//删除区间元素
            System.out.println(list_seq02.toString());
            System.out.println("\n");


            System.out.println("将x插入到顺序表的适当位置上，以保持顺序表中元素的有序性");
            System.out.println("插入C，且输出：");
            list_seq02.insertKeepSeq("C");
            System.out.println(list_seq02.toString());
            System.out.println("\n");



            System.out.println("顺序表进行逆置");
            System.out.println("倒置前：");
            System.out.println(list_seq.toString());
            System.out.println("倒置后：");
            list_seq.inversion();//倒置
            System.out.println(list_seq.toString());
            System.out.println("\n");


            System.out.println("将两个有序顺序表合并为一个顺序表，合并后依然有序");
            //合并
            String[] a1 = {"A", "D", "F", "H"};
            String[] a2 = {"B", "C", "D", "E", "G"};
            SeqList<String> list_int1 = new SeqList<>(a1);
            SeqList<String> list_int2 = new SeqList<>(a2);
            SeqList<String> combine1 = new SeqList<>();
            new SeqList<String>().combine(list_int1,list_int2,combine1);
            System.out.println(list_int1.toString());
            System.out.println(list_int2.toString());
            System.out.println(combine1.toString());
            System.out.println("\n");


            System.out.println("若两个元素按值递增有序排列的顺序表A和B，"+"\n"+"且同一表中的元素值各不相同。试构造一个顺序表C，其元素为A和B中元素的交集");
            //集合
            String[] setArray1 = {"A", "B", "C", "D", "E", "F", "G"};
            String[] setArray2 = {"A", "C", "E", "G", "H", "J"};
            SeqList<String> set1 = new SeqList<>(setArray1);
            SeqList<String> set2 = new SeqList<>(setArray2);
            SeqList<String> setCommon = new SeqList<>();
            System.out.println(set1.toString());
            System.out.println(set2.toString());
            new SeqList<String>().intersection(set1,set2,setCommon);
            System.out.println(setCommon.toString());
            System.out.println("\n");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
