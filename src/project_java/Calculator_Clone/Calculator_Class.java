package Project_Java;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Calculator_Class implements ActionListener
{
    JFrame frame;
    JButton btn[]=new JButton[10];
    JButton extra[]=new JButton[8];
    JButton delbutton,clearbutton,eqlbutton,decimalbutton;
    JButton addButton,subButton,MulButton,DivButton;
    JTextField txt;
    JPanel panel;
    Font f=new Font("Serif", Font.BOLD, 24);
    double num1,num2,result;
    char operator;
    public Calculator_Class()
    {
       frame=new JFrame("Calculator");
       frame.setSize(700, 700);
       frame.setDefaultCloseOperation(3);
       frame.setLayout(null);
       frame.getContentPane().setBackground(new Color(154,134,123));
      
       
       txt=new JTextField();
       txt.setFont(f);
       txt.setBounds(100, 50, 300, 70);
       txt.setEditable(false);
       frame.add(txt);
       
       panel=new JPanel();
       panel.setBounds(100,125,300,400);
       panel.setBackground(new Color(100,124,123));
       frame.add(panel);
       
       
       
       
       clearbutton=new JButton("Clr");
       delbutton=new JButton("Del");
       addButton=new JButton("+");
       subButton=new JButton("-");
       MulButton=new JButton("*");
       DivButton=new JButton("/");
       eqlbutton=new JButton("=");
       decimalbutton=new JButton(".");
       
       
       extra[0]=addButton;
       extra[1]=subButton;
       extra[2]=MulButton;
       extra[3]=DivButton;
       extra[4]=eqlbutton;
       extra[5]=decimalbutton;
       extra[6]=clearbutton;
       extra[7]=delbutton;
       
       for(int i=0;i<8;i++)
       {
         extra[i].setFocusable(false);
         extra[i].setFont(f);
         extra[i].addActionListener(this);
       }
       
        for(int i=0;i<10;i++)
       {
           
         btn[i]=new JButton(String.valueOf(i));
         btn[i].setFocusable(false);
         btn[i].setFont(f);
         btn[i].addActionListener(this);
        
       }
       panel.setLayout(new GridLayout(4,4,10,10));
       panel.add(btn[1]);
       panel.add(btn[2]);
       panel.add(btn[3]);
       panel.add(extra[0]);
       
       panel.add(btn[4]);
       panel.add(btn[5]);
       panel.add(btn[6]);
       panel.add(extra[1]);
       
       panel.add(btn[7]);
       panel.add(btn[8]);
       panel.add(btn[9]);
       panel.add(extra[2]);
       
       panel.add(extra[3]);
       panel.add(extra[5]);
       panel.add(btn[0]);
       panel.add(extra[4]);
       panel.add(extra[3]);
       
       
       
       delbutton.setBounds(100, 530, 150, 100);
       frame.add(delbutton);
       
       
       clearbutton.setBounds(260, 530, 140, 100);
       frame.add(clearbutton);
       
       
       frame.setVisible(true);
       
    }
    
    
    
    public static void main(String[] args) 
    {
        Calculator_Class c=new  Calculator_Class();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==btn[i])
            {
            txt.setText(txt.getText().concat(String.valueOf(i)));
            }
        }
            if(e.getSource()==decimalbutton)
            {
            txt.setText(txt.getText().concat("."));
            }
            
            if(e.getSource()==addButton)
            {
            num1=Double.parseDouble(txt.getText());
            operator='+';
            txt.setText("");
            }
            
            if(e.getSource()==subButton)
            {
            num1=Double.parseDouble(txt.getText());
            operator='-';
            txt.setText("");
            }
            
            if(e.getSource()==MulButton)
            {
            num1=Double.parseDouble(txt.getText());
            operator='*';
            txt.setText("");
            }
            
            if(e.getSource()==DivButton)
            {
            num1=Double.parseDouble(txt.getText());
            operator='/';
            txt.setText("");
            }
            
            if(e.getSource()==eqlbutton)
            {
            num2=Double.parseDouble(txt.getText());
            txt.setText("");
             
                switch (operator) {
                    case '+' -> result=num1+num2;
                        
                    case '-' -> result=num1-num2;
                        
                        
                    case '*' -> result=num1*num2;
                        
                        
                     case '/' -> result=num1/num2;
                        
                    default -> txt.setText("Error");
                }
                txt.setText(String.valueOf(result));
                num1=result;
            }
            
            if(e.getSource()==delbutton)
            {
            String str=txt.getText();
            txt.setText("");
            for(int i=0;i<str.length()-1;i++)
            {
                txt.setText(txt.getText()+str.charAt(i));
            }
            }
            
            if(e.getSource()==clearbutton)
            {
            txt.setText("");
            }
       
    }
}

