package no.uio.inf5750.assignment2.dao;
import no.uio.inf5750.assignment2.dao.DegreeDAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/beans.xml" })
@Transactional
public class DegreeDaoTest {

	@Autowired
	private DegreeDAO degreeDao;

	@Test
	public void testSaveDegree() {

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
	public void testDelDegree() {

	}

}
