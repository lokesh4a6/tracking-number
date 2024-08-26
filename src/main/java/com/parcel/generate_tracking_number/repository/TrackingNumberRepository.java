package com.parcel.generate_tracking_number.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parcel.generate_tracking_number.util.TrackingNumber;

public interface TrackingNumberRepository extends JpaRepository<TrackingNumber, UUID> {

	  boolean existsByTrackingNumber(String trackingNumber);
}
