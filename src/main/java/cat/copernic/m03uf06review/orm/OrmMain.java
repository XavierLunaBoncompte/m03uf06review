/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.orm;

import cat.copernic.m03uf06review.Connexio.ConnexioSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 *
 * int o long, double o float, boolean, char, String i java.sql.Date
 *
 * Recòrrer el result set i mostrar-lo per la consola com a instancies de la
 * classe Registre, que tindrà l'estructura de la teva taula.
 *
 *
 * @author pep
 */
public class OrmMain extends ConnexioSQL {

    static OrmMain o = new OrmMain();
    ResultSet rs;
    List<Persona> listaDePersonas = new ArrayList<>();
    static List<Persona> listaDePersonasFinal = o.getListaDePersonas();

    public static void main(String[] args) {
        mostrarListaFinalDePersonas();
    }

    public List<Persona> getListaDePersonas() {
        Statement st = null;
        Connection conn = getConnexio();

        String query = "SELECT * FROM personas";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);

            Persona persona;

            while (rs.next()) {
                persona = new Persona(rs.getString("nombre"), rs.getString("apellidos")
                        , rs.getString("direccion"), rs.getInt("codigo_postal"), rs.getString("ciudad")
                        , rs.getDouble("altura"), rs.getBoolean("fumador"), rs.getDate("fecha_nacimiento"));
                persona.setId(rs.getInt("id_persona"));
                listaDePersonas.add(persona);
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
        return listaDePersonas;

    }

    public static void mostrarListaFinalDePersonas() {

        for (Iterator it = listaDePersonasFinal.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }

}
