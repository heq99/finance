package qiang.finance.portfolio.dao.jpa;

import org.springframework.stereotype.Repository;

import qiang.finance.portfolio.domain.Market;

@Repository("marketDao")
public class MarketDaoJpa extends GenericDaoJpa<Market> implements MarketDao {

	public MarketDaoJpa() {
		super(Market.class);
	}

}
