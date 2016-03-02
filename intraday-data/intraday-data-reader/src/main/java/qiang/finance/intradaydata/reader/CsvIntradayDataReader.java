package qiang.finance.intradaydata.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import qiang.finance.intradaydata.reader.config.ProxyConfiguration;
import qiang.finance.intradaydata.entities.IntraDayData;
import qiang.finance.intradaydata.entities.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.StringTokenizer;

@Component
public class CsvIntradayDataReader extends IntradayDataReader {

    private static final Logger logger = LoggerFactory.getLogger(CsvIntradayDataReader.class);

    @Autowired
    ProxyConfiguration proxyConfiguration;

    @Override
    public void read() {

        Product product = productRepository.findByName("FTSE 100 Index");
        if (product == null) {
            product = new Product();
            product.setName("FTSE 100 Index");
            product = productRepository.save(product);
        }

        String url = "http://chartapi.finance.yahoo.com/instrument/1.0/%5Eftse/chartdata;type=quote;range=1d/csv";

        URLConnection urlConnection;
        BufferedReader reader;
        try {
            if (proxyConfiguration.isProxyEnabled()) {
                urlConnection = new URL(url).openConnection(proxyConfiguration.getProxy());
                urlConnection.setRequestProperty("Proxy-Authorization",
                        "Basic " + proxyConfiguration.getProxyCredentials());
            } else {
                urlConnection = new URL(url).openConnection();
            }
            urlConnection.connect();
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        } catch (MalformedURLException e) {
            logger.error("The provided URL is invalid: " + url);
            // TODO: alarm this.
            return;
        } catch (IOException e) {
            logger.error("Failed to access the provided URL: " + url);
            // TODO: alarm this.
            return;
        }

        long lineNum = 1;
        try {
            boolean dataComing = false;
            String line = null;
            line = reader.readLine();
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

                    IntraDayData intraDayData = new IntraDayData(timestamp, close, high, low, open, volume);
                    intraDayData.setProduct(product);
                    repository.save(intraDayData);
                }

                if (line.startsWith("volume")) {
                    dataComing = true;
                }

                lineNum++;
                line = reader.readLine();

            }
        } catch (IOException e) {
            logger.error("Failed to read the CSV at line: " + lineNum);
            // TODO: alarm this.
            return;
        }
    }
}
