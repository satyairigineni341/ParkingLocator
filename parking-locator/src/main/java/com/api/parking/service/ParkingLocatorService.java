/**
 * 
 */

package com.api.parking.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.parking.exception.LocationNotFoundException;
import com.api.parking.modal.ParkingSlots;
import com.api.parking.modal.ParkingSlotsDB;
import com.api.parking.repository.ParkingLocatorRepository;

@Service
public class ParkingLocatorService {

	@Autowired
	private ParkingLocatorRepository locatorRepository;

	/**
	 * This method DB with the query to get the available parking spaces for given location.
	 * @param locationdetails Holds the zipcode or combination of street name and city.
	 * @return ParkingSlots holds number of parking slots available.
	 */
	public ParkingSlots availableParkingSpaces(String locationDetails) {
		
		ParkingSlotsDB availableSlots = locatorRepository.findById(locationDetails)
		.orElseThrow(() -> new LocationNotFoundException("parking", "location", locationDetails));
		
		ParkingSlots parkingSlots = new ParkingSlots();
		BeanUtils.copyProperties(availableSlots, parkingSlots);
		
		return parkingSlots;
	}

	

}
