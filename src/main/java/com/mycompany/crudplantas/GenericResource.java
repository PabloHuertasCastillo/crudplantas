/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudplantas;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.Plantas;
import modelo.Plantascrud;

/**
 * REST Web Service
 *
 * @author Pablo
 */
@Path("tiendaplantas")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    @GET
    @Path("/test/{nombre}")
    public String bienvenido(@PathParam("nombre") String nombre) {
        return "Bienvenido a nuestra tienda " + nombre;
    }

    @GET
    @Path("/planta/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Plantas getPlantaJson(@PathParam("id") int id) {
        Plantas miPlanta = Plantascrud.getPlanta(id);

        return miPlanta;
    }

    @GET
    @Path("/listadoplantas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Plantas> getPlanta() {
        List<Plantas> plantas = Plantascrud.getPlantas();

        return plantas;
    }

    @PUT
    @Path("/planta/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Plantas UpdatePlanta(Plantas p) {
        Plantascrud.actualizaPlanta(p);

        return p;
    }

    @POST
    @Path("/planta/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Plantas setPlanta(Plantas p) {
        Plantascrud.insertaPlanta(p);
        return p;
    }

    @DELETE
    @Path("/planta/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePlanta(@PathParam("id") int id) {
        Plantascrud.destroyPlanta(id);
    }

    /**
     * Retrieves representation of an instance of
     * com.mycompany.crudplantas.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
