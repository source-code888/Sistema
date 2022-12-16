package main.library;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel{

    public TableModel() {
        
    }

    public TableModel(int rowCount, int columnCount) {
        super(rowCount, columnCount);
    }

    public TableModel(Vector<?> columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    public TableModel(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    public TableModel(Vector<? extends Vector> data, Vector<?> columnNames) {
        super(data, columnNames);
    }

    public TableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    
            
            
}
