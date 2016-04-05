package be.brouwers.restclients;

public interface WeatherClient {
	Current getCurrent(String gemeente);
}
