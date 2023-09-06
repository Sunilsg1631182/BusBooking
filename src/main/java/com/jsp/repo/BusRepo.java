package com.jsp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Bus;

@Repository
public interface BusRepo extends JpaRepository<Bus, Integer> {

}
