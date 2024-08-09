/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package query;

import dbs.oracleConnection;
import java.sql.ResultSet;
import constants.oracleSys;
import constants.userFunction;

/**
 *
 * @author kongh
 */
public class OracleSysQuery {
    oracleConnection conn = new oracleConnection().getInstance();
    public ResultSet getSGAInf(){
        String statement = "SELECT * FROM " + oracleSys.SGA;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getPGAInf(){
        String statement = "SELECT * FROM " + oracleSys.PGA;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getProcessInf(){
        String statement = "SELECT * FROM " + oracleSys.PROCESS;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getInstanceInf(){
        String statement = "SELECT * FROM " + oracleSys.INSTANCE;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getDatabaseInf(){
        String statement = "SELECT * FROM " + oracleSys.DATABASE;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getDatafileInf(){
        String statement = "SELECT * FROM " + oracleSys.DATAFILE;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getControlFileInf(){
        String statement = "SELECT * FROM " + oracleSys.CONTROLFILE;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getParameterInf(){
        String statement = "SELECT * FROM " + oracleSys.PARAMETER;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getSPFileInf(){
        String statement = "SELECT * FROM " + oracleSys.SPPARAMETER;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getTableOfUser(){
        String statement = "SELECT TABLE_NAME FROM ALL_TABLES WHERE OWNER = (SELECT SYS_CONTEXT('USERENV', 'SESSION_USER') AS CURRENT_USER FROM DUAL)";
        return conn.executingQueryWithReturn(statement);        
    }
    
    public ResultSet getAllTables(){
        String statement = "SELECT TABLE_NAME,OWNER FROM ALL_TABLES";
        return conn.executingQueryWithReturn(statement);        
    }
    
    public ResultSet getAllColumns(String table_name){
        String statement = "SELECT column_name FROM all_tab_columns WHERE table_name = UPPER('" + table_name + "')";
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getAllUsers(){
        String statement = "SELECT * FROM " + userFunction.GET_ALL_USERS;
        return conn.executingQueryWithReturn(statement);
    }
}
