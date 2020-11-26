/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.jdbc;

import cat.copernic.m03uf06review.Connexio.ConnexioSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 *
 * int o long, double o float, boolean, char, String i java.sql.Date
 *
 * Recòrrer el result set i mostrar-lo per la consola.
 *
 *
 * @author pep
 */
public class JdbcMain extends ConnexioSQL {

    static ResultSet rs;

    public static void main(String[] args) {
        getListaDePersonas();
    }

    public static void getListaDePersonas() {
        Statement st = null;
        Connection conn = getConnexio();

        String query = "SELECT * FROM personas";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {

                System.out.println("ID; " + rs.getInt("id_persona") + ", Nombre; " + rs.getString("nombre")
                        + ", Apellidos; " + rs.getString("apellidos") + ", Direccion; " + rs.getString("direccion")
                        + ", Codigo Postal; " + rs.getInt("codigo_postal") + ", Ciudad; " + rs.getString("ciudad") 
                        + ", Altura; " + rs.getDouble("altura") + ", Es fumador; " + rs.getBoolean("fumador") 
                        + ", Fecha de Nacimineto; " + rs.getDate("fecha_nacimiento"));
            }

        } catch (Exception ex) {
            ex.getMessage();
        }

    }

}
