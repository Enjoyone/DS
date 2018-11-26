package exa01_顺序表;

public class SeqList_test {
    public static void main(String args[]) {
        //空表
        SeqList<String> list01 = new SeqList<String>(4);
        System.out.println("list01 is empty: "+list01.toString());
        //扩容
        for (int i = 5; i >= 0; i--) {
            list01.insert(i, new String((char)('A' + i) + ""));
        }
        System.out.println("list01 insert finished: "+list01.toString());
        list01.set(3, new String((char)(list01.get(3).charAt(0) + 32) + ""));
        System.out.println("list01 set 3 : "+list01.toString());
        list01.remove(0);
        System.out.println("list01 remove 0 position: "+list01.toString());
        list01.remove(3);
        System.out.println("list01 remove 3 position: "+list01.toString());
    }
}
