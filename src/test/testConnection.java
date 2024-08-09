/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dbs.oracleConnection;
/**
 *
 * @author kongh
 */
public class testConnection {
    oracleConnection orcl = new oracleConnection().getInstance();
    
    public static void main(String[] args) {
        testConnection test = new testConnection();
        //test.start();
        test.startOrclConxnection();
        test.stopOrclConxnection();
    }
    
    public void startOrclConxnection(){
        try{
            orcl.connectToOracle("boss","boss");
        } catch(Exception err){
            System.out.print("Error");
            System.out.print(err);
        }
    }
    
    public void stopOrclConxnection(){
        try{
            orcl.disconnectOracle();
        } catch(Exception err){
            System.out.print("Error");
            System.out.print(err);
        }
    }
}
