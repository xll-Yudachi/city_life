package com.yudachi.citylife.util;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.util.ArrayList;
import java.util.List;

public class ElasticSearchClient {
    private static String[] hostsAndPorts = new String[]{"xxx"};

    public ElasticSearchClient() {}

    public static RestHighLevelClient getClient() {
        RestHighLevelClient client = null;
        List<HttpHost> httpHosts = new ArrayList<>();
        for (String hostsAndPort : hostsAndPorts) {
            String[] hp = hostsAndPort.split(":");
            httpHosts.add(new HttpHost(hp[0], Integer.valueOf(hp[1]), "http"));
        }
        client = new RestHighLevelClient(
                RestClient.builder(httpHosts.toArray(new HttpHost[0])));
        return client;
    }
}