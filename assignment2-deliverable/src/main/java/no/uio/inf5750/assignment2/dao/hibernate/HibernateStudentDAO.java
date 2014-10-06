package no.uio.inf5750.assignment2.dao.hibernate;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import no.uio.inf5750.assignment2.dao.StudentDAO;
import no.uio.inf5750.assignment2.model.Student;

public class HibernateStudentDAO implements StudentDAO {

	static Logger logger = Logger.getLogger(HibernateStudentDAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int saveStudent(Student student) {
		Student savedStudent = getStudentByName(student.getName());

		if (savedStudent == null) {
			student.setId(student.hashCode());
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(student);
				tx.commit();
				session.flush();

			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				logger.error("DB query failed", e);

			} finally {
				//session.close();
			}

			return student.getId();
		}

		else {
			System.out.println("Returning cached student");
			return savedStudent.getId();
		}
	}

	@Override
	public Student getStudent(int id) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
	}

	@Override
	public Student getStudentByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		Student student = null;

		try {
			tx = session.beginTransaction();
			student = (Student) session.createQuery(
					"FROM Student WHERE name='" + name + "'").uniqueResult();
			tx.commit();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			logger.error("DB query failed", e);

		} finally {
			//session.close();
		}
		return student;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Student> getAllStudents() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		List<Student> students = null;

		try {
			tx = session.beginTransaction();
			students = (List<Student>) session.createQuery(
					"FROM Student ORDER by studentId ASC").list();
			tx.commit();
			session.flush();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			logger.error("DB query failed", e);

		} finally {
			//session.close();
		}
		return students;
	}

	@Override
	public void delStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(student);
			tx.commit();
			session.flush();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			logger.error("DB query failed", e);

		} finally {
			//session.close();
		}
	}
}