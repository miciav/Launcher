package it.ciavotta.Node.components;

import java.net.URI;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.protocol.HttpContext;

public class StatefullHttpComponentsClientHttpRequestFactory extends 
HttpComponentsClientHttpRequestFactory
{
private final HttpContext httpContext;

public StatefullHttpComponentsClientHttpRequestFactory(HttpClient httpClient, HttpContext httpContext)
{
super(httpClient);
this.httpContext = httpContext;
}

@Override
protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri)
{
return this.httpContext;
}
}