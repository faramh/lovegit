package view;
import control.Manager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu_frame {
    public JFrame Menu_frame = new JFrame("                                                      Menu Frame");
    JFrame Level_frame = new JFrame("Chose your Level :");
    ImageIcon background= new ImageIcon("background.png");
    JButton Setting = new JButton("Settings");
    JButton Level = new JButton("Level");
    JButton logout = new JButton("Logout");
    JButton Start = new JButton("Start");
    JLabel messageLabel = new JLabel();
    ImageIcon image_icon = new ImageIcon("logo.png");


    ImageIcon setting_hover_icon = new ImageIcon("PikPng.com_gears-png_1811985.png");
    ImageIcon Star_icon = new ImageIcon("Level_chose.png");
    ImageIcon chicken_icon = new ImageIcon("chicken.png");
    ImageIcon message_icon = new ImageIcon("message.png");
    JLabel chicken_label = new JLabel();
    JPanel setting_panel = new JPanel();
    JPanel panel = new JPanel();
    JComboBox comboBox ;


    public Menu_frame(){
        Menu_frame.getContentPane().setBackground(Color.orange);
        Menu_frame.setIconImage(image_icon.getImage());
        Menu_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Menu_frame.setSize(550,650);
        Menu_frame.setLayout(null);
        Menu_frame.setVisible(true);
        Menu_frame.setResizable(false);

        setting_panel.setBounds(50,50,300,300);
        setting_panel.setVisible(false);

        chicken_label.setBounds(0,0,500,600);
        chicken_label.setIcon(chicken_icon);

        Setting();
        logout();

        String[] Level_list = {"Level : 1", "Level : 2", "Level : 3", "Level : 4", "Level : 5"};
        System.out.println("*********");
        comboBox = new JComboBox(Level_list);
        comboBox.setBounds(165, 425, 150, 25);
        comboBox.setVisible(true);
        comboBox.setBackground(Color.PINK);

        int Int_Level;
        if (comboBox.getSelectedIndex() == 1) {
            Int_Level = 2;
        } else if (comboBox.getSelectedIndex() == 2) {
            Int_Level = 3;
        } else if (comboBox.getSelectedIndex() == 3) {
            Int_Level = 4;
        } else if (comboBox.getSelectedIndex() == 4) {
            Int_Level = 5;
        } else {
            Int_Level = 1;
        }
        Start(Int_Level);

       // Menu_frame.setContentPane(panel);
        Menu_frame.add(Setting);
        Menu_frame.add(logout);
        Menu_frame.add(Level);
        Menu_frame.add(Start);
        Menu_frame.add(comboBox);
        Menu_frame.add(messageLabel);
        Menu_frame.add(chicken_label);
        Menu_frame.setBackground(Color.orange);
        //Menu_frame.setContentPane(setting_panel);
   }
    public void logout(){
        logout.setBounds(165,375,150,25);
        logout.setFocusable(false);
        logout.setFont(new Font(null,Font.BOLD,16));
        logout.setBorderPainted(false);
        logout.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Menu_frame.dispose();
                //login_Panel.get_login_Panel_Instatnce().music(0);
                new login_Panel();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                logout.setBounds(155,375,175,50);
                logout.setFont(new Font(null,Font.BOLD,20));
                logout.setFocusable(false);
                logout.setBorderPainted(false);
                //logout.setBackground(Color.orange);
               // logout.setIcon(home_icon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logout.setBounds(165,375,150,25);
                logout.setFont(new Font(null,Font.BOLD,16));
            }
        });
    }
    public void Setting(){
        Setting.setBounds(165,325,150,25);
        Setting.setFocusable(false);
        Setting.setFont(new Font(null,Font.BOLD,16));

        //Setting.setBackground(Color.orange);
       // Setting.setIcon(setting_hover_icon);
        Setting.setBorderPainted(false);
        Setting.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               setting_panel.setVisible(true);
               setting_panel.setBackground(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Setting.setBounds(155,325,175,50);
                Setting.setFont(new Font(null,Font.BOLD,20));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                Setting.setBounds(165,325,150,25);
                Setting.setFont(new Font(null,Font.BOLD,16));

            }
        });
         }
    public void Start(int Level){
        Start .setBounds(165,275,150,25);
        Start .setFocusable(false);
        Start .setFont(new Font(null,Font.BOLD,16));

        Start .setBorderPainted(false);
        Start .addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Manager.get_manager_Instatnce().level_Check(Level)){
                    Menu_frame.dispose();
                    new Game_frame();
                }
                else{
                    messageLabel.setBounds(200,200,100,50);
                    messageLabel.setFont(new Font(null,Font.BOLD,16));
                    messageLabel.setText("This Level Is Lock !");
                    messageLabel.setVisible(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Start .setBounds(155,275,175,50);
                Start .setFont(new Font(null,Font.BOLD,20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Start .setBounds(165,275,150,25);
                Start .setFont(new Font(null,Font.BOLD,16));
            }
        });
    }
}
