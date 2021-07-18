package view;

import control.Manager;
import model.Workshop;
import model.WorkshopList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Single_workshop_panel extends JPanel implements Animatable {

    JLabel name_price = new JLabel();
    JLabel img = new JLabel();
    JProgressBar bar = new JProgressBar();

    JButton work = new JButton("Work");
    JButton build = new JButton("Build");
    JButton upgrade = new JButton("Upgrade");

    WorkshopList label_name;
    Workshop object;
    Animation animate = new Animation(this);

    final int max_frames = 16;
    int frame_cnt =1,level;
    int state=2; //1 busy    2 not built    3 ready

    Single_workshop_panel(WorkshopList lName){
        Border b = new LineBorder(new Color(0x0303E0),1,false);
        setBorder(b);

        setLayout(new FlowLayout());

        this.label_name = lName;
        img.setIcon(Load_assets.workshop_img(label_name,1,1));
        //System.out.println(img.getIcon().getIconHeight());
        name_price.setText(label_name.name()+" "+label_name.cost[0]+"$");
        img.setPreferredSize(new Dimension(150,150));
       img.setBorder(new LineBorder(new Color(0x48DC0E),1,false));
        img.setText("hello");
        add(img);
        add(name_price);
        add(build);
        add(upgrade);
        add(work);

        //todo set size and location

        animate.setDaemon(true);
        animate.start();
        work.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager.get_manager_Instatnce().workshop_manager(label_name);
                Game_window.get_instance().update_everything();
            }
        });

        build.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager.get_manager_Instatnce().workshop_builder(label_name);
                Game_window.get_instance().update_everything();

            }
        });

        upgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager.get_manager_Instatnce().workshop_upgrade(label_name);
                Game_window.get_instance().update_everything();

            }
        });

          refresh();

    }

    void refresh (){
        Workshop temp=null;
        for (Workshop w:Manager.get_manager_Instatnce().farm.workshops) {
            if (w.name==label_name){
                temp = w;
                break;
            }
        }
        if (temp == null){
           state = 2;
            name_price.setText(label_name.name()+" "+label_name.cost[0]+"$");
            upgrade.setEnabled(false);
           work.setEnabled(false);
           build.setEnabled(true);
           animate.setFlag(false);
           img.setIcon(Load_assets.workshop_img(label_name,1,1));
            //remove(img);
            return;
        }
        level = temp.level;
        name_price.setText(label_name.name()+" "+label_name.cost[level-1]+"$");
        if(temp.working){
            state = 1;
            upgrade.setEnabled(false);
            work.setEnabled(false);
            build.setEnabled(false);
            bar.setMinimum(0);
            bar.setMaximum(temp.timeTodo);
            bar.setValue(temp.timer);
            animate.setFlag(true);
            //add(img);
        }else{
            state =3;
            bar.setMinimum(0);
            bar.setMaximum(temp.timeTodo);
            upgrade.setEnabled(true);
            work.setEnabled(true);
            build.setEnabled(false);
            bar.setValue(0);
            animate.setFlag(false);
            img.setIcon(Load_assets.workshop_img(label_name,1,level));
            //add(img);
        }

    }
    @Override
    public void nextFrame(){
        frame_cnt++;
            if (frame_cnt>max_frames)
                frame_cnt=1;
            img.setIcon(Load_assets.workshop_img(label_name,frame_cnt,level));

    }

}
