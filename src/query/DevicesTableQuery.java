package query;
import constants.devicePROC;
import dbs.oracleConnection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kongh
 */
public class DevicesTableQuery {
    oracleConnection conn = new oracleConnection().getInstance();
    public boolean InsertDevice(String name, String type, String price, String quantity, String fileName){
        String statement = "{call " + devicePROC.INSERT_DEVICE + "(?,?,?,?,?)}";
        try{
            conn.executingProcedure(statement, new String[]{name,type,price,quantity,fileName});
            return true;
        } catch(Exception err){
            return false;
        }
    }
    
    public boolean ModifyDevice(String ID, String name, String type, String price, String quantity, String image){
        String statement = "{call " + devicePROC.MODIFY_DEVICE + "(?,?,?,?,?,?)}";
        try{
            conn.executingProcedure(statement, new String[]{ID, name, type, price, quantity,image});
            return true;
        } catch(Exception err){
            return false;
        }
    }
    
    public boolean ModifyDeviceNoFile(String ID, String name, String type, String price, String quantity){
        String statement = "{call " + devicePROC.MODIFY_DEVICE_NO_IMAGE + "(?,?,?,?,?)}";
        try{
            conn.executingProcedure(statement, new String[]{ID, name, type, price, quantity});
            return true;
        } catch(Exception err){
            return false;
        }
    }
    
    public boolean DeleteDevice(String ID){
        String statement = "{call " + devicePROC.DELETE_DEVICE + "(?)}";
        try{
            conn.executingProcedure(statement, new String[]{ID});
            return true;
        } catch(Exception err){
            return false;
        }
    }
}
