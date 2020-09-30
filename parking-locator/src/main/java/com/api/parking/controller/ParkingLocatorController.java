/**
 * 
 */

package com.api.parking.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parking.modal.ParkingSlots;
import com.api.parking.service.ParkingLocatorService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/api")
@Slf4j
public class ParkingLocatorController {

	@Autowired
	private ParkingLocatorService parkingLocatorService;

	
	@GetMapping(value = "/parkingslot/{locationDetails}")
	@ApiOperation(value = "GET enrollee", response = Integer.class)
	public ParkingSlots availableParkingSpaces(@NotNull @PathVariable String locationDetails) throws Exception{
		log.info(" input location details ",locationDetails);
		ParkingSlots parkingSlots = parkingLocatorService.availableParkingSpaces(locationDetails);
		return parkingSlots;
	}

	}
