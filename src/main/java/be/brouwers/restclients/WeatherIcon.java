package be.brouwers.restclients;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class WeatherIcon {
	@XmlAttribute
	private String icon;
	@XmlAttribute
	private String value;
	
	public String getIcon() {
		return icon;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getIconImage() {
		return "http://openweathermap.org/img/w/" + icon + ".png";
	}
}
