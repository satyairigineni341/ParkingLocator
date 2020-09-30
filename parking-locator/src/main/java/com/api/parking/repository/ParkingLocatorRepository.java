package com.api.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.parking.modal.ParkingSlotsDB;

@Repository
public interface ParkingLocatorRepository extends JpaRepository<ParkingSlotsDB, String>{

}
