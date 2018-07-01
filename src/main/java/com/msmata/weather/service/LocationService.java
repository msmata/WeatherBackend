package com.msmata.weather.service;

import com.msmata.weather.model.Location;

public interface LocationService {

	Location findByWoeid(Long woeid);
}
