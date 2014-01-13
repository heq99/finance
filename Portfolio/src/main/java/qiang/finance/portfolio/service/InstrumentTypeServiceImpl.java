package qiang.finance.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qiang.finance.portfolio.dao.jpa.InstrumentTypeDao;
import qiang.finance.portfolio.domain.InstrumentType;

@Service("instrumentTypeService")
public class InstrumentTypeServiceImpl implements InstrumentTypeService {
	
	@Autowired
	private InstrumentTypeDao instrumentTypeDao;

	@Override
	public List<InstrumentType> getAllInstrumentTypes() {
		return instrumentTypeDao.getAll();
	}

	@Override
	public InstrumentType getInstrumentTypeById(Integer id) {
		return instrumentTypeDao.get(id);
	}

	@Override
	@Transactional
	public InstrumentType saveInstrumentType(InstrumentType instrumentType) {
		return instrumentTypeDao.save(instrumentType);
	}

	@Override
	@Transactional
	public InstrumentType updateInstrumentType(InstrumentType instrumentType) {
		return instrumentTypeDao.update(instrumentType);
	}

	@Override
	@Transactional
	public InstrumentType deleteInstrumentType(Integer id) {
		return instrumentTypeDao.delete(instrumentTypeDao.get(id));
	}

}
