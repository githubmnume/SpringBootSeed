package interview.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//@RunWith(Suite.class)
@RunWith(SpringRunner.class)
@SuiteClasses({InterviewServiceTest.class})
public class InterviewServiceTests {

}
