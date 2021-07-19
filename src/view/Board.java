package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Board extends JPanel {
    Cell [][] cells;
    int max_row,max_col;

    Board (int r , int c){
        setLayout(null);


        max_col = c;
        max_row = r;
        cells = new Cell[max_col][max_row];
        for (int i = 0; i <max_col ; i++) {
            for (int j = 0; j <max_row ; j++) {
                cells[i][j] = new Cell(i+1,j+1);
                //Border border = new LineBorder(new Color(0x000084),1,true);
                //cells[i][j].setBorder(border);
                cells[i][j].setBounds(i*(900/r),j*(615/c),900/r,615/c);
                add(cells[i][j]);
            }
        }

        refresh();
    }

    void refresh (){
        for (int i = 0; i <max_col ; i++) {
            for (int j = 0; j <max_row ; j++) {
                cells[i][j].refresh();
            }
        }
    }
}
