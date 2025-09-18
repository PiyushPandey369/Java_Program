package quiz_package;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz_Main extends JFrame implements ActionListener {

    JLabel lb3, lb4, timerLabel;
    JRadioButton op1, op2, op3, op4;
    ButtonGroup group;
    JButton next, submit, lifeline;
    String name;
    Timer quizTimer;
    String[][] questions = new String[10][5];
    String[][] answers = new String[10][2];
    String[][] answer_given = new String[10][1];
    int timer = 15;
    int count = 0;
    int score = 0;

    public Quiz_Main(String n) {
        this.name=n;
        setTitle("Java Quiz");
        setLayout(null);

        // Background Images
        ImageIcon img = new ImageIcon("C:\\Users\\DELL\\Downloads\\quizimg.png");
        ImageIcon img1 = new ImageIcon("C:\\Users\\DELL\\Downloads\\imgquiz.png");

        JLabel lbl = new JLabel(new ImageIcon(img.getImage().getScaledInstance(700, 350, Image.SCALE_SMOOTH)));
        JLabel lb2 = new JLabel(new ImageIcon(img1.getImage().getScaledInstance(700, 350, Image.SCALE_SMOOTH)));
        lbl.setBounds(0, 0, 700, 350);
        lb2.setBounds(700, 0, 700, 350);
        add(lbl);
        add(lb2);

        lb3 = new JLabel("1.");
        lb3.setBounds(80, 370, 35, 20);
        lb3.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(lb3);

        lb4 = new JLabel();
        lb4.setBounds(110, 330, 900, 100);
        lb4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lb4);

        timerLabel = new JLabel("Time Left: 15 sec");
        timerLabel.setBounds(1100, 400, 200, 30);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(timerLabel);

        op1 = new JRadioButton();
        op1.setBounds(130, 400, 600, 30);
        op1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        op1.setBackground(Color.WHITE);
        add(op1);

        op2 = new JRadioButton();
        op2.setBounds(130, 442, 600, 30);
        op2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        op2.setBackground(Color.WHITE);
        add(op2);

        op3 = new JRadioButton();
        op3.setBounds(130, 482, 600, 30);
        op3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        op3.setBackground(Color.WHITE);
        add(op3);

        op4 = new JRadioButton();
        op4.setBounds(130, 520, 600, 30);
        op4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        op4.setBackground(Color.WHITE);
        add(op4);

        group = new ButtonGroup();
        group.add(op1);
        group.add(op2);
        group.add(op3);
        group.add(op4);

        next = new JButton("Next");
        next.setBounds(1200, 450, 110, 30);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("Lifeline");
        lifeline.setBounds(1200, 500, 110, 30);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1200, 550, 110, 30);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        loadQuestions();
        start(count);

        quizTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerLabel.setText("Time Left: " + timer + " sec");
                timer--;
                if (timer < 0) {
                    recordAnswer();
                    timer = 15;
                    if (count == 8) {
                        next.setEnabled(false);
                        submit.setEnabled(true);
                    }
                    if (count == 9) {
                        quizTimer.stop();
                        recordAnswer();
                        showScore();
                    } else {
                        count++;
                        start(count);
                    }
                }
            }
        });
        quizTimer.start();

        setSize(1400, 700);
        setLocation(100, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void loadQuestions() {
        questions[0][0] = "Which exception is thrown when an array is accessed with an illegal index?";
        questions[0][1] = "NullPointerException";
        questions[0][2] = "ArrayIndexOutOfBoundsException";
        questions[0][3] = "IllegalArgumentException";
        questions[0][4] = "IndexMismatchException";

        questions[1][0] = "Which method is used to start a thread in Java?";
        questions[1][1] = "run()";
        questions[1][2] = "start()";
        questions[1][3] = "init()";
        questions[1][4] = "execute()";

        questions[2][0] = "Which keyword is used to inherit a class in Java?";
        questions[2][1] = "this";
        questions[2][2] = "super";
        questions[2][3] = "extends";
        questions[2][4] = "implements";

        questions[3][0] = "What is the size of an int variable in Java?";
        questions[3][1] = "8 bytes";
        questions[3][2] = "2 bytes";
        questions[3][3] = "4 bytes";
        questions[3][4] = "1 byte";

        questions[4][0] = "Which class is used to take input from the user in Java?";
        questions[4][1] = "Scanner";
        questions[4][2] = "BufferReader";
        questions[4][3] = "SystemReader";
        questions[4][4] = "InputDevice";

        questions[5][0] = "Which is not a Java feature?";
        questions[5][1] = "Object-Oriented";
        questions[5][2] = "Portable";
        questions[5][3] = "Use of pointers";
        questions[5][4] = "Platform Independent";

        questions[6][0] = "Which method is automatically called when an object is created?";
        questions[6][1] = "finalize()";
        questions[6][2] = "start()";
        questions[6][3] = "constructor";
        questions[6][4] = "main()";

        questions[7][0] = "Which symbol is used to declare a variable as constant?";
        questions[7][1] = "const";
        questions[7][2] = "static";
        questions[7][3] = "final";
        questions[7][4] = "immutable";

        questions[8][0] = "Which of the following is not a Java primitive type?";
        questions[8][1] = "float";
        questions[8][2] = "boolean";
        questions[8][3] = "char";
        questions[8][4] = "String";

        questions[9][0] = "Which of the following cannot be used for a constructor name?";
        questions[9][1] = "Same as class name";
        questions[9][2] = "Any valid identifier";
        questions[9][3] = "Different from class name";
        questions[9][4] = "It must be the same as class name";

        answers[0][1] = "ArrayIndexOutOfBoundsException";
        answers[1][1] = "start()";
        answers[2][1] = "extends";
        answers[3][1] = "4 bytes";
        answers[4][1] = "Scanner";
        answers[5][1] = "Use of pointers";
        answers[6][1] = "constructor";
        answers[7][1] = "final";
        answers[8][1] = "String";
        answers[9][1] = "Different from class name";
    }

    public void start(int count) {
        lb3.setText((count + 1) + ".");
        lb4.setText(questions[count][0]);

        op1.setText(questions[count][1]);
        op1.setActionCommand(questions[count][1]);

        op2.setText(questions[count][2]);
        op2.setActionCommand(questions[count][2]);

        op3.setText(questions[count][3]);
        op3.setActionCommand(questions[count][3]);

        op4.setText(questions[count][4]);
        op4.setActionCommand(questions[count][4]);

        group.clearSelection();
    }

    public void recordAnswer() {
        if (group.getSelection() == null) {
            answer_given[count][0] = "";
        } else {
            answer_given[count][0] = group.getSelection().getActionCommand();
        }
    }

    public void showScore() {
        for (int i = 0; i < answer_given.length; i++) {
            if (answer_given[i][0] != null && answer_given[i][0].equals(answers[i][1])) {
                score += 10;
            }
        }
        setVisible(false);
        new Quiz_Score(name, score); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            recordAnswer();
            timer = 15;

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);

        } else if (e.getSource() == lifeline) {
            JOptionPane.showMessageDialog(this, "It's a prank! Lifeline not coded.");
            lifeline.setEnabled(false);

        } else if (e.getSource() == submit) {
            recordAnswer();
            quizTimer.stop();
            showScore();
        }
    }

}
