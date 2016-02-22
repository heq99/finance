package qiang.finance.intradaydata.reader;

import org.springframework.beans.factory.annotation.Autowired;
import qiang.finance.intradaydata.reader.repositories.IntraDayDataRepository;
import qiang.finance.intradaydata.reader.repositories.ProductRepository;

/**
 * Created by qhe on 13/02/16.
 */
public abstract class IntradayDataReader {

    @Autowired
    protected IntraDayDataRepository repository;

    @Autowired
    protected ProductRepository productRepository;

    abstract public void read();

}
