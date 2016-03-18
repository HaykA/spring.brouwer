package be.brouwers.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.brouwers.entities.Brouwer;

public interface BrouwerService {
	Brouwer read(long id);
	void create(Brouwer brouwer);
	List<Brouwer> findAll();
	Page<Brouwer> findAll(Pageable pageable);
	Page<Brouwer> findByBeginnaam(String beginnaam, Pageable pageable);
	void delete(long id);
	void update(Brouwer brouwer);
}
