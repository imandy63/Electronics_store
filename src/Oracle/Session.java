/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Oracle;
import dbs.oracleConnection;
import utils.textFieldHandler;
import utils.tableHandler;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import query.SessionQuery;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableRow;
/**
 *
 * @author kongh
 */
public class Session extends javax.swing.JPanel {
    oracleConnection conn = new oracleConnection().getInstance();
    SessionQuery session = new SessionQuery();
    ResultSet rs = session.getAllSessions();
    /**
     * Creates new form Session
     */
    public Session() {
        initComponents();
        initial();
    }
    
    void initial(){
        textFieldHandler.addPlaceHolder(txt_Username, "Enter username");
        cb_Type.addItem("All");
        cb_Type.addItem("Blocking");
        cb_Type.addItem("Not Background");
        cb_Type.addItem("Process");
        cb_Type.setSelectedIndex(0);
        table_Sessions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ResultSet totalSession = session.countSessions();
        try{
            if(totalSession.next()){
                label_TotalSession.setText(totalSession.getString("GetTotalSession"));
            }
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(this, "Lỗi không load số lượng session");
        }
    }
    
    void loadData(ResultSet result){
        try{
            DefaultTableModel model = tableHandler.buildTableModel(result);
            table_Sessions.setModel(model);
        } catch(SQLException | Error err){
            JOptionPane.showMessageDialog(this, "Cannot load data");
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

        jTextField2 = new javax.swing.JTextField();
        btn_Refresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Sessions = new javax.swing.JTable();
        btn_KillSession = new javax.swing.JButton();
        cb_Type = new javax.swing.JComboBox<>();
        txt_Username = new javax.swing.JTextField();
        btn_Find = new javax.swing.JButton();
        label_TotalSession = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        btn_Refresh.setText("Refresh");
        btn_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefreshActionPerformed(evt);
            }
        });

        table_Sessions.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_Sessions);

        btn_KillSession.setText("Kill");
        btn_KillSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KillSessionActionPerformed(evt);
            }
        });

        cb_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_TypeActionPerformed(evt);
            }
        });
        cb_Type.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cb_TypePropertyChange(evt);
            }
        });

        txt_Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UsernameActionPerformed(evt);
            }
        });

        btn_Find.setText("Find");
        btn_Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FindActionPerformed(evt);
            }
        });

        label_TotalSession.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Refresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Username, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Find)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_KillSession))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_TotalSession)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Refresh)
                    .addComponent(btn_KillSession)
                    .addComponent(cb_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Find))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_TotalSession)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TypeActionPerformed
        // TODO add your handling code here:
        int index = cb_Type.getSelectedIndex();
        switch(index){
            case 0 -> rs = session.getAllSessions();
            case 1 -> rs = session.getAllBlockedSessions();
            case 2 -> rs = session.getNonBackgroundSessions();
            case 3 -> rs = session.getProcessInf();
        }
        loadData(rs);
    }//GEN-LAST:event_cb_TypeActionPerformed

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
        loadData(rs);
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void txt_UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UsernameActionPerformed

    private void btn_FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FindActionPerformed
        // TODO add your handling code here:
        String username = txt_Username.getText();
        rs = session.getSessionsByUsername(username);
        loadData(rs);
    }//GEN-LAST:event_btn_FindActionPerformed

    private void cb_TypePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cb_TypePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_TypePropertyChange

    private void btn_KillSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KillSessionActionPerformed
        // TODO add your handling code here:
        int selectedRow = table_Sessions.getSelectedRow();
        String SID = table_Sessions.getValueAt(selectedRow, 0).toString();
        String Serial = table_Sessions.getValueAt(selectedRow, 1).toString();
        boolean success = session.killSession(SID, Serial);
        if(success){
            JOptionPane.showMessageDialog(this, "Successfully kill!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed!");
        }
    }//GEN-LAST:event_btn_KillSessionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Find;
    private javax.swing.JButton btn_KillSession;
    private javax.swing.JButton btn_Refresh;
    private javax.swing.JComboBox<String> cb_Type;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel label_TotalSession;
    private javax.swing.JTable table_Sessions;
    private javax.swing.JTextField txt_Username;
    // End of variables declaration//GEN-END:variables
}
