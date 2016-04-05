package be.brouwers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import be.brouwers.dao.BrouwerDAO;
import be.brouwers.entities.Brouwer;

@ReadOnlyTransactionalService
public class BrouwerServiceImpl implements BrouwerService {

	private final BrouwerDAO brouwerDAO;
	
	@Autowired
	public BrouwerServiceImpl(BrouwerDAO brouwerDAO) {
		this.brouwerDAO = brouwerDAO;
	}
	
	@Override
	public Brouwer read(long id) {
		return brouwerDAO.findOne(id);
	}
	
	@Override
	@ModifyingTransactionalServiceMethod
	public void create(Brouwer brouwer) {
		brouwerDAO.save(brouwer);
	}
	
	@Override
	@ModifyingTransactionalServiceMethod
	public void update(Brouwer brouwer) {
		brouwerDAO.save(brouwer);
	}

	@Override
	public List<Brouwer> findAll() {
		return brouwerDAO.findAll(new Sort("naam"));
	}
	
	@Override
	public Page<Brouwer> findAll(Pageable pageable) {
		return brouwerDAO.findAll(pageable);
	}

	@Override
	public Page<Brouwer> findByBeginnaam(String beginnaam, Pageable pageable) {
		return brouwerDAO.findByNaamStartingWithOrderByNaam(beginnaam, pageable);
	}
	
	@Override
	public List<Brouwer> findByBeginnaam(String beginnaam) {
		return brouwerDAO.findByNaamStartingWithOrderByNaam(beginnaam);
	}
	
	@Override
	@ModifyingTransactionalServiceMethod
	public void delete(long id) {
		brouwerDAO.delete(id);
	}

}
