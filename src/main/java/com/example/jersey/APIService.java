package com.example.jersey;

import org.codehaus.jettison.json.JSONObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class APIService {
    @POST
    @Path("/notes")
    public JSONObject createNoteAPI( JSONObject notes ) throws Exception {
        String input = (String) notes.get("body");
        return DatabaseService.createNote( input );
    }

    @GET
    @Path("/notes/{id}")
    public JSONObject getNoteAPI(@PathParam("id")int id) throws Exception {
        return DatabaseService.getNote( id );
    }

    @GET
    @Path("/notes")
    public JSONObject getAllNotesAPI(@QueryParam("query")String query) throws Exception {
        return DatabaseService.getAllNotes( query );
    }
}
