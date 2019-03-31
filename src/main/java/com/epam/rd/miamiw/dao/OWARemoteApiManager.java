package com.epam.rd.miamiw.dao;

import com.epam.rd.miamiw.model.WeatherEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilderFactory;

import java.net.URI;
import java.util.Map;

@Component
public class OWARemoteApiManager implements RemoteApiManager {

    private final String baseUrl;
    private final String urlPath;
    private final String apiKey;
    private RestTemplate restTemplate;
    private UriBuilderFactory uriBuilderFactory;

    public OWARemoteApiManager(
            @Value("${api.baseurl}") String baseUrl,
            @Value("${api.path}") String urlPath,
            @Value("${api.key}") String apiKey,
            RestTemplate restTemplate,
            UriBuilderFactory uriBuilderFactory) {
        this.baseUrl = baseUrl;
        this.urlPath = urlPath;
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
        this.uriBuilderFactory = uriBuilderFactory;
    }

    @Override
    public WeatherEntity getWeather(Map<String, String> reqParams) {
        var uri = getUri(reqParams);
        var response = restTemplate.getForEntity(uri, OWAResponse.class).getBody();
        var weatherEntity = WeatherEntity.builder()
                .city(response.getName())
                .temperature(response.getMain().getTemp())
                .build();
        return weatherEntity;
    }

    private URI getUri(Map<String, String> reqParams) {
        var uriBuilder = uriBuilderFactory.builder()
                .scheme("http")
                .host(baseUrl)
                .path(urlPath)
                .queryParam(OWAConstants.API_KEY, apiKey);
        reqParams.forEach(uriBuilder::queryParam);
        return uriBuilder.build();
    }
}
