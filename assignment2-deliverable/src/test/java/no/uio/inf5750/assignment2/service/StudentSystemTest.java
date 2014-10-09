package no.uio.inf5750.assignment2.service;

import static org.junit.Assert.*;
import no.uio.inf5750.assignment2.model.Course;
import no.uio.inf5750.assignment2.model.Degree;
import no.uio.inf5750.assignment2.model.Student;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/assignment2/beans.xml" })
@Transactional
public class StudentSystemTest {

	@Autowired
	private StudentSystem studentSystem;

	@Test
	public void testAddCourse() {
		Course course = new Course("INF1010", "Objektorientert programmering");
		course.setId(course.hashCode());
		studentSystem.addCourse("INF1010", "Objektorientert programmering");

		assertTrue(studentSystem.getAllCourses().contains(course));

	}

	@Test
	public void testUpdateCourse() {
		Course course = new Course("INF1010", "Objektorientert programmering");
		
		int courseId = studentSystem.addCourse("INF1010", "Objektorientert programmering");
		assertTrue(studentSystem.getAllCourses().contains(course));

		studentSystem.updateCourse(courseId, "INF1020",
				"Objektorientert programmering 2");
		assertFalse(studentSystem.getAllCourses().contains(course));

		course.setCourseCode("INF1020");
		course.setName("Objektorientert programmering 2");

		assertTrue(studentSystem.getAllCourses().contains(course));
	}

	@Test
	public void testGetCourse() {
		Course course = new Course("INF1010", "Objektorientert programmering");
		int courseId = studentSystem.addCourse("INF1010", "Objektorientert programmering");

		assertTrue(course.equals(studentSystem.getCourse(courseId)));
		assertNull(studentSystem.getCourse(0));
	}

	@Test
	public void testGetCourseByCourseCode() {
		Course course = new Course("INF1010", "Objektorientert programmering");
		studentSystem.addCourse("INF1010", "Objektorientert programmering");

		assertTrue(course.equals(studentSystem.getCourseByCourseCode(course
				.getCourseCode())));
		assertNull(studentSystem.getCourseByCourseCode("INF1000"));
	}

	@Test
	public void testGetCourseByName() {
		Course course = new Course("INF1010", "Objektorientert programmering");
		studentSystem.addCourse("INF1010", "Objektorientert programmering");

		assertTrue(course
				.equals(studentSystem.getCourseByName(course.getName())));
		assertNull(studentSystem.getCourseByName("Funksjonell programmering"));
	}

	@Test
	public void testGetAllCourses() {
		Course course1 = new Course("INF1010", "Objektorientert programmering");
		Course course2 = new Course("INF2810", "Funksjonell programmering");
		
		studentSystem.addCourse("INF1010", "Objektorientert programmering");
		studentSystem.addCourse("INF2810", "Funksjonell programmering");
		
		assertTrue(studentSystem.getAllCourses().contains(course1));
		assertTrue(studentSystem.getAllCourses().contains(course2));
	}

	@Test
	public void testDelCourse() {
		fail("Not implemented");
	}

	@Test
	public void testaddAttendantToCourse() {
		Course course1 = new Course("INF1010", "Objektorientert programmering");
		int courseId1 = studentSystem.addCourse("INF1010", "Objektorientert programmering");
		
		Student student = new Student("Freddy");
		int studentId = studentSystem.addStudent("Freddy");
		
		Course course2 = new Course("INF2810", "Funksjonell programmering");
		int courseId2 = studentSystem.addCourse("INF2810", "Funksjonell programmering");
		
		studentSystem.addAttendantToCourse(courseId1, studentId);
		
		assertTrue(studentSystem.getCourse(courseId1).getAttendants().contains(student));
		assertTrue(studentSystem.getStudent(studentId).getCourses().contains(course1));
		
		assertFalse(studentSystem.getCourse(courseId2).getAttendants().contains(student));
		assertFalse(studentSystem.getStudent(studentId).getCourses().contains(course2));		
	}

	@Test
	public void testRemoveAttendantFromCourse() {
		Course course1 = new Course("INF1010", "Objektorientert programmering");
		int courseId1 = studentSystem.addCourse("INF1010", "Objektorientert programmering");
		
		Student student = new Student("Freddy");
		int studentId = studentSystem.addStudent("Freddy");
		
		Course course2 = new Course("INF2810", "Funksjonell programmering");
		int courseId2 = studentSystem.addCourse("INF2810", "Funksjonell programmering");
		
		studentSystem.addAttendantToCourse(courseId1, studentId);
		studentSystem.addAttendantToCourse(courseId2, studentId);
		
		assertTrue(studentSystem.getCourse(courseId1).getAttendants().contains(student));
		assertTrue(studentSystem.getStudent(studentId).getCourses().contains(course1));
		
		studentSystem.removeAttendantFromCourse(courseId1,  studentId);
		
		assertFalse(studentSystem.getCourse(courseId1).getAttendants().contains(student));
		assertFalse(studentSystem.getStudent(studentId).getCourses().contains(course1));
		
		assertTrue(studentSystem.getCourse(courseId2).getAttendants().contains(student));
		assertTrue(studentSystem.getStudent(studentId).getCourses().contains(course2));		
	}

	@Test
	public void testAddDegree() {
		Degree degree = new Degree("Bachelor");

		studentSystem.addDegree("Bachelor");

		assertTrue(studentSystem.getAllDegrees().contains(degree));
	}

	@Test
	public void testUpdateDegree() {
		Degree degree = new Degree("Bachelor");
		
		int degreeId = studentSystem.addDegree("Bachelor");
		assertTrue(studentSystem.getAllDegrees().contains(degree));

		studentSystem.updateDegree(degreeId, "Master");		
		assertFalse(studentSystem.getAllDegrees().contains(degree));

		degree.setType("Master");
		assertTrue(studentSystem.getAllDegrees().contains(degree));
	}

	@Test
	public void testGetDegree() {
		Degree degree = new Degree("Bachelor");
		int degreeId = studentSystem.addDegree("Bachelor");

		assertTrue(degree.equals(studentSystem.getDegree(degreeId)));
		assertNull(studentSystem.getDegree(0));
	}

	@Test
	public void testGetDegreeByType() {
		Degree degree = new Degree("Bachelor");
		studentSystem.addDegree("Bachelor");

		assertTrue(degree.equals(studentSystem.getDegreeByType(degree
				.getType())));
		assertNull(studentSystem.getDegreeByType("Master"));
	}

	@Test
	public void testGetAllDegrees() {
		fail("Not implemented");
	}

	@Test
	public void testdelDegree() {
		fail("Not implemented");
	}

	@Test
	public void testAddRequiredCourseToDegree() {
		fail("Not implemented");
	}

	@Test
	public void testRemoveRequiredCourseFromDegree() {
		fail("Not implemented");
	}

	@Test
	public void testAddStudent() {
		fail("Not implemented");
	}

	@Test
	public void testUpdateStudent() {
		fail("Not implemented");
	}

	@Test
	public void testGetStudent() {
		fail("Not implemented");
	}

	@Test
	public void testGetStudentByName() {
		fail("Not implemented");
	}

	@Test
	public void testGetAllStudents() {
		fail("Not implemented");
	}

	@Test
	public void testDelStudent() {
		fail("Not implemented");
	}

	@Test
	public void testAddDegreeToStudent() {
		fail("Not implemented");
	}

	@Test
	public void testRemoveDegreeFromStudent() {
		fail("Not implemented");
	}

	@Test
	public void testStudentFulfillsDegreeRequirements() {
		fail("Not implemented");

	}
}
