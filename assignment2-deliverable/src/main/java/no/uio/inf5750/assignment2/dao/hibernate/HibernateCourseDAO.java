package no.uio.inf5750.assignment2.dao.hibernate;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import no.uio.inf5750.assignment2.dao.CourseDAO;
import no.uio.inf5750.assignment2.model.Course;


public class HibernateCourseDAO implements CourseDAO {
	
	static Logger logger = Logger.getLogger(HibernateCourseDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int saveCourse(Course course) {
		Course savedCourse = getCourseByCourseCode(course.getCourseCode());

		if (savedCourse == null) {
			course.setId(course.hashCode());
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(course);
				tx.commit();
				session.flush();

			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				logger.error("DB query failed", e);

			} finally {
				//session.close()
			}
			
			return course.getId();
		}

		else {
			System.out.println("Returning cached course");
			return savedCourse.getId();
		}
	}

	@Override
	public Course getCourse(int id) {
		return (Course) sessionFactory.getCurrentSession().get(Course.class, id);
	}

	@Override
	public Course getCourseByCourseCode(String courseCode) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		Course course = null;

		try {
			tx = session.beginTransaction();
			course = (Course) session.createQuery(
					"FROM Course WHERE courseCode='" + courseCode + "'").uniqueResult();
			tx.commit();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			logger.error("DB query failed", e);

		} finally {
			//session.close()
		}
		return course;
	}

	@Override	
	public Course getCourseByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		Course course = null;

		try {
			tx = session.beginTransaction();
			course = (Course) session.createQuery(
					"FROM Course WHERE name='" + name + "'").uniqueResult();
			tx.commit();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			logger.error("DB query failed", e);

		} finally {
			//session.close()
		}
		return course;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public Collection<Course> getAllCourses() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		List<Course> courses = null;

		try {
			tx = session.beginTransaction();
			courses = (List<Course>) session.createQuery(
					"FROM Course ORDER by courseId ASC").list();
			tx.commit();
			session.flush();

		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			logger.error("DB query failed", e);

		} finally {
			//session.close();
		}
		return courses;
	}

	@Override
	public void delCourse(Course course) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(course);
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
