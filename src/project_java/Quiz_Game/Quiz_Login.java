package quiz_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Quiz_Login implements ActionListener,DocumentListener{
    JFrame frame;
    JPanel p1, p2;
    JLabel lbl, lb1, lb2,lb3;
    JTextField txt;
    JButton rule,exit;
    public Quiz_Login() {
        frame = new JFrame("Quiz_Times");
        frame.setLayout(null);

        // Left panel with image
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 450, 500);

        lbl = new JLabel();
        lbl.setBounds(0, 0, 450, 500);

        ImageIcon img = new ImageIcon("C:\\Users\\DELL\\Downloads\\imagequiz.png");
        Image scaledImage = img.getImage().getScaledInstance(450, 500, Image.SCALE_SMOOTH);
        lbl.setIcon(new ImageIcon(scaledImage));

        p1.add(lbl);
        frame.add(p1);

        // Right panel for login form
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(450, 0, 350, 500);
        p2.setBackground(new Color(230, 230, 230));
        frame.add(p2);

        // Welcome Label
        lb1 = new JLabel("Welcome to Quiz Show.");
        lb1.setBounds(20, 50, 320, 40);  // adjusted inside p2 width
        lb1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        p2.add(lb1);

        lb3=new JLabel("Prashna chha chunautiko, uttar chha jitko!");
        lb3.setBounds(20,95,320,40);
        lb3.setForeground(Color.BLUE);
        lb3.setFont(new Font("SansSerif", Font.ITALIC, 16));
        p2.add(lb3);
        
        // Name Label
        lb2 = new JLabel("Enter your name:");
        lb2.setBounds(20, 150, 200, 30);
        lb2.setFont(new Font("SansSerif", Font.BOLD, 16));
        p2.add(lb2);

        // Text Field for name
        txt = new JTextField();
        txt.setBounds(20, 190, 300, 30);
        txt.setFont(new Font("Arial", Font.PLAIN, 16));
        p2.add(txt);
        txt.getDocument().addDocumentListener(this);

        rule=new JButton("Login");
        rule.setBounds(20, 240, 100, 30);
        rule.setFocusable(false);
        rule.setBackground(Color.GREEN);
        p2.add(rule);
        rule.setEnabled(false);
        rule.addActionListener(this);
        
        exit=new JButton("Exit");
        exit.setBounds(220, 240, 100, 30);
        exit.setFocusable(false);
        exit.setBackground(Color.RED);
        p2.add(exit);
        exit.addActionListener(this);
        
        frame.setLocation(50, 50);
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        new Quiz_Login();   
    }
    private void checkLength() {
        String text = txt.getText().trim();
        if (text.length() >= 5) {
            rule.setEnabled(true);
        } else {
            rule.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==rule)
        {
            String name=txt.getText();
            new Quiz_Rules(name);
        }
        else if(e.getSource()==exit)
        {
            int result = JOptionPane.showConfirmDialog(frame, "Are you sure to exit?", "Confirm Exit", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) 
            {
            frame.setVisible(false);
            frame.dispose(); 
            }
        }
    }
    @Override
    public void insertUpdate(DocumentEvent e) 
    {
       checkLength();
    }    

    @Override
    public void removeUpdate(DocumentEvent e) {
      checkLength();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
