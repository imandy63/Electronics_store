/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;


/**
 *
 * @author kongh
 */
public class tableHandler { 
    public static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        // Create column names
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }

        // Create data rows
        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(resultSet.getObject(i));
            }
            data.add(row);
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    public static void addRowToTable(DefaultTableModel table, Vector data){
        table.addRow(data);
    }
    
    public static void addRowToTable(DefaultTableModel table, Object[] data){
        table.addRow(data);
    }
    
    public static void removeRowFromTable(DefaultTableModel table, int index){
        table.removeRow(index);
    }
    
    public static DefaultTableModel modifyRowInTable(DefaultTableModel table, Vector data, int index){
        if (index >= 0 && index < table.getRowCount()) {
            for (int i = 0; i < data.size(); i++) {
                table.setValueAt(data.get(i), index, i);
            }
        } else {
            System.out.println("Invalid index");
        }
        return table;
    }
    
    public static Vector getRowDataByValue(DefaultTableModel table,int column,String value){
        Vector result = new Vector();
        for(int i = 0; i<=table.getRowCount(); i++){
            if(table.getValueAt(i, column) == value){
                for(int j=0;j<table.getColumnCount();j++){
                    result.add(table.getValueAt(i, j));
                }
                return result;
            }
        }
        return null;
    }
}
