package co.flight.searchms;

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

import co.flight.searchms.controller.FlightController;
import co.flight.searchms.model.Flight;
import co.flight.searchms.service.FlightService;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import co.flight.searchms.repository.FlightRepo;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
public class SearchMsApplicationTests {

	@Autowired
    FlightService FlightService;

	@Autowired
	private FlightController flightController;
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FlightRepo FlightRepo;
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
		assertTrue(flightController != null);
	}

	@Test
	public void shouldReturnAllFlights() throws Exception {
		this.mockMvc.perform(get("/flight/admin/getflight"));
		
	}


	@Test
	@DisplayName("Flight Repo can't be null")
	void testgetAllflights(){
		FlightService flightService = new FlightService();
		assertFalse(flightService == null);
		List<Flight> list = FlightRepo.findAll();
		assertFalse(list == null);
	}

	@Test
	@DisplayName("Flight must be available when data is correct")
	void testgetflightsFromOrigIntoDest(){
		FlightService flightService = new FlightService();
		assertFalse(flightService == null);
		List<Flight> list = FlightRepo.getMatchingFlight("test", "test");
		assertTrue(list != null);
	}

	@Test
	@DisplayName("Flight must be returned id ID is correct")
	void testFlightById(){
		FlightService flightService = new FlightService();
		assertFalse(flightService == null);
		Optional<Flight> flight =  FlightRepo.findById("test");
		assertFalse(flight == null);
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
