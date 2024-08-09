/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Oracle;
import dbs.oracleConnection;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import query.util;
import java.lang.System;
import javax.swing.JFrame;
import query.util;
import java.sql.*;
import utils.formRegister;

/**
 *
 * @author kongh
 */
public class Main extends javax.swing.JFrame {
    oracleConnection conn = new oracleConnection().getInstance();
    util u = new util();
    /**
     * Creates new form Main
     */
    
    public void addFormToPanel(javax.swing.JPanel panel){
        panel.setPreferredSize(panel_Main.getSize()); // Adjust the size as needed
        panel_Main.removeAll();
        panel_Main.setLayout(new BorderLayout()); // Set the layout manager
        panel_Main.add(panel, BorderLayout.PAGE_START); // Add to the center of BorderLayout
        panel.setVisible(true); // Ensure visibility
        panel_Main.repaint();
        panel_Main.revalidate();
        panel_Main.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                panel.setPreferredSize(panel_Main.getSize());
                panel.revalidate(); // Ensures the layout manager updates the component
            }
        });
    }
    
    public void initial(){
            try{
                new formRegister(this);
                
                CallableStatement stmt1 = u.getCurrentUser();
                String usernameLine = stmt1.getString(1);
                label_Name.setText(usernameLine);
                
                CallableStatement stmt2 = u.getLastLogin();
                String line = stmt2.getString(1);
                if (line != null) {
                    label_LastLogin.setText("Last login: \n" + line);
                } else {
                    label_LastLogin.setText("Last login: null");
                }
            } catch(SQLException err){
                err.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi");
            }
    }
        
    public Main() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initial();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_SystemFormOpen = new javax.swing.JButton();
        btn_SessionFormOpen = new javax.swing.JButton();
        btn_Logout = new javax.swing.JButton();
        btn_TableFormOpen = new javax.swing.JButton();
        btn_TableSpaceFormOpen = new javax.swing.JButton();
        label_LastLogin = new javax.swing.JLabel();
        btn_TableSpaceFormOpen1 = new javax.swing.JButton();
        label_Name = new javax.swing.JLabel();
        btn_PolicyFormOpen = new javax.swing.JButton();
        btn_ProfileFormOpen = new javax.swing.JButton();
        btn_RoleFormOpen = new javax.swing.JButton();
        panel_Main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(204, 255, 255));

        btn_SystemFormOpen.setBackground(new java.awt.Color(182, 193, 246));
        btn_SystemFormOpen.setText("System");
        btn_SystemFormOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SystemFormOpenActionPerformed(evt);
            }
        });

        btn_SessionFormOpen.setBackground(new java.awt.Color(182, 193, 246));
        btn_SessionFormOpen.setText("Session");
        btn_SessionFormOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SessionFormOpenActionPerformed(evt);
            }
        });

        btn_Logout.setBackground(new java.awt.Color(182, 193, 246));
        btn_Logout.setText("Log out");
        btn_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LogoutActionPerformed(evt);
            }
        });

        btn_TableFormOpen.setBackground(new java.awt.Color(182, 193, 246));
        btn_TableFormOpen.setText("Table");
        btn_TableFormOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TableFormOpenActionPerformed(evt);
            }
        });

        btn_TableSpaceFormOpen.setBackground(new java.awt.Color(182, 193, 246));
        btn_TableSpaceFormOpen.setText("Table Space");
        btn_TableSpaceFormOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TableSpaceFormOpenActionPerformed(evt);
            }
        });

        label_LastLogin.setBackground(new java.awt.Color(255, 255, 255));
        label_LastLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_LastLogin.setForeground(new java.awt.Color(255, 255, 255));
        label_LastLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_LastLogin.setText("label_LastLogin");

        btn_TableSpaceFormOpen1.setBackground(new java.awt.Color(182, 193, 246));
        btn_TableSpaceFormOpen1.setText("User");
        btn_TableSpaceFormOpen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TableSpaceFormOpen1ActionPerformed(evt);
            }
        });

        label_Name.setBackground(new java.awt.Color(255, 255, 255));
        label_Name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_Name.setForeground(new java.awt.Color(255, 255, 255));
        label_Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Name.setText("label_Name");

        btn_PolicyFormOpen.setBackground(new java.awt.Color(182, 193, 246));
        btn_PolicyFormOpen.setText("Policy");
        btn_PolicyFormOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PolicyFormOpenActionPerformed(evt);
            }
        });

        btn_ProfileFormOpen.setBackground(new java.awt.Color(182, 193, 246));
        btn_ProfileFormOpen.setText("Profile");
        btn_ProfileFormOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProfileFormOpenActionPerformed(evt);
            }
        });

        btn_RoleFormOpen.setBackground(new java.awt.Color(182, 193, 246));
        btn_RoleFormOpen.setText("Role");
        btn_RoleFormOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RoleFormOpenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_SystemFormOpen, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(btn_SessionFormOpen, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(btn_Logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(btn_TableFormOpen, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(btn_TableSpaceFormOpen, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(btn_TableSpaceFormOpen1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(label_LastLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_Name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_PolicyFormOpen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(btn_ProfileFormOpen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(btn_RoleFormOpen, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_SystemFormOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_SessionFormOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_TableFormOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_TableSpaceFormOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_TableSpaceFormOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_PolicyFormOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btn_ProfileFormOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_RoleFormOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btn_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_LastLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_Main.setBackground(new java.awt.Color(128, 128, 242));

        javax.swing.GroupLayout panel_MainLayout = new javax.swing.GroupLayout(panel_Main);
        panel_Main.setLayout(panel_MainLayout);
        panel_MainLayout.setHorizontalGroup(
            panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 702, Short.MAX_VALUE)
        );
        panel_MainLayout.setVerticalGroup(
            panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SystemFormOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SystemFormOpenActionPerformed
        // TODO add your handling code here:
        Sys sysForm = new Sys();
        addFormToPanel(sysForm);
        //addFormToPanel(provider);
    }//GEN-LAST:event_btn_SystemFormOpenActionPerformed

    private void btn_SessionFormOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SessionFormOpenActionPerformed
        // TODO add your handling code here:
        Session sessionForm = new Session();
        addFormToPanel(sessionForm);
    }//GEN-LAST:event_btn_SessionFormOpenActionPerformed

    private void btn_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LogoutActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(this, "Đăng xuất ?");
        if(a==JOptionPane.YES_OPTION){
            u.logout();
            conn.disconnectOracle();
            this.dispose();
        }
    }//GEN-LAST:event_btn_LogoutActionPerformed

    private void btn_TableFormOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TableFormOpenActionPerformed
        // TODO add your handling code here:
        Table table = new Table();
        addFormToPanel(table);
    }//GEN-LAST:event_btn_TableFormOpenActionPerformed

    private void btn_TableSpaceFormOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TableSpaceFormOpenActionPerformed
        // TODO add your handling code here:
        Tablespace ts = new Tablespace();
        addFormToPanel(ts);
    }//GEN-LAST:event_btn_TableSpaceFormOpenActionPerformed

    private void btn_TableSpaceFormOpen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TableSpaceFormOpen1ActionPerformed
        // TODO add your handling code here:
        User us = new User();
        addFormToPanel(us);
    }//GEN-LAST:event_btn_TableSpaceFormOpen1ActionPerformed

    private void btn_PolicyFormOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PolicyFormOpenActionPerformed
        // TODO add your handling code here:
        Policy policy = new Policy();
        addFormToPanel(policy);
    }//GEN-LAST:event_btn_PolicyFormOpenActionPerformed

    private void btn_ProfileFormOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProfileFormOpenActionPerformed
        // TODO add your handling code here:
        Profile profile = new Profile();
        addFormToPanel(profile);
    }//GEN-LAST:event_btn_ProfileFormOpenActionPerformed

    private void btn_RoleFormOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RoleFormOpenActionPerformed
        // TODO add your handling code here:
        Role role = new Role();
        addFormToPanel(role);
    }//GEN-LAST:event_btn_RoleFormOpenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Logout;
    private javax.swing.JButton btn_PolicyFormOpen;
    private javax.swing.JButton btn_ProfileFormOpen;
    private javax.swing.JButton btn_RoleFormOpen;
    private javax.swing.JButton btn_SessionFormOpen;
    private javax.swing.JButton btn_SystemFormOpen;
    private javax.swing.JButton btn_TableFormOpen;
    private javax.swing.JButton btn_TableSpaceFormOpen;
    private javax.swing.JButton btn_TableSpaceFormOpen1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_LastLogin;
    private javax.swing.JLabel label_Name;
    private javax.swing.JPanel panel_Main;
    // End of variables declaration//GEN-END:variables
}