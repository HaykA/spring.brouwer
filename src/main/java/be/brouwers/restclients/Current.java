package be.brouwers.restclients;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Current {
	Temperature temperature;
	@XmlElement(name = "weather")
	WeatherIcon weatherIcon;
	
	public Temperature getTemperature() {
		return temperature;
	}
	
	public WeatherIcon getWeatherIcon() {
		return weatherIcon;
	}
	
	
}
