package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Home extends JFrame implements ActionListener {

    JButton loginButton, registrationButton, viewUsersButton;

    Home() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to DIU Quiz Application!");
        welcomeLabel.setBounds(325, 30, 400, 45);
        welcomeLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(22, 99, 54));
        add(welcomeLabel);

        loginButton = new JButton("Login");
        loginButton.setBounds(400, 100, 200, 25);
        loginButton.setBackground(new Color(22, 99, 54));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton);

        registrationButton = new JButton("Registration");
        registrationButton.setBounds(400, 130, 200, 25);
        registrationButton.setBackground(new Color(22, 99, 54));
        registrationButton.setForeground(Color.WHITE);
        registrationButton.addActionListener(this);
        add(registrationButton);

        viewUsersButton = new JButton("View Registered Users");
        viewUsersButton.setBounds(400, 160, 200, 25);
        viewUsersButton.setBackground(new Color(22, 99, 54));
        viewUsersButton.setForeground(Color.WHITE);
        viewUsersButton.addActionListener(this);
        add(viewUsersButton);

        setSize(1000, 500);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            setVisible(false);
            new Login();
        } else if (e.getSource() == registrationButton) {
            setVisible(false);
            new Registration();
        } else if (e.getSource() == viewUsersButton) {
            displayRegisteredUsers();
        }
    }

    private void displayRegisteredUsers() {
        // Retrieve the list of registered users from the Registration class
        HashMap<String, String> registeredUsers = Registration.getRegisteredUsers();

        // Create a StringBuilder to build the user list message
        StringBuilder userListMessage = new StringBuilder("Registered Users:\n");

        // Append each username to the message
        for (String username : registeredUsers.keySet()) {
            userListMessage.append(username).append("\n");
        }

        // Display the message in a dialog box
        JOptionPane.showMessageDialog(this, userListMessage.toString(), "Registered Users", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new Home();
    }
}
