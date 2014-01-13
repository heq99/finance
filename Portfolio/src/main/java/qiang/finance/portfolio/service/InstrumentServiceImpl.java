package qiang.finance.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qiang.finance.portfolio.dao.jpa.InstrumentDao;
import qiang.finance.portfolio.domain.Instrument;
import qiang.finance.portfolio.domain.Market;

@Service("instrumentService")
public class InstrumentServiceImpl implements InstrumentService {
	
	@Autowired
	private InstrumentDao instrumentDao;

	@Override
	public List<Instrument> getInstrumentsByMarket(Market market) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instrument getInstrumentById(Integer id) {
		return instrumentDao.get(id);
	}

	@Override
	@Transactional
	public Instrument saveInstrument(Instrument instrument) {
		return instrumentDao.save(instrument);
	}

	@Override
	@Transactional
	public Instrument updateInstrument(Instrument instrument) {
		return instrumentDao.update(instrument);
	}

	@Override
	@Transactional
	public Instrument deleteInstrument(Integer id) {
		return instrumentDao.delete(instrumentDao.get(id));
	}

}
