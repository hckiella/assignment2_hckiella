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
		
		if(savedStudent == null) {
			student.setId(student.hashCode());			
			int i = (Integer) sessionFactory.getCurrentSession().save(student);
			System.out.println("Saving " + student.getName() + " id: " + i + "(stdent.id: " + student.getId());
			return student.getId();
		}
		
		else {
			System.out.println("Returning saved value");
			return savedStudent.getId();
		}
			
	}

	@Override
	public Student getStudent(int id) {
		return null; 
		
	}

	@Override
	public Student getStudentByName(String name) {
		// TODO Auto-generated method stub
		Student student = null;
		return student;
	}

	@Override
	public Collection<Student> getAllStudents() {
		Session session = sessionFactory.openSession();
	    Transaction tx = null;
	    List <Student> studentus = null;
	    //Student students;
	    try{
	       tx = session.beginTransaction();
	       @SuppressWarnings("unchecked")
	       // This is an HQL query, not an SQL query (HQL is based on SQL, but is not 100% the same)
	       List<Student> students = session.createQuery("FROM Student ORDER by studentId ASC").list();
	       for(Student s: students)
	    	   System.out.println("name " + s.getName());
	       
	       studentus = students;
	       
	      tx.commit();	       
	       
	    }catch (HibernateException e) {
	    	
	       if (tx!=null) tx.rollback();
	       logger.error("DB query failed", e);
	       
	    }finally {
	       session.close();
	    }
	    return studentus;
	}

	@Override
	public void delStudent(Student student) {
		// TODO Auto-generated method stub

	}

}

/*
public int save( Message message )
{
    return (Integer) sessionFactory.getCurrentSession().save( message );
}


public Message get( int id )
{
    return (Message) sessionFactory.getCurrentSession().get( Message.class, id );
}

public Message getLast()
{
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    Message message = null;
    
    try{
       tx = session.beginTransaction();
       @SuppressWarnings("unchecked")
       // This is an HQL query, not an SQL query (HQL is based on SQL, but is not 100% the same)
       List<Message> messages = session.createQuery("FROM Message ORDER by id DESC").list();
       
       if (!messages.isEmpty()) {
               message = messages.iterator().next();
       }
       tx.commit();
       
    }catch (HibernateException e) {
    	
       if (tx!=null) tx.rollback();
       logger.error("DB query failed", e);
       
    }finally {
       session.close();
    }
    return message;
}
}
*/
