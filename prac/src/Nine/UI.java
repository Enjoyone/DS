package Nine;
import javax.swing.*;
import java.awt.*;
public class UI{
    public static void main(String[] args) {
        JFrame UI1=new JFrame("Start");
        //Container con=UI1.getContentPane();
        UI1.setBounds(400,400,500,800);

        /*JLabel jla=new JLabel("hi");

        jla.setBounds(0,0,60,60);
        UI1.add(jla);

        JCheckBox check=new JCheckBox("ok?");
        check.setBounds(80,80,80,80);
        UI1.add(check);

        JButton button=new JButton("点");
        button.setBounds(150,150,80,80);
        UI1.add(button);

        JRadioButton radioButton=new JRadioButton("display");
        radioButton.setBounds(200,200,80,80);
        UI1.add(radioButton);

        JTextField jTextField=new JTextField("write");
        jTextField.setBounds(300,300,80,80);
        UI1.add(jTextField);

        JTextArea jTextField1=new JTextArea("asaf");
        jTextField1.setBounds(400,400,90,90);
        UI1.add(jTextField1);*/

        FlowLayout flowLayout=new FlowLayout();
        UI1.setLayout(flowLayout);

        //menu
        JMenuBar jMenuBar=new JMenuBar();
        JMenu menu1=new JMenu("File");
        jMenuBar.add(menu1);
        JMenuItem item1=new JMenuItem("open");
        menu1.add(item1);
        UI1.setJMenuBar(jMenuBar);

        UI1.setVisible(true);
        UI1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
