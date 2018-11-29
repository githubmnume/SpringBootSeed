package interview.controller;

import static org.springframework.hateoas.client.Hop.rel;

import java.net.URI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Hop;
import org.springframework.hateoas.client.Traverson;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class InterviewTraversonIntegrationTests {

	@LocalServerPort
	private int port;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


    @Test
    public void envEndpointNotHidden() throws Exception {
        Traverson traverson = new Traverson(new URI("http://localhost:" + this.port + "/interview/4"), MediaTypes.HAL_JSON);
//        assertThat(itemResource.hasLink("self")).isTrue();
//        assertThat(traverson.follow("self").toObject("$.code").equals("200")).isTrue();
//        TraversalBuilder follow = traverson.follow("self");
//        assertThat(traverson.follow("self").toObject("$.code").equals("200")).isTrue();
        Hop rel = rel("self");
//        Link asLink = traverson.follow("self").asLink();
        Object object = traverson.follow(rel).toObject("$.code");
        System.out.println(object);
        //TODO
    }

}
