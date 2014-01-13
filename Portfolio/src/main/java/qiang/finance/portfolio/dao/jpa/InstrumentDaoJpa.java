package qiang.finance.portfolio.dao.jpa;

import org.springframework.stereotype.Repository;

import qiang.finance.portfolio.domain.Instrument;

@Repository("instrumentDao")
public class InstrumentDaoJpa extends GenericDaoJpa<Instrument> implements InstrumentDao {
	
	public InstrumentDaoJpa() {
		super(Instrument.class);
	}

}
