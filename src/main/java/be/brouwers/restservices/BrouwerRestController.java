package be.brouwers.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import be.brouwers.entities.Brouwer;
import be.brouwers.exceptions.BrouwerNietGevondenException;
import be.brouwers.services.BrouwerService;

@RestController
@RequestMapping("/brouwers")
@ExposesResourceFor(Brouwer.class)
public class BrouwerRestController {
	private final BrouwerService brouwerService;
	private final EntityLinks entityLinks;
	
	@Autowired
	BrouwerRestController(BrouwerService brouwerService, EntityLinks entityLinks) {
		this.brouwerService = brouwerService;
		this.entityLinks = entityLinks;
	}
	
	@ExceptionHandler(BrouwerNietGevondenException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	void brouwerNietGevonden() {}
	
	@RequestMapping(path = "{brouwer}", method = RequestMethod.GET)
	BrouwerResource read(@PathVariable Brouwer brouwer) {
		if (brouwer == null) {
			throw new BrouwerNietGevondenException();
		}
		return new BrouwerResource(brouwer, entityLinks);
	}
	
	@RequestMapping(params="beginnaam", method = RequestMethod.GET)
	BrouwersResource findAll(String beginnaam) {
		return new BrouwersResource(brouwerService.findByBeginnaam(beginnaam), entityLinks);
	}
}
