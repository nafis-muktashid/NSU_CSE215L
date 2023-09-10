import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class main {

	public static void main(String[] args) {
		JFrame Frame = new JFrame("Calculator");
        Frame.setLayout(null);
        Frame.setSize(250,400);
        JTextField Input = new JTextField();
        
        Input.setBounds(0,60,150,40);
        Frame.add(Input);
        
        JLabel display = new JLabel();
        display.setBounds(0, 20, 150, 30);
        Frame.add(display);
        
        Btn B0 = new Btn (Input, "0");
        Btn B1 = new Btn (Input, "1");
        Btn B2 = new Btn (Input, "2");
        Btn B3 = new Btn (Input, "3");

        Btn B4 = new Btn (Input, "4");
        Btn B5 = new Btn (Input, "5");
        Btn B6 = new Btn (Input, "6");

        Btn B7 = new Btn (Input, "7");
        Btn B8 = new Btn (Input, "8");
        Btn B9 = new Btn (Input, "9");

        B0.setBounds(50,240,50,30);
        B1.setBounds(0,150,50,30);
        B2.setBounds(50,150,50,30);
        B3.setBounds(100,150,50,30);
        B4.setBounds(0,180,50,30);
        B5.setBounds(50,180,50,30);
        B6.setBounds(100,180,50,30);
        B7.setBounds(0,210,50,30);
        B8.setBounds(50,210,50,30);
        B9.setBounds(100,210,50,30);
        Frame.add(B0);
        Frame.add(B1);
        Frame.add(B2);
        Frame.add(B3);
        Frame.add(B4);
        Frame.add(B5);
        Frame.add(B6);
        Frame.add(B7);
        Frame.add(B8);
        Frame.add(B9);
        JButton JX = new JButton("*");
        JButton JD = new JButton("/");
        JButton JP = new JButton("+");
        JButton JS = new JButton("-");
        JX.setBounds(0,120,50,30);
        JD.setBounds(50,120,50,30);
        JP.setBounds(100,120,50,30);
        JS.setBounds(0,240,50,30);
        Frame.add(JX);
        Frame.add(JD);
        Frame.add(JP);
        Frame.add(JS);
        JButton JE = new JButton("=");
        JE.setBounds(100,240,50,30);
        Frame.add(JE);
        JButton JDot = new JButton(".");
        JDot.setBounds(50,270,50,30);
        Frame.add(JDot);
        JButton JB = new JButton("<-");
        JB.setBounds(0,270,50,30);
        Frame.add(JB);
        JButton JPer = new JButton("%");
        JPer.setBounds(100,270,50,30);
        Frame.add(JPer);

        JX.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e){
            String in = Input.getText();
            in+="*";
            Input.setText(in);
        	}
        });
        JD.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e){
            String in = Input.getText();
            in+="/";
            Input.setText(in);
        	}
        });
        JP.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e){
            String in = Input.getText();
            in+="+";
            Input.setText(in);
        	}
        });
        JS.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e){
            String in = Input.getText();
            in+="-";
            Input.setText(in);
        	}
        });
        JDot.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e){
            String in = Input.getText();
            in+=".";
            Input.setText(in);
        	}
        });
        JPer.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e){
            String in = Input.getText();
            in+="%";
            Input.setText(in);
        	}
        });
        JB.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e){
            String in = Input.getText();
            in = in.substring(0, in.length() - 1);
            Input.setText(in);
        	}
        });

        JE.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e){
            String in = Input.getText();
            String[] parts = in.split("[\\+\\-*/%]");
            char[] operators = in.replaceAll("[^+\\-*/%]", "").toCharArray();

            double result;

            if (parts.length >= 2 && parts.length == operators.length + 1) {
                result = Double.parseDouble(parts[0]);

                for (int i = 1; i < parts.length; i++) {
                    double operand = Double.parseDouble(parts[i]);
                    char operator = operators[i - 1];

                    switch (operator) {
                        case '+' : result += operand;
                        case '-' : result -= operand;
                        case '*' : result *= operand;
                        case '%' : result *= operand / 100.0;
                        case '/' : {
                            if (operand != 0) {
                                result /= operand;
                            } else {
                                result = Double.NaN;
                            }
                        }
                    }
                }

                Input.setText(Double.toString(result));
            }
        	}
        });
        JButton JC = new JButton("Clear");
        JC.setBounds(40,300,80,30);
        Frame.add(JC);
        JC.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e){
            String in = "";
            Input.setText(in);
        	}
        });

        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setVisible(true);

	}

}
