/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.EventListenerList;
import utils.JFontChooser;


public class FrmSettings extends javax.swing.JDialog {

    DefaultListModel listModel = new DefaultListModel();
    Font font = null;
    UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
    Color colors[] = {Color.black, Color.blue, Color.cyan, Color.darkGray,
        Color.gray, Color.green, Color.lightGray, Color.magenta,
        Color.orange, Color.pink, Color.red, Color.white, Color.yellow};

    public FrmSettings(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        cbDefaultColor.setRenderer(new ColorCellRenderer());
        cbDefaultColor.setEditor(new ColorComboBoxEditor());
        cbCommentColor.setRenderer(new ColorCellRenderer());
        cbCommentColor.setEditor(new ColorComboBoxEditor());
        cbKeywordColor.setRenderer(new ColorCellRenderer());
        cbKeywordColor.setEditor(new ColorComboBoxEditor());
        cbStringColor.setRenderer(new ColorCellRenderer());
        cbStringColor.setEditor(new ColorComboBoxEditor());
        cbBackgroundColor.setRenderer(new ColorCellRenderer());
        cbBackgroundColor.setEditor(new ColorComboBoxEditor());

        loadProperties();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabServidor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listHideAccounts = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        txName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txHost = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txPort = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txUser = new javax.swing.JTextField();
        txPassword = new javax.swing.JPasswordField();
        btAdd = new javax.swing.JButton();
        btRemove = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txProgramsFile = new javax.swing.JTextField();
        tabEstilo = new javax.swing.JPanel();
        btFontChoose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txFont = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbLookAndFeel = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbDefaultColor = new javax.swing.JComboBox(colors);
        cbCommentColor = new javax.swing.JComboBox(colors);
        cbKeywordColor = new javax.swing.JComboBox(colors);
        cbStringColor = new javax.swing.JComboBox(colors);
        cbBackgroundColor = new javax.swing.JComboBox(colors);
        jLabel13 = new javax.swing.JLabel();
        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Settings");
        setLocationByPlatform(true);
        setModal(true);
        setResizable(false);

        jLabel2.setText("Hide Accounts");

        jScrollPane1.setViewportView(listHideAccounts);

        jLabel3.setText("Name");

        jLabel4.setText("Host");

        jLabel5.setText("Port");

        jLabel6.setText("User");

        jLabel7.setText("Password");

        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btRemove.setText("Remove");
        btRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveActionPerformed(evt);
            }
        });

        jLabel14.setText("Programs File");

        javax.swing.GroupLayout tabServidorLayout = new javax.swing.GroupLayout(tabServidor);
        tabServidor.setLayout(tabServidorLayout);
        tabServidorLayout.setHorizontalGroup(
            tabServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabServidorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabServidorLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabServidorLayout.createSequentialGroup()
                        .addGroup(tabServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txHost)
                            .addComponent(txUser)
                            .addComponent(txPort)
                            .addComponent(txName))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabServidorLayout.createSequentialGroup()
                        .addComponent(txPassword)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabServidorLayout.createSequentialGroup()
                        .addComponent(txProgramsFile)
                        .addContainerGap())))
        );
        tabServidorLayout.setVerticalGroup(
            tabServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabServidorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txProgramsFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(tabServidorLayout.createSequentialGroup()
                        .addGroup(tabServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(tabServidorLayout.createSequentialGroup()
                                .addComponent(btAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRemove)))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Server", tabServidor);

        btFontChoose.setText("...");
        btFontChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFontChooseActionPerformed(evt);
            }
        });

        jLabel1.setText("Font");

        txFont.setEditable(false);

        jLabel8.setText("Theme");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Syntax Colors"));

        jLabel9.setText("Default");

        jLabel10.setText("Comment");

        jLabel11.setText("Keyword");

        jLabel12.setText("String");

        cbDefaultColor.setEditable(true);

        cbCommentColor.setEditable(true);

        cbKeywordColor.setEditable(true);

        cbStringColor.setEditable(true);

        cbBackgroundColor.setEditable(true);

        jLabel13.setText("Background");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbBackgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbStringColor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbKeywordColor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCommentColor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDefaultColor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDefaultColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbCommentColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKeywordColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbStringColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBackgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabEstiloLayout = new javax.swing.GroupLayout(tabEstilo);
        tabEstilo.setLayout(tabEstiloLayout);
        tabEstiloLayout.setHorizontalGroup(
            tabEstiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabEstiloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabEstiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tabEstiloLayout.createSequentialGroup()
                        .addGroup(tabEstiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabEstiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabEstiloLayout.createSequentialGroup()
                                .addComponent(txFont)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btFontChoose))
                            .addComponent(cbLookAndFeel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        tabEstiloLayout.setVerticalGroup(
            tabEstiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabEstiloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabEstiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbLookAndFeel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabEstiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFontChoose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Fonts/Colors", tabEstilo);

        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_32.png"))); // NOI18N
        btSave.setText("Save");
        btSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSave.setIconTextGap(0);
        btSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        btCancel.setText("Cancel");
        btCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancel.setIconTextGap(0);
        btCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCancel)
                    .addComponent(btSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFontChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFontChooseActionPerformed

        JFontChooser fontChooser = new JFontChooser();
        fontChooser.setSelectedFont(new Font(FrmMain.getProperty("font_name"), Integer.parseInt(FrmMain.getProperty("font_style")), Integer.parseInt(FrmMain.getProperty("font_size"))));
        int result = fontChooser.showDialog(this);

        if (result == JFontChooser.OK_OPTION) {

            font = fontChooser.getSelectedFont();

            String fontStyle = "";
            switch (font.getStyle()) {
                case 1:
                    fontStyle = "Bold";
                    break;
                case 2:
                    fontStyle = "Italic";
            }

            txFont.setText(font.getName() + " " + font.getSize() + " " + fontStyle);

        }

    }//GEN-LAST:event_btFontChooseActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        save();
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed

        try {
            FrmMain.properties.load(new FileInputStream(new File(FrmMain.pathProperties)));
        } catch (IOException ex) {
            Logger.getLogger(FrmSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();

    }//GEN-LAST:event_btCancelActionPerformed

    private void btRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveActionPerformed

        if (listHideAccounts.getSelectedIndex() != -1) {
            listModel.removeElementAt(listHideAccounts.getSelectedIndex());
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma account selecionda.", "Remove", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btRemoveActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed

        String account = JOptionPane.showInputDialog(null, "Informe a account:", "Add", JOptionPane.QUESTION_MESSAGE);
        if (account != null && !account.equals("")) {
            listModel.addElement(account);
        }

    }//GEN-LAST:event_btAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FrmSettings dialog = new FrmSettings(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    protected javax.swing.JButton btCancel;
    private javax.swing.JButton btFontChoose;
    private javax.swing.JButton btRemove;
    protected javax.swing.JButton btSave;
    private javax.swing.JComboBox cbBackgroundColor;
    private javax.swing.JComboBox cbCommentColor;
    private javax.swing.JComboBox cbDefaultColor;
    private javax.swing.JComboBox cbKeywordColor;
    private javax.swing.JComboBox cbLookAndFeel;
    private javax.swing.JComboBox cbStringColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList listHideAccounts;
    private javax.swing.JPanel tabEstilo;
    private javax.swing.JPanel tabServidor;
    private javax.swing.JTextField txFont;
    private javax.swing.JTextField txHost;
    private javax.swing.JTextField txName;
    private javax.swing.JPasswordField txPassword;
    private javax.swing.JTextField txPort;
    private javax.swing.JTextField txProgramsFile;
    private javax.swing.JTextField txUser;
    // End of variables declaration//GEN-END:variables

    private void save() {

        //Server
        FrmMain.setProperty("name", txName.getText());
        FrmMain.setProperty("host", txHost.getText());
        FrmMain.setProperty("port", txPort.getText());
        FrmMain.setProperty("user", txUser.getText());
        FrmMain.setProperty("password", txPassword.getText());
        FrmMain.setProperty("programs_file", txProgramsFile.getText());

        // Hide accounts
        String hideAccounts = "";

        for (int c = 0; c < listModel.getSize(); c++) {
            hideAccounts += listModel.get(c) + "|";
        }

        FrmMain.setProperty("hide_accounts", hideAccounts);

        // Font
        if (font != null) {
            FrmMain.setProperty("font_name", font.getName());
            FrmMain.setProperty("font_style", Integer.toString(font.getStyle()));
            FrmMain.setProperty("font_size", Integer.toString(font.getSize()));
        }

        // LookAndFeel
        FrmMain.setProperty("look_and_feel", ((LafInfo) cbLookAndFeel.getSelectedItem()).getLafClass());

        // Colors
        FrmMain.setProperty("default_color", Integer.toString(((Color) cbDefaultColor.getSelectedItem()).getRGB()));
        FrmMain.setProperty("comment_color", Integer.toString(((Color) cbCommentColor.getSelectedItem()).getRGB()));
        FrmMain.setProperty("keyword_color", Integer.toString(((Color) cbKeywordColor.getSelectedItem()).getRGB()));
        FrmMain.setProperty("string_color", Integer.toString(((Color) cbStringColor.getSelectedItem()).getRGB()));
        FrmMain.setProperty("background_color", Integer.toString(((Color) cbBackgroundColor.getSelectedItem()).getRGB()));

        try {

            File propertiesFile = new File(FrmMain.pathProperties);
            FrmMain.properties.store(new FileOutputStream(propertiesFile), null);

            JOptionPane.showMessageDialog(null, "You need to restart application for the changes to take effect.", "Save", JOptionPane.INFORMATION_MESSAGE);
            dispose();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving changes: " + ex.getMessage(), "Save", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void loadProperties() {

        // Server
        txName.setText(FrmMain.getProperty("name"));
        txHost.setText(FrmMain.getProperty("host"));
        txPort.setText(FrmMain.getProperty("port"));
        txUser.setText(FrmMain.getProperty("user"));
        txPassword.setText(FrmMain.getProperty("password"));
        txProgramsFile.setText(FrmMain.getProperty("programs_file"));

        // Hide accounts
        listModel.removeAllElements();
        listHideAccounts.setModel(listModel);

        String[] accountsEscondidos = FrmMain.getProperty("hide_accounts").split("\\|");
        for (String account : accountsEscondidos) {
            listModel.addElement(account);
        }

        // Font
        String fontStyle = "";
        switch (Integer.parseInt(FrmMain.getProperty("font_style"))) {
            case 1:
                fontStyle = "Bold";
                break;
            case 2:
                fontStyle = "Italic";
        }

        // LookAndFeel
        cbLookAndFeel.removeAllItems();
        for (UIManager.LookAndFeelInfo laf : lafInfo) {
            cbLookAndFeel.addItem(new LafInfo(laf.getName(), laf.getClassName()));
        }
        for (int c = 0; c < cbLookAndFeel.getItemCount(); c++) {
            if (((LafInfo) cbLookAndFeel.getItemAt(c)).getLafClass().equals(FrmMain.getProperty("look_and_feel"))) {
                cbLookAndFeel.setSelectedIndex(c);
            }
        }

        txFont.setText(FrmMain.getProperty("font_name") + " " + FrmMain.getProperty("font_size") + " " + fontStyle);

        // Colors
        cbDefaultColor.setSelectedItem(new Color(Integer.parseInt(FrmMain.getProperty("default_color"))));
        cbCommentColor.setSelectedItem(new Color(Integer.parseInt(FrmMain.getProperty("comment_color"))));
        cbKeywordColor.setSelectedItem(new Color(Integer.parseInt(FrmMain.getProperty("keyword_color"))));
        cbStringColor.setSelectedItem(new Color(Integer.parseInt(FrmMain.getProperty("string_color"))));
        cbBackgroundColor.setSelectedItem(new Color(Integer.parseInt(FrmMain.getProperty("background_color"))));

    }
}
class LafInfo {

    String name;
    String lafClass;

    public LafInfo(String nome, String lafClass) {
        this.name = nome;
        this.lafClass = lafClass;
    }

    public String getLafClass() {
        return lafClass;
    }

    public void setLafClasse(String lafClass) {
        this.lafClass = lafClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class ColorComboBoxEditor implements ComboBoxEditor {

    final protected JButton editor;
    protected EventListenerList listenerList = new EventListenerList();

    public ColorComboBoxEditor() {
        editor = new JButton("");
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color currentBackground = editor.getBackground();
                Color color = JColorChooser.showDialog(editor, "Color Chooser", currentBackground);
                if ((color != null) && (currentBackground != color)) {
                    editor.setBackground(color);
                    fireActionEvent(color);
                }
            }
        };
        editor.addActionListener(actionListener);
    }

    @Override
    public void addActionListener(ActionListener l) {
        listenerList.add(ActionListener.class, l);
    }

    @Override
    public Component getEditorComponent() {
        return editor;
    }

    @Override
    public Object getItem() {
        return editor.getBackground();
    }

    @Override
    public void removeActionListener(ActionListener l) {
        listenerList.remove(ActionListener.class, l);
    }

    @Override
    public void selectAll() {
        // Ignore
    }

    @Override
    public void setItem(Object newValue) {
        if (newValue instanceof Color) {
            Color color = (Color) newValue;
            editor.setBackground(color);
        } else {
            try {
                Color color = Color.decode(newValue.toString());
                editor.setBackground(color);
            } catch (NumberFormatException e) {
            }
        }
    }

    protected void fireActionEvent(Color color) {
        Object listeners[] = listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ActionListener.class) {
                ActionEvent actionEvent = new ActionEvent(editor, ActionEvent.ACTION_PERFORMED, color.toString());
                ((ActionListener) listeners[i + 1]).actionPerformed(actionEvent);
            }
        }
    }
}

class ColorCellRenderer implements ListCellRenderer {

    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
    // width doesn't matter as combobox will size
    private final static Dimension preferredSize = new Dimension(0, 20);

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
        if (value instanceof Color) {
            renderer.setText("");
            renderer.setBackground((Color) value);
        }
        renderer.setPreferredSize(preferredSize);
        return renderer;
    }
}