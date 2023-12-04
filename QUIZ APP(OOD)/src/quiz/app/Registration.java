package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Registration extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton submitButton, backToHomeButton, goToLoginButton, tryAgainButton;

    // Store registered usernames and passwords
    private static HashMap<String, String> registeredUsers = new HashMap<>();

    Registration() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Registration");
        heading.setBounds(450, 50, 200, 25);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 24));
        heading.setForeground(new Color(22, 99, 54));
        add(heading);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(350, 110, 100, 25);
        usernameLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        usernameLabel.setForeground(new Color(22, 99, 54));
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(500, 110, 200, 25);
        usernameField.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(350, 150, 100, 25);
        passwordLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        passwordLabel.setForeground(new Color(22, 99, 54));
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(500, 150, 200, 25);
        passwordField.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(passwordField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(400, 190, 120, 25);
        submitButton.setBackground(new Color(22, 99, 54));
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        add(submitButton);

        backToHomeButton = new JButton("Back to Home");
        backToHomeButton.setBounds(550, 190, 150, 25);
        backToHomeButton.setBackground(new Color(22, 99, 54));
        backToHomeButton.setForeground(Color.WHITE);
        backToHomeButton.addActionListener(this);
        add(backToHomeButton);

        goToLoginButton = new JButton("Go to Login");
        goToLoginButton.setBounds(400, 230, 120, 25);
        goToLoginButton.setBackground(new Color(22, 99, 54));
        goToLoginButton.setForeground(Color.WHITE);
        goToLoginButton.addActionListener(this);
        goToLoginButton.setVisible(false);
        add(goToLoginButton);

        tryAgainButton = new JButton("Try Again");
        tryAgainButton.setBounds(550, 230, 150, 25);
        tryAgainButton.setBackground(new Color(22, 99, 54));
        tryAgainButton.setForeground(Color.WHITE);
        tryAgainButton.addActionListener(this);
        tryAgainButton.setVisible(false);
        add(tryAgainButton);

        setSize(1000, 500);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (registerUser(username, password)) {
                showSuccessMessage();
            } else {
                showFailureMessage();
            }
        } else if (e.getSource() == backToHomeButton) {
            setVisible(false);
            new Home();
        } else if (e.getSource() == goToLoginButton) {
            setVisible(false);
            new Login();
        } else if (e.getSource() == tryAgainButton) {
            tryAgainButton.setVisible(false);
        }
    }

    private boolean registerUser(String username, String password) {
        if (!registeredUsers.containsKey(username)) {
            // Username is unique, so register the user
            registeredUsers.put(username, password);
            return true;
        }
        return false;
    }

    private void showSuccessMessage() {
        JOptionPane.showMessageDialog(this, "Registration Successful!");
        goToLoginButton.setVisible(true);
        tryAgainButton.setVisible(false);
    }

    private void showFailureMessage() {
        JOptionPane.showMessageDialog(this, "Registration Unsuccessful. Username already exists.");
        goToLoginButton.setVisible(false);
        tryAgainButton.setVisible(true);
    }

    // Getter for registered users
    public static HashMap<String, String> getRegisteredUsers() {
        return registeredUsers;
    }

    public static void main(String[] args) {
        new Registration();
    }
}
