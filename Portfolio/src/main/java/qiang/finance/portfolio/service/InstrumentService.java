package qiang.finance.portfolio.service;

import java.util.List;

import qiang.finance.portfolio.domain.Instrument;
import qiang.finance.portfolio.domain.Market;

public interface InstrumentService {
	
	List<Instrument> getInstrumentsByMarket(Market market);
	
	Instrument getInstrumentById(Integer id);
	Instrument saveInstrument(Instrument instrument);
	Instrument updateInstrument(Instrument instrument);
	Instrument deleteInstrument(Integer id);

}
