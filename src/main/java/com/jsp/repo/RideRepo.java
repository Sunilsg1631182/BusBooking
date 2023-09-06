package com.jsp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Ride;

@Repository
public interface RideRepo extends JpaRepository<Ride,Integer> {

}
