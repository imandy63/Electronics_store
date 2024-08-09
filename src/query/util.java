/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package query;

import constants.procParameter;
import dbs.oracleConnection;
import java.sql.ResultSet;
import java.sql.*;
import constants.publicProcedure;
/**
 *
 * @author kongh
 */
public class util {
    oracleConnection conn = new oracleConnection().getInstance();
    public boolean logout (){
        try{
            String statement = "{call " + publicProcedure.Logout + "}";
            conn.executingProcedure(statement);
            return true;
        } catch(Error err){
            System.out.print(err);
            return false;
        }
    }
    
    public CallableStatement getLastLogin (){
        try{
            String statement = "{call " + publicProcedure.GetLastLogin + " (?)}";
            return conn.executingProcedureWithReturn(statement, new String[]{procParameter.VARCHAR});
        } catch(Error err){
            System.out.print(err);
            return null;
        }
    }
    
    public CallableStatement getCurrentUser(){
        try{
            String statement = "{call " + publicProcedure.GetCurrentuser + " (?)}";
            return conn.executingProcedureWithReturn(statement, new String[]{procParameter.VARCHAR});
        } catch(Error err){
            return null;
        }
    }
}
