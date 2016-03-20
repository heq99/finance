package qiang.finance.intradaydata.reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import qiang.finance.intradaydata.IntradayDataCoreConfig;

import java.io.IOException;

/**
 * Created by Qiang He on 08/02/2016.
 */
@Configuration
@Import(IntradayDataCoreConfig.class)
public class IntradayDataReaderApp {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(IntradayDataReaderApp.class);
        CsvIntradayDataReader csvIntradayDataReader = context.getBean(CsvIntradayDataReader.class);
        csvIntradayDataReader.read();

        JsonIntradayDataReader jsonIntradayDataReader = context.getBean(JsonIntradayDataReader.class);
        jsonIntradayDataReader.read();
    }

}
