package be.brouwers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.brouwers.exceptions.KanTemperatuurNietLezenException;
import be.brouwers.services.WeatherService;

@Controller
@RequestMapping("weather")
public class WeatherController {
	private static final String VIEW = "weather/temperature";
	private final WeatherService weatherService;
	
	@Autowired
	WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	@RequestMapping(path = "{gemeente}/temperature", method = RequestMethod.GET)
	ModelAndView weather(@PathVariable String gemeente) {
		ModelAndView modelAndView = new ModelAndView(VIEW);
		try {
			modelAndView.addObject("current", weatherService.getCurrent(gemeente));
		} catch (KanTemperatuurNietLezenException ex) {
			modelAndView.addObject("fout", "kan temperatuur niet lezen");
		}
		return modelAndView;
	}
}
