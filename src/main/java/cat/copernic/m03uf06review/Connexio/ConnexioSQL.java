/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.Connexio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lubo1
 */
public class ConnexioSQL {

    private static final String bbdd = "contactos";
    private static final String usuari = "administrador";
    private static final String psw = "admin_contactos";
    private static final String url = "jdbc:mysql://localhost:3306/" + bbdd;

    private static Connection conn = null;

    public static Connection getConnexio() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                        + "contactos?useUnicode=true&useJDBCCompliantTimezoneShift=true&"
                        + "useLegacyDatetimeCode=false&serverTimezone=UTC",
                        usuari, psw);
            } catch (SQLException ex) {
                Logger.getLogger(ConnexioSQL.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnexioSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
