package be.brouwers.restclients;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import be.brouwers.exceptions.KanTemperatuurNietLezenException;

@Component
public class OpenWeatherMapClient implements WeatherClient {
	private static final Logger logger = Logger.getLogger(OpenWeatherMapClient.class.getName());
	private final String uriTemplate;
	private final RestTemplate restTemplate;
	
	@Autowired
	OpenWeatherMapClient(@Value("${openWeatherMapURL}") String uriTemplate,
			RestTemplate restTemplate) {
		this.uriTemplate = uriTemplate;
		this.restTemplate = restTemplate;
	}
	
	@Override
	public Current getCurrent(String gemeente) {
		try {
			return restTemplate.getForObject(uriTemplate, Current.class, gemeente);
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "kan temperatuur niet lezen", ex);
			throw new KanTemperatuurNietLezenException();
		}
	}

}
