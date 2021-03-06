package repodb.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import repodb.entity.Position;

@Repository("postDao")
public class PositionDaoImpl extends MainDao<Position>{
	

	@Override
	public Position byId(int id) {
		return em.find(Position.class, id);
	}

	@Override
	public List<Position> byList(String namedQery) {;
		TypedQuery<Position> postList = em.createNamedQuery(namedQery, Position.class);
		return postList.getResultList();
	}

}
