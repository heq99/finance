package qiang.finance.intradaydata.reader;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import qiang.finance.intradaydata.reader.entities.PriceTicker;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;
import java.util.StringTokenizer;

@Component
public class IntradayDataReader {

    public void readPrice() throws IOException {

        String url = "https://chartapi.finance.yahoo.com/instrument/1.0/%5Eftse/chartdata;type=quote;range=1d/csv";

        String response = IOUtils.toString(new URL(url));

        BufferedReader reader = new BufferedReader(new StringReader(response));

        boolean dataComing = false;

        String line = reader.readLine();
        while (line != null) {

            if (dataComing) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                String strTimeStamp = tokenizer.nextToken();
                String strClose = tokenizer.nextToken();
                String strHigh = tokenizer.nextToken();
                String strLow = tokenizer.nextToken();
                String strOpen = tokenizer.nextToken();
                String strVolume = tokenizer.nextToken();

                Date timestamp = new Date(Long.parseLong(strTimeStamp) * 1000);
                BigDecimal close = new BigDecimal(strClose);
                BigDecimal high = new BigDecimal(strHigh);
                BigDecimal low = new BigDecimal(strLow);
                BigDecimal open = new BigDecimal(strOpen);
                Long volume = Long.parseLong(strVolume);

                PriceTicker priceTicker = new PriceTicker(timestamp, close, high, low, open, volume);

                System.out.println("time: " + timestamp + "   close: " + close + "   high: " + high + "   low: " + low + "   open: " + open + "    volume: " + volume);
            }

            if (line.startsWith("volume")) {
                dataComing = true;
            }

            line = reader.readLine();
        }

    }
}
