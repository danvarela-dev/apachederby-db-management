/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Danie
 */
public class AddTableWindow extends javax.swing.JFrame {

    /**
     * Creates new form AddTableWindow
     */
    Object[] rowData;
    private static DefaultTableModel tableModel;
    Connection conn;

    GUIMethods.MethodsWins methodsWins = new GUIMethods.MethodsWins();

    String[] datatypes = {"VARCHAR", "INT", "BOOLEAN"};

    public AddTableWindow(Connection conn) {
        initComponents();
        this.conn = conn;
        Data_Type_ComboBo.setModel(new DefaultComboBoxModel(datatypes));
    }

    public AddTableWindow() {
        initComponents();
        Data_Type_ComboBo.setModel(new DefaultComboBoxModel(datatypes));

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DBName_label = new javax.swing.JLabel();
        tableName_JTextField = new javax.swing.JTextField();
        Cancel_btn = new javax.swing.JButton();
        ok_btn = new javax.swing.JButton();
        Add_btn = new javax.swing.JButton();
        Delete_btn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        ColumnName_label = new javax.swing.JLabel();
        DataType_Label = new javax.swing.JLabel();
        PK_CheckBox = new javax.swing.JCheckBox();
        NotNull_CheckBox = new javax.swing.JCheckBox();
        Size_label = new javax.swing.JLabel();
        Size_Spinner = new javax.swing.JSpinner();
        ColumnName_JField = new javax.swing.JTextField();
        Data_Type_ComboBo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DBName_label.setText("Table Name:");

        Cancel_btn.setText("Cancel");
        Cancel_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cancel_btnMouseClicked(evt);
            }
        });

        ok_btn.setText("OK");
        ok_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ok_btnMouseClicked(evt);
            }
        });

        Add_btn.setText("Add");
        Add_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_btnMouseClicked(evt);
            }
        });

        Delete_btn.setText("Delete");
        Delete_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delete_btnMouseClicked(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PK", "Name", "Data Type", "Size", "Not Null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
        }

        ColumnName_label.setText("Column Name: ");

        DataType_Label.setText("Data Type:");

        PK_CheckBox.setText("Primary Key");

        NotNull_CheckBox.setText("Not Null");

        Size_label.setText("Size:");

        Data_Type_ComboBo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(DBName_label, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tableName_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ColumnName_label)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(DataType_Label)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ColumnName_JField, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Data_Type_ComboBo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PK_CheckBox)
                                .addGap(60, 60, 60)
                                .addComponent(NotNull_CheckBox))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Size_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Size_Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Add_btn)
                            .addComponent(Delete_btn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(906, 906, 906)
                        .addComponent(ok_btn)
                        .addGap(29, 29, 29)
                        .addComponent(Cancel_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(DBName_label, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tableName_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Add_btn)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(ColumnName_label)
                                .addGap(24, 24, 24)
                                .addComponent(DataType_Label))
                            .addComponent(ColumnName_JField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PK_CheckBox)
                                    .addComponent(NotNull_CheckBox))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(Data_Type_ComboBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Size_Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Size_label)
                                        .addComponent(Delete_btn)))))))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ok_btn)
                    .addComponent(Cancel_btn))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Add_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_btnMouseClicked

        tableModel = (DefaultTableModel) jTable2.getModel();

        rowData = new Object[5];
        rowData[0] = PK_CheckBox.isSelected();
        rowData[1] = ColumnName_JField.getText();
        rowData[2] = Data_Type_ComboBo.getSelectedItem().toString();
        rowData[3] = (int) Size_Spinner.getValue();
        rowData[4] = NotNull_CheckBox.isSelected();

        if (ColumnName_JField.getText().length() != 0) {
            tableModel.addRow(rowData);
        }

        //Set default values to form
        PK_CheckBox.setSelected(false);
        ColumnName_JField.setText("");
        Data_Type_ComboBo.setSelectedIndex(0);
        Size_Spinner.setValue((int) 0);
        NotNull_CheckBox.setSelected(false);


    }//GEN-LAST:event_Add_btnMouseClicked

    private void Cancel_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cancel_btnMouseClicked
        this.dispose();
    }//GEN-LAST:event_Cancel_btnMouseClicked

    private void Delete_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delete_btnMouseClicked
     int row = jTable2.getSelectedRow();

        if (row >= 0) {
            tableModel.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(null, "Choose Row to Delete");
        }
        
    }//GEN-LAST:event_Delete_btnMouseClicked

    private void ok_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ok_btnMouseClicked

        String tableName = tableName_JTextField.getText();
        Vector<Vector> rowsData = tableModel.getDataVector();
        String SQL_Statement = "CREATE TABLE " + tableName + " (";

        // create create function
        for (int i = 0; i < rowsData.size(); i++) {
            SQL_Statement += rowsData.get(i).get(1) + " ";
            SQL_Statement += rowsData.get(i).get(2);

            if (rowsData.get(i).get(2).toString().equals("VARCHAR")) {
                SQL_Statement += "(" + rowsData.get(i).get(3) + ")";
            }
            if (rowsData.get(i).get(4).toString().equals("true")) {
                SQL_Statement += " NOT NULL ";
            }else{
                SQL_Statement+=" NULL ";
            }
            if (rowsData.get(i).get(0).toString().equals("true")) {
                SQL_Statement += "CONSTRAINT " + tableName.toUpperCase() + "_PK PRIMARY KEY";
            }
            if (i < rowsData.size() - 1) {
                SQL_Statement += ", ";
            }
        }
        SQL_Statement += ")";

        System.out.println(SQL_Statement);

        try {
       
            Statement stmt = conn.createStatement();
           stmt.executeUpdate(SQL_Statement);;
            JOptionPane.showMessageDialog(this, "Sucess: Table Created");
            this.dispose();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }//GEN-LAST:event_ok_btnMouseClicked

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
            java.util.logging.Logger.getLogger(AddTableWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTableWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTableWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTableWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_btn;
    private javax.swing.JButton Cancel_btn;
    private javax.swing.JTextField ColumnName_JField;
    private javax.swing.JLabel ColumnName_label;
    private javax.swing.JLabel DBName_label;
    private javax.swing.JLabel DataType_Label;
    private javax.swing.JComboBox<String> Data_Type_ComboBo;
    private javax.swing.JButton Delete_btn;
    private javax.swing.JCheckBox NotNull_CheckBox;
    private javax.swing.JCheckBox PK_CheckBox;
    private javax.swing.JSpinner Size_Spinner;
    private javax.swing.JLabel Size_label;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton ok_btn;
    private javax.swing.JTextField tableName_JTextField;
    // End of variables declaration//GEN-END:variables
}
