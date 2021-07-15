package view;
import control.Manager;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;

public class login_Panel{
    public JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton SignUpButton = new JButton("SignUp");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JCheckBox checkBox = new JCheckBox();
    JLabel userIDLabel = new JLabel("Username :");
    JLabel userPasswordLabel = new JLabel("Password :");
    JLabel messageLabel = new JLabel();
    JLabel Label = new JLabel();
    JLabel farmer_Label = new JLabel();

    ImageIcon image_icon = new ImageIcon("logo.png");
    ImageIcon background= new ImageIcon("background.png");
    ImageIcon icon_eye = new ImageIcon("eye.png");
    ImageIcon farmer_icon = new ImageIcon("farmer.png");
    JPanel panel = new JPanel();

    public login_Panel(){
        frame.getContentPane().setBackground(Color.orange);

        panel.setBounds(0, 0, 500, 554);
        panel.setVisible(true);
        panel.setBackground(Color.orange);

        userIDField.setBounds(100,295,300,25);
        userPasswordField.setBounds(100,325,300,25);

        checkBox.setBounds(400,320,35,35);
        checkBox.setBackground(Color.orange);
        checkBox.setIcon(icon_eye);
        checkBox.setVisible(true);
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkBox.isSelected()){
                    userPasswordField.setEchoChar((char)0);
                }
                else{
                    userPasswordField.setEchoChar('*');
                }
            }
        });
        user_label();
        Login_SignUp();
        resetButton();

        frame.setTitle("                                                Login Panel State :");
        frame.setIconImage(image_icon.getImage());

        farmer_Label.setBounds(0,50,500,554);
        farmer_Label.setIcon(farmer_icon);
        //music(1);

//        panel.add(loginButton);
//        panel.add(SignUpButton);
//        panel.add(resetButton);
//        panel.add(userIDField);
//        panel.add(userPasswordField);
//        panel.add(userIDLabel);
//        panel.add(userPasswordLabel);
//        panel.add(messageLabel);
//        panel.add(Label);
        //panel.add(farmer_Label);
//        panel.add(userIDField);
//        panel.add(userPasswordField);

        frame.setContentPane(panel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(checkBox);
        frame.add(loginButton);
        frame.add(SignUpButton);
        frame.add(resetButton);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(Label);
        frame.add(farmer_Label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550,650);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    public void resetButton(){
        resetButton.setBounds(100,385,300,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userIDField.setText("");
                userPasswordField.setText("");
            }
        });
    }
    public void Login_SignUp(){
        loginButton.setBounds(100,355,150,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userIDField.getText();
                String password = String.valueOf(userPasswordField.getPassword());
                Manager.get_manager_Instatnce().login_Check(username,password);
                frame.dispose();
            }
        });

        SignUpButton.setBounds(250,355,150,25);
        SignUpButton.setFocusable(false);
        SignUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username= userIDField.getText();
                String password = String.valueOf(userPasswordField.getPassword());
                Manager.get_manager_Instatnce().signup_Password_Check(username,password);
                frame.dispose();
            }
        });
    }
    public void user_label(){
        userIDLabel.setText("Username :");
        userIDLabel.setBackground(Color.BLACK);
        userIDLabel.setFont(new Font(null,Font.ITALIC,14));
        userIDLabel.setBounds(10,290,75,35);
        userPasswordLabel.setBounds(10,320,75,35);
        userPasswordLabel.setFont(new Font(null,Font.ITALIC,14));

    }

//    public void music(int a){
//        Clip clip;
//        try {
//            AudioInputStream input=AudioSystem.getAudioInputStream(new File("Downtempo-music-loop-102-bpm.wav"));
//            clip=AudioSystem.getClip();
//            clip.open(input);
//            clip.start();
//            //clip.loop(5);
//            if(a==0){
//                clip.stop();
//            }
//        } catch (UnsupportedAudioFileException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (LineUnavailableException e) {
//            e.printStackTrace();
//        }
//    }
    public void reset_key(){
        userIDField.setText("");
        userPasswordField.setText("");
    }

    // Singleton Design
    // Only one State Instance should exist
    private static login_Panel login_panel_state;
    public static login_Panel get_login_Panel_Instatnce(){
        if (login_panel_state==null){
            login_panel_state = new login_Panel();
        }
        return login_panel_state;
    }
}

