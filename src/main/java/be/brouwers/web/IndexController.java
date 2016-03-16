package be.brouwers.web;

import java.util.Calendar;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class IndexController {

	private final static String VIEW = "index";
	private final static String GROET = "groet";
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView index(Locale locale) {
		return new ModelAndView(VIEW, GROET,
				getGroet(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)));
	}
	
	private String getGroet(int hour) {
		if (hour >= 0 && hour <= 5) {
			return "GoedeNacht";
		}
		if (hour >= 6 && hour <= 11) {
			return "GoedeMorgen";
		}
		if (hour >=12 && hour <= 17) {
			return "GoedeMiddag";
		}
		return "GoedeAvond";
	}
}
