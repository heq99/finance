package qiang.finance.intradaydata.reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.Consts;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import qiang.finance.intradaydata.reader.config.ProxyConfiguration;
import qiang.finance.intradaydata.entities.IntraDayData;
import qiang.finance.intradaydata.entities.Product;
import qiang.finance.intradaydata.reader.json.lse.Data;
import qiang.finance.intradaydata.repositories.IntraDayDataRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qhe on 13/02/16.
 */
@Component
public class JsonIntradayDataReader extends IntradayDataReader {

    private static final Logger logger = LoggerFactory.getLogger(JsonIntradayDataReader.class);

    @Autowired
    private IntraDayDataRepository intraDayDataRepository;

    @Autowired
    private ProxyConfiguration proxyConfiguration;

    @Override
    public void read() throws IOException {
        Product product = productRepository.findByName("MKS.L");
        if (product == null) {
            product = new Product();
            product.setName("MKS.L");
            product = productRepository.save(product);
        }

        String json = "{\"request\":{\"SampleTime\":\"1mm\",\"TimeFrame\":\"1d\",\"RequestedDataSetType\":\"ohlc\",\"ChartPriceType\":\"price\",\"Key\":\"MKS.LD\",\"OffSet\":-60,\"FromDate\":null,\"ToDate\":null,\"UseDelay\":true,\"KeyType\":\"Topic\",\"KeyType2\":\"Topic\",\"Language\":\"en\"}}";

        CloseableHttpClient httpClient;
        HttpPost httpPost = new HttpPost("http://charts.londonstockexchange.com/WebCharts/services/ChartWService.asmx/GetPricesWithVolume");

        if (proxyConfiguration.isProxyEnabled()) {
            httpClient = HttpClients.custom().setDefaultCredentialsProvider(proxyConfiguration.getCredentialsProvider()).build();

            HttpHost proxy = new HttpHost(proxyConfiguration.getHostname(), proxyConfiguration.getPort());
            RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
            httpPost.setConfig(requestConfig);
        } else {
            httpClient = HttpClients.createDefault();

        }

        httpPost.setEntity(new StringEntity(json, ContentType.create("application/json", Consts.UTF_8)));

        CloseableHttpResponse response = httpClient.execute(httpPost);
        InputStream instream = response.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        Gson gson = new GsonBuilder().create();
        Data data = gson.fromJson(result.toString(), Data.class);

        for (int i=0; i<data.d.length; i++) {
            String[] k = data.d[i];

            IntraDayData intraDayData = new IntraDayData();
            intraDayData.setTimestamp(new Date(Long.parseLong(k[0])));
            intraDayData.setOpen(new BigDecimal(k[2]));
            intraDayData.setHigh(new BigDecimal(k[3]));
            intraDayData.setLow(new BigDecimal(k[4]));
            intraDayData.setClose(new BigDecimal(k[5]));
            intraDayData.setVolume(Long.parseLong(k[6]));
            intraDayData.setProduct(product);

            intraDayDataRepository.save(intraDayData);
        }
    }
}
