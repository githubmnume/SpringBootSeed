/**
 * 
 */
package interview.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import interview.BaseTester;
import interview.domain.Interview;

/**
 * @author zhouufen
 *
 */
public class InterviewServiceTest extends BaseTester {
	@Autowired
	private InterviewService interviewService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		try {
			Interview interview = new Interview();
			interview.setCvId(1);
			interview.setInDu("IP & Cloud");
			interview.setInLine("Craft");
			interview.setInPosition("SW");
			interview.setInStatus("new");
			interview.setIn_comment("init");
			interview.setInDate(new Date());
			interview.setInOwner("admin");
			interview.setInEnable(true);
			Interview save = interviewService.save(interview);
			Assert.assertNotNull(save);
		} catch (Exception e) {
			fail("failed" + e.getMessage());
		}

	}

	@Test
	public void testSaveAll() {
		try {
			LinkedList<Interview> interviews = new LinkedList<>();
			for (int i = 0; i < Math.random(); i++) {
				Interview interview = new Interview();
				interview.setCvId(0);
				interview.setInDu("IP & Cloud");
				interview.setInLine("Craft");
				interview.setInPosition("SW");
				interview.setInStatus("new");
				interview.setIn_comment("init");
				interview.setInDate(new Date());
				interview.setInOwner("admin");
				interviews.add(interview);
			}
			List<Interview> saveAll = interviewService.saveAll(interviews);
			assertNotNull(saveAll);
			assertTrue(saveAll.size() == interviews.size());
		} catch (Exception e) {
			fail("failed" + e.getMessage());
		}

	}

	@Test
	public void testLogicDelete() {
		try {
			Integer id = 4;
			interviewService.logicDeleteById(id);
			assertTrue(1 > 0);
		} catch (Exception e) {
			fail("failed : " + e.getMessage());
		}

	}

	@Test
	public void testLogicDeletes() {
		try {
			ArrayList<Integer> ids = new ArrayList<>();
			ids.add(new Integer(3));
			ids.add(new Integer(4));
			ids.add(new Integer(5));
			ids.add(new Integer(6));
			interviewService.logicDeleteByIds(ids);
			assertTrue(1 > 0);
		} catch (Exception e) {
			fail("failed : " + e.getMessage());
		}

	}

	@Test
	public void testUpdate() {
		try {
			try {
				Interview interview = new Interview();
				interview.setCvId(0);
				interview.setInDu("IP&Cloud");
				interview.setInLine("Craft");
				interview.setInPosition("SW");
				interview.setInStatus("new");
				interview.setIn_comment("init");
				interview.setInDate(new Date());
				interview.setInOwner("admin");
				interviewService.update(interview);
				// TODO
				Assert.assertTrue(1 > 0);
			} catch (Exception e) {
				fail("failed" + e.getMessage());
			}
		} catch (Exception e) {
			fail("failed : " + e.getMessage());
		}

	}

	@Test
	public void testFindByOwner() {
		try {
			try {
				String owner = "admin";
				List<Interview> findByOwner = interviewService.findByOwner(owner);
				assertNotNull(findByOwner);
				assertTrue(findByOwner.size() > 0);
			} catch (Exception e) {
				fail("failed" + e.getMessage());
			}
		} catch (Exception e) {
			fail("failed : " + e.getMessage());
		}

	}

	@Test
	public void testFindByCV() {
		try {
			try {
				String cv = "1";
				List<Interview> findByCv = interviewService.findByCV(cv);
				assertNotNull(findByCv);
				assertTrue(findByCv.size() > 0);
			} catch (Exception e) {
				fail("failed" + e.getMessage());
			}
		} catch (Exception e) {
			fail("failed : " + e.getMessage());
		}

	}

	@Test
	public void testFindByStatus() {
		try {
			try {
				String status = "hold";
				List<Interview> findByStatus = interviewService.findByStatus(status);
				assertNotNull(findByStatus);
				assertTrue(findByStatus.size() > 0);
			} catch (Exception e) {
				fail("failed" + e.getMessage());
			}
		} catch (Exception e) {
			fail("failed : " + e.getMessage());
		}

	}

	@Test
	public void testFindByPosition() {
		try {
			try {
				String position = "SW";
				List<Interview> findByStatus = interviewService.findByPosition(position);
				assertNotNull(findByStatus);
				assertTrue(findByStatus.size() > 0);
			} catch (Exception e) {
				fail("failed" + e.getMessage());
			}
		} catch (Exception e) {
			fail("failed : " + e.getMessage());
		}

	}

	@Test
	public void testFindByDate() {
		try {
			try {

				LocalDate date = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
				String text = date.format(formatter);
				LocalDate parsedDate = LocalDate.parse(text, formatter);
				ZoneId zoneId = ZoneId.systemDefault();
				ZonedDateTime atStartOfDay = parsedDate.atStartOfDay(zoneId);

				List<Interview> findByStatus = interviewService.findByDate(Date.from(atStartOfDay.toInstant()));
				assertNotNull(findByStatus);
				assertTrue(findByStatus.size() > 0);
			} catch (Exception e) {
				fail("failed" + e.getMessage());
			}
		} catch (Exception e) {
			fail("failed : " + e.getMessage());
		}

	}

	@Test
	public void testFindByDateBefore() {
		try {
			try {
				Date date = new Date();
				List<Interview> findByDate = interviewService.findByDateBefore(date);
				assertNotNull(findByDate);
				assertTrue(findByDate.size() > 0);
			} catch (Exception e) {
				fail("failed" + e.getMessage());
			}
		} catch (Exception e) {
			fail("failed : " + e.getMessage());
		}

	}

	@Test
	public void testFindByDateAfter() {
		try {
			try {
				Date date = new Date();
				date.setTime(date.getTime() - 1000 * 60 * 60 * 24 * 5);// 5 days
				List<Interview> findByDate = interviewService.findByDateAfter(date);
				assertNotNull(findByDate);
				assertTrue(findByDate.size() > 0);
			} catch (Exception e) {
				fail("failed" + e.getMessage());
			}
		} catch (Exception e) {
			fail("failed : " + e.getMessage());
		}

	}

	@Test
	public void testFindByDateBetween() {
		try {
			try {
				Date dateTo = new Date();
				Date dateFrom = new Date();
				dateFrom.setTime(dateFrom.getTime() - 1000 * 60 * 60 * 24 * 5);// 5 days
				List<Interview> findByDate = interviewService.findByDateBetween(dateFrom, dateTo);
				assertNotNull(findByDate);
				assertTrue(findByDate.size() > 0);
			} catch (Exception e) {
				fail("failed" + e.getMessage());
			}
		} catch (Exception e) {
			fail("failed : " + e.getMessage());
		}
	}
	
	@Test
	public void testFindByDU() {
		try {
			try {
				String du="IP & Cloud";
				String line="";
				List<Interview> findByDUAndLine = interviewService.findByDUAndLine(du, line);
				assertNotNull(findByDUAndLine);
				assertTrue(findByDUAndLine.size() > 0);
			} catch (Exception e) {
				fail("failed" + e.getMessage());
			}
		} catch (Exception e) {
			fail("failed : " + e.getMessage());
		}
	}
	
	@Test
	public void testFindByDUAndLine() {
		try {
			try {
				String du="IP & Cloud";
				String line="Craft";
				List<Interview> findByDUAndLine = interviewService.findByDUAndLine(du, line);
				assertNotNull(findByDUAndLine);
				assertTrue(findByDUAndLine.size() > 0);
			} catch (Exception e) {
				fail("failed" + e.getMessage());
			}
		} catch (Exception e) {
			fail("failed : " + e.getMessage());
		}
	}

}
