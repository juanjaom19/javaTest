/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.managerl.Manager;
import com.mycompany.model.Usuarios;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author usuario
 */
@Path("user")
public class UserResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean create(Usuarios entity) {
        return Manager.create(entity);
    }
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean edit(Usuarios entity) {
        return Manager.edit(entity);
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean remove(@PathParam("id") Integer id) {
        return Manager.delete(Usuarios.class, id);
    }
    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuarios find(@PathParam("id") Integer id) {
        return (Usuarios) Manager.getById(Usuarios.class, id);
    }
    @GET
    @Path("{user}/{psw}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuarios findUserLogin(@PathParam("user") String user,@PathParam("psw") String psw) {
        return Manager.getUser(user, psw);
    }
    

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuarios> findAll() {
          return (List<Usuarios>) Manager.getAll(Usuarios.class);
    }


    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public String countREST() {
        return "";
    }

}
