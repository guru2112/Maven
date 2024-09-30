package com.example.loginregister;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Login extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton, registerButton;
    
    public Login() {
        // Setting up the login frame
        setTitle("Login");
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
        
        loginButton = new JButton("Login");
        loginButton.setBounds(50, 120, 100, 30);
        loginButton.addActionListener(this);
        add(loginButton);
        
        registerButton = new JButton("Register");
        registerButton.setBounds(200, 120, 100, 30);
        registerButton.addActionListener(this);
        add(registerButton);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            login();
        } else if (e.getSource() == registerButton) {
            new Register();
        }
    }
    
    public void login() {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        
        try {
            File file = new File("users.txt");
            Scanner scanner = new Scanner(file);
            
            boolean loginSuccess = false;
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] userDetails = line.split(",");
                
                if (userDetails[0].equals(username) && userDetails[1].equals(password)) {
                    JOptionPane.showMessageDialog(this, "Login successful!");
                    loginSuccess = true;
                    break;
                }
            }
            
            if (!loginSuccess) {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
