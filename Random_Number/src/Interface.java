import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Interface implements ActionListener{
    JFrame frame = new JFrame();

    JPanel panel = new JPanel();

    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();

    JButton button = new JButton();

    JTextField textField = new JTextField();

    Border border1 = BorderFactory.createLineBorder(Color.green, 5);
    Border border2 = BorderFactory.createLineBorder(Color.RED, 3);
    Border border3 = BorderFactory.createLineBorder(Color.ORANGE, 5);

    int randomNumber;
    int tries = 1;

    Random rand2 = new Random();

    Interface(int x){
        randomNumber = x;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(409, 437);
        frame.setTitle("Random Number Guesser");
        frame.setLayout(null);

        panel.setSize(395, 400);
        panel.setBackground(Color.YELLOW);
        panel.setLayout(null);
        panel.setBorder(border1);

        label1.setBackground(Color.BLUE);
        label1.setForeground(Color.WHITE);
        label1.setText("?");
        label1.setFont(new Font("MV Boli", Font.BOLD, 100));
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBounds(85, 10, 220,210);
        label1.setOpaque(true);
        label1.setBorder(border2);

        label2.setBackground(Color.WHITE);
        label2.setText("Enter a guessing number :");
        label2.setFont(new Font("MV Boli", Font.BOLD, 20));
        label2.setBounds(10, 270, 350, 30);

        label3.setBackground(Color.LIGHT_GRAY);
        label3.setText("Enter numbers between 1 and 100");
        label3.setFont(new Font("MV Boli", Font.BOLD, 20));
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setBounds(10, 230, 370, 40);
        label3.setForeground(Color.red);
        label3.setOpaque(true);
        label3.setBorder(border3);

        textField.setBounds(280, 275, 100, 30);
        textField.setFont(new Font("MV Boli", Font.BOLD, 20));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBackground(Color.WHITE);
        // textField.setFocusable(false);

        button.setBounds(150, 320, 100, 30);
        button.setText("OK");
        button.setFont(new Font("MV Boli", Font.BOLD, 20));
        button.setFocusable(false);
        button.addActionListener(this);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(textField);
        panel.add(button);
        frame.add(panel);

        frame.getRootPane().setDefaultButton(button);

        frame.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(button.getText()=="OK"){
            if((e.getSource() == button) && (Integer.parseInt(textField.getText()) == randomNumber)){
                textField.setEditable(false);
                label3.setText("Congragulations you won in "+tries+" tries");
                label1.setText(String.valueOf(randomNumber));
                button.setBounds(120, 320, 150, 30);
                button.setText("New Game");
                }
            else if(((e.getSource() == button) && (Integer.parseInt(textField.getText()) <= randomNumber)) && Math.abs(Integer.parseInt(textField.getText())-randomNumber)>10){
                label3.setText("Try more higher !!!");
                textField.setText("");
                tries++;
            }
            else if((e.getSource() == button) && (Integer.parseInt(textField.getText()) >= randomNumber) && Math.abs(Integer.parseInt(textField.getText())-randomNumber)>10){
                label3.setText("Try more lower !!!");
                textField.setText("");
                tries++;
            }
            else if((e.getSource() == button) && (Integer.parseInt(textField.getText()) <= randomNumber) && Math.abs(Integer.parseInt(textField.getText())-randomNumber)<=10){
                label3.setText("Try bit more higher !!!");
                textField.setText("");
                tries++;
            }
            else if((e.getSource() == button) && (Integer.parseInt(textField.getText()) >= randomNumber) && Math.abs(Integer.parseInt(textField.getText())-randomNumber)<=10){
                label3.setText("Try bit more lower !!!");
                textField.setText("");
                tries++;
            }
        }
        else if(button.getText() == "New Game"){
            if(e.getSource() == button){
                frame.dispose();
                new Interface(rand2.nextInt(100)+1);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        new Interface(rand.nextInt(100)+1);
    }
}
