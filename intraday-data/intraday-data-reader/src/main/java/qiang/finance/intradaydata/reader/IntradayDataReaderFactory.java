package qiang.finance.intradaydata.reader;

import org.springframework.stereotype.Component;
import qiang.finance.intradaydata.reader.entities.DataSourceDefinition;

/**
 * Created by Qiang He on 20/03/2016.
 */
@Component
public class IntradayDataReaderFactory {

    public IntradayDataReader getIntradayDataReader(DataSourceDefinition dataSourceDefinition) {
        return null;
    }

}
