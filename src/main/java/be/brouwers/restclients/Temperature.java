package be.brouwers.restclients;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Temperature {
	@XmlAttribute
	BigDecimal max;
	@XmlAttribute
	BigDecimal min;
	@XmlAttribute
	BigDecimal value;
	
	public BigDecimal getMax() {
		return max;
	}
	public BigDecimal getMin() {
		return min;
	}
	public BigDecimal getValue() {
		return value;
	}
}
