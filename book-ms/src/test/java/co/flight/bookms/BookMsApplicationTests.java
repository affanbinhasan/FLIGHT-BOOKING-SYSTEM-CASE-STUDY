package co.flight.bookms;

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

import co.flight.bookms.repository.BookingRepo;
import co.flight.bookms.service.*;
import co.flight.bookms.controller.*;
import co.flight.bookms.model.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
class BookMsApplicationTests {

	@Autowired
    BookingService BookingService;

	@Autowired
	private BookingController BookingController;
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookingRepo BookingRepo;
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
		assertTrue(BookingController != null);
	}

	@Test
	public void checkRepoConnection() throws Exception {
		this.mockMvc.perform(get("/book"));
		
	}


	@Test
	@DisplayName("Booking Repo can't be null")
	void testgetAllBooking(){
		BookingService BookingService = new BookingService();
		assertFalse(BookingService == null);
		List<Booking> list = BookingRepo.findAll();
		assertFalse(list == null);
	}

	@Test
	@DisplayName("Booking must be returned id when ID is correct else must not")
	void testBookingById(){
		BookingService bookingService = new BookingService();
		assertFalse(bookingService == null);
		Optional<Booking> booking =  BookingRepo.findById("test");
		assertFalse(booking.isPresent());
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
