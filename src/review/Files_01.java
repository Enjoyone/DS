package review;
import java.io.*;
public class Files_01 {
    public static void main(String[] args) {
        File file1=new File("C:\\Users\\TIME\\Desktop","qwe.txt");
        File file2=new File("C:\\Users\\TIME\\Desktop","abc.txt");
        byte[]a="ok".getBytes();

try {
    file2.createNewFile();
    FileInputStream in = new FileInputStream(file2);
    FileOutputStream out = new FileOutputStream(file1);//写进a
    out.write(a);
    out.close();
}
catch(Exception e){
    System.out.println();
}

       // FileOutputStream out2=new FileOutputStream(file2);
        //int n=-1;
        //byte[] b=new byte[1024];
        //while((n=in.read(b,0,100))!=-1){
        //    out2.write(b);
       // }


      //  out2.close();

    }
}