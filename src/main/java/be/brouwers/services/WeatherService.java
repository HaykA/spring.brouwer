package be.brouwers.services;

import be.brouwers.restclients.Current;

public interface WeatherService {
	Current getCurrent(String gemeente);
}
