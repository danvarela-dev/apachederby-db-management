/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danie
 */
public class TriggersWindow extends javax.swing.JFrame {

    /**
     * Creates new form TriggersWindow
     */
    Connection conn;
    DefaultTableModel tableModel;

    public TriggersWindow() {
        initComponents();
    }

    public TriggersWindow(Connection conn_) {
        initComponents();
        this.conn = conn_;
        initMyComponents();
    }

    public void initMyComponents() {
        tableModel = (DefaultTableModel) this.jTable1.getModel();
        try {

            ResultSet resSchemas = this.conn.getMetaData().getSchemas();
            while (resSchemas.next()) {
                this.schemaComboBox.addItem(resSchemas.getString("TABLE_SCHEM"));
            }
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String SQLQuery = "SELECT S.tablename FROM SYS.SYSTABLES S INNER JOIN SYS.SYSSCHEMAS SCH"
                    + " ON S.SCHEMAID = SCH.SCHEMAID and SCH.SCHEMANAME = '" + this.schemaComboBox.getSelectedItem().toString() + "' WHERE S.TABLETYPE = 'T'";
            ResultSet res = st.executeQuery(SQLQuery);

            while (res.next()) {
                this.BaseTable_jComboBox.addItem(res.getString(1));
            }

        } catch (Exception e) {
            errorPrint(e);
        }
    }

    public void errorPrint(Exception e) {
        JOptionPane.showMessageDialog(this, "Error:" + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        schemaComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        triggerName_jTextField = new javax.swing.JTextField();
        OK_jButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        BaseTable_jComboBox = new javax.swing.JComboBox<>();
        UPDATE_checkBox = new javax.swing.JCheckBox();
        INSERT_checkBox = new javax.swing.JCheckBox();
        DELETE_checkBox = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        oldReference_jTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        generateSQL_jButton1 = new javax.swing.JButton();
        RUNSQL_jButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        timing_ComboBox = new javax.swing.JComboBox<>();
        Refresh_jButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        newReference_jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        deleteTRG_jButton = new javax.swing.JButton();
        refreshTRG_jButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Schema:");

        jLabel2.setText("Name:");

        OK_jButton.setText("OK");
        OK_jButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OK_jButtonMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Base Table:");

        UPDATE_checkBox.setText("UPDATE");

        INSERT_checkBox.setText("INSERT");

        DELETE_checkBox.setText("DELETE");

        jLabel5.setText("Referencing Old as:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        generateSQL_jButton1.setText("GENERATE SQL");
        generateSQL_jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generateSQL_jButton1MouseClicked(evt);
            }
        });

        RUNSQL_jButton.setText("RUN SQL");
        RUNSQL_jButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RUNSQL_jButtonMouseClicked(evt);
            }
        });

        jLabel4.setText("Timing:");

        timing_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO CASCADE BEFORE", "AFTER" }));

        Refresh_jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/resources/refresh.png"))); // NOI18N
        Refresh_jButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Refresh_jButtonMouseClicked(evt);
            }
        });

        jLabel6.setText("Referencing New as:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oldReference_jTextField)
                            .addComponent(BaseTable_jComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(UPDATE_checkBox)
                                .addGap(68, 68, 68)
                                .addComponent(INSERT_checkBox)
                                .addGap(66, 66, 66)
                                .addComponent(DELETE_checkBox)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(timing_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(generateSQL_jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RUNSQL_jButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel6)
                                .addGap(7, 7, 7)
                                .addComponent(newReference_jTextField1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Refresh_jButton)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(BaseTable_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Refresh_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UPDATE_checkBox)
                    .addComponent(INSERT_checkBox)
                    .addComponent(DELETE_checkBox))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(timing_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(oldReference_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(newReference_jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RUNSQL_jButton)
                    .addComponent(generateSQL_jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Create Trigger", jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Schema", "Trigger Name"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        deleteTRG_jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/resources/delete.png"))); // NOI18N
        deleteTRG_jButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteTRG_jButtonMouseClicked(evt);
            }
        });

        refreshTRG_jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/resources/refresh.png"))); // NOI18N
        refreshTRG_jButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshTRG_jButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(deleteTRG_jButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refreshTRG_jButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteTRG_jButton)
                    .addComponent(refreshTRG_jButton))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consult Triggers", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OK_jButton)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(schemaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(triggerName_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(schemaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(triggerName_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(OK_jButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateSQL_jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateSQL_jButton1MouseClicked
        try {

            String SQLTrigger = "CREATE TRIGGER " + this.schemaComboBox.getSelectedItem().toString() + "."
                    + this.triggerName_jTextField.getText() + "\n" + this.timing_ComboBox.getSelectedItem().toString();
            if (this.INSERT_checkBox.isSelected()) {
                SQLTrigger += " INSERT ON ";
            } else if (this.DELETE_checkBox.isSelected()) {
                SQLTrigger += " DELETE ON ";
            } else if (this.UPDATE_checkBox.isSelected()) {
                SQLTrigger += " UPDATE ON ";
            }

            SQLTrigger += this.BaseTable_jComboBox.getSelectedItem().toString() + "\nREFERENCING ";
            if (this.INSERT_checkBox.isSelected()) {
                SQLTrigger += " NEW AS " + this.newReference_jTextField1.getText();
            }
            if (this.DELETE_checkBox.isSelected() || this.UPDATE_checkBox.isSelected()) {
                SQLTrigger += " OLD AS " + this.oldReference_jTextField.getText();
            }
            SQLTrigger += "\nFOR EACH ROW MODE DB2SQL\n-->[ TRIGGER BODY GOES HERE ]<--";

            this.jTextArea1.setText(SQLTrigger);

        } catch (Exception e) {
            errorPrint(e);
        }
    }//GEN-LAST:event_generateSQL_jButton1MouseClicked

    private void RUNSQL_jButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUNSQL_jButtonMouseClicked
        try {

            Statement st = this.conn.createStatement();
            st.executeUpdate(this.jTextArea1.getText());

            JOptionPane.showMessageDialog(this, "Trigger Created!");
        } catch (Exception e) {
            errorPrint(e);
        }
    }//GEN-LAST:event_RUNSQL_jButtonMouseClicked

    private void Refresh_jButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Refresh_jButtonMouseClicked
        this.BaseTable_jComboBox.removeAllItems();
        try {
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String SQLQuery = "SELECT S.tablename FROM SYS.SYSTABLES S INNER JOIN SYS.SYSSCHEMAS SCH"
                    + " ON S.SCHEMAID = SCH.SCHEMAID and SCH.SCHEMANAME = '" + this.schemaComboBox.getSelectedItem().toString() + "'";
            ResultSet res = st.executeQuery(SQLQuery);

            while (res.next()) {
                this.BaseTable_jComboBox.addItem(res.getString("TABLENAME"));
            }
        } catch (Exception e) {
            errorPrint(e);
        }

    }//GEN-LAST:event_Refresh_jButtonMouseClicked

    private void OK_jButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK_jButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_OK_jButtonMouseClicked

    private void refreshTRG_jButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshTRG_jButtonMouseClicked
        tableModel.setRowCount(0);
        try {
            String SQL = "SELECT S.SCHEMANAME , T.TRIGGERNAME FROM SYS.SYSSCHEMAS S INNER JOIN SYS.SYSTRIGGERS T ON S.SCHEMAID = T.SCHEMAID WHERE S.SCHEMANAME = '" + this.schemaComboBox.getSelectedItem().toString() + "'";

            Statement st = this.conn.createStatement();
            ResultSet resTriggers = st.executeQuery(SQL);

            while (resTriggers.next()) {
                tableModel.addRow(new Object[]{resTriggers.getString(1), resTriggers.getString(2)});
            }

        } catch (Exception e) {
            errorPrint(e);
        }
    }//GEN-LAST:event_refreshTRG_jButtonMouseClicked

    private void deleteTRG_jButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteTRG_jButtonMouseClicked

        int selectedRow = this.jTable1.getSelectedRow();

        try {
            String SQL = "DROP TRIGGER " + this.tableModel.getValueAt(selectedRow, 1);
            Statement st = this.conn.createStatement();

            st.execute(SQL);
            JOptionPane.showMessageDialog(this, "Trigger Succesfully Deleted");

        } catch (Exception e) {
            errorPrint(e);
        }


    }//GEN-LAST:event_deleteTRG_jButtonMouseClicked

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
            java.util.logging.Logger.getLogger(TriggersWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TriggersWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TriggersWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TriggersWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TriggersWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BaseTable_jComboBox;
    private javax.swing.JCheckBox DELETE_checkBox;
    private javax.swing.JCheckBox INSERT_checkBox;
    private javax.swing.JButton OK_jButton;
    private javax.swing.JButton RUNSQL_jButton;
    private javax.swing.JButton Refresh_jButton;
    private javax.swing.JCheckBox UPDATE_checkBox;
    private javax.swing.JButton deleteTRG_jButton;
    private javax.swing.JButton generateSQL_jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField newReference_jTextField1;
    private javax.swing.JTextField oldReference_jTextField;
    private javax.swing.JButton refreshTRG_jButton;
    private javax.swing.JComboBox<String> schemaComboBox;
    private javax.swing.JComboBox<String> timing_ComboBox;
    private javax.swing.JTextField triggerName_jTextField;
    // End of variables declaration//GEN-END:variables
}
