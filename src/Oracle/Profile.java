/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Oracle;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.tableHandler;
import query.ProfileQuery;
/**
 *
 * @author Khang
 */
public class Profile extends javax.swing.JPanel {
    ProfileQuery profile = new ProfileQuery();
    /**
     * Creates new form Profile
     */
    public Profile() {
        initComponents();
        initial();
    }
    
    public void initial(){
        loadProfile();
    }
    
    public void loadProfile(){
        try{
            DefaultTableModel model = tableHandler.buildTableModel(profile.getAllProfiles());
            table_Profiles.setModel(model);
        } catch(SQLException | Error err){
            JOptionPane.showMessageDialog(this, "Can't load data");
        }
    }
    
    public void loadProfileDetails(String profileName){
        try{
            ResultSet rs = profile.getProfileDetails(profileName);
            
            
            DefaultTableModel model = tableHandler.buildTableModel(profile.getProfileDetails(profileName));
            table_Details.setModel(model);
        } catch(SQLException | Error err){
            JOptionPane.showMessageDialog(this, "Can't load data");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_Profiles = new javax.swing.JTable();
        txt_Username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_ProName = new javax.swing.JTextField();
        btn_Create = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_ConnectTime = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_IDLETime = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_FLA = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_LifeTime = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_ReuseTime = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_ReuseMax = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_LockTime = new javax.swing.JTextField();
        btn_Grant = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Details = new javax.swing.JTable();
        btn_Remove = new javax.swing.JButton();
        txt_UsernameInsert = new javax.swing.JTextField();
        txt_PasswordInsert = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_CreateUser = new javax.swing.JButton();

        table_Profiles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_Profiles.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                table_ProfilesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        table_Profiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ProfilesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_Profiles);

        jLabel1.setText("Username:");

        jLabel2.setText("Profile_Name:");

        txt_ProName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ProNameKeyPressed(evt);
            }
        });

        btn_Create.setText("Create");
        btn_Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CreateActionPerformed(evt);
            }
        });

        jLabel3.setText("Connect_Time:");

        txt_ConnectTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keyPress(evt);
            }
        });

        jLabel4.setText("IDLE_Time:");

        jLabel5.setText("Failed_Login_Attempts:");

        txt_FLA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keyPress(evt);
            }
        });

        jLabel6.setText("Life_Time:");

        txt_LifeTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keyPress(evt);
            }
        });

        jLabel7.setText("Reuse_Time:");

        txt_ReuseTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keyPress(evt);
            }
        });

        jLabel8.setText("Reuse_Max:");

        txt_ReuseMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keyPress(evt);
            }
        });

        jLabel9.setText("Lock_Time:");

        txt_LockTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keyPress(evt);
            }
        });

        btn_Grant.setText("Grant");
        btn_Grant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GrantActionPerformed(evt);
            }
        });

        table_Details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table_Details);

        btn_Remove.setText("Remove");
        btn_Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoveActionPerformed(evt);
            }
        });

        jLabel10.setText("Username");

        jLabel11.setText("Pass");

        btn_CreateUser.setText("Create");
        btn_CreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CreateUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel2)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_ReuseTime, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_LifeTime, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_ReuseMax, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_LockTime, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_Remove))
                                        .addGap(75, 75, 75))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btn_Grant)
                                        .addGap(120, 120, 120))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_FLA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_IDLETime, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(142, 142, 142)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_ConnectTime, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                        .addComponent(txt_ProName, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                        .addComponent(txt_UsernameInsert)
                                        .addComponent(txt_PasswordInsert)))
                                .addComponent(btn_CreateUser, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btn_Create))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Grant)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_UsernameInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_PasswordInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_CreateUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_ProName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_ConnectTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_IDLETime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_FLA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_LifeTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_ReuseTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_ReuseMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_LockTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Create)
                            .addComponent(btn_Remove))
                        .addGap(53, 53, 53))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table_ProfilesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_table_ProfilesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_table_ProfilesAncestorAdded

    private void table_ProfilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ProfilesMouseClicked
        // TODO add your handling code here:
        int index = table_Profiles.getSelectedRow();
        if(index<0){
            JOptionPane.showMessageDialog(this, "Please select a profile");
        } else {
            String profileName = table_Profiles.getValueAt(index, 0).toString();
            loadProfileDetails(profileName);
        }
    }//GEN-LAST:event_table_ProfilesMouseClicked

    private void keyPress(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyPress
        // TODO add your handling code here:
        Character ch = evt.getKeyChar();
        if(!Character.isDigit(ch)){
            evt.consume();
        }
    }//GEN-LAST:event_keyPress

    private void txt_ProNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ProNameKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_ProNameKeyPressed

    private void btn_CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CreateActionPerformed
        // TODO add your handling code here:
        String name = txt_ProName.getText();
        String conTime = txt_ConnectTime.getText();
        String idle = txt_IDLETime.getText();
        String fla = txt_FLA.getText();
        String life = txt_LifeTime.getText();
        String reuse = txt_ReuseTime.getText();
        String reuseMax = txt_ReuseMax.getText();
        String lock = txt_LockTime.getText();
        
        if(name.length()==0){
            JOptionPane.showMessageDialog(this, "Name field needs to be filled");
            return;
        }
        
        boolean success = profile.createProfile(name, life, fla, lock, idle, conTime, reuse, reuseMax);
        if(success){
            JOptionPane.showMessageDialog(this, "Successfully added");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add");
        }
    }//GEN-LAST:event_btn_CreateActionPerformed

    private void btn_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoveActionPerformed
        // TODO add your handling code here:
        int index = table_Profiles.getSelectedRow();
        if(index<0){
            JOptionPane.showMessageDialog(this, "Please select a profile");
        } else {
            String profileName = table_Profiles.getValueAt(index, 0).toString();
            boolean success = profile.deleteProfile(profileName);
            if(success){
                JOptionPane.showMessageDialog(this, "Successfully remove");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to remove");
            }
            loadProfile();
        }
    }//GEN-LAST:event_btn_RemoveActionPerformed

    private void btn_GrantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GrantActionPerformed
        // TODO add your handling code here:
        int index = table_Profiles.getSelectedRow();
        if(index<0){
            JOptionPane.showMessageDialog(this, "Please select a profile");
        } else {
            String profileName = table_Profiles.getValueAt(index, 0).toString();            
            String user = txt_Username.getText();
            boolean success = profile.switchProfile(profileName, user);
            if(success){
                JOptionPane.showMessageDialog(this, "Successfully switched");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to switch");
            }
            loadProfile();
        }
    }//GEN-LAST:event_btn_GrantActionPerformed

    private void btn_CreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CreateUserActionPerformed
        // TODO add your handling code here:
        String username = txt_UsernameInsert.getText();
        String password = txt_PasswordInsert.getText();
        
        int index = table_Profiles.getSelectedRow();
        if(index<0){
            JOptionPane.showMessageDialog(this, "Please select a profile");
        } else {
            String profileName = table_Profiles.getValueAt(index, 0).toString();
            System.out.print(profileName);
            boolean success = profile.createUserWithProfile(username, password, profileName);
            if(success){
                JOptionPane.showMessageDialog(this, "Create user successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Create user failed!");
            }
        }
        
        
    }//GEN-LAST:event_btn_CreateUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Create;
    private javax.swing.JButton btn_CreateUser;
    private javax.swing.JButton btn_Grant;
    private javax.swing.JButton btn_Remove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_Details;
    private javax.swing.JTable table_Profiles;
    private javax.swing.JTextField txt_ConnectTime;
    private javax.swing.JTextField txt_FLA;
    private javax.swing.JTextField txt_IDLETime;
    private javax.swing.JTextField txt_LifeTime;
    private javax.swing.JTextField txt_LockTime;
    private javax.swing.JTextField txt_PasswordInsert;
    private javax.swing.JTextField txt_ProName;
    private javax.swing.JTextField txt_ReuseMax;
    private javax.swing.JTextField txt_ReuseTime;
    private javax.swing.JTextField txt_Username;
    private javax.swing.JTextField txt_UsernameInsert;
    // End of variables declaration//GEN-END:variables
}
