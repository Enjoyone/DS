package review;

public class Instanceof_1 {
    public static void main(String[] args) {
        String str="123";
        Long a=1L;
        int b =a instanceof Long?2:3;
        System.out.println(b);
       /* if(str instanceof String){
                    System.out.println(str);
        }
        if(a instanceof Long){
                    System.out.println(a);
        }*/
    }

}
