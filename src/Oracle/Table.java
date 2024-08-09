/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Oracle;

import dbs.oracleConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import query.OracleSysQuery;
import utils.tableHandler;
import query.TableQuery;
import javax.imageio.ImageIO;
import constants.availableTableFunction;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import query.DevicesTableQuery;

/**
 *
 * @author kongh
 */
public class Table extends javax.swing.JPanel {
    oracleConnection conn = new oracleConnection().getInstance();
    OracleSysQuery sys = new OracleSysQuery();
    TableQuery tq = new TableQuery();
    DevicesTableQuery otq = new DevicesTableQuery();
    File openedFile;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
    boolean fileChange = false;

    
    String fileDest = "C:\\Image\\";
    /**
     * Creates new form Table
     */
    public Table() {
        initComponents();
        initial();
    }
    
    void initial (){
        cb_AvailableTable.addItem("DEVICES");
        cb_AvailableTable.addItem("RECEIVED_BILLS");
        cb_AvailableTable.addItem("RECEIVED_BILL_DETAILS");
        cb_AvailableTable.addItem("ORDERS");
        cb_AvailableTable.addItem("ORDER_DETAILS");
        
    }
    
    public void loadHinh(String image) {
        ImageIcon image1 = new ImageIcon(image);
        Image im = image1.getImage();
        Image scaledImage = im.getScaledInstance(label_Image.getWidth(), label_Image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);
        label_Image.setIcon(icon);
    }

    private String ChonHinh() {
        JFileChooser open = new JFileChooser();
        File defaultDirectory = new File("src");
        open.setCurrentDirectory(defaultDirectory);
        int kq = open.showOpenDialog(null);
        String hinh = "";  
        if (kq == JFileChooser.APPROVE_OPTION) {          
            openedFile = open.getSelectedFile();
            hinh = openedFile.getAbsolutePath();
        }
        System.out.print(openedFile);
        return hinh;
    }
    
    private boolean saveFile(File file, String newFileName) {
        try {
            File destFile = new File(fileDest + newFileName);
            if (destFile.exists()) {
                destFile.delete();
            }
            Files.copy(file.toPath(), destFile.toPath());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private static String getFileExtension(File file) {
        String extension = "";
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            extension = fileName.substring(dotIndex).toLowerCase();
        }
        return extension;
    }
    
    void loadData(String tableName){
        try{
            ResultSet result = null;
            switch(tableName){
                case "DEVICES" -> result = tq.getTableValues(availableTableFunction.DEVICES);
                case "RECEIVED_BILLS" -> result = tq.getTableValues(availableTableFunction.RECEIVED_BILLS);
                case "RECEIVED_BILL_DETAILS" -> result = tq.getTableValues(availableTableFunction.RECEIVED_BILL_DETAILS);
                case "ORDERS" -> result = tq.getTableValues(availableTableFunction.ORDERS);
                case "ORDER_DETAILS" -> result = tq.getTableValues(availableTableFunction.ORDER_DETAILS);
            }
            if(result !=null){
                DefaultTableModel model = tableHandler.buildTableModel(result);
                table_Table.setModel(model);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy bảng");
            }
        } catch(SQLException err){
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Table = new javax.swing.JTable();
        cb_AvailableTable = new javax.swing.JComboBox<>();
        label_Img_Sound = new javax.swing.JLabel();
        btn_Add = new javax.swing.JButton();
        btn_Remove = new javax.swing.JButton();
        btn_Modify = new javax.swing.JButton();
        txt_Name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_Type = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_Price = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_Quantity = new javax.swing.JTextField();
        btn_ChooseFile = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        label_Path = new javax.swing.JLabel();
        label_Image = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        table_Table.setModel(new javax.swing.table.DefaultTableModel(
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
        table_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_Table);

        cb_AvailableTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cb_AvailableTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cb_AvailableTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_AvailableTableActionPerformed(evt);
            }
        });

        btn_Add.setText("Add Device");
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });

        btn_Remove.setText("Remove Device");
        btn_Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoveActionPerformed(evt);
            }
        });

        btn_Modify.setText("Update Device");
        btn_Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModifyActionPerformed(evt);
            }
        });

        jLabel2.setText("Name:");

        jLabel3.setText("Type:");

        jLabel4.setText("Price:");

        txt_Price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                KeyTyped(evt);
            }
        });

        jLabel5.setText("Quantity:");

        txt_Quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                KeyTyped(evt);
            }
        });

        btn_ChooseFile.setText("File");
        btn_ChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChooseFileActionPerformed(evt);
            }
        });

        jLabel6.setText("Path:");

        label_Path.setText("path");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cb_AvailableTable, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_ChooseFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_Modify, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_Remove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_Add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_Path)))
                            .addComponent(label_Img_Sound, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(label_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(44, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_AvailableTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_Img_Sound, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(label_Path))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_ChooseFile)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Add)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Remove)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Modify))
                            .addComponent(label_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb_AvailableTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cb_AvailableTableAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_AvailableTableAncestorAdded

    private void cb_AvailableTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_AvailableTableActionPerformed
        // TODO add your handling code here:
        String value = cb_AvailableTable.getSelectedItem().toString();
        loadData(value);
    }//GEN-LAST:event_cb_AvailableTableActionPerformed

    private void table_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_TableMouseClicked
        // TODO add your handling code here:
        int index = table_Table.getSelectedRow();
        if(index >=0) {
            fileChange = false;
            String value = cb_AvailableTable.getSelectedItem().toString();
            if(value == "DEVICES"){
                ResultSet rs = tq.getTableValues(availableTableFunction.DEVICES);
                String name = table_Table.getValueAt(index, 1).toString();
                String type = table_Table.getValueAt(index, 2).toString();
                String price = table_Table.getValueAt(index, 4).toString();
                String quantity = table_Table.getValueAt(index, 5).toString();
                txt_Name.setText(name);
                txt_Type.setText(type);
                txt_Price.setText(price);
                txt_Quantity.setText(quantity);
                try{
                    for(int i = 0;i<index+1; i++){
                        rs.next();
                    }
                    byte[] blob = rs.getBytes("MORE_INFO");
                    ByteArrayInputStream bis = new ByteArrayInputStream(blob);
                    try{
                        Image image = ImageIO.read(bis);
                        if(image!=null){
                            ImageIcon icon = new ImageIcon(image);
                            label_Img_Sound.setIcon(icon);
                        } else {
                            label_Img_Sound.setIcon(null);
                        }
                    } catch (IOException ex) {
                        return;
                    }
                } catch(SQLException err){
                    return;
                }
            }
        }
    }//GEN-LAST:event_table_TableMouseClicked

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        // TODO add your handling code here:
        String name = txt_Name.getText();
        String type = txt_Type.getText();
        String price = txt_Price.getText();
        String quantity = txt_Quantity.getText();
        if(name.length() == 0 || type.length() == 0 || price.length() == 0 || quantity.length()==0){
            JOptionPane.showMessageDialog(this, "All fields must be filled");
            return;
        }
        LocalDateTime currentDateTime = LocalDateTime.now();
        String ext = getFileExtension(openedFile);
        String newFileName = "file" + currentDateTime.format(formatter) + ext;
        // Directory to save the file
        boolean save = saveFile(openedFile, newFileName);
        if(!save){
            JOptionPane.showMessageDialog(this, "File error");
            return;
        }
        boolean success = otq.InsertDevice(name, type, price, quantity, newFileName);
        if(success){
            JOptionPane.showMessageDialog(this, "Success");
        } else {
            JOptionPane.showMessageDialog(this, "Failed");
        }
        cb_AvailableTable.setSelectedIndex(0);
    }//GEN-LAST:event_btn_AddActionPerformed

    private void btn_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoveActionPerformed
        // TODO add your handling code here:
        String value = cb_AvailableTable.getSelectedItem().toString();
        if(value == "DEVICES"){
            int index = table_Table.getSelectedRow();
            String id = table_Table.getValueAt(index, 0).toString();
            if(index>=0){
                boolean success = otq.DeleteDevice(id);
                if(success){
                    JOptionPane.showMessageDialog(this, "Success");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed");
                }
            }
        }
        
        cb_AvailableTable.setSelectedIndex(0);
    }//GEN-LAST:event_btn_RemoveActionPerformed

    private void btn_ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModifyActionPerformed
        // TODO add your handling code here:
        String name = txt_Name.getText();
        String type = txt_Type.getText();
        String price = txt_Price.getText();
        String quantity = txt_Quantity.getText();
        if(name.length() == 0 || type.length() == 0 || price.length() == 0 || quantity.length()==0){
            JOptionPane.showMessageDialog(this, "All fields must be filled");
            return;
        }
        String value = cb_AvailableTable.getSelectedItem().toString();
        if(value == "DEVICES"){
            int index = table_Table.getSelectedRow();
            String id = table_Table.getValueAt(index, 0).toString();
            if(index>=0){
                boolean success;
                if(fileChange){
                    LocalDateTime currentDateTime = LocalDateTime.now();
                    String ext = getFileExtension(openedFile);
                    String newFileName = "file" + currentDateTime.format(formatter) + ext;
                    boolean save = saveFile(openedFile, newFileName);
                    if(save){
                        success = otq.ModifyDevice(id, name, type, price, quantity,newFileName);
                    } else {
                        success = false;
                        JOptionPane.showMessageDialog(this, "File error");
                    }
                } else {
                    success = otq.ModifyDeviceNoFile(id, name, type, price, quantity);
                }
                
                if(success){
                    JOptionPane.showMessageDialog(this, "Success");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed");
                }
            }
        }
        
        cb_AvailableTable.setSelectedIndex(0);
    }//GEN-LAST:event_btn_ModifyActionPerformed

    private void KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeyTyped
        // TODO add your handling code here:
        Character ch = evt.getKeyChar();
        if(!Character.isDigit(ch)){
            evt.consume();
        }
    }//GEN-LAST:event_KeyTyped

    private void btn_ChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChooseFileActionPerformed
        // TODO add your handling code here:
        String path = ChonHinh();
        if(path.length()>0){
            fileChange = true;
            loadHinh(path);
            label_Path.setText(path);
        }
        label_Image.setIcon(null);
    }//GEN-LAST:event_btn_ChooseFileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_ChooseFile;
    private javax.swing.JButton btn_Modify;
    private javax.swing.JButton btn_Remove;
    private javax.swing.JComboBox<String> cb_AvailableTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_Image;
    private javax.swing.JLabel label_Img_Sound;
    private javax.swing.JLabel label_Path;
    private javax.swing.JTable table_Table;
    private javax.swing.JTextField txt_Name;
    private javax.swing.JTextField txt_Price;
    private javax.swing.JTextField txt_Quantity;
    private javax.swing.JTextField txt_Type;
    // End of variables declaration//GEN-END:variables
}