/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbs;

import java.io.FileInputStream;
import java.sql.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import constants.procParameter;

/**
 *
 * @author kongh
 */
public class oracleConnection {
    Connection conn;
    static oracleConnection instance;
    String user;
    String password;

    public void setUser(String user) {
        this.user = user;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void OracleConnection(String user, String password){
        this.connectToOracle(user, password);
    }
    
    public void executingQueryNoReturn(String query){
        try {
            Statement statement = conn.createStatement();
            statement.executeQuery(query);

            System.out.print("Query Executed!");
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new Error("Failed");
        }
    }
    
    public void executingProcedure(String proccall){
        try {
            CallableStatement callableStatement = conn.prepareCall(proccall);
            callableStatement.execute();
            System.out.print("Procedure Executed!");
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new Error("Failed");
        }
    }
    
    public void executingProcedure(String proccall, String[] parameter){
        try {
            CallableStatement callableStatement = conn.prepareCall(proccall);
            for(int i = 0; i<parameter.length;i++){
                callableStatement.setString(i+1, parameter[i]);
            }
            callableStatement.executeUpdate();
            System.out.print("Procedure Executed!");
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new Error("Failed");
        }
    }
    
    public CallableStatement executingProcedureWithReturn(String proccall, String[] outPar){
        try {
            CallableStatement callableStatement = conn.prepareCall(proccall);
            for (int i = 0; i< outPar.length;i++) {
                switch(outPar[i]){
                    case procParameter.VARCHAR:
                        callableStatement.registerOutParameter(i+1, Types.VARCHAR);
                        break;
                    case procParameter.INTEGER:
                        callableStatement.registerOutParameter(i+1, Types.INTEGER);
                        break;
                }
                
            }
            callableStatement.execute();
            return callableStatement;
        } catch (SQLException e) {
            throw new Error("Failed");
        }
    }
    
    
    public String getConnectionString() throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\kongh\\Documents\\NetBeansProjects\\Oracle\\src\\config\\oracle.properties"));
        String service = properties.getProperty("db.dbservice");
        String host = properties.getProperty("db.host");
        String port = properties.getProperty("db.port");
        String driverType = properties.getProperty("db.drivertype");
        String database = properties.getProperty("db.database");
        String databaseName = properties.getProperty("db.serviceName");
        String connectionString = service + ":";
        connectionString += database + ":";
        connectionString += driverType + ":@";
        connectionString += host + ":";
        connectionString += port + "/";
        connectionString +=  databaseName;
        return connectionString;
    }    
    
    public oracleConnection getInstance(){
        if(instance==null){
            instance = new oracleConnection();
        }
        return instance;
    }
    
    public ResultSet executingQueryWithReturn(String query){
        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error("Error appeared while it was querying");
        }
    }
    
    public void connectToOracle(String user, String password) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.setPassword(password);
            this.setUser(user);
            String connectionString = getConnectionString();
            Connection connection = DriverManager.getConnection(connectionString,this.user,this.password);
            if(connection instanceof Connection){
                conn = connection;
            }
            System.out.print("Success");
        } catch ( ClassNotFoundException | SQLException | IOException error) {
            System.out.println("Error::" + error.toString());
            throw new Error("Cannot connect to server");
        }
    }
    
    public void disconnectOracle(){   
        try{
            conn.close();
            System.out.print("Sql server disconnected");
        } catch(SQLException error){
            System.out.println("Error::" + error.toString());
        }
    }
    
    public boolean isConnected(){
        try {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            //e.printStackTrace();
            return false;
        }
    }
}
