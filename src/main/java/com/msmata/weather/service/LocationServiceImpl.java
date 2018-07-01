package com.msmata.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msmata.weather.dao.LocationRepository;
import com.msmata.weather.model.Location;

@Service("locationService")
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public Location findByWoeid(Long woeid) {
		return locationRepository.findByWoeid(woeid);
	}

}
