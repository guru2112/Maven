package com.example.loginregister;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Register extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton registerButton;
    
    public Register() {
        // Setting up the registration frame
        setTitle("Register");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 30, 100, 30);
        add(userLabel);
        
        usernameField = new JTextField();
        usernameField.setBounds(150, 30, 150, 30);
        add(usernameField);
        
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 70, 100, 30);
        add(passLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        add(passwordField);
        
        registerButton = new JButton("Register");
        registerButton.setBounds(150, 120, 100, 30);
        registerButton.addActionListener(this);
        add(registerButton);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            register();
        }
    }
    
    public void register() {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        
        try {
            FileWriter writer = new FileWriter("users.txt", true);
            writer.write(username + "," + password + "\n");
            writer.close();
            
            JOptionPane.showMessageDialog(this, "Registration successful!");
            dispose(); // Close the registration window
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
