package no.uio.inf5750.assignment2.dao.hibernate;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import no.uio.inf5750.assignment2.dao.DegreeDAO;
import no.uio.inf5750.assignment2.model.Degree;

@Component
public class HibernateDegreeDAO implements DegreeDAO {

	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public int saveDegree(Degree degree) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Degree getDegree(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Degree getDegreeByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Degree> getAllDegrees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delDegree(Degree degree) {
		// TODO Auto-generated method stub

	}

}
