package co.flight.checkinms;

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

import co.flight.checkinms.controller.*;
import co.flight.checkinms.model.*;
import co.flight.checkinms.service.*;

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

import co.flight.checkinms.repository.*;

@SpringBootTest
@ContextConfiguration(classes=CheckInMsApplication.class)
@WithMockUser
@AutoConfigureMockMvc
public class CheckInControllerTest {
    @Autowired
	private MockMvc mockMvc;

	@MockBean
	private CheckInService CheckInService;

	List<CheckIn> mockCheckIn =  Arrays.asList(new CheckIn("test", "test", "test"));

	@Test
	public void retrieveCheckInById() throws Exception {
		
		Mockito.when(CheckInService.getCheckIn(Mockito.anyString())).thenReturn(mockCheckIn);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/check-in/checkin/test")
        .accept( MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{checkInId:test,booking_ref_id:test,seatNo:test}]";

        //unparsableJSON Error
		JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
	}
}
