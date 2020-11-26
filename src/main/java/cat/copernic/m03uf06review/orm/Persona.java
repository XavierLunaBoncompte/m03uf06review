/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.orm;

import java.sql.Date;

/**
 *
 * @author lubo1
 */
public class Persona {

    private String nom;
    private String cognoms;
    private String direccion;
    private Integer codiPostal;
    private String ciutat;
    private double altura;
    private boolean fumador;
    private Date fechaNacimiento;

    private int id;

    public Persona(String nom, String cognoms, String direccion, Integer codiPostal, String ciutat, double altura, boolean fumador, Date fechaNacimiento) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.direccion = direccion;
        this.codiPostal = codiPostal;
        this.ciutat = ciutat;
        this.altura = altura;
        this.fumador = fumador;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(Integer codiPostal) {
        this.codiPostal = codiPostal;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public boolean isFumador() {
        return fumador;
    }

    public void setFumador(boolean fumador) {
        this.fumador = fumador;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Persona{" + "nom=" + nom + ", cognoms=" + cognoms + ", direccion=" + direccion + ", codiPostal=" + codiPostal + ", ciutat=" + ciutat + ", altura=" + altura + ", fumador=" + fumador + ", fechaNacimiento=" + fechaNacimiento + ", id=" + id + '}';
    }

}
