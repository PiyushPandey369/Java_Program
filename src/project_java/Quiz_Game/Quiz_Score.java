
package quiz_package;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Quiz_Score {
    public static int score;
    String name;

    JFrame frame;
    JLabel lb1,lb2;
    
    public Quiz_Score(String n,int s)
    {
        this.name = n;
        this.score=s;
        
        frame=new JFrame();
        
        lb1=new JLabel();
        lb1.setBounds(100, 100, 600, 300);
        lb1.setText(name+" have scored "+s);
        lb1.setBackground(Color.black);
        lb1.setFont(new Font("Tohoma",Font.BOLD,30));
        lb1.setForeground(Color.red);
        frame.add(lb1);
        
        lb2=new JLabel();
        lb2.setBounds(200, 200, 400, 400);
        lb2.setText("Thank you.");
        lb2.setBackground(Color.black);
        lb2.setFont(new Font("Tohoma",Font.BOLD,30));
        lb2.setForeground(Color.red);
        frame.add(lb2);
        
        frame.setLocation(50, 50);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}