package cat.copernic.m03uf06review.hibernate_relational;
// Generated 12/12/2020 02:41:32 by Hibernate Tools 4.3.1



/**
 * Organizacion generated by hbm2java
 */
public class Organizacion  implements java.io.Serializable {


     private Integer idOrg;
     private Persona personaByIdPersona2;
     private Persona personaByIdPersona3;
     private Persona personaByIdPersona1;
     private String nombreGrupo;
     private String descripcion;

    public Organizacion() {
    }

    public Organizacion(Persona personaByIdPersona2, Persona personaByIdPersona3, Persona personaByIdPersona1, String nombreGrupo, String descripcion) {
       this.personaByIdPersona2 = personaByIdPersona2;
       this.personaByIdPersona3 = personaByIdPersona3;
       this.personaByIdPersona1 = personaByIdPersona1;
       this.nombreGrupo = nombreGrupo;
       this.descripcion = descripcion;
    }
   
    public Integer getIdOrg() {
        return this.idOrg;
    }
    
    public void setIdOrg(Integer idOrg) {
        this.idOrg = idOrg;
    }
    public Persona getPersonaByIdPersona2() {
        return this.personaByIdPersona2;
    }
    
    public void setPersonaByIdPersona2(Persona personaByIdPersona2) {
        this.personaByIdPersona2 = personaByIdPersona2;
    }
    public Persona getPersonaByIdPersona3() {
        return this.personaByIdPersona3;
    }
    
    public void setPersonaByIdPersona3(Persona personaByIdPersona3) {
        this.personaByIdPersona3 = personaByIdPersona3;
    }
    public Persona getPersonaByIdPersona1() {
        return this.personaByIdPersona1;
    }
    
    public void setPersonaByIdPersona1(Persona personaByIdPersona1) {
        this.personaByIdPersona1 = personaByIdPersona1;
    }
    public String getNombreGrupo() {
        return this.nombreGrupo;
    }
    
    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}

