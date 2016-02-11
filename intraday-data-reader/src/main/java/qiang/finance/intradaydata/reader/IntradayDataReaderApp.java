package qiang.finance.intradaydata.reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Created by Qiang He on 08/02/2016.
 */
@Configuration
@ComponentScan
public class IntradayDataReaderApp {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(IntradayDataReader.class);
        IntradayDataReader intradayDataReader = context.getBean(IntradayDataReader.class);
        intradayDataReader.readPrice();
    }

}
