package view;

import javax.swing.*;

public class Board extends JPanel {
    Cell [][] cells;
    int max_row,max_col;

    Board (int r , int c){
        max_col = c;
        max_row = r;
        cells = new Cell[max_col][max_row];
        for (int i = 0; i <max_col ; i++) {
            for (int j = 0; j <max_row ; j++) {
                cells[i][j] = new Cell(i+1,j+1);
                //todo set bounds for each cell
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
