package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class LibrarianLogin implements ActionListener {
    private final String USERNAME = "admin", PASSWORD = "admin";// the admin account credentials

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Name :");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();
    JLabel adminLoginForm = new JLabel("Librarian Login Form");

    LibrarianLogin() {

        frame.setResizable(false);
        adminLoginForm.setBounds(100, 10, 220, 50);
        adminLoginForm.setFont(new Font(null, Font.ITALIC, 20));

        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(adminLoginForm);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        } // done
        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            ArrayList<String> dataStudent;
            UserData studentData = new UserData(".\\src\\com\\company\\DB.txt");
            dataStudent = studentData.getData();
            int size = dataStudent.size();
            System.out.println(size);
            String[][] c1 = new String[size][8];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 7; j++) {
                    String[] s1 = dataStudent.get(i).split(",");
                    c1[i][j] = s1[j];
                }
                if (c1[i][1].equals(userID) && c1[i][2].equals(password)) {
                    frame.dispose();
                    new LibrarianSection();
                    break;
                } else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Login failed");
                    // userIDField.setText("");
                    userPasswordField.setText("");
                }
            }

        }

    }
}