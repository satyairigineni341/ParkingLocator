/**
 * 
 */
package com.api.parking.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.api.parking.modal.ParkingSlots;
import com.api.parking.service.ParkingLocatorService;

/**
 * @author Satya
 *
 */
@WebMvcTest(value = ParkingLocatorController.class)
class ParkingLocatorControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ParkingLocatorService parkingLocatorService;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.api.parking.controller.ParkingLocatorController#availableParkingSpaces(java.lang.String)}.
	 * @return ParkingSlots holds the number of parking spaces available
	 * @throws Exception 
	 */
	@Test
	void testAvailableParkingSpaces$Validzipcode() throws Exception {
		ParkingSlots parkingSlots = new ParkingSlots();
		parkingSlots.setAvailableSlots(9);
		Mockito.when(parkingLocatorService.availableParkingSpaces(Mockito.anyString())).thenReturn(parkingSlots);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/api/parkingslot/99876");
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		assertEquals("{\"availableSlots\":9}", mvcResult.getResponse().getContentAsString());
		
	}
	
	/**
	 * Test method for {@link com.api.parking.controller.ParkingLocatorController#availableParkingSpaces(java.lang.String)}.
	 * @return ParkingSlots holds the number of parking spaces available
	 * @throws Exception 
	 */
	@Test
	void testAvailableParkingSpaces$ValidStreetName() throws Exception {
		ParkingSlots parkingSlots = new ParkingSlots();
		parkingSlots.setAvailableSlots(22);
		Mockito.when(parkingLocatorService.availableParkingSpaces(Mockito.anyString())).thenReturn(parkingSlots);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/api/parkingslot/14th Street");
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		assertEquals("{\"availableSlots\":22}", mvcResult.getResponse().getContentAsString());
		
	}
	
	}
