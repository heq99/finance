package qiang.finance.intradaydata.reader;

import org.apache.http.Consts;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import qiang.finance.intradaydata.reader.config.ProxyConfiguration;
import qiang.finance.intradaydata.reader.entities.HttpMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Qiang He on 31/03/2016.
 */
@Component
public class HttpRequestService {

    @Autowired
    private ProxyConfiguration proxyConfiguration;

    public String executeRequest(String url, HttpMethod httpMethod, String requestContent, String requestContentType) throws IOException {

        CloseableHttpClient httpClient;
        RequestConfig requestConfig = null;

        if (proxyConfiguration.isProxyEnabled()) {
            httpClient = HttpClients.custom().setDefaultCredentialsProvider(proxyConfiguration.getCredentialsProvider()).build();

            HttpHost proxy = new HttpHost(proxyConfiguration.getHostname(), proxyConfiguration.getPort());
            requestConfig = RequestConfig.custom().setProxy(proxy).build();
        } else {
            httpClient = HttpClients.createDefault();
        }

        InputStream inputStream = null;
        if (HttpMethod.GET == httpMethod) {
            HttpGet httpGet = new HttpGet(url);
            if (requestConfig != null) {
                httpGet.setConfig(requestConfig);
            }
            CloseableHttpResponse response = httpClient.execute(httpGet);
            inputStream = response.getEntity().getContent();
        } else if (HttpMethod.POST == httpMethod) {
            HttpPost httpPost = new HttpPost(url);
            if (requestConfig != null) {
                httpPost.setConfig(requestConfig);
            }
            httpPost.setEntity(new StringEntity(requestContent, ContentType.create(requestContentType, Consts.UTF_8)));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            inputStream = response.getEntity().getContent();
        }

        String result = null;
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            result = stringBuilder.toString();
        } else {
            throw new IOException("Null Response!");
        }

        return result;
    }
}
