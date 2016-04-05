package be.brouwers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.brouwers.restclients.Current;
import be.brouwers.restclients.WeatherClient;

@Service
public class OpenWeatherMapService implements WeatherService {

	private final WeatherClient weatherClient;
	
	@Autowired
	OpenWeatherMapService(WeatherClient weatherClient) {
		this.weatherClient = weatherClient;
	}
	
	@Override
	public Current getCurrent(String gemeente) {
		return weatherClient.getCurrent(gemeente);
	}

}
