package no.uio.inf5750.assignment2.test;
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
	  
		@Test
	    public public void testSaveAddCourse() {
	    	
	    }

		@Test
	    public void testUpdateCourse() {
	    	
	    	
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
	    
	    
	    Collection<Degree> getAllDegrees();

	    /**
	     * Removes all references to the degree from students and deletes the
	     * degree.
	     * 
	     * @param degreeId the id of the degree to delete.
	     */
	    public void delDegree( int degreeId );

	    /**
	     * Adds a required course to a degree.
	     * 
	     * @param degreeId the id of the degree.
	     * @param courseId the id of the course.
	     */
	    public void addRequiredCourseToDegree( int degreeId, int courseId );

	    /**
	     * Removes a required course from a degree.
	     * 
	     * @param degreeId the id of the degree.
	     * @param courseId the id of the course.
	     */
	    public void removeRequiredCourseFromDegree( int degreeId, int courseId );

	    /**
	     * Adds a student.
	     * 
	     * @param name the name of the student to add.
	     * @return the generated id of the added student.
	     */
	    int addStudent( String name );

	    /**
	     * Updates a student.
	     * 
	     * @param studentId the id of the student to update.
	     * @param name the name to update.
	     */
	    public void updateStudent( int studentId, String name );

	    /**
	     * Returns a student.
	     * 
	     * @param studentId the id of the student to return.
	     * @return the student or null if it doesn't exist.
	     */
	    Student getStudent( int studentId );

	    /**
	     * Returns a student with a specific name.
	     * 
	     * @param name the name of the student to return.
	     * @return the student or null if it doesn't exist.
	     */
	    Student getStudentByName( String name );

	    /**
	     * Returns all students.
	     * 
	     * @return all students or an empty Collection if no student exists.
	     */
	    Collection<Student> getAllStudents();

	    /**
	     * Removes all references to the student from courses and deletes the
	     * student.
	     * 
	     * @param studentId the id of the student to delete.
	     */
	    public void delStudent( int studentId );

	    /**
	     * Adds a degree to a student.
	     * 
	     * @param studentId the id of the student.
	     * @param degreeId the id of the degree.
	     */
	    public void addDegreeToStudent( int studentId, int degreeId );

	    /**
	     * Removes a degree from a student.
	     * 
	     * @param studentId the id of the student.
	     * @param degreeId the id of the degree.
	     */
	    public void removeDegreeFromStudent( int studentId, int degreeId );

	    /**
	     * Checks if a student has the required courses of a degree.
	     * 
	     * @param studentId the id of the student.
	     * @param degreeId the id of the degree.
	     * @return true/false.
	     */
	    boolean studentFulfillsDegreeRequirements( int studentId, int degreeId );
	}
}
