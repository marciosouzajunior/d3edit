/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.StyledEditorKit;
import org.fife.ui.autocomplete.*;
import org.jd3.D3Constants;
import org.jd3.D3File;
import org.jd3.D3Item;
import org.jd3.exceptions.D3Exception;
import utils.*;

/**
 *
 * @author marcio
 */
public class FrmEditor extends JInternalFrame {

    private int currentPos = 0;
    private int pos = -1;
    final JTextPane textPane = new JTextPane() {

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            super.paintComponent(g2);
        }
    };
    D3SyntaxDocument d3SyntaxDoc = new D3SyntaxDocument(textPane);
    EditorKit editorKit = new StyledEditorKit();
    CompoundUndoManager um;
    MyItemNode nodeAccount;
    String account;
    String programsFile;
    String record;
    D3File file;
    D3Item item;
    boolean changedWithoutSave = false;

    public FrmEditor(MyItemNode nodeAccount, String programsFile, String record) {

        this.nodeAccount = nodeAccount;
        this.account = nodeAccount.getAccount();
        this.programsFile = programsFile;
        this.record = record;

        textPane.setEditorKit(editorKit);
        textPane.setDocument(d3SyntaxDoc);

        textPane.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                changedWithoutSave = true;
                btSave.setEnabled(true);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                if (e.getModifiers() == KeyEvent.CTRL_MASK) {

                    if (e.getKeyCode() == KeyEvent.VK_S) {
                        save(false);
                    } else if (e.getKeyCode() == KeyEvent.VK_Z) {
                        um.undo();
                    } else if (e.getKeyCode() == KeyEvent.VK_Y) {
                        um.redo();
                    } else if (e.getKeyCode() == KeyEvent.VK_F) {

                        if (pnlFindReplace.isVisible()) {
                            pnlFindReplace.setVisible(false);
                        } else {
                            pnlFindReplace.setVisible(true);
                            txFind.requestFocusInWindow();
                        }

                    }

                }

                if (e.getKeyCode() == KeyEvent.VK_F5) {
                    compile();
                }

            }
        });

        um = new CompoundUndoManager(textPane);

        initComponents();

        pnlFindReplace.setVisible(false);

        super.setSize(FrmMain.desktop.getWidth() / 100 * 90, FrmMain.desktop.getHeight() / 100 * 90);

        // Code completion
        CompletionProvider provider = createCompletionProvider();
        AutoCompletion ac = new AutoCompletion(provider) {

            @Override
            protected String getReplacementText(Completion c, Document doc, int start, int len) {
                String text = super.getReplacementText(c, doc, start, len);
                if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK) == true) {
                    return text == null ? null : text.toUpperCase();
                } else {
                    return text == null ? null : text;
                }

            }
        };

        ac.setShowDescWindow(true);
        ac.setAutoCompleteSingleChoices(true);
        ac.setParameterAssistanceEnabled(true);

        ac.install(textPane);
        JScrollPane scroll = new JScrollPane(textPane);
        scroll.setBorder(null);
        scroll.setRowHeaderView(new TextLineNumber(textPane));
        super.add(scroll);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new javax.swing.JToolBar();
        btSave = new javax.swing.JButton();
        btSaveAs = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btUndo = new javax.swing.JButton(um.getUndoAction());
        btRedo = new javax.swing.JButton(um.getRedoAction());
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btCompile = new javax.swing.JButton();
        pnlFindReplace = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txFind = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txReplace = new javax.swing.JTextField();
        btNext = new javax.swing.JButton();
        btCloseFind = new javax.swing.JButton();
        chkCaseSensitive = new javax.swing.JCheckBox();
        btSubstituir = new javax.swing.JButton();
        btReplaceAll = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/record.png"))); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_16.png"))); // NOI18N
        btSave.setToolTipText("Save");
        btSave.setEnabled(false);
        btSave.setFocusable(false);
        btSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        toolBar.add(btSave);

        btSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_as.png"))); // NOI18N
        btSaveAs.setToolTipText("Save As");
        btSaveAs.setFocusable(false);
        btSaveAs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSaveAs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveAsActionPerformed(evt);
            }
        });
        toolBar.add(btSaveAs);
        toolBar.add(jSeparator1);

        btUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/undo.png"))); // NOI18N
        btUndo.setToolTipText("Undo");
        btUndo.setFocusable(false);
        btUndo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btUndo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btUndo);

        btRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/redo.png"))); // NOI18N
        btRedo.setToolTipText("Redo");
        btRedo.setFocusable(false);
        btRedo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btRedo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btRedo);
        toolBar.add(jSeparator2);

        btCompile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/compile.png"))); // NOI18N
        btCompile.setToolTipText("Compile");
        btCompile.setFocusable(false);
        btCompile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCompile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCompile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCompileActionPerformed(evt);
            }
        });
        toolBar.add(btCompile);

        getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);

        pnlFindReplace.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Find");

        txFind.setNextFocusableComponent(btNext);
        txFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txFindKeyPressed(evt);
            }
        });

        jLabel3.setText("Replace");

        txReplace.setNextFocusableComponent(btSubstituir);

        btNext.setText("Next");
        btNext.setNextFocusableComponent(txReplace);
        btNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNextActionPerformed(evt);
            }
        });

        btCloseFind.setText("x");
        btCloseFind.setBorder(null);
        btCloseFind.setOpaque(true);
        btCloseFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseFindActionPerformed(evt);
            }
        });

        chkCaseSensitive.setText("Case sensitive");
        chkCaseSensitive.setNextFocusableComponent(btCloseFind);

        btSubstituir.setText("Replace");
        btSubstituir.setNextFocusableComponent(btReplaceAll);
        btSubstituir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubstituirActionPerformed(evt);
            }
        });

        btReplaceAll.setText("Replace All");
        btReplaceAll.setNextFocusableComponent(chkCaseSensitive);
        btReplaceAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReplaceAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFindReplaceLayout = new javax.swing.GroupLayout(pnlFindReplace);
        pnlFindReplace.setLayout(pnlFindReplaceLayout);
        pnlFindReplaceLayout.setHorizontalGroup(
            pnlFindReplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFindReplaceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFindReplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFindReplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txFind, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txReplace))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFindReplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSubstituir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFindReplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFindReplaceLayout.createSequentialGroup()
                        .addComponent(chkCaseSensitive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                        .addComponent(btCloseFind, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFindReplaceLayout.createSequentialGroup()
                        .addComponent(btReplaceAll)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlFindReplaceLayout.setVerticalGroup(
            pnlFindReplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFindReplaceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFindReplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlFindReplaceLayout.createSequentialGroup()
                        .addComponent(btCloseFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(pnlFindReplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btNext)
                        .addComponent(chkCaseSensitive)))
                .addGroup(pnlFindReplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txReplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSubstituir)
                    .addComponent(btReplaceAll))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(pnlFindReplace, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        save(false);
    }//GEN-LAST:event_btSaveActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

        if (file != null) {

            try {

                // Checks if the file is open in another editor
                if (FrmMain.checkOpen(getTitle()) == false) {
                    file.release(record);
                }

            } catch (D3Exception e) {
                JOptionPane.showMessageDialog(null, "Unable to execute the release on file " + account + "," + file + ": " + e.getMessage(), "Release", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_formInternalFrameClosed

    private void btCompileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCompileActionPerformed

        if (file != null) {
            compile();
        } else {
            JOptionPane.showMessageDialog(null, "Save the record before compiling.", "Compile", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btCompileActionPerformed

    private void btSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveAsActionPerformed
        save(true);
    }//GEN-LAST:event_btSaveAsActionPerformed

    private void btCloseFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseFindActionPerformed
        pnlFindReplace.setVisible(false);
    }//GEN-LAST:event_btCloseFindActionPerformed

    private void btNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNextActionPerformed
        findNext();
    }//GEN-LAST:event_btNextActionPerformed

    private void btSubstituirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubstituirActionPerformed
        replace();
    }//GEN-LAST:event_btSubstituirActionPerformed

    private void btReplaceAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReplaceAllActionPerformed
        replaceAll();
    }//GEN-LAST:event_btReplaceAllActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        if (changedWithoutSave == true) {

            int r = JOptionPane.showConfirmDialog(null, "Save the changes in " + record + "?", "Save", JOptionPane.YES_NO_CANCEL_OPTION);

            if (r == JOptionPane.YES_OPTION) {
                save(false);
                dispose();
            } else if (r == JOptionPane.NO_OPTION) {
                dispose();
            }

        } else {
            dispose();
        }

    }//GEN-LAST:event_formInternalFrameClosing

    private void txFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txFindKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btNext.requestFocusInWindow();
            btNextActionPerformed(null);
        }

    }//GEN-LAST:event_txFindKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCloseFind;
    private javax.swing.JButton btCompile;
    private javax.swing.JButton btNext;
    private javax.swing.JButton btRedo;
    private javax.swing.JButton btReplaceAll;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSaveAs;
    private javax.swing.JButton btSubstituir;
    private javax.swing.JButton btUndo;
    private javax.swing.JCheckBox chkCaseSensitive;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPanel pnlFindReplace;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JTextField txFind;
    private javax.swing.JTextField txReplace;
    // End of variables declaration//GEN-END:variables

    private CompletionProvider createCompletionProvider() {

        DefaultCompletionProvider provider = new DefaultCompletionProvider();
        provider.setParameterizedCompletionParams('(', ",", ')');

        //
        // Sentences
        //

        // These functions are here because they do not require parentheses ()
        provider.addCompletion(new BasicCompletion(provider, "@am", null, "The @am function returns a string containing an attribute mark.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;@am"));
        provider.addCompletion(new BasicCompletion(provider, "@fm", null, "The @fm function returns a string containing an attribute mark.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;@fm"));
        provider.addCompletion(new BasicCompletion(provider, "@sm", null, "The @sm function returns a string containing a subvalue mark.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;@sm"));
        provider.addCompletion(new BasicCompletion(provider, "@vm", null, "The @vm function returns a string containing a value mark.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;@vm"));

        provider.addCompletion(new BasicCompletion(provider, "$chain", null, "The $chain statement continues FlashBASIC or BASIC compilation in a different source item.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;$chain {file.ref} item-ID"));
        provider.addCompletion(new BasicCompletion(provider, "$include", null, "The $include statement inserts FlashBASIC or BASIC code from a separate item (known as an include item) to be compiled as part of the object module of the current program or subroutine. The original source program is not altered.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;$include {file.ref} item-ID"));
        provider.addCompletion(new BasicCompletion(provider, "$options", null, "The $options statement sets compatibility options for the FlashBASIC or BASIC compiler.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;$options {tag}"));
        provider.addCompletion(new BasicCompletion(provider, "abort", null, "The abort statement immediately stops program execution and unconditionally returns to the TCL command prompt.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;abort {message#}{,\"parameter\"{,\"parameter\"...}}<br>&nbsp;&nbsp;abort {error.message.str}"));
        provider.addCompletion(new BasicCompletion(provider, "and", null, "The and logical operator indicates that both components of a logical expression must be true.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;exp and exp<br><br><b>Synonym:</b><br>&nbsp;&nbsp;&"));
        provider.addCompletion(new BasicCompletion(provider, "aux", null, "The aux statement enables or disables spooling to the auxiliary port.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;aux [off|on|exp]"));
        provider.addCompletion(new BasicCompletion(provider, "begin case", null, "The begin case statement starts a case construct.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;"
                + "begin case<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;case logical.exp<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{statement{s}}<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;case logical.exp<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{statement{s}}<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.<br>"
                + "&nbsp;&nbsp;end case"));
        provider.addCompletion(new BasicCompletion(provider, "begin work", null, "The begin work statement starts a transaction.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;begin {work|transaction} {name} {then|else statement.block}"));
        provider.addCompletion(new BasicCompletion(provider, "break", null, "The break statement enables or disables the BREAK key.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;break [off|on|exp]"));
        provider.addCompletion(new BasicCompletion(provider, "call", null, "The call statement transfers control to an external FlashBASIC or BASIC subroutine and optionally passes a list of arguments to it.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;call cataloged.program.name{(arg{,arg...})}<br>"
                + "&nbsp;&nbsp;call @program.name.var{(arg{,arg...})}<br>"
                + "&nbsp;&nbsp;call \"file.ref program.name\"{(arg{,arg...})}"));
        provider.addCompletion(new BasicCompletion(provider, "capturing", null, "The capturing clause resumes the capturing effect from the previous execute...capturing statements in a FlashBASIC or BASIC program.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;capturing [off|on|exp]"));
        provider.addCompletion(new BasicCompletion(provider, "casing", null, "The casing statement toggles case sensitivity relative to input data and string comparisons in the current program and any called subroutines.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;casing [on|off|exp]"));
        provider.addCompletion(new BasicCompletion(provider, "cat", null, "The cat relational operator concatenates strings in an expression.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;exp cat exp"));
        provider.addCompletion(new BasicCompletion(provider, "cfunction", null, "The cfunction statement provides access to C libraries from BASIC.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;cfunction name {, name...}"));
        provider.addCompletion(new BasicCompletion(provider, "chain", null, "The chain statement transfers processing control to TCL, which interprets and executes the statement defined in the expression.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;chain tcl.exp"));
        provider.addCompletion(new BasicCompletion(provider, "clear", null, "The clear statement sets all local and common variables to 0 in a main program.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;clear"));
        provider.addCompletion(new BasicCompletion(provider, "cleardata", null, "The cleardata statement clears the data stack.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;cleardata"));
        provider.addCompletion(new BasicCompletion(provider, "clearfile", null, "The clearfile statement deletes all items in the specified file variable previously opened with an open statement.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;clearfile {file.var}"));
        provider.addCompletion(new BasicCompletion(provider, "clearselect", null, "The clearselect statement clears the active select-list specified by the list.var and releases all overflow associated with that list. Any external select-list is also cleared if the list variable is not specified.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;clearselect {list.var}"));
        provider.addCompletion(new BasicCompletion(provider, "close", null, "The close statement closes the file identified by file.var. If file.var is not specified, the file referenced by the default file.var is closed.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;close {file.var}"));
        provider.addCompletion(new BasicCompletion(provider, "commit work", null, "The commit work operation commits a transaction.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;commit {work|transaction} {then|else statement.block}"));
        provider.addCompletion(new BasicCompletion(provider, "common", null, "The common statement declares data elements to share among different FlashBASIC or BASIC modules.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;common {/ID/} var{,var...} {,array(dimension1{,dimension2})...}"));
        provider.addCompletion(new BasicCompletion(provider, "compare", null, "The compare statement compares two dynamic arrays.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;compare str.exp1 to str.exp2 {present var1} {missing var2}"));
        provider.addCompletion(new BasicCompletion(provider, "continue", null, "The continue statement restarts a loop that is under for...next or loop...repeat control.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;continue"));
        provider.addCompletion(new BasicCompletion(provider, "convert", null, "The convert statement searches a given variable and replaces each occurrence of a character by another.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;convert str.exp1 to str.exp2 in var"));
        provider.addCompletion(new BasicCompletion(provider, "crt", null, "The crt statement outputs unconditionally to the terminal display, regardless of whether or not the printer on condition is in effect.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;crt {exp{,exp..}{:}"));
        provider.addCompletion(new BasicCompletion(provider, "data", null, "The data statement queues responses for use by subsequent input requests initiated from chain, enter, execute, or input statements. The data is taken from the queue in the order in which it was added.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;data exp{,exp,...}"));
        provider.addCompletion(new BasicCompletion(provider, "debug", null, "The debug statement temporarily suspends execution of a FlashBASIC or BASIC program and invokes the FlashBASIC or BASIC debugger.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;debug"));
        provider.addCompletion(new BasicCompletion(provider, "del", null, "The del statement provides an alternate to the delete() function for deleting a location from a dynamic array.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;del dyn.array<ac.exp {,vc.exp...{,sc.exp}}>"));
        provider.addCompletion(new BasicCompletion(provider, "delete", null, "The delete statement removes a specific item from a file.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;delete {file.var}, ID.exp {on.error.clause}"));
        provider.addCompletion(new BasicCompletion(provider, "dimension", null, "The dimension statement establishes a specific number of storage locations for a matrix of variables.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;dimension array.var({rows{,cols}})"));
        provider.addCompletion(new BasicCompletion(provider, "do", null, "The optional do clause is used with the loop statement is optional."));
        provider.addCompletion(new BasicCompletion(provider, "echo", null, "The echo statement toggles terminal echo on or off.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;echo {off|on|num.exp}"));
        provider.addCompletion(new BasicCompletion(provider, "else", null, "The else clause is the inline clause for the if statement to execute when it evaluates to false.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;logical.exp else statement.block"));
        provider.addCompletion(new BasicCompletion(provider, "end", null, "The end statement indicates both the end of a series of statements executed conditionally from a then or else condition or the physical end of the program.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;end"));
        provider.addCompletion(new BasicCompletion(provider, "end case", null, "The end case statement terminates case construct.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;end case"));
        provider.addCompletion(new BasicCompletion(provider, "enter", null, "The enter statement transfers control to another cataloged FlashBASIC or BASIC program.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;enter cataloged.program.name<br>"
                + "&nbsp;&nbsp;enter @var"));
        provider.addCompletion(new BasicCompletion(provider, "eq", null, "The eq assignment operator represents either the assignment operator in an assignment statement or a relational operator in a conditional expression.<br><br><b>Synonym:</b><br>&nbsp;&nbsp;="));
        provider.addCompletion(new BasicCompletion(provider, "equate", null, "The equate statement is a compiler directive that declares a constant at compile time or a synonym of another variable or array element.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;equate symbol to char(constant) {,var to exp...}<br>"
                + "&nbsp;&nbsp;equate symbol to var"));
        provider.addCompletion(new BasicCompletion(provider, "error", null, "The error statement displays the error message from the messages file and continues execution of the program.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;error message.num,\"parameter\"{,\"parameter\"...}"));
        provider.addCompletion(new BasicCompletion(provider, "execute", null, "The execute statement temporarily pushes a level and performs any valid TCL expression, then continues execution of the FlashBASIC or BASIC program.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;execute tcl.exp {returning var} {capturing var}<br>"
                + "&nbsp;&nbsp;execute tcl.exp {[stacking|,//in.<] exp} {[passlist|,//select.<] list.var} {[rtnlist|,//select.>] list.var } {[returning|setting] var} {[capturing|,,//out.>] var}"));
        provider.addCompletion(new BasicCompletion(provider, "execute", "unix", "For Windows: Not supported.<br>The execute statement executes a UNIX command from within a FlashBASIC or BASIC program.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;execute \"!unix.command\" {capturing var} {returning var}"));
        provider.addCompletion(new BasicCompletion(provider, "exit", null, "The exit statement forces an early exit from a loop that is under for...next or loop...repeat control.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;exit"));
        provider.addCompletion(new BasicCompletion(provider, "file", null, "The file statement is a compiler directive that allows the use of attribute definition items in the file?s dictionary while compiling a program.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;file file1 {, file2...}"));
        provider.addCompletion(new BasicCompletion(provider, "filelock", null, "The filelock statement sets an exclusive lock on an entire file.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;filelock {file.var} {locked statement.block}"));
        provider.addCompletion(new BasicCompletion(provider, "fileunlock", null, "The fileunlock statement releases an exclusive lock set by the filelock statement on an entire file.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;fileunlock {file.var}"));
        provider.addCompletion(new BasicCompletion(provider, "footing", null, "The footing statement designates a text string composed of literals and special options to output at the bottom of each page.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;footing str.exp<br>"
                + "&nbsp;&nbsp;footing \"{{text} {?options?}...}\""));
        provider.addCompletion(new BasicCompletion(provider, "ge", null, "The ge relational operator denotes a greater than or equal condition between two elements.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;exp ge exp"));
        provider.addCompletion(new BasicCompletion(provider, "get", null, "The get statement gets raw characters from the specified port.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;get var{,length} {setting character.count} from port.exp {until termination.characters} {returning termination.characters} {waiting seconds.exp} {then|else statement.block}"));
        provider.addCompletion(new BasicCompletion(provider, "getx", null, "The getx statement receives input from an attached line in ASCII hexadecimal format. The statement returns an exploded ASCII hexadecimal string that allows binary data to contain a decimal 255 (x?ff?)<br><br><b>Syntax:</b><br>&nbsp;&nbsp;getx var{,length} {setting character.count} from port.exp {until termination.characters} {returning termination.characters} {waiting seconds.exp} {then|else statement.block}"));
        provider.addCompletion(new BasicCompletion(provider, "gosub", null, "The gosub statement transfers control to a local subroutine identified by a statement label within the program. Control returns to the next statement after the gosub statement when the return statement is encountered.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;gosub statement.label{:}"));
        provider.addCompletion(new BasicCompletion(provider, "goto", null,
                "The goto statement transfers control to the location in the FlashBASIC or BASIC program that begins with the given statement label.<br>On statement labels beginning with a nonnumeric value, the : following the statement.label is optional in the goto, but is required following the actual statement label.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;goto statement.label{:}"
                + "&nbsp;&nbsp;go to statement.label{:}"));
        provider.addCompletion(new BasicCompletion(provider, "gt", null, "The gt relational operator denotes a greater than condition between two elements.<br>NOTE: > is also used as a terminator for the dynamic array subscript reference.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;exp gt exp"));
        provider.addCompletion(new BasicCompletion(provider, "heading", null, "The heading statement designates a text string composed of literals and special options to output at the top of each page.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;heading str.exp<br>"
                + "&nbsp;&nbsp;heading \"{{text} {?options?}...}\""));
        provider.addCompletion(new BasicCompletion(provider, "ifr", null, "The ifr statement tests the result of a logical expression.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;ifr logical.exp [then|else] statement.block<br>"
                + "&nbsp;&nbsp;ifr logical.exp then statement.block else statement.block"));
        provider.addCompletion(new BasicCompletion(provider, "in", null, "The in statement accepts a single raw character of input from the keyboard, without displaying a prompt character or requiring pressing ENTER following the input.<br>NOTE: For Windows: Null input is not supported.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;in var {for time.exp then|else statement.block}"));
        provider.addCompletion(new BasicCompletion(provider, "input", null, "The input statement temporarily suspends execution of the program until a response is provided from the keyboard and assigns that response to a specified variable.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;input var{:}<br>"
                + "&nbsp;&nbsp;input var {=val.exp} {, length.exp} {, fill.exp} {:} {_} {for time.exp {then|else statement.block}}<br>"
                + "&nbsp;&nbsp;input @(col.exp,{row.exp}){:} var {,length.exp}{mask} {:}"));
        provider.addCompletion(new BasicCompletion(provider, "inputclear", null, "The inputclear statement clears the keyboard type-ahead buffer.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;inputclear"));
        provider.addCompletion(new BasicCompletion(provider, "inputctrl", null, "The inputctrl statement toggles on and off the ability to enter control characters on succeeding BASIC input statements.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;inputctrl on | off"));
        provider.addCompletion(new BasicCompletion(provider, "inputerr", "windows", "For Windows: When run from a trigger, from the D3 file Manager, or from a Visual Basic rule module, the inputerr statement displays a dialog box (allowing the user to specify the title, text, and buttons), then waits for input. Upon return, the system(0) function returns a numeric code indicating the user choice.<br>"
                + "NOTE: When running a FlashBASIC rule module through an ODBC connection, the rule module is executed on the server. Therefore, an inputerr displays the message box on the server, not on the client. Using a RPC connection, the rule module runs on the client and the message box displays on the client, as expected.<br>"
                + "When run from a trigger, inputerr prevents the operation from being applied to the file system, if it involves a file system update (write, clear file, delete item).<br>"
                + "inputerr has one string argument. If the argument is null, no dialog box displays. If the string is not null, it is formatted.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;inputerr {text{^title{^style}}}"));
        provider.addCompletion(new BasicCompletion(provider, "inputerr", null, "The inputerr statement displays a message on the status (bottom) line of the terminal. it meant to be used with the input@ statement<br><br><b>Syntax:</b><br>&nbsp;&nbsp;inputerr str.exp"));
        provider.addCompletion(new BasicCompletion(provider, "inputnull", null, "The inputnull statement is used with the input @ statement to define the character used to indicate a null input on subsequent input statements.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;inputnull ?character?"));
        provider.addCompletion(new BasicCompletion(provider, "inputparity", null, "The inputparity statement enables or disables the extended character set (xcs) for the current process.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;inputparity on | off"));
        provider.addCompletion(new BasicCompletion(provider, "inputtrap off", null, "The inputtrap off statement cancels the previous inputtrap statement.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;inputtrap off"));
        provider.addCompletion(new BasicCompletion(provider, "ins", null, "The ins statement is an alternative to the insert() function for inserting a string expression into a dynamic array.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;ins str.exp before dyn.array.exp<ac.exp {, vc.exp {, sc.exp}}><br>"
                + "&nbsp;&nbsp;ins str.exp before dim.array.exp(element)<ac.exp {, vc.exp {, sc.exp}}>"));
        provider.addCompletion(new BasicCompletion(provider, "key", null, "The key statement locates an item using a B-tree index key, and returns the item in a variable, providing the ability to sequentially search the items in the file based on the index.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;key(?operator?, root.var , index.key, item-ID {, vc.exp}) {then|else statement.block}"));
        provider.addCompletion(new BasicCompletion(provider, "le", null, "The le relational operator represents the less than or equal to (<=) condition.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;exp le exp"));
        provider.addCompletion(new BasicCompletion(provider, "let", null, "The let statement assigns the value of an expression to a variable.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;{let} var = exp"));
        provider.addCompletion(new BasicCompletion(provider, "locate", null, "The locate statement searches for the location of a specific string expression and returns the location in position.var.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;locate(str.exp, dyn.array.exp {, ac.exp{, vc.exp{, start.exp}}}; start.exp {; sequence.exp}) [then|else statement.block]<br>"
                + "&nbsp;&nbsp;locate str.exp in dyn.array.exp{<ac.exp{, vc.exp}>} {,start.exp} {by sequence.exp} setting position.var [then|else statement.block]<br>"
                + "&nbsp;&nbsp;locate(str.exp, dim.array.exp(element){, ac.exp{, vc.exp{, start.exp}}}; start.exp {; sequence.exp}) [then|else statement.block]<br>"
                + "&nbsp;&nbsp;locate str.exp in dim.array.exp(element){<ac.exp{, vc.exp}>} {,start.exp} {by sequence.exp} setting position.var [then|else statement.block]"));
        provider.addCompletion(new BasicCompletion(provider, "lock", null, "The lock statement sets one of 64 execution locks, in the range from 0 through 63. This prevents re-entry to the program, allowing only one process to run the program at any given time.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;lock lock.num {then|else statement.block}"));
        provider.addCompletion(new BasicCompletion(provider, "locked", null, "The locked clause is used when the requested item is locked and waiting is not desired.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;locked statement.block"));
        provider.addCompletion(new BasicCompletion(provider, "lt", null, "The lt relational operator is used in conditional expressions as an alternate form of the less than (<) condition.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;exp lt exp"));
        provider.addCompletion(new BasicCompletion(provider, "mat", null, "The mat statement assigns data to each element of a dimensioned array variable to a specific value in one operation.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;mat array.var = exp<br>"
                + "&nbsp;&nbsp;mat array.var1 = mat array.var2"));
        provider.addCompletion(new BasicCompletion(provider, "matbuild", null, "The matbuild statement converts a dimensioned array into a dynamic array.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;matbuild dyn.array.var from array.var{,start {,end}} using delimiter yn.array.var = array.var"));
        provider.addCompletion(new BasicCompletion(provider, "match", null, "The match relational operator tests a string and determines if it matches a predefined pattern of alphabetical, numeric, wildcard, or literal characters.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;str.exp1 match str.exp2"));
        provider.addCompletion(new BasicCompletion(provider, "matparse", null, "The matparse statement converts a dynamic array into a dimensioned array.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;matparse array.var {,start {,end}} from dyn.array.exp {using delimiter} {setting} var array.var = dyn.array.exp"));
        provider.addCompletion(new BasicCompletion(provider, "matread", null, "The matread statement reads the specified item from the optionally specified file.var, or if not specified, the default file.var, and stores one attribute per element in the dimensioned array.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;matread array.var from {file.var,} ID.exp {locked statement.block} {then|else statement.block}"));
        provider.addCompletion(new BasicCompletion(provider, "matwrite", null, "The matwrite statement writes an item into the specified file.var.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;matwrite array.var on {file.var,} ID.exp"));
        provider.addCompletion(new BasicCompletion(provider, "matwriteu", null, "The matwriteu statement is identical to the matwrite statement, except the item remains locked. The matwriteu form keeps the item locked if it was previously locked by a readu, readvu, or matwriteu statement within the same program.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;matwriteu array.var on {file.var,} ID.exp"));
        provider.addCompletion(new BasicCompletion(provider, "ne", null, "The ne relational operator represents a not equal to condition within relational expressions.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;exp ne exp<br><br><b>Synonyms:</b><br>"
                + "&nbsp;&nbsp;#<br>"
                + "&nbsp;&nbsp;>&lt;<br>"
                + "&nbsp;&nbsp;&lt;>"));
        provider.addCompletion(new BasicCompletion(provider, "next", null, "The next statement occurs at the end of a for...next construct and causes the iteration counter to increment and branches to the corresponding for statement to decide whether to terminate.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;for var = exp to exp {step exp}<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;statement{s}<br>"
                + "&nbsp;&nbsp;next var"));
        provider.addCompletion(new BasicCompletion(provider, "null", null, "The null statement performs no operation, other than to provide an instruction where one is required. This is usually used for program readability.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;null"));
        provider.addCompletion(new BasicCompletion(provider, "onerr", null, "The onerr clause identifies the statements to execute when an error occurs during statements that perform operations on peripheral storage devices.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;onerr statement.block"));
        provider.addCompletion(new BasicCompletion(provider, "open", null, "The open statement opens a specified file name and associates the file with the optional file.var.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;open {\"{dict}\",}file.ref {to file.var} {then|else statement.block}"));
        provider.addCompletion(new BasicCompletion(provider, "or", null, "The or logical operator indicates that only one of the components of a logical expression need be true for the expression to evaluate as true.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;exp or exp<br><br><b>Synonym:</b><br>&nbsp;&nbsp;!"));
        provider.addCompletion(new BasicCompletion(provider, "out", null, "The out statement outputs a single ASCII character derived from a numeric expression in the range of 0 through 255, which indicates its corresponding position in the ASCII table.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;out num.exp"));
        provider.addCompletion(new BasicCompletion(provider, "page", null, "The page statement terminates the current page of output, prints the optional footing, positions to the top of the form, and prints the optional heading.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;page {num.exp}"));
        provider.addCompletion(new BasicCompletion(provider, "precision", null, "The precision statement defines the number of fractional decimal places that a numerical value can hold.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;precision num.constant"));
        provider.addCompletion(new BasicCompletion(provider, "printchar", null, "The printchar statement prints the first character of the string expression to the screen or to the printer.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;printchar str.exp"));
        provider.addCompletion(new BasicCompletion(provider, "print on", null, "The print on statement directs output to one of 32,767 open print files.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;print on print.file.num print.exp"));
        provider.addCompletion(new BasicCompletion(provider, "printer", null, "The printer statement controls the output from subsequent print, heading, footing, or page statements.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;printer [on|off|close|num.exp]"));
        provider.addCompletion(new BasicCompletion(provider, "procread", null, "The procread statement reads the calling Proc?s primary input buffer and assigns its contents to a specified variable.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;procread var [then|else statement.block]"));
        provider.addCompletion(new BasicCompletion(provider, "procwrite", null, "The procwrite statement writes a string expression variable to the calling Proc?s primary input buffer.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;procwrite var"));
        provider.addCompletion(new BasicCompletion(provider, "program", null, "The program statement is optionally used on the first line of a program to indicate that this is a program.<br>It is not needed, and is ignored by the compiler. It is supported strictly for compatibility with other implementations.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;program name"));
        provider.addCompletion(new BasicCompletion(provider, "prompt", null, "The prompt statement indicates the single character to display during subsequent input statements that prompt for input from the keyboard.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;prompt character.exp"));
        provider.addCompletion(new BasicCompletion(provider, "read", null, "The read statement reads an item as a dynamic array and stores the item as a string. Each attribute is automatically an element of the dynamic array variable and can be referenced with the appropriate intrinsic functions.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;read{u} dyn.array from {file.var,} ID.exp {locked statement{s}} [then|else statement.block]"));
        provider.addCompletion(new BasicCompletion(provider, "readnext", null, "The readnext statement retrieves the next item-ID from an active list and assigns it to a specified variable.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;readnext ID.var{,value.count}{from select.var} [then|else statement.block]"));
        provider.addCompletion(new BasicCompletion(provider, "readt", null, "The readt statement reads a tape record and assigns the value returned to a specified variable.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;readt var [then|else|onerr statement.block]"));
        provider.addCompletion(new BasicCompletion(provider, "readtx", null, "The readtx statement reads a tape record converts the tape record to hexadecimal and assigns the resulting hexadecimal value to a specified variable.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;readtx var [then|else|onerr statement.block]"));
        provider.addCompletion(new BasicCompletion(provider, "readv", null, "The readv statement reads an item from the optionally-specified file variable and assigns the value contained in the attribute number referenced in the attribute expression to the specified variable.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;readv{u} var from {file.var,} ID.exp, ac.exp {locked statement.block} {then|else statement.block}"));
        provider.addCompletion(new BasicCompletion(provider, "release", null, "The release statement clears locks on items locked with a previous matreadu, readu, or readvu statement.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;release {file.var,} {ID.exp}"));
        provider.addCompletion(new BasicCompletion(provider, "rem", null, "The rem statement designates that all text that follows the statement on the same line is ignored by the compiler.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;rem text<br><br><b>Synonyms:</b><br>&nbsp;&nbsp;!<br>&nbsp;&nbsp;*"));
        provider.addCompletion(new BasicCompletion(provider, "remove", null, "The remove statement retrieves a substring delimited by a system delimiter from a dynamic array.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;remove var from dyn.array at position.var setting delimiter.var"));
        provider.addCompletion(new BasicCompletion(provider, "repeat", null, "The repeat statement defines the end of a loop. See loop Statement for more information."));
        provider.addCompletion(new BasicCompletion(provider, "replace", null, "The replace statement maintains referential integrity between items that contain bidirectional bridges used by the Update Processor by eliminating duplicate item-IDs.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;replace file.var,item-ID.old with item-ID.new"));
        provider.addCompletion(new BasicCompletion(provider, "return", null, "The return statement terminates an internal or external subroutine and returns execution control to the statement following the invoking call or gosub statement.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;return<br>"
                + "&nbsp;&nbsp;return {to statement.label}"));
        provider.addCompletion(new BasicCompletion(provider, "rewind", null, "The rewind statement rewinds the currently attached magnetic tape unit to the beginning of the tape.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;rewind [then|else|onerr statement.block]"));
        provider.addCompletion(new BasicCompletion(provider, "rollback work", null, "The rollback work statement rolls back (or undoes) a transaction.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;The rollback work statement rolls back (or undoes) a transaction."));
        provider.addCompletion(new BasicCompletion(provider, "root", null, "The root statement provides an interface to the B-tree indexes for subsequent references with the key statement.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;root file.ref,a.code to root.var {then|else statement.block}"));
        provider.addCompletion(new BasicCompletion(provider, "rqm", null, "The rqm statement suspends processing for a specific number of seconds, or until a specific time.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;rqm {num.exp}<br>"
                + "&nbsp;&nbsp;rqm {\"time.exp\"}"));
        provider.addCompletion(new BasicCompletion(provider, "select", null, "The select statement creates an active list of item-IDs, allowing sequential access to each item in the file by use of the readnext statement.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;select {var|file.var|list.var {to list.var}}"));
        provider.addCompletion(new BasicCompletion(provider, "send", null, "The send statement sends output to a specified port.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;send str.exp{:} to port.num {then|else statement.block}"));
        provider.addCompletion(new BasicCompletion(provider, "sendx", null, "The sendx statement converts the exploded ASCII hexadecimal string results of str.exp to its binary equivalent and then transmits it to the specified port. The conversion process terminates when the first nonhexadecimal character is encountered. sendx suppresses the output of a CR/LF pair. sendx does not allow the : to exist as part of the statement.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;sendx str.exp to port.num {then|else statement.block}"));
        provider.addCompletion(new BasicCompletion(provider, "setting", null, "The setting clause defines the variable to receive the index results of a get or locate statement.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;setting var"));
        provider.addCompletion(new BasicCompletion(provider, "sleep", null, "The sleep statement places a process to sleep for a specific number of seconds, or, until a specific time.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;sleep {num.exp}<br>"
                + "&nbsp;&nbsp;sleep {\"time.exp\"}<br><br>"
                + "<b>Synonym:</b><br>&nbsp;&nbsp;rqm"));
        provider.addCompletion(new BasicCompletion(provider, "spoolq", null, "The spoolq statement enables or disables the spooler entry number message.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;spoolq [off|on|exp]"));
        provider.addCompletion(new BasicCompletion(provider, "stop", null, "The stop statement stops program execution and returns to the invoking the process.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;stop<br>"
                + "&nbsp;&nbsp;stop errnum, \"parameter\"{, \"parameter\"...}"));
        provider.addCompletion(new BasicCompletion(provider, "subroutine", null, "The subroutine statement defines a program as an external subroutine.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;subroutine {(arg.list)}<br>"
                + "&nbsp;&nbsp;subroutine subroutine.name{(arg.list)}"));
        provider.addCompletion(new BasicCompletion(provider, "ta", null, "The ta statement toggles or resets the type-ahead buffer.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;ta [on|off|clear|exp]"));
        provider.addCompletion(new BasicCompletion(provider, "tcl", null, "The tcl statement executes any valid TCL command as a subroutine.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;tcl tcl.command {to dim.array.var)"));
        provider.addCompletion(new BasicCompletion(provider, "tclread", null, "The tclread statement loads the TCL command used to activate the program into a variable.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;tclread var"));
        provider.addCompletion(new BasicCompletion(provider, "then", null, "The then clause specifies which statements to execute when the conditional statement evaluates to true.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;logical.exp then statement.block"));
        provider.addCompletion(new BasicCompletion(provider, "transaction", null, "The transaction statement enables or disables participation in a transaction.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;transaction [on|off|exp]"));
        provider.addCompletion(new BasicCompletion(provider, "transaction abort", null, "<b>Example:</b><br>"
                + "&nbsp;&nbsp;transaction start tn else res = \"Failed transaction start\"; gosub failure; goto done:<br>"
                + "&nbsp;&nbsp;*<br>"
                + "&nbsp;&nbsp;* Perform series of writes<br>"
                + "&nbsp;&nbsp;* ------------------------<br>"
                + "&nbsp;&nbsp;for i = 31 to 40<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;msg = \"write \":i<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;xx = str('*',i)<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;write xx on i on error res = \"Write failed\"; gosub failure; goto done:<br>"
                + "&nbsp;&nbsp;next i<br>"
                + "&nbsp;&nbsp;*<br>"
                + "&nbsp;&nbsp;* Rollback the transaction with transaction abort<br>"
                + "&nbsp;&nbsp;* -----------------------------------------------<br>"
                + "&nbsp;&nbsp;msg = \"Transaction Abort\"<br>"
                + "&nbsp;&nbsp;transaction abort else res = \"Error with transaction abort\"; gosub failure<br>"
                + "&nbsp;&nbsp;*<br>"
                + "&nbsp;&nbsp;* Verify writes were rolled back<br>"
                + "&nbsp;&nbsp;* ------------------------------<br>"
                + "&nbsp;&nbsp;for i = 31 to 40<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;msg = \"read \":i<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;readu xx from i then res = \"Read should have failed\"; gosub failure<br>"
                + "&nbsp;&nbsp;next i"));
        provider.addCompletion(new BasicCompletion(provider, "transaction cache", null, "The transaction cache statement enables or disables the transaction read cache.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;The transaction cache statement enables or disables the transaction read cache."));
        provider.addCompletion(new BasicCompletion(provider, "transaction commit", null, "<b>Example:</b><br>"
                + "&nbsp;&nbsp;transaction start<br>"
                + "&nbsp;&nbsp;transaction cache on else msg=\"6 cache\"; goto fail<br>"
                + "&nbsp;&nbsp;write \"1\" on \"1\"<br>"
                + "&nbsp;&nbsp;read xx from \"1\" else msg=\"6 read\"; goto fail<br>"
                + "&nbsp;&nbsp;transaction rollback<br>"
                + "&nbsp;&nbsp;read xx from \"1\" then msg=\"6 read2\"; goto fail<br>"
                + "&nbsp;&nbsp;delete 1<br>"
                + "&nbsp;&nbsp;transaction start<br>"
                + "&nbsp;&nbsp;transaction cache off else msg=\"7 cache\"; goto fail<br>"
                + "&nbsp;&nbsp;write \"1\" on \"1\"<br>"
                + "&nbsp;&nbsp;read xx from \"1\" then msg=\"7 read\"; goto fail<br>"
                + "&nbsp;&nbsp;transaction commit<br>"
                + "&nbsp;&nbsp;read xx from \"1\" else msg=\"7 read2\"; goto fail<br>"
                + "&nbsp;&nbsp;delete 1"));
        provider.addCompletion(new BasicCompletion(provider, "transaction flush", null, "The transaction flush statement enables or disables the transaction flush mechanism.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;transaction flush [on|off|exp]"));
        provider.addCompletion(new BasicCompletion(provider, "transaction rollback", null, "<b>Examp?e:</b><br>"
                + "&nbsp;&nbsp;transaction start<br>"
                + "&nbsp;&nbsp;transaction cache on else msg=\"6 cache\"; goto fail<br>"
                + "&nbsp;&nbsp;write \"1\" on \"1\"<br>"
                + "&nbsp;&nbsp;read xx from \"1\" else msg=\"6 read\"; goto fail<br>"
                + "&nbsp;&nbsp;transaction rollback<br>"
                + "&nbsp;&nbsp;read xx from \"1\" then msg=\"6 read2\"; goto fail<br>"
                + "&nbsp;&nbsp;delete 1"));
        provider.addCompletion(new BasicCompletion(provider, "transaction start", null, "<b>Examp?e:</b><br>"
                + "&nbsp;&nbsp;transaction start<br>"
                + "&nbsp;&nbsp;transaction cache on else msg=\"6 cache\"; goto fail<br>"
                + "&nbsp;&nbsp;write \"1\" on \"1\"<br>"
                + "&nbsp;&nbsp;read xx from \"1\" else msg=\"6 read\"; goto fail<br>"
                + "&nbsp;&nbsp;transaction rollback<br>"
                + "&nbsp;&nbsp;read xx from \"1\" then msg=\"6 read2\"; goto fail<br>"
                + "&nbsp;&nbsp;delete 1"));
        provider.addCompletion(new BasicCompletion(provider, "unlock", null, "The unlock statement resets an execution lock, in the range 0 to 63, previously set with a lock statement.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;unlock<br>"
                + "&nbsp;&nbsp;unlock lock.num.exp"));
        provider.addCompletion(new BasicCompletion(provider, "until", null, "The until clause specifies a termination condition for a for...next or loop constructs."));
        provider.addCompletion(new BasicCompletion(provider, "weof", null, "The weof statement writes an eof (end of file) mark to the currently attached magnetic media.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;weof var [then statement.block {[else|onerr] statement.block}]"));
        provider.addCompletion(new BasicCompletion(provider, "while", null, "The while clause specifies a continuation condition in a for...next or loop construct."));
        provider.addCompletion(new BasicCompletion(provider, "write", null, "The write statement writes the item specified in dyn.array.var into the specified file, using the item-ID specified in the ID.exp.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;write dyn.array.var on {file.var,} ID.exp {on error.clause}"));
        provider.addCompletion(new BasicCompletion(provider, "writet", null, "The writet statement writes a tape record to the attached magnetic media from the specified variable.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;writet exp [then statement.block {[else|onerr.clause] statement.block}]"));
        provider.addCompletion(new BasicCompletion(provider, "writeu", null, "The writeu form of the write statement writes a dynamic array into the specified file variable and keeps items locked that were locked by a previous readu or readvu statement.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;writeu dyn.array.var on {file.var,} ID.exp {onerr.clause}"));
        provider.addCompletion(new BasicCompletion(provider, "writev", null, "The writev statement writes the value of an expression into the attribute designated in the attribute expression parameter, using the item-ID specified in ID.exp.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;writev exp ON {file.var ,} ID.exp, ac.exp"));
        provider.addCompletion(new BasicCompletion(provider, "writevu", null, "The writevu form of this statement is identical to writev, except that the item remains locked.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;writevu exp ON {file.var ,} ID.exp, ac.exp"));
        provider.addCompletion(new BasicCompletion(provider, "writex", null, "The writex statement writes the item specified in dyn.array.var into the specified file, using the item-ID specified in the ID.exp. The writex statement will wait until the actual disk update takes place before continuing execution of the program. This is used for \"critical\" write-through, such as error-logging.<br><br><b>Syntax:</b><br>&nbsp;&nbsp;writex dyn.array.var on {file.var,} ID.exp {onerr.clause}"));

        //
        // Templates
        //

        addTemplates(provider);

        //
        // Functions
        //

        // @
        provider.addCompletion(createFuncComp(provider, "@", "The @() function provides a standard means of performing control functions on a wide array of terminals.<br>"
                + "Syntax:<br>"
                + "@(num.exp{,num.exp})",
                new ParameterFunc("num.exp", "")));

        // abs
        provider.addCompletion(createFuncComp(provider, "abs", "The abs() function returns the absolute (positive) portion of the integer number derived from the given numeric expression.",
                new ParameterFunc("num.exp", "Expression resulting in an integer number.")));

        // access
        provider.addCompletion(createFuncComp(provider, "access", "The access() function provides data about the AQL or Update Processor environments when the program is called from a dictionary.<br> The access() function can only be used in subroutines that are called from a dictionary item when in AQL or the Update Processor and allows information about the controlling environment to be read and altered by the subroutine.",
                new ParameterFunc("num.exp")));

        // alpha
        provider.addCompletion(createFuncComp(provider, "alpha", "The alpha() function evaluates the expression and returns 1 (true) if every character in the string is alphabetical (that is, a?z upper and lowercase), or 0 (false) if any character is nonalphabetical. The empty (null) string (\"\") is considered nonalphabetical.",
                new ParameterFunc("exp", "String to be tested for the existence of alphabetical characters.")));

        // ascii
        provider.addCompletion(createFuncComp(provider, "ascii", "The ascii() function converts a string of EBCDIC-encoded characters into their equivalent ASCII values.<br>The ascii() function is the inverse of the ebcdic() function.<br>The ascii() function cannot determine whether the string being passed to it is already ASCII or not. Passing an ASCII string through the ascii() function produces undefined results.",
                new ParameterFunc("exp", "String of EBCDIC-encoded characters to convert.")));

        // assigned
        provider.addCompletion(createFuncComp(provider, "assigned", "The assigned() function determines if the variable has been assigned a value.<br>If var has an assigned value, a nonzero value (true) is returned. If no value is assigned, 0 (false) is returned.<br>"
                + "assigned() can tell if common variables have been previously assigned.<br>"
                + "assigned() works well in BASIC subroutines called from the call AQL processing code. It prevents files from being repeatedly opened and variables from continually being re-initialized.<br>"
                + "TIP: TigerLogic advises programmers to not rely on the assigned() function to return a specific nonzero value. Its exact value is undefined and can vary between implementations.",
                new ParameterFunc("var", "Variable to check for assignment")));

        // change
        provider.addCompletion(createFuncComp(provider, "change", "The change() function searches a string expression for the search string and then, if at the start occurrence, replaces search.str with replacement.str for the amount of occurrences specified in occurrences.<br><br><b>Synonyms:</b><br>&nbsp;&nbsp;ereplace()<br>&nbsp;&nbsp;swap()",
                new ParameterFunc("str.exp", "String in which the specified search.str is searched for."),
                new ParameterFunc("search.str", "String to search for in str.exp."),
                new ParameterFunc("replacement.str", "String to replace the specified search.str."),
                new ParameterFunc("occurrences", "Specifies the number of occurrences of search.str to be replaced by replacement.str. If not specified, defaults to 0, which replaces all found occurrences."),
                new ParameterFunc("start", "Specifies which occurrence of search string the replacement begins. If not specified, defaults to 1.")));

        // char
        provider.addCompletion(createFuncComp(provider, "char", "The char() function converts a number between 0 and 255 to its corresponding ASCII character equivalent.",
                new ParameterFunc("num.exp", "Number between 0 and 255 to be converted to the corresponding ASCII character equivalent. Numbers over 255 are adjusted into the range 0 to 255 by taking the number modulo 256.")));

        // col1
        provider.addCompletion(createFuncComp(provider, "col1", "The col1() function returns the numeric column position of the character immediately preceding the substring retrieved in the most recently executed field() function."));

        // col2
        provider.addCompletion(createFuncComp(provider, "col2", "The col2() function returns the numeric column position of the character following the substring retrieved in the most recently executed field() function."));

        // convert
        provider.addCompletion(createFuncComp(provider, "convert", "The convert() function searches a given variable and replaces each occurrence of a character by another.",
                new ParameterFunc("var", "Variable in which the specified string will be searched and replaced."),
                new ParameterFunc("str.exp1", "Specifies the characters to be replaced with the corresponding replacement characters from str.exp2."),
                new ParameterFunc("str.exp2", "Specifies the characters to replace the characters specified in str.exp1.")));

        // cos
        provider.addCompletion(createFuncComp(provider, "cos", "The cos() function calculates the trigonometric cosine of an angle of a specified numeric expression in the range 0 to 360 degrees.",
                new ParameterFunc("num.exp", "Angle from 0 through 360 from which the trigonometric cosine is to be calculated.")));

        // count
        provider.addCompletion(createFuncComp(provider, "count", "The convert() function searches a given variable and replaces each occurrence of a character by another.",
                new ParameterFunc("str.exp1", "Specifies the string expression in which to search for occurrences of str.exp2."),
                new ParameterFunc("str.exp2", "Specifies the string expression to locate within str.exp1.")));

        // date
        provider.addCompletion(createFuncComp(provider, "date", "The date() function returns the current system date in internal format as an integer number representing the number of days that have elapsed since December 31, 1967 (day 0 on the D3 calendar)."));

        // dcount
        provider.addCompletion(createFuncComp(provider, "dcount", "The dcount() function returns the number of occurrences of the delimiter specified in str.exp2 within str.exp1, plus one.",
                new ParameterFunc("str.exp1", "Specifies the string expression, plus one, in which to search for the delimiter specified in str.exp2."),
                new ParameterFunc("str.exp2", "Specifies the delimiter to locate within str.exp1.")));

        // delete
        provider.addCompletion(createFuncComp(provider, "delete", "The delete() function removes a specific attribute, value, or subvalue from a dimensioned or dynamic array.<br>"
                + "Syntax:<br>"
                + "delete(dyn.array.exp, ac.exp)<br>"
                + "delete(dyn.array.exp, ac.exp, vc.exp)<br>"
                + "delete(dyn.array.exp, ac.exp, vc.exp, sc.exp)<br>",
                new ParameterFunc("dyn.array.exp", "Dynamic array from which the specified attribute, value, or subvalue will be deleted."),
                new ParameterFunc("ac.exp", "Attribute to delete."),
                new ParameterFunc("vc.exp", "Value to delete."),
                new ParameterFunc("sc.exp", "Subvalue to delete.")));

        // dquote
        provider.addCompletion(createFuncComp(provider, "dquote", "The dquote() function extracts a double-quoted string from str.exp.",
                new ParameterFunc("str.exp", "String from which to extract the double-quoted string.")));

        // dtx
        provider.addCompletion(createFuncComp(provider, "dtx", "The dtx() function converts a given decimal number to its corresponding hexadecimal equivalent. The number is first converted to an integer by truncating the fractional part.",
                new ParameterFunc("num.exp", "Specifies the decimal number to be converted to its corresponding hexadecimal equivalent. In the range {+/-}140737488355327*(10(-p)), where p represents the precision number.")));

        // ebcdic
        provider.addCompletion(createFuncComp(provider, "ebcdic", "The ebcdic() function converts a string of ASCII-encoded characters into their equivalent EBCDIC values.",
                new ParameterFunc("str.exp", "String of ASCII-encoded characters to convert into their equivalent EBCDIC values.")));

        // ereplace
        provider.addCompletion(createFuncComp(provider, "ereplace", "The ereplace() function searches a string expression for the search string and then, if at the start occurrence, replaces search.str with replacement.str for the amount of occurrences specified in occurrences.<br>"
                + "Syntax:<br>"
                + "ereplace(str.exp, search.str, replacement.str {,occurrences {,start}})<br>"
                + "Synonym(s): change(), swap()",
                new ParameterFunc("str.exp", "String in which the specified search.str is searched for."),
                new ParameterFunc("search.str", "String to search for in str.exp."),
                new ParameterFunc("replacement.str", "String to replace the specified search.str."),
                new ParameterFunc("occurrences", "Specifies the number of occurrences of search.str to be replaced by replacement.str. If not specified, defaults to 0, which replaces all found occurrences."),
                new ParameterFunc("start", "Specifies which occurrence of search string the replacement begins. If not specified, defaults to 1.")));

        // error
        provider.addCompletion(createFuncComp(provider, "error", "The error() function retrieves the TCL command used to activate the program and loads it into a specified variable."));

        // exchange
        provider.addCompletion(createFuncComp(provider, "exchange", "The exchange() function replaces the characters specified in str.exp1 with the characters specified in str.exp2.",
                new ParameterFunc("var", "Variable in which the specified string will be searched and replaced."),
                new ParameterFunc("str.exp1", "Specifies the characters to be replaced with the corresponding replacement characters from str.exp2."),
                new ParameterFunc("str.exp2", "Specifies the characters to replace the characters specified in str.exp1.")));

        // exp
        provider.addCompletion(createFuncComp(provider, "exp", "The exp() function returns the exponential of a numeric expression, that is, base e, which is 2.718281828 rounded to precision to the power of the numeric expression.",
                new ParameterFunc("num.exp", "Value of the expression in the range {+/-}140737488355327*(10(-p)), where p is the precision.")));

        // extract
        provider.addCompletion(createFuncComp(provider, "extract", "The extract() function retrieves a specific attribute, value, or subvalue from a dimensioned or dynamic array.<br>"
                + "Syntax:<br>"
                + "extract(dyn.array.exp, ac.exp)<br>"
                + "extract(dyn.array.exp, ac.exp, vc.exp)<br>"
                + "extract(dyn.array.exp, ac.exp, vc.exp, sc.exp)<br>",
                new ParameterFunc("dyn.array.exp", "Array from which the specified attribute, value, or subvalue is extracted."),
                new ParameterFunc("ac.exp", "Attribute to extract."),
                new ParameterFunc("vc.exp", "Value to extract."),
                new ParameterFunc("sc.exp", "Subvalue to extract.")));

        // field
        provider.addCompletion(createFuncComp(provider, "field", "The field() function returns a substring from a string expression, by specifying a delimiter and the desired occurrence.",
                new ParameterFunc("str.exp", "String from which the substring will be returned."),
                new ParameterFunc("search.delimiter", "Delimiter to search for. The delimiter is limited to a single character. Any additional characters are ignored."),
                new ParameterFunc("num.delimiters", "Number of delimiters to skip, minus one, prior to substring extraction."),
                new ParameterFunc("num.substr", "Number of substrings separated by the specified delimiter to be returned.")));

        // fmt
        provider.addCompletion(createFuncComp(provider, "fmt", "The fmt() function is identical to performing a FlashBASIC or BASIC mask.",
                new ParameterFunc("str.exp", "Expression to be formatted."),
                new ParameterFunc("mask.exp", "Formatting (mask) to apply to the str.exp.")));

        // fold
        provider.addCompletion(createFuncComp(provider, "fold", "The fold() function folds a string expression into a string of a given length.",
                new ParameterFunc("str.exp", "String to be folded."),
                new ParameterFunc("fold.length.exp", "Length to which the string expression is folded. If omitted, it defaults to 25. Multiple numeric expressions, separated by value marks, can be specified in this parameter."),
                new ParameterFunc("delimiter", "Delimiter used in the folded text.")));

        // iconv
        provider.addCompletion(createFuncComp(provider, "iconv", "The iconv() function converts a value from its external format to its internal equivalent, according to the processing code being applied.",
                new ParameterFunc("str.exp", "Specifies the external value to convert to its equivalent internal value."),
                new ParameterFunc("conv.exp", "Specifies the processing code to use for the conversion.")));

        // index
        provider.addCompletion(createFuncComp(provider, "index", "The index() function searches through a given str.exp for the occurrence of the character or substring specified by substr.exp and if found, returns the numeric position where the nth occurrence of the substring begins. Null strings are skipped.",
                new ParameterFunc("str.exp", "String to search."),
                new ParameterFunc("substr.exp", "Character or substring to search for in str.exp."),
                new ParameterFunc("num.exp", "Specifies the particular occurrence of the character or substring to find (nth occurrence). If not found, 0 is returned.")));

        // inmat
        provider.addCompletion(createFuncComp(provider, "inmat", "The inmat() function returns information about arrays.<br>"
                + "Syntax:<br>"
                + "inmat()<br>"
                + "inmat(array.var)<br>",
                new ParameterFunc("array.var", "Specifying an array variable returns the dimensions of that array.")));

        // insert
        provider.addCompletion(createFuncComp(provider, "insert", "The insert() function inserts the element referenced by str.exp into a specific attribute, value, or subvalue location in dyn.array.exp.<br>"
                + "Syntax:<br>"
                + "insert(dyn.array.exp, ac.exp; str.exp)<br>"
                + "insert(dyn.array.exp, ac.exp, vc.exp; str.exp)<br>"
                + "insert(dyn.array.exp, ac.exp, vc.exp, sc.exp; str.exp)<br>",
                new ParameterFunc("dyn.array.exp", "Dynamic array in which the element will be inserted."),
                new ParameterFunc("ac.exp", "Attribute in which the element will be inserted."),
                new ParameterFunc("vc.exp", "Value in which the element will be inserted."),
                new ParameterFunc("sc.exp", "Subvalue in which the element will be inserted."),
                new ParameterFunc("str.exp", "Element to insert in the dynamic array.")));

        // int
        provider.addCompletion(createFuncComp(provider, "int", "The int() function returns the numeric integer equivalent from a given expression.",
                new ParameterFunc("num.exp", "Expression whose numeric integer equivalent is returned.")));

        // len
        provider.addCompletion(createFuncComp(provider, "len", "The len() function returns the length of a string expression.",
                new ParameterFunc("str.exp", "Expression whose length is returned.")));

        // ln
        provider.addCompletion(createFuncComp(provider, "ln", "The ln() function returns the natural logarithm (base e, which is 2.718281828 rounded to precision) of a given numeric expression.",
                new ParameterFunc("num.exp", "Number to be converted to its natural logarithm form.")));

        // maximum
        provider.addCompletion(createFuncComp(provider, "maximum", "The maximum() function returns the maximum of a list of numbers delimited by attribute, value, or subvalue marks. If different orders of marks are present, the maximum() function returns the maximum of all fields, regardless of delimiter.<br>NOTE: This function requires a nondefault compiler $options setting.",
                new ParameterFunc("str.exp")));

        // minimum
        provider.addCompletion(createFuncComp(provider, "minimum", "The minimum() function returns the minimum of a list of numbers delimited by attribute, value, or subvalue marks. If different orders of marks are present, the minimum() function returns the minimum of all fields, regardless of delimiter.<br>NOTE: This function requires a nondefault compiler $options setting.",
                new ParameterFunc("str.exp")));

        // mod
        provider.addCompletion(createFuncComp(provider, "mod", "The mod() function returns the remainder portion of the result of dividing one number by another.",
                new ParameterFunc("dividend", "Number to be divided by the number specified in divisor."),
                new ParameterFunc("divisor", "Number used to divide the number specified in dividend.")));

        // not
        provider.addCompletion(createFuncComp(provider, "not", "The not() function returns the logical inverse of the normal outcome of true and false generated by a logical expression.",
                new ParameterFunc("logical.exp", "Expression to test.")));

        // num
        provider.addCompletion(createFuncComp(provider, "num", "The num() function evaluates an expression and returns 1 (true) if it is a decimal numeric. Otherwise, it returns 0, if the expression contains any nonnumeric characters.",
                new ParameterFunc("exp", "Expression to test. If it is a decimal numeric, 1 (true) is returned. If it contains any nonnumeric characters, 0 is returned.")));

        // occurs
        provider.addCompletion(createFuncComp(provider, "occurs", "The occurs() function searches a string for attributes or values that occur consecutively.",
                new ParameterFunc("str.exp", "String to search."),
                new ParameterFunc("num.exp", "Numeric expression that specifies the number of occurrences.")));

        // oconv
        provider.addCompletion(createFuncComp(provider, "oconv", "The oconv() function converts a value from its internal format to its external equivalent, according to the processing code being applied.",
                new ParameterFunc("str.exp", "String to convert from its internal format to its external equivalent."),
                new ParameterFunc("conv.exp", "Processing code used in the conversion.")));

        // pwr
        provider.addCompletion(createFuncComp(provider, "pwr", "The pwr() function raises a value contained in an expression to the power of the value of a second expression.",
                new ParameterFunc("num.exp", "Value to raise to the power of the value of power.exp."),
                new ParameterFunc("power.exp", "Value whose power is applied to the value of num.exp.")));

        // rem
        provider.addCompletion(createFuncComp(provider, "rem", "The rem() function returns the remainder portion of the result of dividing one number by another.",
                new ParameterFunc("dividend", "Number to be divided by the number specified in divisor."),
                new ParameterFunc("divisor", "Number used to divide the number specified in dividend.")));

        // replace
        provider.addCompletion(createFuncComp(provider, "replace", "The replace() function inserts or replaces a specific attribute, value, or subvalue in the string referenced by dyn.array.exp with the value referenced in str.exp.<br>"
                + "Syntax:<br>"
                + "replace(dyn.array.exp, ac.exp; str.exp)<br>"
                + "replace(dyn.array.exp, ac.exp, vc.exp; str.exp)<br>"
                + "replace(dyn.array.exp, ac.exp, vc.exp, sc.exp, str.exp)<br>",
                new ParameterFunc("dyn.array.exp", "Attribute, value, or subvalue to replace with the value in str.exp."),
                new ParameterFunc("ac.exp", "Attribute (or, the attribute that contains the value or subvalue) that contains the specified dyn.array.exp to replace."),
                new ParameterFunc("vc.exp", "Value (or, the value that contains the subvalue) that contains the specified dyn.array.exp to replace."),
                new ParameterFunc("sc.exp", "Subvalue that contains the specified dyn.array.exp to replace."),
                new ParameterFunc("str.exp", "Value to replace the value specified in dyn.array.exp.")));

        // rnd
        provider.addCompletion(createFuncComp(provider, "rnd", "The rnd() function generates a random number.",
                new ParameterFunc("num.exp", "Specifies the maximum number minus one from which the rnd() function creates a random number. The minimum number is always 0. the maximum value allowed is 32,000.")));

        // scan
        provider.addCompletion(createFuncComp(provider, "scan", "The scan() function searches through a specified str.exp for the first occurrence of up to three user-definable characters specified by search.delimiters in addition to the system delimiters value, subvalue, and attribute.",
                new ParameterFunc("str.exp", "Specifies the string to search."),
                new ParameterFunc("search.delimiters", "Specifies up to three user-definable characters to be searched for in addition to the system delimiters value, subvalue, and attribute. The user-defined characters must be separated by a system delimiter (? \" \\).")));

        // sentence
        provider.addCompletion(createFuncComp(provider, "sentence", "The sentence() function is identical to performing a tclread statement. It returns the TCL command used to activate the program into a variable."));

        // seq
        provider.addCompletion(createFuncComp(provider, "seq", "The seq() function converts any ASCII character to its corresponding numeric equivalent in the range 0 through 255.",
                new ParameterFunc("ascii.character.exp", "Specifies the ASCII character to convert to its corresponding numeric equivalent in the range 0 through 255.")));

        // sin
        provider.addCompletion(createFuncComp(provider, "sin", "The sin() function calculates the sine of an angle specified in degrees.",
                new ParameterFunc("num.exp", "Specifies the angle used to calculate the sine. If the expression is less than 0 or greater than 360 degrees, mod(exp,360) is used to adjust it to this range before the sine is calculated.")));

        // soundex
        provider.addCompletion(createFuncComp(provider, "soundex", "The soundex() function returns the 4-digit soundex code for a phonetic string expression.",
                new ParameterFunc("str.exp", "Specifies the phonetic string expression from which the 4-digit soundex code is returned."),
                new ParameterFunc("code", "Provides backward compatibility. Options are:<br>0 - Original census soundex (default)<br>1 - English-language soundex.")));

        // sort
        provider.addCompletion(createFuncComp(provider, "sort", "The sort() function sorts an attribute or value mark delimited str.exp in ascending order.<br>"
                + "Syntax:<br>"
                + "sort(str.exp)<br>"
                + "sort(str.exp, ac.exp, vc.exp, sequence.exp)",
                new ParameterFunc("str.exp", "Attribute or value mark to sort in ascending order."),
                new ParameterFunc("ac.exp", "Attribute (or, the attribute that contains the value or subvalue) that contains the specified str.exp to replace."),
                new ParameterFunc("vc.exp", "Value (or, the value that contains the subvalue) that contains the specified str.exp to replace."),
                new ParameterFunc("sequence.exp", "Sequence expression.")));

        // space
        provider.addCompletion(createFuncComp(provider, "space", "The space() function generates a string of spaces of a length equal to the value of the numeric expression.",
                new ParameterFunc("num.exp", "Specifies the number of spaces in the generated string.")));

        // sqrt
        provider.addCompletion(createFuncComp(provider, "sqrt", "The sqrt() function calculates the square root of a given numeric expression.",
                new ParameterFunc("num.exp", "Numeric expression from which the square root is calculated. If num.exp is negative, the function returns 0 and prints an error message.")));

        // squote
        provider.addCompletion(createFuncComp(provider, "squote", "The squote() function extracts a single-quoted string from str.exp.",
                new ParameterFunc("str.exp", "String to be searched for in single quotation marks.")));

        // status
        provider.addCompletion(createFuncComp(provider, "status", "The status() function returns the value of system(0)."));

        // str
        provider.addCompletion(createFuncComp(provider, "str", "The str() function repeats a str.exp the number of times specified in num.exp.",
                new ParameterFunc("str.exp", "String to repeat."),
                new ParameterFunc("num.exp", "Number of times to repeat the string.")));

        // sum
        provider.addCompletion(createFuncComp(provider, "sum", "The sum() function returns the sum of a list of numbers delimited by attribute, value, or subvalue marks. If different orders of marks are present, the sum() function computes the sum of each sublist.",
                new ParameterFunc("str.exp", "List of numbers, delimited by attribute, value, or subvalue marks, from which the sum is calculated.")));

        // summation
        provider.addCompletion(createFuncComp(provider, "summation", "The summation() function returns the sum of a list of numbers delimited by attribute, value, or subvalue marks.",
                new ParameterFunc("str.exp", "List of numbers, delimited by attribute, value, or subvalue marks, from which the sum is calculated.")));

        // swap
        provider.addCompletion(createFuncComp(provider, "swap", "The swap() function searches a string expression for the search string and then, if at the start occurrence, replaces search.str with replacement.str for the amount of occurrences specified in occurrences.<br>"
                + "Syntax:<br>"
                + "swap(str.exp, search.str, replacement.str {,occurrences {,start}})",
                new ParameterFunc("str.exp", "String in which the specified search.str is searched for."),
                new ParameterFunc("search.str", "String to search for in str.exp."),
                new ParameterFunc("replacement.str", "String to replace the specified search.str."),
                new ParameterFunc("occurrences", "Specifies the number of occurrences of search.str to be replaced by replacement.str. If not specified, defaults to 0, which replaces all found occurrences."),
                new ParameterFunc("start", "Specifies which occurrence of search string the replacement begins. If not specified, defaults to 1.")));

        // system
        provider.addCompletion(createFuncComp(provider, "system", "The system() function provides an interface to a number of system variables, depending upon the requested numeric argument.",
                new ParameterFunc("num.exp", "See documentation.")));

        // tan
        provider.addCompletion(createFuncComp(provider, "tan", "The tan() function calculates the trigonometric tangent of the angle specified in degrees.",
                new ParameterFunc("num.exp", "Angle, specified in degrees from 0?360, to calculate its trigonometric tangent.")));

        // time
        provider.addCompletion(createFuncComp(provider, "time", "The time() function returns the current system time in its internal format, representing the number of seconds past midnight.",
                new ParameterFunc("var", "Variable to which the internal system time is returned.")));

        // timedate
        provider.addCompletion(createFuncComp(provider, "timedate", "The timedate() function returns the current system time and date in external format (hh:mm:ss dd mmm yyyy).",
                new ParameterFunc("var", "Variable to which the external time and date is returned.")));

        // trim
        provider.addCompletion(createFuncComp(provider, "trim", "The trim() function removes leading, trailing, and/or redundant characters from a string.<br>"
                + "Syntax:<br>"
                + "trim(str.exp, {trimchar {,type}})<br>"
                + "trim(str.exp, \"process.code\")",
                new ParameterFunc("str.exp", "String from which the specified characters are removed."),
                new ParameterFunc("trimchar", "Specifies the specific leading, trailing, or redundant character to trim. If specified, then that character substitutes for the space."),
                new ParameterFunc("type", "If specified, then the trim() behavior can be controlled more specifically. If not specified, then type R is assumed. Available values are:<br>"
                + "A - Trim all.<br>"
                + "B - Trim leading and trailing.<br>"
                + "L - Trim leading.<br>"
                + "T - Trim trailing.<br>"
                + "R - Trim redundant.<br>"),
                new ParameterFunc("process.code", "The process code is a masking conversion used for both numeric and text string formatting.<br>"
                + "l - Left justification is used primarily for text strings<br>"
                + "r - Right justification is typically used to process decimal numbers."),
                new ParameterFunc("format.mask", "Special fill operators listed below. Maximum 32,767.<br>"
                + "#n - Justify data in a field of n spaces.<br>"
                + "*n - Justify data in a field of n asterisks (*).<br>"
                + "%n - Justify data in a field of n zeroes (0).")));

        // trimb
        provider.addCompletion(createFuncComp(provider, "trimb", "The trimb() function removes trailing spaces from a string.",
                new ParameterFunc("str.exp", "Specifies the string from which trailing spaces are removed.")));

        // trimf
        provider.addCompletion(createFuncComp(provider, "trimf", "The trimf() function removes leading spaces from a string.",
                new ParameterFunc("str.exp", "Specifies the string from which leading spaces are removed.")));

        // xtd
        provider.addCompletion(createFuncComp(provider, "xtd", "The xtd() function converts an expression from its hexadecimal format into its equivalent decimal format.",
                new ParameterFunc("str.exp", "Hexadecimal expression to convert to decimal format.")));

        return provider;

    }

    private FunctionCompletion createFuncComp(DefaultCompletionProvider provider, String nome, String descricao, ParameterizedCompletion.Parameter... p) {

        FunctionCompletion fc = new FunctionCompletion(provider, nome, "");
        List params = new ArrayList<ParameterizedCompletion.Parameter>();
        params.addAll(Arrays.asList(p));
        fc.setParams(params);
        fc.setShortDescription(descricao);
        return fc;

    }

    public void loadRecord() {

        try {

            if (record.equals("NEW.RECORD")) {

                setTitle(account + "," + programsFile + ", NEW.RECORD");
                return;

            }

            if (Connection.getSession() != null) {

                file = Connection.getSession().openFile(account, programsFile);
                item = new D3Item();
                int r = file.readu(record, item);

                if (r == D3Constants.READ_RECORDLOCKED) {

                    JOptionPane.showMessageDialog(null, "The record " + account + "," + programsFile + ", " + record + " is currently used by another process.", "Load record", JOptionPane.ERROR_MESSAGE);
                    dispose();

                } else {

                    item = new D3Item();
                    r = file.readu(record, item);

                    if (r == D3Constants.READ_RECORDLOCKED) {

                        JOptionPane.showMessageDialog(null, "The record " + account + "," + programsFile + ", " + record + " is currently used by another process.", "Load record", JOptionPane.ERROR_MESSAGE);
                        dispose();

                    } else {

                        String code = "";
                        boolean isFirst = true;

                        for (int c = 1; c <= item.AMCount(); c++) {

                            // Do not add last line break
                            if (!isFirst | (isFirst = false)) {
                                code += "\n";
                            }
                            code += item.extract(c);

                        }

                        textPane.setText(code);
                        textPane.setCaretPosition(0);
                        setTitle(account + "," + programsFile + ", " + record);

                        um.die();

                    }

                }

            }

        } catch (D3Exception e) {
            JOptionPane.showMessageDialog(null, "Could not load " + account + "," + file + ", " + record + ": " + e.getMessage(), "Load", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void save(boolean saveAs) {

        int carretPos = 0;

        try {

            carretPos = textPane.getCaretPosition();

            if (record.equals("NEW.RECORD")) {
                saveAs = true;
            }

            if (Connection.getSession() != null) {

                file = Connection.getSession().openFile(account, programsFile);
                item = new D3Item();
                item.insert(1, "");

                Scanner s = new Scanner(textPane.getText());
                int c = 1;

                while (s.hasNextLine()) {

                    item.replace(c, s.nextLine());
                    c++;

                }

                if (saveAs == true) {

                    String recordName = JOptionPane.showInputDialog(null, "Enter the record name:", record);

                    if (recordName != null && !recordName.equals("")) {

                        // If try to save the record with different name, check if it exists
                        if (!record.equalsIgnoreCase(recordName)) {

                            if (file.testExist(recordName)) {

                                int r = JOptionPane.showConfirmDialog(null, "The record " + recordName + " already exists in the file " + account + "," + programsFile + ". Overwrite?", "Save as", JOptionPane.YES_NO_OPTION);

                                if (r == JOptionPane.YES_OPTION) {

                                    // Checks if the file to be overwritten is locked
                                    D3Item itemTemp = new D3Item();
                                    int w = file.readu(recordName, itemTemp);

                                    if (w == D3Constants.READ_RECORDLOCKED) {

                                        JOptionPane.showMessageDialog(null, "The record " + account + "," + programsFile + ", " + recordName + " is currently used by another process.", "Overwrite", JOptionPane.ERROR_MESSAGE);

                                    } else {

                                        // Releases the current file
                                        file.release(record);
                                        // Writes the new file
                                        file.write(recordName, item);
                                        // Updates the name of the file
                                        record = recordName;
                                        // Reload to block
                                        loadRecord();
                                        // Updates other editors
                                        FrmMain.updateEditor(getTitle());

                                    }

                                }

                            } else {

                                file.release(record);
                                file.write(recordName, item);
                                record = recordName;
                                loadRecord();

                            }

                            // If the same name only saves over
                        } else {

                            file.write(recordName, item);
                            // Reloads because the write removes the lock
                            loadRecord();

                        }

                    }

                } else {

                    file.write(record, item);
                    loadRecord();

                }

                changedWithoutSave = false;
                btSave.setEnabled(false);

            }

        } catch (D3Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to save the " + account + "," + file + ", " + record + ": " + e.getMessage(), "Save", JOptionPane.ERROR_MESSAGE);
        } finally {
            textPane.setCaretPosition(carretPos);
        }

    }

    public String getPath() {
        return getTitle();
    }

    private void compile() {

        int carretPos = 0;

        try {

            carretPos = textPane.getCaretPosition();

            if (Connection.getSession() != null) {

                save(false);

                file.release(record);
                String cmd = "compile " + account + "," + programsFile + ", " + record;
                FrmMain.setMessage(cmd);
                String reply = Connection.getSession().execute(cmd);

                // Reloads to block
                loadRecord();
                item = new D3Item(reply);

                String message = "";
                boolean isFirst = true;

                for (int c = 1; c <= item.AMCount(); c++) {

                    // Do not add last line break
                    if (!isFirst | (isFirst = false)) {
                        message += "\n";
                    }

                    message += item.extract(c);

                }

                FrmMain.setMessage(message);

            }

        } catch (D3Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to compile the " + account + "," + file + ", " + record + ": " + e.getMessage(), "Compile", JOptionPane.ERROR_MESSAGE);
        } finally {
            textPane.setCaretPosition(carretPos);
        }

    }

    private void findNext() {

        //If the word to be searched is not there then simply return
        if (txFind.getText().isEmpty()) {
            return;
        }

        // Get the text from the text area.
        String context = textPane.getText();
        currentPos = textPane.getCaretPosition();

        //If the end of the string is reached then simply return
        if (currentPos > context.length()) {
            return;
        }

        //The word entered by the user is the word that needs to be found and this word is stored in the string wordToFind. 
        String wordToFind = txFind.getText();

        // find the word entered by the user in context from the current position
        if (chkCaseSensitive.isSelected()) {
            pos = context.indexOf(wordToFind, currentPos);
        } else {
            pos = context.toLowerCase().indexOf(wordToFind.toLowerCase(), currentPos);
        }

        // This block below checks whether the word is found or not.
        //If the word is found then the value of pos is a nonnegative value as shown below .
        if (pos != -1) {
            // The word that has been found is highlighted in the text area.
            textPane.setSelectionStart(pos);
            textPane.setSelectionEnd(pos + wordToFind.length());
            textPane.requestFocusInWindow();
            //Now after the word has been found inorder that the user should find the next occurence of 
            //the given word increment the value of currentPos by 1 so that the search continues from next position
            //and not from begining when the user clicks the Next Button.
            currentPos = pos + 1;
        } else {
            //If the word to be found is not found then display the message given below.
            JOptionPane.showMessageDialog(this, "Nenhuma ocorrência de \"" + wordToFind + "\"", "Localizar/Substituir", JOptionPane.INFORMATION_MESSAGE);
        }

        btNext.requestFocusInWindow();
    }

    private void replace() {

        if (!txFind.getText().isEmpty()
                || !txReplace.getText().isEmpty()) {

            String replaceWord = txReplace.getText();
            //String wordToReplace = txFind.getText();

            if (pos != -1) {
                textPane.replaceSelection(replaceWord);
            }

        }

    }

    private void replaceAll() {

        if (chkCaseSensitive.isSelected()) {
            textPane.setText(textPane.getText().replaceAll(txFind.getText(), txReplace.getText()));
        } else {
            textPane.setText(textPane.getText().replaceAll("(?i)" + txFind.getText(), txReplace.getText()));
        }
    }

    private void addTemplates(DefaultCompletionProvider provider) {

        // print...
        provider.addCompletion(new TemplateCompletion(provider, "print", "print",
                "print '${cursor}'",
                "", "The print statement directs output of an expression to the current output device.<br><br>"
                + "<b>Syntax:</b><br>"
                + "&nbsp;&nbsp;print {exp {,}{:}}{exp{,}{:}...}"));

        // for...next...until
        provider.addCompletion(new TemplateCompletion(provider, "for", "for...next...until",
                "for ${var} = ${num.exp1} to ${num.exp2} ${step num.exp3} until ${logical.exp}\n  ${cursor}\nnext ${var}",
                "", "for...next...until is a conditional incremental loop statement. It executes when the expression following the until clause evaluates to false. The until clause must appear on the same line as the for...next statement.<br><br>"
                + "<b>General Form:</b><br>"
                + "&nbsp;&nbsp;for var = num.exp to num.exp {step num.exp}...<br>"
                + "&nbsp;&nbsp;...until logical.exp<br>"
                + "&nbsp;&nbsp;statement{s}<br>"
                + "&nbsp;&nbsp;.<br>"
                + "&nbsp;&nbsp;.<br>"
                + "&nbsp;&nbsp;next var"));

        // for...next...while
        provider.addCompletion(new TemplateCompletion(provider, "for", "for...next...while",
                "for ${var} = ${num.exp1} to ${num.exp2} ${step num.exp3} while ${logical.exp}\n  ${cursor}\nnext ${var}",
                "", "for...next...while is also a conditional incremental loop statement. It executes when the expression following the while evaluates to true. Like the until clause, the while statement must appear on the same line as the for ... next statement.<br><br>"
                + "<b>General Form:</b><br>"
                + "&nbsp;&nbsp;for var = num.exp to num.exp {step num.exp}...<br>"
                + "&nbsp;&nbsp;...while logical.exp<br>"
                + "&nbsp;&nbsp;statement{s}<br>"
                + "&nbsp;&nbsp;.<br>"
                + "&nbsp;&nbsp;.<br>"
                + "&nbsp;&nbsp;next var"));

        // on...gosub
        provider.addCompletion(new TemplateCompletion(provider, "on", "on...gosub",
                "on ${exp} gosub ${cursor}",
                "", "The on... gosub statement transfers control to a local subroutine designated by a specific statement label according to the positional value returned by the expression. The syntax can also be specified as on...go sub...(allowing a space between go and sub).<br><br>"
                + "<b>Syntax:</b><br>"
                + "&nbsp;&nbsp;on exp gosub statement.label{,statement.label...}<br>"
                + "&nbsp;&nbsp;on exp gosub statement.label,...,statement.label,statement.label"));

        // on...goto
        provider.addCompletion(new TemplateCompletion(provider, "on", "on...goto",
                "on ${exp} goto ${cursor}",
                "", "The on...goto statement transfers control to the line within the FlashBASIC or BASIC program that begins with the specified statement label, according to the positional value of the expression referenced by exp. The syntax can also be specified as on...go to...(allowing a space between go and to).<br>The on...goto is identical to the on...gosub, except there is no return required.<br><br>"
                + "<b>Syntax:</b><br>"
                + "&nbsp;&nbsp;on exp goto statement.label{,statement.label...}<br>"
                + "&nbsp;&nbsp;on exp goto statement.label,...,statement.label,statement.label"));

        // if...then - single-line form 1
        provider.addCompletion(new TemplateCompletion(provider, "if", "if...then",
                "if ${logical.exp} then ${cursor}",
                "", "The if statement tests the result of a logical expression. Depending on whether the expression evaluates to either true or false, the statements following the then or else clauses respectively are executed.<br><br>"
                + "<b>The single-line form 1:</b><br>"
                + "&nbsp;&nbsp;if logical.exp then statement.block"));

        // if...else - single-line form 2
        provider.addCompletion(new TemplateCompletion(provider, "if", "if...else",
                "if ${logical.exp} else ${cursor}",
                "", "The if statement tests the result of a logical expression. Depending on whether the expression evaluates to either true or false, the statements following the then or else clauses respectively are executed.<br><br>"
                + "<b>The single-line form 2:</b><br>"
                + "&nbsp;&nbsp;if logical.exp else statement.block"));

        // if...then...else - single-line form 3
        provider.addCompletion(new TemplateCompletion(provider, "if", "if...then...else",
                "if ${logical.exp} then ${cursor} else ",
                "", "The if statement tests the result of a logical expression. Depending on whether the expression evaluates to either true or false, the statements following the then or else clauses respectively are executed.<br><br>"
                + "<b>The single-line form 3:</b><br>"
                + "&nbsp;&nbsp;if logical.exp then statement.block else statement.block"));

        // if...then...else - multi-line form 1
        provider.addCompletion(new TemplateCompletion(provider, "if", "if...then...else",
                "if ${logical.exp} then ${cursor} else\n  \nend",
                "", "The if statement tests the result of a logical expression. Depending on whether the expression evaluates to either true or false, the statements following the then or else clauses respectively are executed.<br><br>"
                + "<b>The multi-line form 1:</b><br>"
                + "&nbsp;&nbsp;if logical.exp then statement.block else<br>&nbsp;&nbsp;&nbsp;&nbsp;statement.block<br>&nbsp;&nbsp;end"));

        // if...then...else - multi-line form 2
        provider.addCompletion(new TemplateCompletion(provider, "if", "if...then...else",
                "if ${logical.exp} then\n  ${cursor}\nend else ",
                "", "The if statement tests the result of a logical expression. Depending on whether the expression evaluates to either true or false, the statements following the then or else clauses respectively are executed.<br><br>"
                + "<b>The multi-line form 2:</b><br>"
                + "&nbsp;&nbsp;if logical.exp then<br>&nbsp;&nbsp;&nbsp;&nbsp;statement.block<br>&nbsp;&nbsp;end else statement.block"));

        // if...then...else - multi-line form 3
        provider.addCompletion(new TemplateCompletion(provider, "if", "if...then...else",
                "if ${logical.exp} then\n  ${cursor}\nend else\n  \nend",
                "", "The if statement tests the result of a logical expression. Depending on whether the expression evaluates to either true or false, the statements following the then or else clauses respectively are executed.<br><br>"
                + "<b>The multi-line form 3:</b><br>"
                + "&nbsp;&nbsp;if logical.exp then<br>&nbsp;&nbsp;&nbsp;&nbsp;statement.block<br>&nbsp;&nbsp;end else<br>&nbsp;&nbsp;&nbsp;&nbsp;statement.block<br>&nbsp;&nbsp;end"));

        // if...then...else - multi-line form 4
        provider.addCompletion(new TemplateCompletion(provider, "if", "if...then...else",
                "if ${logical.exp} else\n  ${cursor}\nend",
                "", "The if statement tests the result of a logical expression. Depending on whether the expression evaluates to either true or false, the statements following the then or else clauses respectively are executed.<br><br>"
                + "<b>The multi-line form 4:</b><br>"
                + "&nbsp;&nbsp;if logical.exp else<br>&nbsp;&nbsp;&nbsp;&nbsp;statement.block<br>&nbsp;&nbsp;end"));

        // if...then...else - multi-line form 5
        provider.addCompletion(new TemplateCompletion(provider, "if", "if...then...else",
                "if ${logical.exp} then\n  ${cursor}\nend",
                "", "The if statement tests the result of a logical expression. Depending on whether the expression evaluates to either true or false, the statements following the then or else clauses respectively are executed.<br><br>"
                + "<b>The multi-line form 5:</b><br>"
                + "&nbsp;&nbsp;if logical.exp then<br>&nbsp;&nbsp;&nbsp;&nbsp;statement.block<br>&nbsp;&nbsp;end"));

        // loop...until
        provider.addCompletion(new TemplateCompletion(provider, "loop", "loop...until",
                "loop ${statement.block1} until ${logical.exp} do ${statement.block2} repeat",
                "", "The loop statement repetitively executes (loops) until an ending condition is met. The first set of statements, if present, is executed at least once.<br><br>"
                + "<b>The single-line form:</b><br>"
                + "&nbsp;&nbsp;loop {statement.block1} until logical.exp {do} {statement.block2} repeat"));

        // loop...while
        provider.addCompletion(new TemplateCompletion(provider, "loop", "loop...while",
                "loop ${statement.block1} while ${logical.exp} do ${statement.block2} repeat",
                "", "The loop statement repetitively executes (loops) until an ending condition is met. The first set of statements, if present, is executed at least once.<br><br>"
                + "<b>The single-line form:</b><br>"
                + "&nbsp;&nbsp;loop {statement.block1} while logical.exp {do} {statement.block2} repeat"));

        // loop...until - multi-line
        provider.addCompletion(new TemplateCompletion(provider, "loop", "loop...until",
                "loop\n  ${cursor}\nuntil ${logical.exp} do\n  \nrepeat",
                "", "The loop statement repetitively executes (loops) until an ending condition is met. The first set of statements, if present, is executed at least once.<br><br>"
                + "<b>The multi-line form:</b><br>"
                + "&nbsp;&nbsp;loop<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;{statement.block1}<br>"
                + "&nbsp;&nbsp;until logical.exp {do}<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;{statement.block2}<br>"
                + "&nbsp;&nbsp;repeat"));

        // loop...while - multi-line
        provider.addCompletion(new TemplateCompletion(provider, "loop", "loop...while",
                "loop\n  ${cursor}\nwhile ${logical.exp} do\n  \nrepeat",
                "", "The loop statement repetitively executes (loops) until an ending condition is met. The first set of statements, if present, is executed at least once.<br><br>"
                + "<b>The multi-line form:</b><br>"
                + "&nbsp;&nbsp;loop<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;{statement.block1}<br>"
                + "&nbsp;&nbsp;while logical.exp {do}<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;{statement.block2}<br>"
                + "&nbsp;&nbsp;repeat"));

        // loop...repeat
        provider.addCompletion(new TemplateCompletion(provider, "loop", "loop...repeat",
                "loop ${cursor} repeat",
                "", "The loop statement repetitively executes (loops) until an ending condition is met. The first set of statements, if present, is executed at least once.<br><br>"
                + "<b>Syntax:</b><br>"
                + "&nbsp;&nbsp;loop {statement.block} repeat"));

        // case
        provider.addCompletion(new TemplateCompletion(provider, "case", "case...",
                "begin case\n  case ${logical.exp}\n      ${cursor}\n  case \n      \nend case",
                "", "The case statement delineates a conditional case construct.<br><br>"
                + "<b>Syntax:</b><br>"
                + "&nbsp;&nbsp;begin case<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;case logical.exp<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{statement{s}}<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;case logical.exp<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{statement{s}}<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.<br>"
                + "&nbsp;&nbsp;end case"));

        // inputtrap...gosub
        provider.addCompletion(new TemplateCompletion(provider, "input", "inputtrap...gosub",
                "inputtrap ${str.exp} gosub ${cursor}",
                "", "The inputtrap...gosub statement, using the str.exp, sets up an automatic computed gosub based on the next input @ statement data. The position of the character in the string expression corresponds to the position of the statement label in the list. This acts as a trap that causes a gosub on all subsequent input @ statements.<br><br>"
                + "<b>Syntax:</b><br>"
                + "&nbsp;&nbsp;inputtrap str.exp gosub statement.label{ ,statement.label...}"));

        // inputtrap...goto
        provider.addCompletion(new TemplateCompletion(provider, "input", "inputtrap...goto",
                "inputtrap ${str.exp} goto ${cursor}",
                "", "The inputtrap...goto statement, using the str.exp, sets up an automatic computed goto based on the next input @ statement?s data. The position of each character in the string expression corresponds to the position of the statement label in the list. This acts as a trap that causes a goto on all subsequent input @ statements and branches to a label in the current program.<br><br>"
                + "<b>Syntax:</b><br>"
                + "&nbsp;&nbsp;inputtrap str.exp goto statement.label{ ,statement.label{,...}}"));
    }
}
