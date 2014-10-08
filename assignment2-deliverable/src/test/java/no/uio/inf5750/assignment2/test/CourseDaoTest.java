package no.uio.inf5750.assignment2.test;
import no.uio.inf5750.assignment2.dao.CourseDAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:resources/META-INF/beans.xml" })
@Transactional
public class CourseDaoTest {

	@Autowired
	private CourseDAO courseDao;

	@Test
	public void testSaveCourse() {

	}
	
	@Test
	public void testGetCourse() {

	}

	@Test
	public void testGetCourseByCourseCode() {

	}

	@Test
	public void testGetCourseByName() {

	}

	@Test
	public void testgetAllCourses() {

	}
	
	@Test
	public void testDelCourse() {

	}

}
