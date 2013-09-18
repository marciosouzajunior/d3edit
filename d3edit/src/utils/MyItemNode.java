/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Enumeration;
import java.util.Vector;
import javax.swing.tree.TreeNode;

public class MyItemNode implements TreeNode {

    /**
     * The title will be displayed in the tree
     */
    private String title;
    private String account;
    private String registro;
    /*
     * Type of this node, which is used by a renderer to set appropriate icon
     * for the node
     */
    private int type;
    private Vector<TreeNode> children = new Vector<TreeNode>();
    private MyItemNode parent;

    // Constants for types of node
    public static final int NODE_ROOT = 0;
    public static final int NODE_ACCOUNT = 1;
    public static final int NODE_RECORD = 2;


    public MyItemNode(String title, int type, String account, String registro) {
        this.title = title;
        this.type = type;
        this.account = account;
        this.registro = registro;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public void setParent(MyItemNode parent) {
        this.parent = parent;
    }

    @Override
    public Enumeration<TreeNode> children() {
        return children.elements();
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return children.elementAt(childIndex);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public int getIndex(TreeNode node) {
        return children.indexOf(node);
    }

    @Override
    public MyItemNode getParent() {
        return this.parent;
    }

    @Override
    public boolean isLeaf() {
        return (children.size() == 0);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    /**
     * The node object should override this method to provide a text that will
     * be displayed for the node in the tree.
     */
    public String toString() {
        return title;
    }

    public int getType() {
        return type;
    }

    public String getAccount() {
        return account;
    }

    public String getRecord() {
        return registro;
    }
    
}