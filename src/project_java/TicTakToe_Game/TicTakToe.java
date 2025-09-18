
package Project_Java;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTakToe implements ActionListener{

    JFrame frame;
    JPanel panel1,panel2;
    Font f;
    JButton btn[]=new JButton[9];
    JLabel lbl;
    String PlayerX="X";
    String PlayerO="O";
    String CurrentPlayer=PlayerX;
    boolean gameover=false;
    int count=0;
    public TicTakToe() 
    {
        frame=new JFrame("TicTacToe");
        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        
        f=new Font("Serif",Font.BOLD,30) ;
        
        panel1=new JPanel();
        panel1.setBounds(0, 0, 600, 100);
        panel1.setBackground(new Color(150,150,150));
        frame.add(panel1);
        
        lbl=new JLabel("Tic-Tac-Toe");
        lbl.setBounds(0, 0, 100, 80);
        lbl.setFont(f);
        panel1.add(lbl);
        
        
        
        panel2=new JPanel();
        panel2.setBounds(0, 100, 600, 600);
        panel2.setBackground(new Color(200,100,200));
        panel2.setLayout(new GridLayout(3,3));
        frame.add(panel2);
        
        for(int i=0;i<9;i++)
        {
            btn[i]=new JButton();
            btn[i].setFont(f);
            btn[i].setBackground(new Color(0,123,133));
            btn[i].setForeground(new Color(255,100,10));
            btn[i].setFocusable(false);
            panel2.add(btn[i]);
            btn[i].addActionListener(this);
        }
        
        frame.setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        TicTakToe t=new TicTakToe();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(gameover) return;
        
        for(int i=0;i<9;i++)
            
        {
            if(btn[i]==e.getSource())
            {
                if(btn[i].getText().equals(""))
                {
                 btn[i].setText(CurrentPlayer);
                 checkWinner();
                 if(!gameover)
                 {
                     CurrentPlayer = CurrentPlayer == PlayerX ? PlayerO : PlayerX;
                     lbl.setText(CurrentPlayer + "'s turn.");
                 }
                 
                }
                 
            }
        }
    }
   public void checkWinner() {
    String[][] winCombos = {
        {btn[0].getText(), btn[1].getText(), btn[2].getText()},
        {btn[3].getText(), btn[4].getText(), btn[5].getText()},
        {btn[6].getText(), btn[7].getText(), btn[8].getText()},
        {btn[0].getText(), btn[3].getText(), btn[6].getText()},
        {btn[1].getText(), btn[4].getText(), btn[7].getText()},
        {btn[2].getText(), btn[5].getText(), btn[8].getText()},
        {btn[0].getText(), btn[4].getText(), btn[8].getText()},
        {btn[2].getText(), btn[4].getText(), btn[6].getText()}
    };

    for (String[] line : winCombos)
    {
        if (!line[0].equals("") && line[0].equals(line[1]) && line[1].equals(line[2])) 
        {
            lbl.setText(line[0]+" is the Winner" );
            lbl.setForeground(Color.red);
            count++;
            gameover = true;
            return;
        }
       
        
    }
  }
  
}
