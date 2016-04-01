package qiang.finance.intradaydata.reader;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import qiang.finance.intradaydata.reader.entities.HttpMethod;

import java.io.IOException;

/**
 * Created by Qiang He on 31/03/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = IntradayDataReaderApp.class)
public class HttpRequestServiceTest {

    @Autowired
    HttpRequestService httpRequestService;

    @Test
    public void testHttpGetWithoutProxy() {
        String url = "http://chartapi.finance.yahoo.com/instrument/1.0/%5Eftse/chartdata;type=quote;range=1d/csv";

        try {
            String responseContent = httpRequestService.executeRequest(url, HttpMethod.GET, "", "text/plain");
            Assert.assertNotNull(responseContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHttpPostWithoutProxy() {
        String url = "http://charts.londonstockexchange.com/WebCharts/services/ChartWService.asmx/GetPricesWithVolume";
        String requestContent = "{\"request\":{\"SampleTime\":\"1mm\",\"TimeFrame\":\"1d\",\"RequestedDataSetType\":\"ohlc\",\"ChartPriceType\":\"price\",\"Key\":\"MKS.LD\",\"OffSet\":-60,\"FromDate\":null,\"ToDate\":null,\"UseDelay\":true,\"KeyType\":\"Topic\",\"KeyType2\":\"Topic\",\"Language\":\"en\"}}";

        try {
            String responseContent = httpRequestService.executeRequest(url, HttpMethod.POST, requestContent, "application/json");
            Assert.assertNotNull(responseContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
