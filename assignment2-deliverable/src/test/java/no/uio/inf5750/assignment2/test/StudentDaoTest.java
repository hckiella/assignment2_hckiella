package no.uio.inf5750.assignment2.test;
import no.uio.inf5750.assignment2.dao.StudentDAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:resources/META-INF/beans.xml" })
@Transactional
public class StudentDaoTest {

	@Autowired
	private StudentDAO courseDao;

	@Test
	public void testSaveStudent() {

	}
	
	@Test
	public void testGetStudent() {

	}

	@Test
	public void testGetStudentByName() {

	}

	@Test
	public void testGetAllStudents() {

	}

	@Test
	public void testDelStudent() {

	}

}
