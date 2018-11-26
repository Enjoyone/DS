package _6_21;
import javax.swing.*;
import java.awt.*;

public class SwingPro {
    public static void main(String args[]){
    JFrame jFrame=new JFrame("New");
    //Container container=jFrame.getContentPane();
    jFrame.setBounds(400,300,600,600);

    FlowLayout flowLayout=new FlowLayout();
    jFrame.setLayout(flowLayout);

    JMenuBar menuBar1=new JMenuBar();
    JMenuBar menuBar2=new JMenuBar();
    JMenu menu1=new JMenu("file");
    JMenu menu2=new JMenu("help");
    menuBar1.add(menu1);
    menuBar1.add(menu2);
   // menuBar2.add(menu2);
    JMenuItem item3=new JMenuItem("search");
    JMenuItem item1=new JMenuItem("open");
    JMenuItem item2=new JMenuItem("edit");
    menu1.add(item1);
    menu1.add(item2);
    menu2.add(item3);
   // menu2.add(item3);
    jFrame.setJMenuBar(menuBar1);
    //jFrame.setJMenuBar(menuBar2);//只能有一个menubar，第一个会被第二个覆盖
     // JFrame jFrame=new JFrame("New");
      /*  JMenuBar jMenuBar=new JMenuBar();
        JMenu menu1=new JMenu("File");
        jMenuBar.add(menu1);
        JMenuItem item1=new JMenuItem("open");
        menu1.add(item1);
        jFrame.setJMenuBar(jMenuBar);*/

    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void ok(){

    }
}
