package co.flight.searchms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import co.flight.searchms.controller.FlightController;
import co.flight.searchms.model.Flight;
import co.flight.searchms.service.FlightService;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import co.flight.searchms.repository.FlightRepo;


@SpringBootTest
@ContextConfiguration(classes=SearchMsApplication.class)
@WithMockUser
@AutoConfigureMockMvc
public class FlightControllerTest {
    @Autowired
	private MockMvc mockMvc;

	@MockBean
	private FlightService FlightService;

	Flight mockFlight = new Flight("spicy007", "SpicyJet", "DLI","NYC","test","test",80,900);
    Optional<Flight> flight = Optional.of(mockFlight);
	String exampleFlightJson = "{\"flight_id\":\"spicy007\",\"flight_name\":\"SpiceJet\",\"flight_origin\":\"DLI\",\"flight_destination\":\"NYC\",\"flight_arrival\":\"test\",\"flight_destination\":\"test\",\"flight_seat_no\":\"80\",\"destiantion\":\"900\"}";

	@Test
	public void retrieveFlightById() throws Exception {
		
		Mockito.when(
				FlightService.getFlightbyId(Mockito.anyString())).thenReturn(flight);

            RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                    "/flight/getflight/spicy007").accept(
                    MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{flight_id:spicy007,flight_name:SpicyJet,flight_origin:DLI,flight_destination:NYC,flight_arrival:test,flight_departure:test,flight_seat_no:80,duration:900}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

	@Test
	public void postFlightData() throws Exception {
		Mockito.when(FlightService.addFlight(Mockito.any(Flight.class)))
		.thenReturn(mockFlight);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/flight/admin/addflight")
				.accept(MediaType.APPLICATION_JSON).content(exampleFlightJson)
				.contentType(MediaType.APPLICATION_JSON);
		

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertNotEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertNotEquals("http://localhost:9001/flight/admin/addflight",
				response.getHeader(HttpHeaders.LOCATION));
	}

}
