/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JOptionPane;
import main.FrmMain;
import org.jd3.D3Connection;
import org.jd3.D3Constants;
import org.jd3.D3Session;

public class Connection {

    private static D3Connection connection;
    private static D3Session session;

    public synchronized static D3Session getSession() {

        if (connection == null) {

            try {

                connection = new D3Connection(
                        FrmMain.getProperty("host"),
                        Integer.parseInt(FrmMain.getProperty("port")),
                        FrmMain.getProperty("user"),
                        FrmMain.getProperty("password"),
                        D3Constants.CONNECTION_TCP);

                session = connection.createSession();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Unable to connect to server: " + e.getMessage(), "Connection", JOptionPane.ERROR_MESSAGE);
            }
        }

        return session;

    }

    public static void close() {

        if (connection != null) {
            connection.close();
            connection = null;
        }

    }
}
