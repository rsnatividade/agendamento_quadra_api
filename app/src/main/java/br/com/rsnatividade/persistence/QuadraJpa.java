package br.com.rsnatividade.persistence;

import java.util.List;

import br.com.rsnatividade.model.Quadra;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class QuadraJpa {

	private EntityManager em;
	
	public QuadraJpa(EntityManager em) {
		this.em = em;
	}
	
	public List<Quadra> getQuadras() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Quadra> cq = cb.createQuery(Quadra.class);
		cq.from(Quadra.class);
		List<Quadra> quadras = this.em.createQuery(cq).getResultList();
		
		return quadras;
	}
	
	public Quadra getQuadra(Long idQuadra) {
		String sql = "from Quadra where id = :id";
		Query qry = this.em.createQuery(sql);
		qry.setParameter("id", idQuadra);
		Quadra quadra = (Quadra)qry.getSingleResult();
		
		return quadra;
	}

}
