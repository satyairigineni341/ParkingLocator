package com.api.parking.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "PARKING_SLOTS")
public class ParkingSlotsDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@NotBlank
	private Integer availableSlots;
	
}
