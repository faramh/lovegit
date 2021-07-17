import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatPropertiesLaf;
import com.jtattoo.plaf.JTattooUtilities;
import view.*;
import  control.*;

import javax.swing.*;
import java.text.FieldPosition;

public class Main {
    public static void main(String[] args) {
        try
        {
            String lookandfeel="com.jtattoo.plaf.mint.MintLookAndFeel";
            UIManager.setLookAndFeel(lookandfeel);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        //new login_Panel();
        //new Menu_frame();
        new Loadbar();
       // new Game_frame();
    }
}
