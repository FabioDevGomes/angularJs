package com.fabio;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/contatos")
public class Contatos {
	static ArrayList<Contato> contatos = new ArrayList<>();

	@Path("array")
	@GET
	@Produces("application/json")
	public Response convertFtoCfromInput() throws JSONException {
		
		if(contatos.isEmpty()){
			Contato contato = new Contato("Fábio", "2222-3333", new java.util.Date(), "red");
			Contato contato2 = new Contato("Hawking", "1222-3333", new java.util.Date(), "blue");
			contatos.add(contato);
			contatos.add(contato2);
		}

		String result = contatos.toString();
		return Response.status(200).entity(result).build();
	}

	@Path("/post")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adicionarContato(String data) throws JSONException {
		Contato contatoRecebido = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			contatoRecebido = mapper.readValue(data, Contato.class);
			contatos.add(contatoRecebido);

			String result = contatos.toString();
			return Response.status(201).entity(result).build();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}