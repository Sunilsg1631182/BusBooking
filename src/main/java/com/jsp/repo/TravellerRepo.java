package com.jsp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Traveller;


@Repository
public interface TravellerRepo extends JpaRepository<Traveller,Integer> {

}
