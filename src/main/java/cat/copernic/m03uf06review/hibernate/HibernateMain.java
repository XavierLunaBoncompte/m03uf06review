/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.hibernate;

import static cat.copernic.m03uf06review.Connexio.ConnexioSQL.getConnexio;
import cat.copernic.m03uf06review.HibernateUtil.HibernateUtil;
import cat.copernic.m03uf06review.orm.OrmMain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 *
 * int o long, double o float, boolean, char, String i java.sql.Date
 *
 * Recòrrer el result set i mostrar-lo per la consola com a instancies de la
 * classe Registre, que tindrà l'estructura de la teva taula.
 *
 * Cal usar la llibreria Hibernate.
 *
 *
 * @author pep
 */
public class HibernateMain {

    static HibernateMain HibeMain = new HibernateMain();
    static HibernateUtil HibeUtil = new HibernateUtil();
    static Personas p1;
    static Personas p2;
    static Personas p3;
    static Personas p4;

    public static void main(String[] args) {
        p1 = new Personas("David", "Garcia", "Carrer de Palet i Barba", 8225, "Terrassa", 1.88, false, new Date(1999 - 10 - 22));
        p2 = new Personas("Manuel", "Fernandez", "Carrer de Carrasco i Formiguera", 8224, "Terrassa", 1.74, true, new Date(2000 - 11 - 05));
        p3 = new Personas("Eric", "Lopez", "Carrer de Ferrer i Guardia", 8224, "Terrassa", 1.95, false, new Date(1999 - 12 - 31));

        Integer ID1 = HibeMain.añadirPersona(p1);
        Integer ID2 = HibeMain.añadirPersona(p2);
        Integer ID3 = HibeMain.añadirPersona(p3);
        
        p2 = new Personas("Javier", "Fernandez", "Carrer de Carrasco i Formiguera", 8224, "Terrassa", 1.74, true, new Date(2000 - 11 - 05));

        HibeMain.actualizarPersona(p2);

        HibeMain.eliminarPersona(ID3);

        HibeMain.getListaDePersonas();
    }

    public Integer añadirPersona(Personas persona) {

        Session session = HibeUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer ID = null;
        Integer contador = 6;

        try {
            tx = session.beginTransaction();
            ID = (Integer) session.save(persona);
            //persona.setIdPersona(contador++);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ID;
    }

    public void actualizarPersona(Personas p) {
        Session session = HibeUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(p);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void eliminarPersona(Integer ID) {
        Session session = HibeUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Personas persona = (Personas) session.get(Personas.class, ID);
            session.delete(persona);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void getListaDePersonas() {
        Session session = HibeUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List personas = session.createQuery("FROM Personas").list();
            for (Iterator iterator = personas.iterator(); iterator.hasNext();) {
                Personas persona = (Personas) iterator.next();
                System.out.println("+---------------------------------------------+");
                System.out.println("Nombre: " + persona.getNombre() + "\n");
                System.out.println("Apellidos: " + persona.getApellidos() + "\n");
                System.out.println("Direccion: " + persona.getDireccion() + "\n");
                System.out.println("Codigo Postal: " + persona.getCodigoPostal() + "\n");
                System.out.println("Ciudad: " + persona.getCiudad() + "\n");
                System.out.println("Altura: " + persona.getAltura() + "\n");
                System.out.println("És fumador: " + persona.getFumador() + "\n");
                System.out.println("Fecha Nacimiento: " + persona.getFechaNacimiento() + "\n");
                System.out.println("+---------------------------------------------+\n");
            }
            tx.commit();
            System.out.println("LISTA IMPRIMIDA CORRECTAMENTE");
            personas.clear();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

}
