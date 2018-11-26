package review;
import java.awt.*;
import javax.swing.*;
public class New {
    public static void main(String[] args) {
        JFrame jFrame1=new JFrame("First");
        Container container=jFrame1.getContentPane();

        jFrame1.setBounds(200,200,400,400);
        JMenuBar jMenuBar=new JMenuBar();
        JMenu jMenu=new JMenu("file");
        JMenuItem jMenuItem=new JMenuItem("open");
        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);
        jFrame1.setJMenuBar(jMenuBar);

        jFrame1.setVisible(true);
        jFrame1.setDefaultCloseOperation(jFrame1.DISPOSE_ON_CLOSE);
        jFrame1.setDefaultCloseOperation(jFrame1.EXIT_ON_CLOSE);
    }
}
