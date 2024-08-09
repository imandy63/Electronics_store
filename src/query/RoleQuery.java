/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package query;

import constants.rolePrivsProcedure;
import dbs.oracleConnection;
import java.sql.*;
import constants.rolePrivsFunction;
/**
 *
 * @author kongh
 */
public class RoleQuery {
    oracleConnection conn = new oracleConnection().getInstance();
    public ResultSet GetRole(){
        String statement = "Select * FROM " + rolePrivsFunction.GET_ROLES;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet GetRoleOfUser(String username){
        String statement = "Select * FROM TABLE(" + rolePrivsFunction.GET_ROLE_BY_USER + "('" + username + "'))";
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet GetAvailablePrivs(String Role){
        String statement = "Select * FROM TABLE(" + rolePrivsFunction.GET_AVAILABLE_PRIVS_BY_ROLE + "('" + Role + "'))";
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet GetUnavailablePrivs(String Role){
        String statement = "Select * FROM TABLE(" + rolePrivsFunction.GET_UNAVAILABLE_PRIVS_BY_ROLE + "('" + Role + "'))";
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet GetAvailableSysPrivs(String Role){
        String statement = "Select * FROM TABLE(" + rolePrivsFunction.GET_AVAILABLE_SYS_PRIVS_BY_ROLE + "('" + Role + "'))";
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet GetUnavailableSysPrivs(String Role){
        String statement = "Select * FROM TABLE(" + rolePrivsFunction.GET_UNAVAILABLE_SYS_PRIVS_BY_ROLE + "('" + Role + "'))";
        return conn.executingQueryWithReturn(statement);
    }
    
    public boolean CreateRole(String Role){
        try{
            String statement = "{call " + rolePrivsProcedure.CREATE_ROLE + "(?)}";
            conn.executingProcedure(statement,new String[]{Role});
            return true;
        } catch(Error err){
            return false;
        }
    }
    
    public boolean DeleteRole(String Role){
        try{
            String statement = "{call " + rolePrivsProcedure.DROP_ROLE + "(?)}";
            conn.executingProcedure(statement,new String[]{Role});
            return true;
        } catch(Error err){
            return false;
        }
    }
    
    public boolean GrantPrivToRole(String Role, String Priv){
        try{
            String statement = "{call " + rolePrivsProcedure.GRANT_PRIV + "(?,?)}";
            conn.executingProcedure(statement,new String[]{Role,Priv});
            return true;
        } catch(Error err){
            return false;
        }
    }
    
    public boolean RevokePrivFromRole(String Role, String Priv){
        try{
            String statement = "{call " + rolePrivsProcedure.REVOKE_PRIV + "(?,?)}";
            conn.executingProcedure(statement,new String[]{Role,Priv});
            return true;
        } catch(Error err){
            return false;
        }
    }
    
    public boolean GrantRoleToUser(String Username,String Role){
        try{
            String statement = "{call " + rolePrivsProcedure.GRANT_ROLE + "(?,?)}";
            conn.executingProcedure(statement,new String[]{Username,Role});
            return true;
        } catch(Error err){
            return false;
        }
    }
    
    public boolean RevokeRoleFromUser(String Username,String Role){
        try{
            String statement = "{call " + rolePrivsProcedure.REVOKE_ROLE + "(?,?)}";
            conn.executingProcedure(statement,new String[]{Username,Role});
            return true;
        } catch(Error err){
            return false;
        }
    }
}
