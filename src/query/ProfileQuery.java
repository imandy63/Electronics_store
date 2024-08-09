/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package query;

import dbs.oracleConnection;
import java.sql.ResultSet;
import constants.profileFunction;
import constants.profileProcedure;

/**
 *
 * @author kongh
 */
public class ProfileQuery {
    oracleConnection conn = new oracleConnection().getInstance();
    public ResultSet getAllProfiles(){
        String statement = "SELECT * FROM " + profileFunction.GET_ALL_PROFILES;
        return conn.executingQueryWithReturn(statement);
    }
    
    public ResultSet getProfileDetails(String profile){
        String statement = "SELECT * FROM TABLE(" + profileFunction.GET_PROFILE_DETAILS + "('" + profile + "'))";
        return conn.executingQueryWithReturn(statement);
    }
    
    public boolean deleteProfile(String profile){
        String statement = "{ call " + profileProcedure.DELETE_PROFILE + "(?) }";
        try{
            conn.executingProcedure(statement, new String[]{profile});
            return true;
        } catch(Error err){
            return false;
        }
    }
    
    public boolean switchProfile(String profile, String username){
        String statement = "{ call " + profileProcedure.SWITCH_PROFILE + "(?,?) }";
        try{
            conn.executingProcedure(statement, new String[]{username,profile});
            return true;
        } catch(Error err){
            return false;
        }
    }
    
    public boolean createProfile(String profileName, String lifeTime, String failedAttempts, String lockTime, String idleTime, String connectTime, String reuse, String reuseMax){
        String statement = "{ call " + profileProcedure.CREATE_PROCEDURE + "(?,?,?,?,?,?,?,?) }";
        try{
            conn.executingProcedure(statement, new String[]{profileName,lifeTime,failedAttempts, lockTime, idleTime, connectTime, reuse, reuseMax});
            return true;
        } catch(Error err){
            return false;
        }
    }
    
    public boolean updateProfile(String profileName, String lifeTime, String failedAttempts, String lockTime, String idleTime, String connectTime, String reuse, String reuseMax){
        String statement = "{ call " + profileProcedure.CHANGE_PARAMETERS + "(?,?,?,?,?,?,?,?) }";
        try{
            conn.executingProcedure(statement, new String[]{profileName,lifeTime,failedAttempts, lockTime, idleTime, connectTime, reuse, reuseMax});
            return true;
        } catch(Error err){
            return false;
        }
    }
    
    public boolean createUserWithProfile(String username, String password, String profile){
        String statement = "{ call " + profileProcedure.CREATE_USER_WITH_PROFILE + "(?,?,?) }";
        try{
            conn.executingProcedure(statement, new String[]{username, password, profile});
            return true;
        } catch(Error err){
            return false;
        }
    }
}
