package br.com.rsnatividade.resource;

import java.util.List;

import br.com.rsnatividade.model.Quadra;
import br.com.rsnatividade.service.QuadraService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/quadras")
public class Quadras {

	private QuadraService quadraService;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getQuadras(){
		this.quadraService = new QuadraService();
		List<Quadra> quadras = this.quadraService.getQuadras();
		
		StringBuilder sb = new StringBuilder();
		for(Quadra quadra : quadras) {
			sb.append("quadra: ")
			.append(quadra.getId())
			.append(", nome: ")
			.append(quadra.getNome())
			.append("\n");
			
		}
		
		return Response.ok(sb.toString()).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public Response getQuadra(@PathParam("id") Long id) {
		this.quadraService = new QuadraService();
		Quadra quadra = this.quadraService.getQuadra(id);
		
		StringBuilder sb = new StringBuilder();
		sb.append("quadra: ")
		.append(quadra.getId())
		.append(", nome: ")
		.append(quadra.getNome());

		return Response.ok(sb.toString()).header("Access-Control-Allow-Origin", "*").build();
	}
}
