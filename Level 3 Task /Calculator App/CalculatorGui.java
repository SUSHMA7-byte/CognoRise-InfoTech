import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CalculatorGui implements ActionListener{
    
    JFrame frame;
    JTextField textField;
    JButton numberButtons[] = new JButton[10];
    JButton operationButtons[] = new JButton[8];
    JButton addButton,subButton,mulButton,divButton,deciButton,delButton,clrButton,equalButton;
    JPanel panel = new JPanel();
    Font font=new Font("Calibri",Font.BOLD,30);

    char ch;
    double num1=0,num2=0,output=0;

    CalculatorGui(){

        frame = new JFrame("Calculator App");
        frame.setSize(420, 540);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textField = new JTextField();
        textField.setBounds(50,25, 300, 50);
        textField.setFont(font);
        textField.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        deciButton=new JButton(".");
        delButton=new JButton("DELETE");
        equalButton=new JButton("=");
        clrButton=new JButton("CLEAR");

        operationButtons[0] =  addButton;
        operationButtons[1] =  subButton;
        operationButtons[2] =  mulButton;
        operationButtons[3] =  divButton;
        operationButtons[4] =  deciButton;
        operationButtons[5] =  delButton;
        operationButtons[6] =  equalButton;
        operationButtons[7] =  clrButton;


        for(int i=0;i<8;i++){
            operationButtons[i].addActionListener(this);
            operationButtons[i].setFont(font);
            operationButtons[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setBackground(Color.lightGray);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(deciButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++){
            if(e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
            if(e.getSource()==deciButton){
                textField.setText(textField.getText().concat("."));
            }

            if(e.getSource()==addButton){
                num1=Double.parseDouble(textField.getText());
                ch='+';
                textField.setText("");
            }

            if(e.getSource()==subButton){
                num1=Double.parseDouble(textField.getText());
                ch='+';
                textField.setText("");
            }

            if(e.getSource()==mulButton){
                num1=Double.parseDouble(textField.getText());
                ch='+';
                textField.setText("");
            }

            if(e.getSource()==divButton){
                num1=Double.parseDouble(textField.getText());
                ch='/';
                textField.setText("");
            }

            if(e.getSource()==equalButton){
                num2=Double.parseDouble(textField.getText());

                switch(ch) {
        	
                    case '+':
                        output = num1 + num2;
                        break;
                        
                    case '-':
                        output = num1 - num2;
                        break;
                        
                    case '*':
                        output = num1 * num2;
                        break;
                        
                    case '/':
                        if(num2==0) {
                            throw new ArithmeticException("Cannot divide by zero");
                        }
                        output = num1 / num2;
                        break;
                    
                    }

                    textField.setText(String.valueOf(output));
                    num1=output;
                    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }

            if(e.getSource()==clrButton){
                textField.setText("");
            }

            if(e.getSource()==delButton){
                String str = textField.getText();
                textField.setText("");
                for(int i=0;i<str.length()-1;i++){
                    textField.setText(textField.getText()+str.charAt(i));
                }
            }
        
    }

    public static void main(String args[]){
        CalculatorGui calc = new CalculatorGui();
    }
}

