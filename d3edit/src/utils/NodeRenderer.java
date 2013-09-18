package utils;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * This class is implemented to customize the display of a node.
 *
 * @author Ha Minh Nam
 * 
*/
public class NodeRenderer extends DefaultTreeCellRenderer {
    
    private ImageIcon iconRoot = new ImageIcon(getClass().getResource("/img/server.png"));
    private ImageIcon iconAccount = new ImageIcon(getClass().getResource("/img/account.png"));
    private ImageIcon iconRegistro = new ImageIcon(getClass().getResource("/img/record.png"));

    @Override
    public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        MyItemNode node = (MyItemNode) value;

        switch (node.getType()) {
            case MyItemNode.NODE_ROOT:
                setIcon(iconRoot);
                break;
            case MyItemNode.NODE_ACCOUNT:
                setIcon(iconAccount);
                break;
            case MyItemNode.NODE_RECORD:
                setIcon(iconRegistro);
                break;
        }

        return this;
    }
}