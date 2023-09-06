package com.jsp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Seat;


@Repository
public interface SeatRepo extends JpaRepository<Seat,Integer> {

}
