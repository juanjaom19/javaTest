/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.managerl.Manager;
import com.mycompany.model.Peliculas;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author usuario
 */
@Path("pelicula")
public class PeliculaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PeliculaResource
     */
    public PeliculaResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean create(Peliculas entity) {
        return Manager.create(entity);
    }
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean edit(Peliculas entity) {
        return Manager.edit(entity);
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean remove(@PathParam("id") Integer id) {
        return Manager.delete(Peliculas.class, id);
    }
    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Peliculas find(@PathParam("id") Integer id) {
        return (Peliculas) Manager.getById(Peliculas.class, id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Peliculas> findAll() {
          return (List<Peliculas>) Manager.getAll(Peliculas.class);
    }


    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public String countREST() {
        return "";
    }
}
