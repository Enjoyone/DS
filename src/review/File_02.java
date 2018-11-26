package review;

import java.io.File;
import java.io.FileInputStream;

public class File_02 {
    public static void main(String[] args) {

        byte[] b=new byte[200];
        int n=0;

        try{
            File file1=new File("C:\\Users\\TIME\\Desktop","abc.txt");
            if(file1.exists()){
                System.out.println("存在");
            }
            FileInputStream in1=new FileInputStream(file1);

            while((n=in1.read(b))!=-1){
               String s=new String(b,0,n);
                System.out.println(s);
            }

            in1.close();
        }
        catch(Exception e){
            System.out.println();
        }
    }
}
