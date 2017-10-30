/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.managerl.Manager;
import com.mycompany.model.Comentarios;
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
@Path("comentario")
public class ComentarioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ComentarioResource
     */
    public ComentarioResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean create(Comentarios entity) {
        return Manager.create(entity);
    }
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean edit(Comentarios entity) {
        return Manager.edit(entity);
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean remove(@PathParam("id") Integer id) {
        return Manager.delete(Comentarios.class, id);
    }
    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comentarios find(@PathParam("id") Integer id) {
        return (Comentarios) Manager.getById(Comentarios.class, id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comentarios> findAll() {
          return (List<Comentarios>) Manager.getAll(Comentarios.class);
    }


    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public String countREST() {
        return "";
    }
}
