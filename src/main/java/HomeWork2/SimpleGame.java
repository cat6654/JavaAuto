package HomeWork2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by akosatuchenko on 12/10/2014.
 */
public class SimpleGame extends JFrame {

    JButton guessButton;
    JTextField textField;
    JLabel label;
    Listener handler = new Listener();
    Random rand = new Random();
    int secretNumber = rand.nextInt(1000);

    public SimpleGame(String s) {
        super(s);
        setLayout(new FlowLayout());

        guessButton = new JButton("Guess");
        label = new JLabel("");
        textField = new JTextField(15);

        add(textField);
        add(guessButton);
        add(label);

        guessButton.addActionListener(handler);

        textField.setText("Guess a number, dude");
    }


    public class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == guessButton) {
                    if (textField.getText() == "") {
                        JOptionPane.showMessageDialog(null, "Guess a number.");
                        textField.setText("0");
                    }
                }
                int yourNumber = Integer.parseInt(textField.getText());

                if(yourNumber == secretNumber)
                    label.setText("You win, bro!");
                if(yourNumber < secretNumber)
                    label.setText("Nope! You entered a smaller number");
                if(yourNumber > secretNumber)
                    label.setText("Nope! You entered a bigger number");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage() + " Ooops!");
            }
        }
    }
}


