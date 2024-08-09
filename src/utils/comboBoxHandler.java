/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Vector;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author kongh
 */
public class comboBoxHandler {
    public static DefaultComboBoxModel populateData(ResultSet resultSet, String columnName) throws SQLException {
        Vector<String> items = new Vector<>();
        while (resultSet.next()) {
            String name = resultSet.getString(columnName);
            items.add(name);
        }
        return new DefaultComboBoxModel(items);
    }
    
    public static void removeFromComboBox(){
        
    }
}
