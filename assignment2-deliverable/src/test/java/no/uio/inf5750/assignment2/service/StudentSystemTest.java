package no.uio.inf5750.assignment2.service;

import no.uio.inf5750.assignment2.model.Course;
import no.uio.inf5750.assignment2.service.StudentSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:resources/META-INF/beans.xml" })
@Transactional
public class StudentSystemTest {
	
	@Autowired
	private StudentSystem studentSystem;
	

	@Test
	public void testAddCourse() {
		Course course = new Course("INF1010", "Objektorientert programmering");
		course.setId(course.hashCode());
		studentSystem.addCourse("INF1010", "Objektorientert programmering");
		
		assert(studentSystem.getAllCourses().contains(course));		
	}

	@Test
	public void testUpdateCourse() {
		Course course = new Course("INF1010", "Objektorientert programmering");
		course.setId(course.hashCode());
		
		studentSystem.addCourse("INF1010", "Objektorientert programmering");
		assert(studentSystem.getAllCourses().contains(course));
		
		studentSystem.updateCourse(course.getId(), "Objektorientert programmering 2", "INF1020");
		assert(!studentSystem.getAllCourses().contains(course));
		
		course.setCourseCode("INF1020");
		course.setName( "Objektorientert programmering 2");
		assert(studentSystem.getAllCourses().contains(course));
	}

	@Test
	public void testGetCourse() {
		Course course = new Course("INF1010", "Objektorientert programmering");
		course.setId(course.hashCode());
		studentSystem.addCourse("INF1010", "Objektorientert programmering");
		
		assert(course.equals(studentSystem.getCourse(course.getId())));
		
		assert(studentSystem.getCourse(0) == null);
	}

	@Test
	public void testGetCourseByCourseCode() {

	}

	@Test
	public void testGetCourseByName() {

	}

	@Test
	public void testGetAllCourses() {

	}

	@Test
	public void testDelCourse() {

	}

	@Test
	public void testDddAttendantToCourse() {

	}

	@Test
	public void testRemoveAttendantFromCourse() {
	}

	@Test
	public void testAddDegree() {

	}

	@Test
	public void testUpdateDegree() {

	}

	@Test
	public void testGetDegree() {

	}

	@Test
	public void testGetDegreeByType() {

	}

	@Test
	public void testGetAllDegrees() {

	}

	@Test
	public void testdelDegree(int degreeId) {

	}

	@Test
	public void testAddRequiredCourseToDegree() {

	}

	@Test
	public void testRemoveRequiredCourseFromDegree() {
	}

	@Test
	public void testAddStudent() {

	}

	@Test
	public void testUpdateStudent() {

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

	@Test
	public void testAddDegreeToStudent() {
	}

	@Test
	public void testRemoveDegreeFromStudent() {
	}

	@Test
	public void testStudentFulfillsDegreeRequirements() {

	}
}
