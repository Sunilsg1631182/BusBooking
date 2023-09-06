package com.jsp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Booking;
@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

}
