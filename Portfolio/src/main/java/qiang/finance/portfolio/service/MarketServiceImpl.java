package qiang.finance.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qiang.finance.portfolio.dao.jpa.MarketDao;
import qiang.finance.portfolio.domain.Market;

@Service("marketService")
public class MarketServiceImpl implements MarketService {
	
	@Autowired
	private MarketDao marketDao;
	
	@Override
	public List<Market> getAllMarkets() {
		return marketDao.getAll();
	}

	@Override
	public Market getMarketById(Integer id) {
		return marketDao.get(id);
	}

	@Override
	@Transactional
	public Market saveMarket(Market market) {
		return marketDao.save(market);
	}
	
	@Override
	@Transactional
	public Market updateMarket(Market market) {
		return marketDao.update(market);
	}
	
	@Override
	@Transactional 
	public Market deleteMarket(Integer id) {
		return marketDao.delete(marketDao.get(id));
	}
}
