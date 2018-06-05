package com.fabio;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/operadoras")
public class OperadorasService {
	
	  @GET
	  @Produces("application/json")
	  public Response convertFtoCfromInput() throws JSONException {
 
		ArrayList<Operadora> operadoras = new ArrayList<>();
		Operadora operadora1 = new Operadora("Vivo", 15, "Celular", 1.5);
		Operadora operadora2 = new Operadora("Oi", 14, "Celular", 2.5);
		Operadora operadora3 = new Operadora("Tim", 41, "Celular", 2.0);
		Operadora operadora4 = new Operadora("Vivo Fixo", 25, "Fixo", 1.5);
		operadoras.add(operadora1);
		operadoras.add(operadora2);
		operadoras.add(operadora3);
		operadoras.add(operadora4);
		
		  
		String result = operadoras.toString();
		return Response.status(200).entity(result).header("Access-Control-Allow-Origin", "*").build();
	  }
}