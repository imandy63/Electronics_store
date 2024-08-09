/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package query;
import constants.tablespaceFunction;
import constants.tablespaceProcedure;
import dbs.oracleConnection;
import java.sql.ResultSet;
import java.sql.*;
/**
 *
 * @author Khang
 */
public class TablespaceQuery {
    oracleConnection conn = new oracleConnection().getInstance();
    public ResultSet getAllTablespaceName(){
        String statement = "SELECT * FROM " + tablespaceFunction.GET_ALL_TABLESPACES;
        return conn.executingQueryWithReturn(statement);
    }
    public ResultSet getAllTablespaceName(String user){
        String statement = "SELECT * FROM TABLE(" + tablespaceFunction.GET_USER_TABLESPACES + "('" + user+"'))";
        return conn.executingQueryWithReturn(statement);
    }
    public ResultSet getAllDatafile(){
        String statement = "SELECT * FROM " + tablespaceFunction.GET_ALL_DATAFILES;
        return conn.executingQueryWithReturn(statement);
    }
    public ResultSet getAllDatafile(String user){
        String statement = "SELECT * FROM TABLE(" + tablespaceFunction.GET_USER_DATAFILES + "('" + user+"'))";
        return conn.executingQueryWithReturn(statement);
    }
    public boolean createTablespace(String name, String size , String path){
        String statement ="{ call " + tablespaceProcedure.CREATE_TABLESPACE + "(?,?,?)}";
        try{
            conn.executingProcedure(statement, new String[]{name,path,size});
            return true;
        }catch(Error err){
            return false;
        }
    }
    public boolean createTablespace(String name, String size , String path, String maxsize){
        String statement ="{ call " + tablespaceProcedure.CREATE_TABLESPACE_WITH_EXTEND + "(?,?,?,?)}";
        try{
            conn.executingProcedure(statement, new String[]{name,path,size,maxsize});
            return true;
        }catch(Error err){
            return false;
        }
    }
    public boolean dropTablespace(String TS_name){
        String statement = "{ call " + tablespaceProcedure.DROP_TABLESPACE + "(?)}";
        try{
            conn.executingProcedure(statement, new String[]{TS_name});
            return true;
        }catch(Error err){
            return false;
        }
    }
    public boolean dropTablespaceDatafile(String TS_name){
        String statement = "{ call " + tablespaceProcedure.DROP_TABLESPACE_WITH_FILE + "(?)}";
        try{
            conn.executingProcedure(statement, new String[]{TS_name});
            return true;
        }catch(Error err){
            return false;
        }
    }
    
    public boolean addTablespace(String tablespace, String path){
        String statement = "{call SYS.create_tablespace_path (?,?)}";
        try{
            conn.executingProcedure(statement, new String[]{tablespace, path});
            return true;
        }catch(Error err){
            return false;
        }
    }
    
    public boolean addDatafile(String name, String size , String path){
        String statement = "{ call " + tablespaceProcedure.ADD_DATAFILE + "(?,?,?)}";
        try{
            conn.executingProcedure(statement, new String[]{name,path,size});
            return true;
        }catch(Error err){
            return false;
        }
    }
    
    public boolean addDatafile(String name, String path){
        String statement = "{ call " + tablespaceProcedure.ADD_DATAFILE_WITH_PATH_ONLY + "(?,?)}";
        try{
            conn.executingProcedure(statement, new String[]{name,path});
            return true;
        }catch(Error err){
            return false;
        }
    }
    
    public boolean addDatafile(String name, String size , String path, String maxsize){
        String statement = "{ call " + tablespaceProcedure.ADD_DATAFILE_WITH_EXTEND + "(?,?,?,?)}";
        try{
            conn.executingProcedure(statement, new String[]{name,path,size,maxsize});
            return true;
        }catch(Error err){
            return false;
        }
    }
    
    public boolean dropDatafile(String DF_name){
        String statement = "Alter database datafile '"+ DF_name +"' offline drop";
        try{
            conn.executingQueryNoReturn(statement);
            return true;
        }catch(Error err){
            return false;
        }
    }
    
}
