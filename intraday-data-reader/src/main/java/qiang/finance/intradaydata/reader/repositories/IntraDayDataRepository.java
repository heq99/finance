package qiang.finance.intradaydata.reader.repositories;

import org.springframework.data.repository.CrudRepository;
import qiang.finance.intradaydata.reader.entities.IntraDayData;

/**
 * Created by qhe on 12/02/16.
 */
public interface IntraDayDataRepository extends CrudRepository<IntraDayData, Long> {

}
