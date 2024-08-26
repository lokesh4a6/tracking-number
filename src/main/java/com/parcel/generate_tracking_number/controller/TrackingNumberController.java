package com.parcel.generate_tracking_number.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parcel.generate_tracking_number.service.TrackingNumberService;
import com.parcel.generate_tracking_number.util.TrackingNumber;

@RestController
public class TrackingNumberController {

	@Autowired
	public TrackingNumberService trackingNumberService;
	
	
	@GetMapping("/next-tracking-number")
    public TrackingNumber  getNextTrackingNumber(
            @RequestParam(required = false) String origin_country_id,
            @RequestParam(required = false) String destination_country_id,
            @RequestParam(required = false) Double weight,
            @RequestParam(required = false) String created_at,
            @RequestParam(required = false) UUID customer_id,
            @RequestParam(required = false) String customer_name,
            @RequestParam(required = false) String customer_slug) {
    	
		return trackingNumberService.generateTrackingNumber();
    	
    }
}
