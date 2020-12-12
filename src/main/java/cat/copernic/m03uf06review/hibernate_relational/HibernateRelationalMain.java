/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.hibernate_relational;

import cat.copernic.m03uf06review.HibernateUtil.HibernateUtil;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * En aquesta secció cal accedir a dues taules de MySQL que formin una relació
 *
 * One to Many, com per exemple: Departament -> Empleat
 *
 * Cada departament té molts empleats, i un empleat només treballa en un
 * departament.
 *
 * Recòrrer la relaciçó i mostrar-la per la consola
 *
 * Cal usar la llibreria Hibernate.
 *
 * @author pep
 */
public class HibernateRelationalMain {

    static HibernateRelationalMain HibeRelaMain = new HibernateRelationalMain();
    static HibernateUtil HibeUtil = new HibernateUtil();
    static Persona p1;
    static Persona p2;
    static Persona p3;
    static Persona p4;

    static Organizacion o1;

    public static void main(String[] args) {
        p1 = new Persona("David", "Garcia", "Carrer de Palet i Barba", 8225, "Terrassa", 1.88, false, new Date(1999 - 10 - 22));
        p2 = new Persona("Manuel", "Fernandez", "Carrer de Carrasco i Formiguera", 8224, "Terrassa", 1.74, true, new Date(2000 - 11 - 05));
        p3 = new Persona("Eric", "Lopez", "Carrer de Ferrer i Guardia", 8224, "Terrassa", 1.95, false, new Date(1999 - 12 - 31));
        p4 = new Persona("Jorge", "Ramirez", "Carrer de Ferrer i Guardia", 8224, "Terrassa", 1.75, false, new Date(2000 - 01 - 27));

        Integer ID1 = HibeRelaMain.añadirPersona(p1);
        Integer ID2 = HibeRelaMain.añadirPersona(p2);
        Integer ID3 = HibeRelaMain.añadirPersona(p3);

        HibeRelaMain.actualizarPersona(ID1);

        //HibeRelaMain.eliminarPersona(ID3);
        //HibeRelaMain.getListaDePersonas();
        o1 = new Organizacion(p1, p2, p3, "World Wildlife Fund", "Sus objetivos de trabajo son la investigación, la conservación y la restauración ambiental.");

        Integer ID4 = HibeRelaMain.añadirOrganizacion(o1);

        HibeRelaMain.actualizarOrg(ID4);

        //HibeRelaMain.eliminarOrg(ID4);
        HibeRelaMain.getListaDeOrganizaciones();
    }

    public Integer añadirPersona(Persona persona) {

        Session session = HibeUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer ID = null;

        try {
            tx = session.beginTransaction();
            ID = (Integer) session.save(persona);
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

    public void actualizarPersona(Integer ID) {
        Session session = HibeUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Persona p = (Persona) session.get(Persona.class, ID);
            p.setNombrePersona("Jorge");
            p.setCodigoPostal(8224);
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
            Persona persona = (Persona) session.get(Persona.class, ID);
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
            List personas = session.createQuery("FROM Persona").list();
            for (Iterator iterator = personas.iterator(); iterator.hasNext();) {
                Persona persona = (Persona) iterator.next();
                System.out.println("+---------------------------------------------+");
                System.out.println("Nombre: " + persona.getNombrePersona() + "\n");
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

    public Integer añadirOrganizacion(Organizacion organizacion) {

        Session session = HibeUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer ID = null;

        try {
            tx = session.beginTransaction();
            ID = (Integer) session.save(organizacion);
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

    public void actualizarOrg(Integer ID) {
        Session session = HibeUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Organizacion o = (Organizacion) session.get(Organizacion.class, ID);
            o.setDescripcion("Nueva Descripcion -> El World Wildlife Fund ha desempeñado un papel muy importante en el desarrollo de una conciencia ambientalista en el planeta y en el movimiento conservacionista mundial.");
            session.update(o);
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

    public void eliminarOrg(Integer ID) {
        Session session = HibeUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Organizacion organizacion = (Organizacion) session.get(Organizacion.class, ID);
            session.delete(organizacion);
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

    public void getListaDeOrganizaciones() {
        Session session = HibeUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List organizaciones = session.createQuery("FROM Organizacion").list();
            for (Iterator iterator = organizaciones.iterator(); iterator.hasNext();) {
                Organizacion organizacion = (Organizacion) iterator.next();
                System.out.println("+---------------------------------------------+");
                System.out.println("Nombre Organizacion: " + organizacion.getNombreGrupo() + "\n");
                System.out.println("Descripcion: " + organizacion.getDescripcion() + "\n");
                System.out.println("Persona 1: " + organizacion.getPersonaByIdPersona1()+ "\n");
                System.out.println("Persona 2: " + organizacion.getPersonaByIdPersona2() + "\n");
                System.out.println("Persona 3: " + organizacion.getPersonaByIdPersona3() + "\n");
                System.out.println("+---------------------------------------------+\n");
            }
            tx.commit();
            System.out.println("LISTA DE ORGANIZACIONES IMPRIMIDA CORRECTAMENTE");
            organizaciones.clear();
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
