package review;

public class First_1 {
    public static void main(String[] args) {
        System.out.println("hello");
        People people=new People();
        people.speak("hi");
    }
}
class People{
    public void speak(String s){

        System.out.println(s);
    }
}