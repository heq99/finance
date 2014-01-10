package qiang.finance.portfolio.service;

import java.util.List;

import qiang.finance.portfolio.domain.Market;

public interface MarketService {
	
	List<Market> getAllMarkets();

	Market getMarketById(Integer id);
	Market saveMarket(Market market);
	Market updateMarket(Market market);
	Market deleteMarket(Integer id);
}
