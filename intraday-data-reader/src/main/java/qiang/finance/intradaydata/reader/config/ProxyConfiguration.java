package qiang.finance.intradaydata.reader.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Base64;

/**
 * Created by qhe on 19/02/16.
 */
@Component
public class ProxyConfiguration {

    @Value("${proxy.enabled}")
    private boolean proxyEnabled = true;

    @Value("${proxy.hostname}")
    private String hostname;

    @Value("${proxy.port}")
    private int port;

    @Value("${proxy.username}")
    private String username;

    @Value("${proxy.password}")
    private String password;


    public boolean isProxyEnabled() {
        return proxyEnabled;
    }

    public Proxy getProxy() {
        if (isProxyEnabled()) {
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostname, port));
        } else {
            return null;
        }
    }

    public String getProxyCredentials() {
        return Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    }
}
