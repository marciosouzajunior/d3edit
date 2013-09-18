package main;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.tree.TreeModel;
import org.jd3.D3Params;
import utils.Connection;
import utils.MyItemNode;
import utils.MyTreeModel;
import utils.NodeRenderer;

/**
 * @author Márcio de Souza Júnior - javacomcafe.com
 */

public final class FrmMain extends javax.swing.JFrame {

    static Properties properties = new Properties();
    static JDesktopPane desktop;
    JScrollPane scrollTree;
    static JTree tree = new JTree();
    String[] nodes;
    TreeModel model;
    MyItemNode rootNode;
    String programsFile;
    JScrollPane scrollMessages;
    static JTextArea messages = new JTextArea();
    static File file = new File(FrmMain.class.getProtectionDomain().getCodeSource().getLocation().getFile());
    static String pathProperties = file.getParent() + File.separator + "config.properties";

    public FrmMain() {

        try {

            properties.load(new FileInputStream(new File(pathProperties)));

            programsFile = getProperty("programs_file");
            UIManager.setLookAndFeel(getProperty("look_and_feel"));
            UIManager.put("TextPane.font", new Font(getProperty("font_name"), Integer.parseInt(getProperty("font_style")), Integer.parseInt(getProperty("font_size"))));
            UIManager.put("TextPane.background", new Color(Integer.parseInt(FrmMain.getProperty("background_color"))));
            UIManager.put("DesktopPaneUI", "javax.swing.plaf.basic.BasicDesktopPaneUI");

            ImageIcon icon = new ImageIcon(getClass().getResource("/img/d3_16.png"));
            super.setIconImage(icon.getImage());

            initComponents();

            tree.addMouseListener(
                    new MouseAdapter() {

                        @Override
                        public void mousePressed(MouseEvent e) {

                            int selRow = tree.getRowForLocation(e.getX(), e.getY());

                            MyItemNode node = (MyItemNode) tree.getLastSelectedPathComponent();

                            if (node == null) {
                                return;
                            }

                            if (selRow != -1) {

                                if (e.getClickCount() == 2) {

                                    if (node.getType() == MyItemNode.NODE_ROOT) {

                                        listAccounts();
                                        tree.expandRow(selRow);

                                    } else if (node.getType() == MyItemNode.NODE_RECORD) {

                                        if (checkOpen(node.getAccount() + "," + programsFile + ", " + node.getRecord()) == false) {

                                            FrmEditor editor = new FrmEditor(node.getParent(), programsFile, node.getRecord());
                                            loadForm(editor);
                                            editor.loadRecord();

                                        }
                                    } else if (node.getType() == MyItemNode.NODE_ACCOUNT) {

                                        listRecords(node.getAccount(), node);
                                        tree.expandRow(selRow);

                                    }

                                }
                            }
                        }
                    });

            tree.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {

                    MyItemNode node = (MyItemNode) tree.getLastSelectedPathComponent();

                    if (node == null) {
                        return;
                    }

                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                        if (node.getType() == MyItemNode.NODE_RECORD) {

                            if (checkOpen(node.getAccount() + "," + programsFile + ", " + node.getRecord()) == false) {

                                FrmEditor editor = new FrmEditor(node.getParent(), programsFile, node.getRecord());
                                loadForm(editor);
                                editor.loadRecord();

                            }

                        }

                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            });

            tree.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent me) {

                    if ((me.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
                        JPopupMenu menu = new JPopupMenu();
                        JMenuItem item = new JMenuItem("Refresh");
                        menu.add(item);

                        item.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                listAccounts();
                            }
                        });

                        menu.show(tree, me.getX(), me.getY());

                    }
                }
            });

            messages.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent me) {

                    if ((me.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
                        JPopupMenu menu = new JPopupMenu();
                        JMenuItem item = new JMenuItem("Clean");
                        menu.add(item);

                        item.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                messages.setText("");
                            }
                        });

                        menu.show(messages, me.getX(), me.getY());

                    }
                }
            });

            desktop = new JDesktopPane();
            desktop.setBackground(new java.awt.Color(254, 254, 254));
            desktop.setForeground(new java.awt.Color(255, 255, 255));
            desktop.setName("desktop");

            scrollTree = new JScrollPane();
            scrollTree.getViewport().add(tree);

            messages.setEditable(false);
            scrollMessages = new JScrollPane();
            scrollMessages.getViewport().add(messages);

            jSplitPane1.setLeftComponent(desktop);
            jSplitPane1.setRightComponent(scrollMessages);
            jSplitPane1.setResizeWeight(0.9);

            jSplitPane.setLeftComponent(scrollTree);
            jSplitPane.setRightComponent(jSplitPane1);
            jSplitPane.setResizeWeight(0.1);

            Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
            setSize(tela);
            this.setExtendedState(MAXIMIZED_BOTH);

            makeTree();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        menu = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        itemNovoRegistro = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenu();
        itemSettings = new javax.swing.JMenuItem();
        menuWindow = new javax.swing.JMenu();
        itemCascade = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("D3Edit by Márcio Souza Júnior - javacomcafe.com");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        jSplitPane.setBorder(null);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane.setRightComponent(jSplitPane1);

        getContentPane().add(jSplitPane, "card2");

        menuArquivo.setText("File");

        itemNovoRegistro.setText("New Record");
        itemNovoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNovoRegistroActionPerformed(evt);
            }
        });
        menuArquivo.add(itemNovoRegistro);
        menuArquivo.add(jSeparator1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuArquivo.add(jMenuItem2);

        menu.add(menuArquivo);

        menuEditar.setText("Edit");

        itemSettings.setText("Settings");
        itemSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSettingsActionPerformed(evt);
            }
        });
        menuEditar.add(itemSettings);

        menu.add(menuEditar);

        menuWindow.setText("Window");

        itemCascade.setText("Cascade");
        itemCascade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCascadeActionPerformed(evt);
            }
        });
        menuWindow.add(itemCascade);

        jMenuItem1.setText("Tile");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuWindow.add(jMenuItem1);

        menu.add(menuWindow);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Connection.close();
    }//GEN-LAST:event_formWindowClosed

    private void itemSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSettingsActionPerformed
        FrmSettings frmConfig = new FrmSettings(this, true);
        frmConfig.setLocationRelativeTo(this);
        frmConfig.setVisible(true);
    }//GEN-LAST:event_itemSettingsActionPerformed

    private void itemNovoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNovoRegistroActionPerformed

        MyItemNode node = (MyItemNode) tree.getLastSelectedPathComponent();

        if (node != null && node.getType() == MyItemNode.NODE_ACCOUNT) {

            FrmEditor editor = new FrmEditor(node, programsFile, "NEW.RECORD");
            loadForm(editor);
            editor.loadRecord();

        } else {
            JOptionPane.showMessageDialog(null, "Select an account for record creation.", "New", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_itemNovoRegistroActionPerformed

    private void itemCascadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCascadeActionPerformed
        cascade();
    }//GEN-LAST:event_itemCascadeActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        tile(desktop.getAllFrames(), desktop.getBounds());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemCascade;
    private javax.swing.JMenuItem itemNovoRegistro;
    private javax.swing.JMenuItem itemSettings;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JMenu menuWindow;
    // End of variables declaration//GEN-END:variables

    public void loadForm(JInternalFrame frm) {
        frm.setLocation(desktop.getWidth() / 2 - frm.getWidth() / 2,
                desktop.getHeight() / 2 - frm.getHeight() / 2);
        desktop.add(frm);
        frm.setVisible(true);
    }

    private void cascade() {
        int separation = 25;

        int i = desktop.getAllFrames().length;
        for (JInternalFrame f : desktop.getAllFrames()) {

            f.setLocation(i * separation, i * separation);
            i--;

        }
    }

    private static void tile(JInternalFrame[] frames, Rectangle dBounds) {
        int cols = (int) Math.sqrt(frames.length);
        int rows = (int) (Math.ceil(((double) frames.length) / cols));
        int lastRow = frames.length - cols * (rows - 1);
        int width, height;

        if (lastRow == 0) {
            rows--;
            height = dBounds.height / rows;
        } else {
            height = dBounds.height / rows;
            if (lastRow < cols) {
                rows--;
                width = dBounds.width / lastRow;
                for (int i = 0; i < lastRow; i++) {
                    frames[cols * rows + i].setBounds(i * width, rows * height,
                            width, height);
                }
            }
        }

        width = dBounds.width / cols;
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < cols; i++) {
                frames[i + j * cols].setBounds(i * width, j * height,
                        width, height);
            }
        }
    }

    public static String getProperty(String p) {
        return properties.getProperty(p);
    }

    public static void setProperty(String p, String value) {
        properties.setProperty(p, value);
    }

    public void makeTree() {
        rootNode = new MyItemNode(FrmMain.getProperty("name"), MyItemNode.NODE_ROOT, "MDS,SYSTEM", "");
        model = new MyTreeModel(rootNode);
        tree.setModel(model);
        tree.setCellRenderer(new NodeRenderer());
    }

    public void listAccounts() {

        try {

            makeTree();

            D3Params subparams1 = new D3Params();
            subparams1.addParam("MDS,SYSTEM ");
            subparams1.addParam("0");
            subparams1.addParam("BY A0 WITH A1 = \"D\"");
            subparams1.addParam("|");
            subparams1.addParam("");

            if (Connection.getSession() != null) {

                int r = (Connection.getSession().call("RLISTA", subparams1));

                if (r == 0) {

                    Scanner listAccounts = new Scanner(subparams1.getParam(4));

                    while (listAccounts.hasNext()) {

                        String account = listAccounts.nextLine();

                        if (getProperty("hide_accounts").contains(account)) {
                            continue;
                        }

                        MyItemNode accountNode = new MyItemNode(account, MyItemNode.NODE_ACCOUNT, account, "");
                        rootNode.addChild(accountNode);

                    }

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "List accounts", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void listRecords(String account, MyItemNode parentNode) {

        try {

            D3Params subparams = new D3Params();
            subparams.addParam(account + "," + getProperty("programs_file") + ", ");
            subparams.addParam("0");
            subparams.addParam("BY A0");
            subparams.addParam("|");
            subparams.addParam("");

            if (Connection.getSession() != null) {

                int r = (Connection.getSession().call("RLISTA", subparams));

                if (r == 0) {

                    Scanner listRecords = new Scanner(subparams.getParam(4));

                    while (listRecords.hasNext()) {

                        String registro = listRecords.nextLine();
                        MyItemNode nodeRegistro = new MyItemNode(registro, MyItemNode.NODE_RECORD, account, registro);
                        nodeRegistro.setParent(parentNode);
                        parentNode.addChild(nodeRegistro);

                    }

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Atualizar Accounts", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Updates an editor when another override this code
    static public void updateEditor(String path) {

        for (JInternalFrame jit : desktop.getAllFrames()) {

            FrmEditor editor = (FrmEditor) jit;

            if (editor.getPath().equals(path)) {
                editor.loadRecord();
            }

        }

    }

    // Checks if the file is already open in the editor
    static boolean checkOpen(String path) {

        for (JInternalFrame jit : desktop.getAllFrames()) {

            FrmEditor editor = (FrmEditor) jit;

            if (editor.getPath().equals(path)) {
                editor.toFront();
                return true;
            }

        }

        return false;

    }

    public static void setMessage(String message) {
        messages.append(message + "\n");
    }
}
