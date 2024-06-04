package br.com.rsnatividade.service;

import java.util.List;

import br.com.rsnatividade.model.Quadra;
import br.com.rsnatividade.persistence.QuadraJpa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Stateless
public class QuadraService {

	private EntityManager em;
	QuadraJpa quadraJpa;
	
	public List<Quadra> getQuadras() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("agendamentoQuadraApiPU");
		this.em = factory.createEntityManager();
		this.quadraJpa = new QuadraJpa(this.em);
		return quadraJpa.getQuadras();
	}
	
	public Quadra getQuadra(Long idQuadra) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("agendamentoQuadraApiPU");
		this.em = factory.createEntityManager();
		this.quadraJpa = new QuadraJpa(this.em);
		return quadraJpa.getQuadra(idQuadra);
	}

}
