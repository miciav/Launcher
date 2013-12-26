package it.ciavotta.Launcher.components.restclient;

import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("deprecation")
public class StatefullRestTemplate extends RestTemplate
{
    private final HttpClient httpClient;
    private final CookieStore cookieStore;
    private final HttpContext httpContext;
    private final StatefullHttpComponentsClientHttpRequestFactory statefullHttpComponentsClientHttpRequestFactory;

    @SuppressWarnings("deprecation")
	public StatefullRestTemplate()
    {
        super();
        httpClient = new DefaultHttpClient();
        cookieStore = new BasicCookieStore();
        httpContext = new BasicHttpContext();
        httpContext.setAttribute(ClientContext.COOKIE_STORE, getCookieStore());
        statefullHttpComponentsClientHttpRequestFactory = new StatefullHttpComponentsClientHttpRequestFactory(httpClient, httpContext);
        super.setRequestFactory(statefullHttpComponentsClientHttpRequestFactory);
    }

    public HttpClient getHttpClient()
    {
        return httpClient;
    }

    public CookieStore getCookieStore()
    {
        return cookieStore;
    }

    public HttpContext getHttpContext()
    {
        return httpContext;
    }

    public StatefullHttpComponentsClientHttpRequestFactory getStatefulHttpClientRequestFactory()
    {
        return statefullHttpComponentsClientHttpRequestFactory;
    }
}