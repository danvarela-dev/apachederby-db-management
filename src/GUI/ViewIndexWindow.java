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
public class ViewIndexWindow extends javax.swing.JFrame {

    /**
     * Creates new form ViewIndexWindow
     */
    Connection conn;
    DefaultTableModel IND_tableModel, PK_tableModel, FK_tableModel;

    public ViewIndexWindow() {
        initComponents();
        initMyComponents();

    }

    public ViewIndexWindow(Connection conn_) {
        conn = conn_;
        initComponents();
        initMyComponents();
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
        Tables_ComboBox = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        IND_Table = new javax.swing.JTable();
        OK_IND = new javax.swing.JButton();
        IND_Refresh_btn = new javax.swing.JButton();
        INDDeete_btn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        OK_PK = new javax.swing.JButton();
        PK_Refresh_btn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        PK_Table = new javax.swing.JTable();
        deletePK_btn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        FK_OK = new javax.swing.JButton();
        FK_Refresh_btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        FK_Table = new javax.swing.JTable();
        deleteFK_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Table:");

        IND_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Constraint Name", "Column Name"
            }
        ));
        IND_Table.setColumnSelectionAllowed(true);
        IND_Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(IND_Table);
        IND_Table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        OK_IND.setText("OK");

        IND_Refresh_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/resources/refresh.png"))); // NOI18N
        IND_Refresh_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IND_Refresh_btnMouseClicked(evt);
            }
        });

        INDDeete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/resources/delete.png"))); // NOI18N
        INDDeete_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                INDDeete_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(696, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(OK_IND)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(INDDeete_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IND_Refresh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IND_Refresh_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(INDDeete_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(OK_IND)
                .addGap(29, 29, 29))
        );

        jTabbedPane1.addTab("Indexes", jPanel1);

        OK_PK.setText("OK");

        PK_Refresh_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/resources/refresh.png"))); // NOI18N
        PK_Refresh_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PK_Refresh_btnMouseClicked(evt);
            }
        });

        PK_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Constraint Name", "Column Name"
            }
        ));
        PK_Table.setColumnSelectionAllowed(true);
        PK_Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(PK_Table);
        PK_Table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        deletePK_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/resources/delete.png"))); // NOI18N
        deletePK_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletePK_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(OK_PK)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(deletePK_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PK_Refresh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PK_Refresh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletePK_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(OK_PK)
                .addGap(29, 29, 29))
        );

        jTabbedPane1.addTab("Primary Keys", jPanel2);

        FK_OK.setText("OK");

        FK_Refresh_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/resources/refresh.png"))); // NOI18N
        FK_Refresh_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FK_Refresh_btnMouseClicked(evt);
            }
        });

        FK_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Contraint Name", "Column Name", "Referenced Table"
            }
        ));
        FK_Table.setColumnSelectionAllowed(true);
        FK_Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(FK_Table);
        FK_Table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        deleteFK_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/resources/delete.png"))); // NOI18N
        deleteFK_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteFK_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(696, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(FK_OK)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(deleteFK_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FK_Refresh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteFK_btn)
                    .addComponent(FK_Refresh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(FK_OK)
                .addGap(29, 29, 29))
        );

        jTabbedPane1.addTab("Foreign Keys", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(Tables_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Tables_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IND_Refresh_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IND_Refresh_btnMouseClicked
        this.IND_tableModel.setRowCount(0);
        try {
            Statement st = this.conn.createStatement();
            ResultSet res = conn.getMetaData().getIndexInfo(conn.getCatalog(), conn.getSchema(), this.Tables_ComboBox.getSelectedItem().toString(), false, false);
            while (res.next()) {
                this.IND_tableModel.addRow(new Object[]{res.getString("INDEX_NAME"), res.getString("COLUMN_NAME")});
            }
        } catch (Exception e) {
            errorPrint(e);
        }

    }//GEN-LAST:event_IND_Refresh_btnMouseClicked

    private void PK_Refresh_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PK_Refresh_btnMouseClicked
        this.PK_tableModel.setRowCount(0);
        try {
            Statement st = this.conn.createStatement();
            ResultSet res = conn.getMetaData().getPrimaryKeys(conn.getCatalog(), this.conn.getSchema(), this.Tables_ComboBox.getSelectedItem().toString());

            while (res.next()) {
                this.PK_tableModel.addRow(new Object[]{res.getString("PK_NAME"), res.getString("COLUMN_NAME")});
            }

        } catch (Exception e) {
            errorPrint(e);
        }

    }//GEN-LAST:event_PK_Refresh_btnMouseClicked

    private void FK_Refresh_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FK_Refresh_btnMouseClicked
        this.FK_tableModel.setRowCount(0);
        try {
            ResultSet res = conn.getMetaData().getImportedKeys(conn.getCatalog(), conn.getSchema(), this.Tables_ComboBox.getSelectedItem().toString());

            while (res.next()) {
                this.FK_tableModel.addRow(new Object[]{res.getString("FK_NAME"), res.getString("FKCOLUMN_NAME"), res.getString("PKTABLE_NAME")});
            }

        } catch (Exception e) {
            errorPrint(e);
        }


    }//GEN-LAST:event_FK_Refresh_btnMouseClicked

    private void deleteFK_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteFK_btnMouseClicked
        int selected = this.FK_Table.getSelectedRow();
        try {
            String SQL = "ALTER TABLE " + conn.getSchema() + "." + this.Tables_ComboBox.getSelectedItem().toString() + " DROP CONSTRAINT " + FK_tableModel.getValueAt(selected, 0);
            Statement st = this.conn.createStatement();
            st.executeUpdate(SQL);

        } catch (Exception e) {
            errorPrint(e);
        }

    }//GEN-LAST:event_deleteFK_btnMouseClicked

    private void deletePK_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletePK_btnMouseClicked
        int selected = this.PK_Table.getSelectedRow();
        try {
            String SQL = "ALTER TABLE " + conn.getSchema() + "." + this.Tables_ComboBox.getSelectedItem().toString() + " DROP CONSTRAINT " + this.PK_tableModel.getValueAt(selected, 0);
            Statement st = this.conn.createStatement();
            st.executeUpdate(SQL);
        } catch (Exception e) {
            errorPrint(e);
        }
    }//GEN-LAST:event_deletePK_btnMouseClicked

    private void INDDeete_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_INDDeete_btnMouseClicked
        int selected = this.IND_Table.getSelectedRow();
        try {
            String SQL = "DROP INDEX " + this.IND_tableModel.getValueAt(selected, 0);
            Statement st = this.conn.createStatement();
            st.executeUpdate(SQL);
        } catch (Exception e) {
            errorPrint(e);
        }

    }//GEN-LAST:event_INDDeete_btnMouseClicked

    public void initMyComponents() {
        this.IND_tableModel = (DefaultTableModel) this.IND_Table.getModel();
        this.PK_tableModel = (DefaultTableModel) this.PK_Table.getModel();
        this.FK_tableModel = (DefaultTableModel) this.FK_Table.getModel();

        try {
            Statement st = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String SQLQuery = "SELECT S.tablename FROM SYS.SYSTABLES S INNER JOIN SYS.SYSSCHEMAS SCH"
                    + " ON S.SCHEMAID = SCH.SCHEMAID and SCH.SCHEMANAME = '" + conn.getSchema() + "' WHERE S.TABLETYPE = 'T'";

            ResultSet res = st.executeQuery(SQLQuery);

            if (res.next() == false) {
                this.Tables_ComboBox.addItem("No Tables");
            }
            res.beforeFirst();
            while (res.next()) {
                Tables_ComboBox.addItem(res.getString(1));
            }

        } catch (Exception e) {
            errorPrint(e);
        }

    }

    public void errorPrint(Exception e) {
        JOptionPane.showMessageDialog(this, "Error:" + e.getLocalizedMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
    }

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
            java.util.logging.Logger.getLogger(ViewIndexWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewIndexWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewIndexWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewIndexWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewIndexWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FK_OK;
    private javax.swing.JButton FK_Refresh_btn;
    private javax.swing.JTable FK_Table;
    private javax.swing.JButton INDDeete_btn;
    private javax.swing.JButton IND_Refresh_btn;
    private javax.swing.JTable IND_Table;
    private javax.swing.JButton OK_IND;
    private javax.swing.JButton OK_PK;
    private javax.swing.JButton PK_Refresh_btn;
    private javax.swing.JTable PK_Table;
    private javax.swing.JComboBox<String> Tables_ComboBox;
    private javax.swing.JButton deleteFK_btn;
    private javax.swing.JButton deletePK_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}