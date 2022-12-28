/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.library;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author heber
 */
public class RowColorRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {

        if (table == null) {
            return this;
        }
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        int actual = Integer.parseInt((table.getValueAt(row, 2).toString()));
        int limiteMinimo = Integer.parseInt(table.getValueAt(row, 3).toString());

        if (!isSelected) {
            if (actual <= limiteMinimo) {
                this.setBackground(Color.red);

            } else {
                this.setBackground(Color.WHITE);
            }
        } 

        // Establece el color de fondo de la fila en función del valor de la celda
        return this;
    }

}
