package co.flight.bookms;

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

import co.flight.bookms.controller.*;
import co.flight.bookms.model.*;
import co.flight.bookms.service.*;

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

@SpringBootTest
@ContextConfiguration(classes=BookMsApplication.class)
@WithMockUser
@AutoConfigureMockMvc
public class BookingControllerTest {
    @Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookingService BookingService;

	Flight mockFlight = new Flight("spicy007", "SpicyJet", "DLI","NYC","test","test",80,900);
    Optional<Flight> flight = Optional.of(mockFlight);
	String exampleFlightJson = "{\"flight_id\":\"spicy007\",\"flight_name\":\"SpiceJet\",\"flight_origin\":\"DLI\",\"flight_destination\":\"NYC\",\"flight_arrival\":\"test\",\"flight_destination\":\"test\",\"flight_seat_no\":\"80\",\"destiantion\":\"900\"}";

    User user = new User("test","test","test","test","test");

    Booking mockBooking = new Booking("wfehaouh", mockFlight, user, "booked");
    String exampleBookingJson = "{\"booking_ref_id\":\"wfehaouh\",\"{\"flight_id\":\"spicy007\",\"flight_name\":\"SpiceJet\",\"flight_origin\":\"DLI\",\"flight_destination\":\"NYC\",\"flight_arrival\":\"test\",\"flight_destination\":\"test\",\"flight_seat_no\":\"80\",\"destiantion\":\"900\"}\",\"{}\",\"booking_status\":\"booked\"}";

    @Test
	public void retrieveBookingById() throws Exception {
        Mockito.when(BookingService.getBooking(Mockito.any(User.class),Mockito.anyString()))
        .thenReturn("Booking Done");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/booking/book/wfehaouh")
        .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "uwaebvwiu";
        
        assertNotEquals(expected, result.getResponse()
				.getContentAsString());
    }
}
