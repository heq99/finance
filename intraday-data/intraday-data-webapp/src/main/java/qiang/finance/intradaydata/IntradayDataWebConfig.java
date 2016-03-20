package qiang.finance.intradaydata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Qiang He on 04/03/2016.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@Import(IntradayDataCoreConfig.class)
public class IntradayDataWebConfig {

    public static void main(String[] args) {
        SpringApplication.run(IntradayDataWebConfig.class, args);
    }

}
