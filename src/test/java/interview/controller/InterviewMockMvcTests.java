package interview.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import interview.system.util.ResultHttpCode;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
public class InterviewMockMvcTests extends BaseMockTest{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
    public void envEndpointNotHidden() throws Exception {
        mockMvc.perform(get("/interview"))
            .andExpect(jsonPath("$.code").value(ResultHttpCode.SC_OK));
    }
	
	@Test
    public void putInterview() throws Exception {
        mockMvc.perform(put("/interview",""))
            .andExpect(jsonPath("$.code").value(ResultHttpCode.SC_CREATED));
    }

}
