/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.managerl.Manager;
import com.mycompany.model.Resenas;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author usuario
 */
@Path("resenas")
public class ResenasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ResenasResource
     */
    public ResenasResource() {
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean remove(@PathParam("id") Integer id) {
        return Manager.delete(Resenas.class, id);
    }
    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Resenas find(@PathParam("id") Integer id) {
        return (Resenas) Manager.getById(Resenas.class, id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Resenas> findAll() {
          return (List<Resenas>) Manager.getAll(Resenas.class);
    }


    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public String countREST() {
        return "";
    }
}
