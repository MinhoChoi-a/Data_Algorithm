package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.*;

public class MainWindow extends JFrame {

    private JTextField textField;
    private DefaultListModel<String> textList;
    private JList<String> textArray;
    private ArrayList<String> conversation;
    private String text;

    private String userName;

    private final int WIDTH = 450;
    private final int HEIGHT = 650;

    public MainWindow(String name) throws IOException {

        userName = name;
        //this.s1 = s1;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //text input

        JPanel panelInput = new JPanel();
        add(panelInput, BorderLayout.NORTH);

        panelInput.setLayout(new BorderLayout());

        JLabel lblNewLabel = new JLabel("Message to Send:");
        panelInput.add(lblNewLabel, BorderLayout.NORTH);

        textField = new JTextField();
        panelInput.add(textField, BorderLayout.CENTER);
        textField.setColumns(10);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 12));

        JPanel panelSendButton = new JPanel();
        panelInput.add(panelSendButton, BorderLayout.SOUTH);

        JButton sendButton = new JButton("Send");
        panelSendButton.add(sendButton);

        sendButton.addActionListener(new sendListener());

        //text result

        JPanel panelText = new JPanel();
        add(panelText, BorderLayout.CENTER);

        panelText.setLayout(new BorderLayout());

        JLabel lblNewLabel_1 = new JLabel("Message Board");
        panelText.add(lblNewLabel_1, BorderLayout.NORTH);

        textList = new DefaultListModel<>();
        textArray = new JList<>(textList);

        JScrollPane textPane = new JScrollPane(textArray);
        panelText.add(textPane, BorderLayout.CENTER);

        JPanel panelConnect = new JPanel();
        panelText.add(panelConnect, BorderLayout.SOUTH);

        JButton connectButton = new JButton("Connect");
        panelConnect.add(connectButton);

        JButton disconButton = new JButton("Disconnect");
        panelConnect.add(disconButton);


    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    private class sendListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String text = textField.getText();
            //conversation.add(text);
            setText(text);
        }

    }

    public void addMessage(String text) {
        textList.addElement(text);
    }


    public static void main(String[] args) throws IOException {
        String userName = "asdf";
        userName = JOptionPane.showInputDialog( "Enter user name: " );

        Socket s1 = new Socket("LocalHost", 5555 );

        MainWindow window = new MainWindow(userName);
        window.setVisible(true);
    }
}

