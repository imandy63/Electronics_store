package constants;


import dbs.oracleConnection;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kongh
 */
public class PolicyQuery {
    oracleConnection conn = new oracleConnection().getInstance();
    public ResultSet getAllPolicies(){
        String statment = "SELECT * FROM audit_unified_policies";
        return conn.executingQueryWithReturn(statment);
    }
    
    public ResultSet turnOnPolicy(String policyName){
        return null;
    }
    
    public ResultSet turnOffPolicy(String policyName){
        return null;
    }
}
