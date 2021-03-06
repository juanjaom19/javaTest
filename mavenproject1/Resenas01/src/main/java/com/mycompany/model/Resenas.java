package com.mycompany.model;
// Generated 30/10/2017 04:00:46 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Resenas generated by hbm2java
 */
public class Resenas  implements java.io.Serializable {


     private Integer id;
     private Peliculas peliculas;
     private Date fecha;
     private String resena;
     private Set<Comentarios> comentarioses = new HashSet<Comentarios>(0);

    public Resenas() {
    }

	
    public Resenas(Peliculas peliculas) {
        this.peliculas = peliculas;
    }
    public Resenas(Peliculas peliculas, Date fecha, String resena, Set<Comentarios> comentarioses) {
       this.peliculas = peliculas;
       this.fecha = fecha;
       this.resena = resena;
       this.comentarioses = comentarioses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Peliculas getPeliculas() {
        return this.peliculas;
    }
    
    public void setPeliculas(Peliculas peliculas) {
        this.peliculas = peliculas;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getResena() {
        return this.resena;
    }
    
    public void setResena(String resena) {
        this.resena = resena;
    }
    public Set<Comentarios> getComentarioses() {
        return this.comentarioses;
    }
    
    public void setComentarioses(Set<Comentarios> comentarioses) {
        this.comentarioses = comentarioses;
    }




}


