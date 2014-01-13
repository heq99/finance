package qiang.finance.portfolio.service;

import java.util.List;

import qiang.finance.portfolio.domain.InstrumentType;

public interface InstrumentTypeService {
	
	List<InstrumentType> getAllInstrumentTypes();
	
	InstrumentType getInstrumentTypeById(Integer id);
	InstrumentType saveInstrumentType(InstrumentType instrumentType);
	InstrumentType updateInstrumentType(InstrumentType instrumentType);
	InstrumentType deleteInstrumentType(Integer id);
}
