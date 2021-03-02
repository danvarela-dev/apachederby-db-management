/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Danie
 */
public class TableModificationWindow extends javax.swing.JFrame {

    /**
     * Creates new form AddTableWindow
     */
    Object[] rowData;
    private static DefaultTableModel tableModel;
    DefaultTableModel tableModel2;
    Connection conn;
    String table2ModifyName;

    GUIMethods.MethodsWins methodsWins = new GUIMethods.MethodsWins();

    String[] datatypes = {"VARCHAR", "INT", "BOOLEAN"};

    public TableModificationWindow(String tableName_, Connection conn_) {
        initComponents();
        this.table2ModifyName = tableName_;
        this.conn = conn_;
        initTabletoModify();
        Data_Type_ComboBo.setModel(new DefaultComboBoxModel(datatypes));
    }

    public TableModificationWindow() {
        initComponents();
        Data_Type_ComboBo.setModel(new DefaultComboBoxModel(datatypes));
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
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
        Modify_btn = new javax.swing.JButton();
        loadFields_btn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        DBName_label1 = new javax.swing.JLabel();
        Cancel_btn1 = new javax.swing.JButton();
        ok_btn1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        loadFields_btn1 = new javax.swing.JButton();
        editTable_comboBox = new javax.swing.JComboBox<>();
        editRefresh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setHeaderValue("PK");
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setHeaderValue("Name");
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setHeaderValue("Data Type");
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setHeaderValue("Size");
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setHeaderValue("Not Null");
        }

        ColumnName_label.setText("Column Name: ");

        DataType_Label.setText("Data Type:");

        PK_CheckBox.setText("Primary Key");

        NotNull_CheckBox.setText("Not Null");

        Size_label.setText("Size:");

        Data_Type_ComboBo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Modify_btn.setText("Modify");
        Modify_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Modify_btnMouseClicked(evt);
            }
        });

        loadFields_btn.setText("Load Fields");
        loadFields_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadFields_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(DBName_label, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tableName_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(ColumnName_label)
                        .addGap(18, 18, 18)
                        .addComponent(ColumnName_JField, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(PK_CheckBox)
                        .addGap(60, 60, 60)
                        .addComponent(NotNull_CheckBox)
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Add_btn)
                            .addComponent(Modify_btn)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(DataType_Label)
                        .addGap(23, 23, 23)
                        .addComponent(Data_Type_ComboBo, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(Size_label)
                        .addGap(12, 12, 12)
                        .addComponent(Size_Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(Delete_btn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(loadFields_btn)
                        .addGap(805, 805, 805)
                        .addComponent(ok_btn)
                        .addGap(29, 29, 29)
                        .addComponent(Cancel_btn))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(DBName_label, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tableName_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(ColumnName_label))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(ColumnName_JField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(PK_CheckBox))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(NotNull_CheckBox))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Add_btn)
                        .addGap(8, 8, 8)
                        .addComponent(Modify_btn)))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(DataType_Label))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Data_Type_ComboBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Size_label))
                    .addComponent(Size_Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(Delete_btn)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ok_btn)
                        .addComponent(loadFields_btn))
                    .addComponent(Cancel_btn))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Edit Structure", jPanel1);

        DBName_label1.setText("Table Name:");

        Cancel_btn1.setText("Cancel");
        Cancel_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cancel_btn1MouseClicked(evt);
            }
        });

        ok_btn1.setText("OK");
        ok_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ok_btn1MouseClicked(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable3.setColumnSelectionAllowed(false);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);

        loadFields_btn1.setText("Load Fields");
        loadFields_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadFields_btn1MouseClicked(evt);
            }
        });

        editRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/resources/refresh.png"))); // NOI18N
        editRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editRefreshMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/resources/delete.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/resources/add.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(DBName_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editTable_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(loadFields_btn1)
                        .addGap(805, 805, 805)
                        .addComponent(ok_btn1)
                        .addGap(29, 29, 29)
                        .addComponent(Cancel_btn1))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DBName_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editTable_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(editRefresh, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ok_btn1)
                        .addComponent(loadFields_btn1))
                    .addComponent(Cancel_btn1))
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Edit Data", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initTabletoModify() {

        this.tableName_JTextField.setText(table2ModifyName);
        this.tableName_JTextField.disable();
        tableModel = (DefaultTableModel) jTable2.getModel();
        tableModel2 = (DefaultTableModel) this.jTable3.getModel();

        try {
            Statement s = this.conn.createStatement();
            String SQLQuery = "SELECT * FROM " + table2ModifyName;
            ResultSet res = s.executeQuery(SQLQuery);
            ResultSetMetaData resMD = res.getMetaData();
            DatabaseMetaData DBMD = conn.getMetaData();
            //Search for Primary Keys
            ResultSet res2 = DBMD.getPrimaryKeys(conn.getCatalog(), resMD.getSchemaName(1), table2ModifyName);

            Vector<Object> rowInfo;
            int i = 1;
            while (resMD.getColumnCount() >= i) {
                rowInfo = new Vector<>();
                boolean pk = false;
                while (res2.next()) {
                    if (resMD.getColumnName(i).equals(res2.getString("COLUMN_NAME"))) {
                        pk = true;
                    }
                }
                rowInfo.add(pk);
                rowInfo.add(resMD.getColumnName(i));

                switch (resMD.getColumnClassName(i)) {
                    case "java.lang.String" ->
                        rowInfo.add("VARCHAR");
                    case "java.lang.Integer" ->
                        rowInfo.add("INT");
                    case "java.lang.Boolean" ->
                        rowInfo.add("BOOLEAN");
                    default -> {
                    }
                }

                rowInfo.add(resMD.getPrecision(i));
                if (resMD.isNullable(i) == ResultSetMetaData.columnNullable) {
                    rowInfo.add(true);
                } else {
                    rowInfo.add(false);
                }
                tableModel.addRow(rowInfo);
                i++;
            }

            Statement st = conn.createStatement();
            String SQLQuery_ = "SELECT S.tablename FROM SYS.SYSTABLES S INNER JOIN SYS.SYSSCHEMAS SCH"
                    + " ON S.SCHEMAID = SCH.SCHEMAID and SCH.SCHEMANAME = '" + this.conn.getSchema() + "' WHERE S.TABLETYPE = 'T'";
            ResultSet res_ = st.executeQuery(SQLQuery_);
            while (res_.next()) {
                this.editTable_comboBox.addItem(res_.getString(1));
            }

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

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

        String SQLStatement = "ALTER TABLE " + table2ModifyName + " ADD COLUMN " + ColumnName_JField.getText() + " " + Data_Type_ComboBo.getSelectedItem().toString();

        if (Data_Type_ComboBo.getSelectedItem().toString().equals("VARCHAR")) {
            SQLStatement += "(" + (int) Size_Spinner.getValue() + ")";
        };
        if (NotNull_CheckBox.isSelected()) {
            SQLStatement += " CONSTRAINT " + ColumnName_JField.getText() + "_CHK_NOTNULL CHECK(" + ColumnName_JField.getText() + " IS NOT NULL)";
        }

        System.out.println(SQLStatement);
        try {

            Statement s = this.conn.createStatement();
            s.executeUpdate(SQLStatement);

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
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

        try {
            if (row >= 0) {
                String SQL = "ALTER TABLE " + conn.getSchema() + "." + this.table2ModifyName + " DROP COLUMN " + tableModel.getValueAt(row, 1);

                tableModel.removeRow(row);
                Statement st = this.conn.createStatement();
                System.out.println(SQL);
                st.executeUpdate(SQL);

            } else {
                JOptionPane.showMessageDialog(this, "Choose Row to Delete", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_Delete_btnMouseClicked

    private void ok_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ok_btnMouseClicked

//        String tableName = tableName_JTextField.getText();
//        Vector<Vector> rowsData = tableModel.getDataVector();
//        String SQL_Statement = "CREATE TABLE " + tableName + " ( ";
//
//        // create create function
//        for (int i = 0; i < rowsData.size(); i++) {
//            SQL_Statement += rowsData.get(i).get(1) + " ";
//            SQL_Statement += rowsData.get(i).get(2);
//            if (rowsData.get(i).get(2).toString().equals("VARCHAR")) {
//                SQL_Statement += "(" + rowsData.get(i).get(3) + ")";
//            }
//            if (rowsData.get(i).get(4).toString().equals("true")) {
//                SQL_Statement += " NOT NULL ";
//            }
//            if (i < rowsData.size() - 1) {
//                SQL_Statement += ",";
//            }
//        }
//        SQL_Statement += " )";
//
//        System.out.println(SQL_Statement);
//        try {
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(SQL_Statement);
//
//         
//        } catch (SQLException e) {
//            System.out.println(e.getLocalizedMessage());
//        }
        this.dispose();
    }//GEN-LAST:event_ok_btnMouseClicked

    private void loadFields_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadFields_btnMouseClicked
        loadFieldsFromRow();
    }//GEN-LAST:event_loadFields_btnMouseClicked

    private void Modify_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Modify_btnMouseClicked

        Vector<Object> curValues = getChosenRow();

        try {
            Statement st = this.conn.createStatement();
            String SQLStatement = "";
            String SQLBase = "ALTER TABLE " + this.conn.getSchema() + "." + table2ModifyName;

            if (!curValues.get(0).equals(PK_CheckBox.isSelected())) {
                ResultSet res = conn.getMetaData().getPrimaryKeys(conn.getCatalog(), this.conn.getSchema(), table2ModifyName);

                //update constraint
                if ((Boolean) curValues.get(0) == true && !PK_CheckBox.isSelected()) {
                    while (res.next()) {
                        //WORKING
                        if (curValues.get(1).equals(res.getString("COLUMN_NAME"))) {
                            SQLStatement = SQLBase + " DROP CONSTRAINT " + res.getString("PK_NAME");
                        }
                    }

                    System.out.println(SQLStatement);
                    st.executeUpdate(SQLStatement);
// PK needs to be dropped
                } else {

                    //NOT SURE WHAT HAPPENS
                    SQLStatement = SQLBase + " ADD PRIMARY KEY (" + this.ColumnName_JField.getText() + ")";
                    st.executeUpdate(SQLStatement);

                    System.out.println(SQLStatement);
                }

            } else if (!curValues.get(1).equals(this.ColumnName_JField.getText())) {
                //update column name
                //WORKING
                SQLStatement = "RENAME COLUMN " + table2ModifyName + "." + curValues.get(1).toString() + " TO " + this.ColumnName_JField.getText();
                st.executeUpdate(SQLStatement);

                System.out.println(SQLStatement);

            } else if (!curValues.get(2).equals(Data_Type_ComboBo.getSelectedItem())) {
                //update data type can not be done in apache derby https://db.apache.org/derby/docs/10.0/manuals/reference/sqlj26.html#HDRSII-SQLJ-81005 
            } else if (curValues.get(3) != this.Size_Spinner.getValue()) {
                //change size , it can only be increased, not decreased
                //WORKING
                SQLStatement = SQLBase + " ALTER COLUMN " + curValues.get(1).toString() + " SET DATA TYPE VARCHAR(" + this.Size_Spinner.getValue() + ")";
                st.executeUpdate(SQLStatement);

                System.out.println(SQLStatement);
            } else if (!(Boolean) curValues.get(4).equals(this.NotNull_CheckBox.isSelected())) {
                //WORKING
                if ((Boolean) curValues.get(4) == true && !this.NotNull_CheckBox.isSelected()) {
                    SQLStatement = SQLBase + " ALTER COLUMN " + this.ColumnName_JField.getText() + " NOT NULL";
                    st.executeUpdate(SQLStatement);
                    System.out.println(SQLStatement);
                } else {
                    SQLStatement = SQLBase + " ALTER COLUMN " + this.ColumnName_JField.getText() + " NULL";
                    st.executeUpdate(SQLStatement);
                    System.out.println(SQLStatement);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_Modify_btnMouseClicked

    private void Cancel_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cancel_btn1MouseClicked
        this.dispose();
    }//GEN-LAST:event_Cancel_btn1MouseClicked

    private void ok_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ok_btn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ok_btn1MouseClicked

    private void loadFields_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadFields_btn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_loadFields_btn1MouseClicked

    private void editRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editRefreshMouseClicked
        tableModel2.setRowCount(0);
        tableModel2.setColumnCount(0);

        try {
            String SQL = "SELECT * FROM " + this.editTable_comboBox.getSelectedItem().toString();
            ResultSet res = this.conn.createStatement().executeQuery(SQL);
            ResultSetMetaData resMD = res.getMetaData();

            tableModel2.setColumnCount(resMD.getColumnCount());
            Vector<Object> columnIdentifiers = new Vector<>();
            Vector<String> rowData_;
            Vector<Vector> dataArray = new Vector<>();

            for (int i = 0; i < resMD.getColumnCount(); i++) {
                columnIdentifiers.addElement(resMD.getColumnName(i + 1));
            }
            while (res.next()) {
                rowData_ = new Vector<>();
                for (int k = 1; k <= resMD.getColumnCount(); k++) {
                    rowData_.add(res.getString(k));
                }

                dataArray.add(rowData_);
            }
            dataArray.add(new Vector<>());
            tableModel2.setDataVector(dataArray, columnIdentifiers);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_editRefreshMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        try {
            String SQL = "INSERT INTO " + this.editTable_comboBox.getSelectedItem().toString() + " VALUES(";

            for (int i = 0; i < this.tableModel2.getColumnCount(); i++) {
                if (this.tableModel2.getValueAt(this.tableModel2.getRowCount() - 1, i).getClass().equals(String.class)) {
                    SQL += "'" + this.tableModel2.getValueAt(this.tableModel2.getRowCount() - 1, i) + "'";
                } else {
                    SQL += this.tableModel2.getValueAt(this.tableModel2.getRowCount() - 1, i);
                }

                if (i < this.tableModel2.getColumnCount() - 1) {
                    SQL += ",";
                }
            }
            SQL += ")";
            System.out.println(SQL);
            
            Statement st = this.conn.createStatement();
            st.executeUpdate(SQL);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jLabel3MouseClicked
    public Vector getChosenRow() {
        int chosenRowIndex = jTable2.getSelectedRow();
        if (chosenRowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Load fields first", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        Vector<Object> rowData = tableModel.getDataVector().get(chosenRowIndex);
        return rowData;
    }

    public boolean loadFieldsFromRow() {

        Vector<Object> rowData = getChosenRow();

        if (rowData == null) {
            return false;
        }

        this.PK_CheckBox.setSelected((Boolean) rowData.get(0));
        this.ColumnName_JField.setText(rowData.get(1).toString());
        for (int i = 0; i < datatypes.length; i++) {
            if (datatypes[i].equals(rowData.get(2).toString())) {
                this.Data_Type_ComboBo.setSelectedIndex(i);
            }
        }
        this.Size_Spinner.setValue(rowData.get(3));
        this.NotNull_CheckBox.setSelected((Boolean) rowData.get(4));

        return true;
    }

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
            java.util.logging.Logger.getLogger(TableModificationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableModificationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableModificationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableModificationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
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
    private javax.swing.JButton Cancel_btn1;
    private javax.swing.JTextField ColumnName_JField;
    private javax.swing.JLabel ColumnName_label;
    private javax.swing.JLabel DBName_label;
    private javax.swing.JLabel DBName_label1;
    private javax.swing.JLabel DataType_Label;
    private javax.swing.JComboBox<String> Data_Type_ComboBo;
    private javax.swing.JButton Delete_btn;
    private javax.swing.JButton Modify_btn;
    private javax.swing.JCheckBox NotNull_CheckBox;
    private javax.swing.JCheckBox PK_CheckBox;
    private javax.swing.JSpinner Size_Spinner;
    private javax.swing.JLabel Size_label;
    private javax.swing.JLabel editRefresh;
    private javax.swing.JComboBox<String> editTable_comboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton loadFields_btn;
    private javax.swing.JButton loadFields_btn1;
    private javax.swing.JButton ok_btn;
    private javax.swing.JButton ok_btn1;
    private javax.swing.JTextField tableName_JTextField;
    // End of variables declaration//GEN-END:variables
}
