package com.msmata.weather.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msmata.weather.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
