/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package query;
import dbs.oracleConnection;
import java.sql.ResultSet;
import java.sql.*;
/**
 *
 * @author Khang
 */
public class TableQuery {
    oracleConnection conn = new oracleConnection().getInstance();
    public ResultSet getTableValues(String name){
        String statment = "Select * from "+ name;
        return conn.executingQueryWithReturn(statment);
    }
}
