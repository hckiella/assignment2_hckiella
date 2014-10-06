package no.uio.inf5750.assignment2.dao.hibernate;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import no.uio.inf5750.assignment2.dao.DegreeDAO;
import no.uio.inf5750.assignment2.model.Degree;


public class HibernateDegreeDAO implements DegreeDAO {
	
	static Logger logger = Logger.getLogger(HibernateDegreeDAO.class);

	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public int saveDegree(Degree degree) {
		Degree savedDegree = getDegreeByType(degree.getType());

		if (savedDegree == null) {
			degree.setId(degree.hashCode());
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(degree);
				tx.commit();
				session.flush();

			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				logger.error("DB query failed", e);

			} finally {
				//session.close()
			}

			return degree.getId();
		}

		else {
			System.out.println("Returning cached degree");
			return savedDegree.getId();
		}
	}

	@Override
	public Degree getDegree(int id) {
		return (Degree) sessionFactory.getCurrentSession().get(Degree.class, id);
		
	}

	@Override
	public Degree getDegreeByType(String type) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		Degree degree = null;

		try {
			tx = session.beginTransaction();
			degree = (Degree) session.createQuery(
					"FROM Degree WHERE type='" + type + "'").uniqueResult();
			tx.commit();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			logger.error("DB query failed", e);

		} finally {
			//session.close()
		}
		return degree;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public Collection<Degree> getAllDegrees() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		List<Degree> degrees = null;

		try {
			tx = session.beginTransaction();
			degrees = (List<Degree>) session.createQuery(
					"FROM Degree ORDER by degreeId ASC").list();
			tx.commit();
			session.flush();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			logger.error("DB query failed", e);

		} finally {
			////session.close()
		}
		return degrees;
	}

	@Override
	public void delDegree(Degree degree) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(degree);
			tx.commit();
			session.flush();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			logger.error("DB query failed", e);

		} finally {
			//session.close()
		}
	}

}
