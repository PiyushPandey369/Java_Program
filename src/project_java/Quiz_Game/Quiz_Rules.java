
package quiz_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Quiz_Rules implements ActionListener{
    JFrame frame;
    String name;
    JLabel lb1,lb2,lb3;
    JButton start,back;
    public Quiz_Rules(String n) 
    {
        this.name=n;
        frame=new JFrame("Rule");
        
        lb1=new JLabel("Welcome to Quiz Game "+name);
        lb1.setBounds(70, 5, 800, 100);
        lb1.setForeground(Color.BLUE);
        lb1.setFont(new Font("Lucida Handwriting",Font.BOLD,30));
        frame.add(lb1);
        
        lb2=new JLabel("Rules and Regulations:");
        lb2.setBounds(50, 90, 500, 70);
        lb2.setFont(new Font("Gabriola",Font.BOLD,30));
        frame.add(lb2);
        
        lb3=new JLabel();
        lb3.setBounds(50, 110, 660, 400);
        lb3.setText(
                    "<html>" + 
                    "1. This is not ChatGPT — vague answers won't get you marks. Be precise, or be prepared to try again next year." + "<br><br>" +
                    "2. Thinking hard is allowed. Thinking out loud is not. Please respect the silence of those battling their own confusion." + "<br><br>" +
                    "3. If your pen stops working, take it as a sign — but ignore it and borrow another." + "<br><br>" +
                    "4. Copying may look easy, but remember: even Ctrl+C and Ctrl+V have limits in life — especially under CCTV." + "<br><br>" +
                    "5. Your neighbor’s answer may look right. So did the Titanic’s route." + "<br><br>" +
                    "6. If you complete the paper early, double-check. If you're still confident, you’re either brilliant or missed a question." + "<br><br>" +
                    "7. Nervousness is normal. But if you start hallucinating answers, seek help *after* the exam." + "<br><br>" +
                    "8. Calculators may not be allowed, but your brain is — try using it for a change." + "<br><br>" +
                    "9. This exam paper was set by humans... but don’t expect human mercy." + "<br><br>" +
                    "10. Lastly, remember: Google won't save you here. But a calm mind might. Good luck, you'll need it." + 
                    "<html>"
                    );
        frame.add(lb3);
        
        back=new JButton("Back");
        back.setBounds(100, 500, 80, 30);
        back.setBackground(Color.red);
        back.setFocusable(false);
        frame.add(back);
        back.addActionListener(this);
        
        start=new JButton("Start");
        start.setBounds(400, 500, 80, 30);
        start.setBackground(Color.green);
        start.setFocusable(false);
        frame.add(start);
        start.addActionListener(this);
        
        frame.setLocation(50, 50);
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==back)
        {
            frame.setVisible(false);
            new Quiz_Login();
        }
        else if(e.getSource()==start)
        {
            frame.setVisible(false);
            new Quiz_Main(name);
        }
    }
    
    
}
