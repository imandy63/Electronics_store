/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package query;

import dbs.oracleConnection;
import java.sql.ResultSet;
import java.sql.*;
import constants.function;
/**
 *
 * @author kongh
 */
public class UserQuery {
    oracleConnection conn = new oracleConnection().getInstance();
    public ResultSet getAllUsersInfo(){
        String statement = "SELECT * FROM TABLE("+ function.userInfomation +"())";
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getUserInfo(String username){
        String statement = "SELECT * FROM TABLE(" + function.userInfomation + "('" +username +"'))";
        return conn.executingQueryWithReturn(statement);
    }
}
