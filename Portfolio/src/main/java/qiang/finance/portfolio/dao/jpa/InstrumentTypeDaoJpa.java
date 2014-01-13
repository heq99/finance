package qiang.finance.portfolio.dao.jpa;

import org.springframework.stereotype.Repository;

import qiang.finance.portfolio.domain.InstrumentType;

@Repository("instrumentTypeDao")
public class InstrumentTypeDaoJpa extends GenericDaoJpa<InstrumentType> implements
		InstrumentTypeDao {
	
	public InstrumentTypeDaoJpa() {
		super(InstrumentType.class);
	}

}
