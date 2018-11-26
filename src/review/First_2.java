package review;
import java.lang.*;
public class First_2 {
    int id;
    public First_2(int id){
        this.id=id;
    }
    public static void main(String[] args) {
        First_2 first_2=new First_2(3);
        int a;
        int b;
        int c;
        a=Integer.parseInt("10");
        c=(int)23.6;
        b=Integer.valueOf("12").intValue();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
