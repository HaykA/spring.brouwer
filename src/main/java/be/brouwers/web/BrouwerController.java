package be.brouwers.web;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.brouwers.entities.Brouwer;
import be.brouwers.services.BrouwerService;

@Controller
@RequestMapping(path = "/brouwers", produces = MediaType.TEXT_HTML_VALUE)
class BrouwerController {

	private static final String BROUWERS_VIEW = "/brouwers/brouwers";
	private static final String ALFABET_VIEW = "/brouwers/opalfabet";
	private static final String BEGINNAAM_VIEW = "/brouwers/beginnaam";
	private static final String TOEVOEGEN_VIEW = "/brouwers/toevoegen";
	private static final String WIJZIGEN_VIEW = "/brouwers/wijzigen";
	private static final String REDIRECT_NA_TOEVOEGEN = "redirect:/brouwers";
	private static final String REDIRECT_URL_BROUWER_NIET_GEVONDEN = "redirect:/brouwers";
	private static final String REDIRECT_NA_VERWIJDEREN = "redirect:/brouwers";
	private static final String REDIRECT_NA_WIJZIGEN = "redirect:/brouwers";
	
	@SuppressWarnings("unused")
	private static final Logger logger
		= Logger.getLogger(BrouwerController.class.getName());
	private final BrouwerService brouwerService;
	private final char[] alfabet = new char['Z' - 'A' + 1];
	
	@Autowired
	BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			alfabet[letter - 'A'] = letter;
		}
	}
	
	@InitBinder("brouwer")
	void initBinderBrouwer(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView brouwers(Pageable pageable) {
		if (pageable.getPageSize() == 3) {
			PageRequest pr = new PageRequest(pageable.getPageNumber(), 6, pageable.getSort());
			pageable = new PageRequest(pageable.getPageNumber(), 6, pr.getSort());
		}
		System.out.println(pageable.getClass().getName());
		return new ModelAndView(BROUWERS_VIEW, "page",
				brouwerService.findAll(pageable));
	}
	
	@RequestMapping(path = "beginnaam", method = RequestMethod.GET)
	ModelAndView findByBeginnaam(Pageable pageable) {
		return new ModelAndView(BEGINNAAM_VIEW).addObject(new BeginnaamForm());
	}
	
	@RequestMapping(method = RequestMethod.GET, params="beginnaam")
	ModelAndView findByBeginnaam(@Valid BeginnaamForm beginnaamForm,
			Pageable pageable, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView(BEGINNAAM_VIEW).addObject("errBeginnaamEmpty", true);
		} else {
			return new ModelAndView(BEGINNAAM_VIEW, "page",
					brouwerService.findByBeginnaam(
							beginnaamForm.getBeginnaam(), pageable));
		}
	}
	
	@RequestMapping(path = "toevoegen", method = RequestMethod.GET)
	ModelAndView createForm() {
		return new ModelAndView(TOEVOEGEN_VIEW, "brouwer", new Brouwer());
	}
	
	@RequestMapping(path = "toevoegen", method = RequestMethod.POST)
	String create(@Valid Brouwer brouwer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return TOEVOEGEN_VIEW;
		}
		brouwerService.create(brouwer);
		return REDIRECT_NA_TOEVOEGEN;
	}
	
	@RequestMapping(path = "opalfabet/{x}", method = RequestMethod.GET)
	ModelAndView opAlfabet(@PathVariable String x, Pageable pageable) {
		return new ModelAndView(ALFABET_VIEW, "alfabet", alfabet)
				.addObject("page", brouwerService.findByBeginnaam(x, pageable))
				.addObject("gekozenLetter", x.toLowerCase().charAt(0));
	}
	
	@RequestMapping(path = "opalfabet", method = RequestMethod.GET)
	ModelAndView opAlfabet() {
		return new ModelAndView(ALFABET_VIEW, "alfabet", alfabet);
	}
	
	@RequestMapping(path = "{brouwer}/verwijderen", method = RequestMethod.POST)
	String delete(@PathVariable Brouwer brouwer) {
		if (brouwer == null) {
			return REDIRECT_URL_BROUWER_NIET_GEVONDEN;
		}
		brouwerService.delete(brouwer.getId());
		return REDIRECT_NA_VERWIJDEREN;
	}
	
	@RequestMapping(path = "{brouwer}/wijzigen", method = RequestMethod.GET)
	ModelAndView update(@PathVariable Brouwer brouwer) {
		if (brouwer == null) {
			return new ModelAndView(REDIRECT_URL_BROUWER_NIET_GEVONDEN);
		}
		return new ModelAndView(WIJZIGEN_VIEW).addObject(brouwer);
	}
	
	@RequestMapping(path = "{brouwer}/wijzigen", method = RequestMethod.POST)
	String update(@Valid Brouwer brouwer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return WIJZIGEN_VIEW;
		}
		brouwerService.update(brouwer);
		return REDIRECT_NA_WIJZIGEN;
	}
}
