package co.flight.searchms;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import co.flight.searchms.controller.FlightController;
import co.flight.searchms.service.FlightService;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SearchMsApplicationTests {

	@Autowired
    FlightService FlightService;

	@Autowired
	private FlightController flightController;
	
	@Autowired
	private MockMvc mockMvc;
	// static int count = 0;

	// @BeforeAll
    // public static void setup(){
	// 	System.out.println("Initiating Unit Testing");
    // }

	// @BeforeEach
    // public static void setbefore(){
    //     System.out.println("Test Case "+ count + " running");
    // }

	@Test
	void contextLoads() {
		assertTrue(flightController != null);
	}

	@Test
	public void shouldReturnAllFlights() throws Exception {
		this.mockMvc.perform(get("/"));
		
	}


	// @Test
	// @DisplayName("Flight Repo can't be null")
	// void testgetAllflights(){
	// 	FlightService flightService = new FlightService();
	// 	assertFalse(flightService == null);
	// 	List<Flight> list = flightService.getFlight();
	// 	assertFalse(list == null);
	// }

	// @Test
	// @DisplayName("Flight must be available when data is correct")
	// void testgetflightsFromOrigIntoDest(){
	// 	FlightService flightService = new FlightService();
	// 	List<Flight> list = flightService.getFlightByOriginDest("test","test");
	// 	assertTrue(list != null);
	// }

	// @Test
	// @DisplayName("Flight must be returned id ID is correct")
	// void testFlightById(){
	// 	FlightService flightService = new FlightService();
	// 	Optional<Flight> flight =  flightService.getFlightbyId("test");
	// 	assertFalse(flight == null);
	// }
	
	// @AfterEach
    // public static void setAfter(){
    //     System.out.println("Test Case "+ count + " Completed");
    //     count++;
    // }

    // @AfterAll
    // public static void setEnd(){
    //     System.out.println("Testing Completed");
    // }


}
