package qiang.finance.intradaydata.reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import qiang.finance.intradaydata.reader.entities.Product;
import qiang.finance.intradaydata.reader.yahoo.json.JsonData;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created by qhe on 13/02/16.
 */
@Component
public class JsonIntradayDataReader extends IntradayDataReader {

    private static final Logger logger = LoggerFactory.getLogger(JsonIntradayDataReader.class);

    @Override
    public void read() {
        Product product = productRepository.findByName("MKS.L");
        if (product == null) {
            product = new Product();
            product.setName("MKS.L");
            product = productRepository.save(product);
        }

        String url = "https://finance-yql.media.yahoo.com/v7/finance/chart/MKS.L?period2=1455486171&period1=1455140571&interval=1m&indicators=quote&includeTimestamps=true&includePrePost=true&events=div|split|earn&corsDomain=finance.yahoo.com";

        String response = null;
        try {
            response = IOUtils.toString(new URL(url));
        } catch (MalformedURLException e) {
            logger.error("The provided URL is invalid: " + url);
            // TODO: alarm this.
            return;
        } catch (IOException e) {
            logger.error("Failed to access the provided URL: " + url);
            // TODO: alarm this.
            return;
        }

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().serializeNulls();
        Gson gson = builder.create();

        JsonData jsonData = gson.fromJson(response, JsonData.class);

        System.out.println(gson.toJson(jsonData));

    }
}
