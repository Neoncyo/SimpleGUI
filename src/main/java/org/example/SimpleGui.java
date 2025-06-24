package org.example;

import javax.swing.*;

public class SimpleGui {
    public static void main(String[] args) {

        //Create new window (Jframe)
        JFrame frame = new JFrame("My First GUI");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);  // absolute positioning

        frame.setVisible(true);

        JTextField textField = new JTextField();
        textField.setBounds(20, 20, 150, 25);
        JButton button = new JButton("Enter your encrypted message");
        button.setBounds(180, 20, 300, 25);
        JLabel label = new JLabel();
        label.setBounds(20, 60, 250, 25);

        //stuff that adds components to the frame
        frame.add(textField);
        frame.add(button);
        frame.add(label);

        //adds functionality
        button.addActionListener(e -> {
            String message = textField.getText();

            // Caesar cipher shift code
            Encrypter encrypter = new Encrypter();
            String encrypted = encrypter.encrypt(message, 3);

            label.setText(encrypted);
        });
    }
}
        //setup for the scanner
class Encrypter {
    public String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        //for-each loop
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                char shifted = (char) ((character - base + shift) % 26 + base);
                result.append(shifted);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }
        }