package no.uio.inf5750.assignment2.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import no.uio.inf5750.assignment2.dao.CourseDAO;
import no.uio.inf5750.assignment2.dao.DegreeDAO;
import no.uio.inf5750.assignment2.dao.StudentDAO;
import no.uio.inf5750.assignment2.model.Course;
import no.uio.inf5750.assignment2.model.Degree;
import no.uio.inf5750.assignment2.model.Student;
import no.uio.inf5750.assignment2.service.StudentSystem;

public class DefaultStudentSystem implements StudentSystem {

	@Autowired
	private CourseDAO courseDao;

	@Autowired
	private DegreeDAO degreeDao;

	@Autowired
	private StudentDAO studentDao;

	public int addCourse(String courseCode, String name) {
		Course course = getCourseByCourseCode(courseCode);

		if (course == null) {
			// add as a new course
			course = new Course(courseCode, name);
			course.setId(course.hashCode());
		}

		return course.getId();
	}

	public void updateCourse(int courseId, String courseCode, String name) {
		Course toUpdate = getCourse(courseId);

		toUpdate.setCourseCode(courseCode);
		toUpdate.setName(name);
	}

	public Course getCourse(int courseId) {
		return courseDao.getCourse(courseId);
	}

	public Course getCourseByCourseCode(String courseCode) {
		return courseDao.getCourseByCourseCode(courseCode);
	}

	public Course getCourseByName(String name) {
		return courseDao.getCourseByName(name);
	}

	public Collection<Course> getAllCourses() {
		return courseDao.getAllCourses();
	}

	public void delCourse(int courseId) {
		Course course = courseDao.getCourse(courseId);

		Collection<Degree> degrees = degreeDao.getAllDegrees();
		Collection<Student> students = studentDao.getAllStudents();

		for (Degree d : degrees) {
			d.getRequiredCourses().remove(course);
		}

		for (Student s : students) {
			s.getCourses().remove(course);
		}
	}

	public void addAttendantToCourse(int courseId, int studentId) {
		Course course = courseDao.getCourse(courseId);
		course.getAttendants().add(studentDao.getStudent(studentId));
	}

	public void removeAttendantFromCourse(int courseId, int studentId) {
		Course course = courseDao.getCourse(courseId);
		Student student = studentDao.getStudent(studentId);

		course.getAttendants().remove(student);
		student.getCourses().remove(course);
	}

	public int addDegree(String type) {
		Degree degree = degreeDao.getDegreeByType(type);

		if (degree == null) {
			// add as a new course
			degree = new Degree(type);
			degree.setId(degree.hashCode());
		}

		return degree.getId();
	}

	public void updateDegree(int degreeId, String type) {
		Degree degree = degreeDao.getDegree(degreeId);
		degree.setType(type);
	}

	public Degree getDegree(int degreeId) {
		return degreeDao.getDegree(degreeId);
	}

	public Degree getDegreeByType(String type) {
		return degreeDao.getDegreeByType(type);
	}

	public Collection<Degree> getAllDegrees() {
		return degreeDao.getAllDegrees();
	}

	@Override
	public void delDegree(int degreeId) {

	}

	@Override
	public void addRequiredCourseToDegree(int degreeId, int courseId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRequiredCourseFromDegree(int degreeId, int courseId) {
		// TODO Auto-generated method stub

	}

	@Override
	public int addStudent(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateStudent(int studentId, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delStudent(int studentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDegreeToStudent(int studentId, int degreeId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeDegreeFromStudent(int studentId, int degreeId) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean studentFulfillsDegreeRequirements(int studentId, int degreeId) {
		// TODO Auto-generated method stub
		return false;
	}

}
