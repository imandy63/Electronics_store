/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package query;

import constants.PolicyProcedure;
import constants.functionSpecific;
import dbs.oracleConnection;
import java.sql.*;
import constants.policyFunction;

/**
 *
 * @author kongh
 */
public class PolicyQuery {
    oracleConnection conn = new oracleConnection().getInstance();
    public ResultSet getAllPolicies(){
        String statement = "SELECT * FROM " + policyFunction.POLICIES;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getAllEnabledPolicies(){
        String statement = "SELECT * FROM " + policyFunction.ENABLED_POLICIES;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getPolicyByName(String policyName){
        String statement = "SELECT * FROM TABLE(" + policyFunction.POLICY_BY_NAME + "('" + policyName + "'))";
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getAuditLog(){
        String statement = "SELECT * FROM TABLE(" + functionSpecific.getAuditLog + ")";
        return conn.executingQueryWithReturn(statement);
    }
    
    public boolean CreatePolicy(String PolicyName,String condition,String table){
        try{
            String statement= "{ call " + PolicyProcedure.ADD_POLICY +"(?,?,?) }";
            conn.executingProcedure(statement, new String[]{PolicyName,table, condition});
            return true;
        } catch(Error e){
            return false;
        }
    }
    
    public boolean Remove(String PolicyName){
        try{
            String statement= "{ call " + PolicyProcedure.REMOVE_POLICY +"(?) }";
            conn.executingProcedure(statement, new String[]{PolicyName});
            return true;
        } catch(Error e){
            return false;
        }
    }
    
    public boolean ApplyPolicyToUser(String PolicyName, String username){
        try{
            String statement = "{ call " + PolicyProcedure.APPLY_POLICY +"(?,?) }";
            conn.executingProcedure(statement, new String[]{PolicyName, username});
            return true;
        } catch(Error e){
            return false;
        }
    }
    
    public boolean UnapplyPolicyToUser(String PolicyName, String username){
        try{
            String statement = "{ call " + PolicyProcedure.UNAPPLY_POLICY +"(?,?) }";
            conn.executingProcedure(statement, new String[]{PolicyName, username});
            return true;
        } catch(Error e){
            return false;
        }
    }
}
