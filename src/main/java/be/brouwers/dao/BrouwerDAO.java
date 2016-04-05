package be.brouwers.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import be.brouwers.entities.Brouwer;

public interface BrouwerDAO extends JpaRepository<Brouwer, Long> {
	Page<Brouwer> findByNaamStartingWithOrderByNaam(String beginnaam, Pageable pageable);
	List<Brouwer> findByNaamStartingWithOrderByNaam(String beginnaam);
	@Override
	Page<Brouwer> findAll(Pageable pageable);
}
