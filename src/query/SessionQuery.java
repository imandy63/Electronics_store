/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package query;

import constants.sessionFunction;
import constants.sessionProcedure;
import dbs.oracleConnection;
import java.sql.ResultSet;
import java.sql.*;

/**
 *
 * @author kongh
 */
public class SessionQuery {
    oracleConnection conn = new oracleConnection().getInstance();
    public ResultSet countSessions(){
        String statement = "SELECT "+ sessionFunction.GET_TOTAL_SESSION +" FROM DUAL";
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getAllSessions(){
        String statement = "SELECT  * FROM " + sessionFunction.GET_ALL_SESSIONS;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getNonBackgroundSessions(){
        String statement = "SELECT * FROM " + sessionFunction.GET_NOT_BACKGROUND;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getAllBlockedSessions(){
        String statement = "SELECT * FROM " + sessionFunction.GET_BLOCKING_SESSION;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getSessionsByUsername(String username){
        String statement = "SELECT * FROM TABLE(" + sessionFunction.GET_SESSIONS_BY_USER + "('" + username + "'))";
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getProcessInf(){
        String statement = "SELECT * FROM " + sessionFunction.GET_PROCESS_OF_SESSION;
        return conn.executingQueryWithReturn(statement);
    }
    
    public boolean killSession(String sid, String serial){
        String statement = "{call " + sessionProcedure.KILL_SESSION +"(?,?)}";
        try{
            conn.executingProcedure(statement, new String[]{sid, serial});
            return true;
        } catch(Exception err){
            return false;
        }
    }
}
