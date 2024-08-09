/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import constants.publicProcedure;
import dbs.oracleConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.sql.*;
import query.util;

/**
 *
 * @author kongh
 */
public class formRegister {
    oracleConnection conn = new oracleConnection().getInstance();
    util u = new util();
    public formRegister(javax.swing.JFrame inputFrame){
        connectionCheckingInterval();
    }
   
    
    void connectionCheckingInterval(){
        Timer timer;
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thực hiện kiểm tra điều kiện
                if (!isConnected()) {
                    // Nếu điều kiện được đáp ứng, đóng form
                    System.exit(0);
                }
            }
        });
        timer.start();
    }
    
    boolean isConnected(){
        String out = "";
        CallableStatement callable = u.getCurrentUser();
        return conn.isConnected();
    }
}
