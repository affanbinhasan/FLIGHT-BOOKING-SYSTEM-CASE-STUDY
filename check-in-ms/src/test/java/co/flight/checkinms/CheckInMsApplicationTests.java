package co.flight.checkinms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import co.flight.checkinms.repository.*;
import co.flight.checkinms.service.*;
import co.flight.checkinms.controller.*;
import co.flight.checkinms.model.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
class CheckInMsApplicationTests {

	@Autowired
    CheckInService CheckInService;

	@Autowired
	private CheckInController CheckInController;
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CheckInRepo CheckInRepo;
	static int count = 0;

	@BeforeAll
    public void setup(){
		System.out.println("Initiating Unit Testing");
    }

	@BeforeEach
    public void setbefore(){
        System.out.println("Test Case "+ count + " running");
    }

	@Test
	void contextLoads() {
		assertTrue(CheckInController != null);
	}

	@Test
	public void checkRepoConnection() throws Exception {
		this.mockMvc.perform(get("/checkin"));
	}


	@Test
	@DisplayName("CheckIn Repo can't be null")
	void testgetAllCheckIn(){
		CheckInService CheckInService = new CheckInService();
		assertFalse(CheckInService == null);
		List<CheckIn> list = CheckInRepo.findAll();
		assertFalse(list == null);
	}

	@Test
	@DisplayName("CheckIn must be returned id when ID is correct")
	void testCheckById(){
		CheckInService CheckInService = new CheckInService();
		assertFalse(CheckInService == null);
		Optional<CheckIn> checkin =  CheckInRepo.findById("test");
		assertFalse(checkin.isPresent());
	}
	
	@AfterEach
    public void setAfter(){
        System.out.println("Test Case "+ count + " Completed");
        count++;
    }

    @AfterAll
    public void setEnd(){
        System.out.println("Testing Completed");
    }

}
