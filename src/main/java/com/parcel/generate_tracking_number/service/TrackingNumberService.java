package com.parcel.generate_tracking_number.service;

import java.time.OffsetDateTime;
import java.util.random.RandomGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcel.generate_tracking_number.repository.TrackingNumberRepository;
import com.parcel.generate_tracking_number.util.TrackingNumber;

import jakarta.transaction.Transactional;

@Service
public class TrackingNumberService {

	@Autowired
	private TrackingNumberRepository trackingNumberRepository;

	@Transactional
	public TrackingNumber generateTrackingNumber() {
		String trackingNumber;
		do {
			trackingNumber = createTrackingNumber();
		} while (trackingNumberRepository.existsByTrackingNumber(trackingNumber));

		TrackingNumber trackingNumberEntity = new TrackingNumber();
		trackingNumberEntity.setTrackingNumber(trackingNumber);
		trackingNumberEntity.setCreatedAt(OffsetDateTime.now());

		return trackingNumberRepository.save(trackingNumberEntity);
	}

	public String createTrackingNumber() {
		RandomGenerator generator = RandomGenerator.getDefault();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		StringBuilder password = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			int index = generator.nextInt(characters.length());
			password.append(characters.charAt(index));
		}
		return password.toString();
	}
}
