package com.agp.kafka;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;

import org.opensearch.client.RequestOptions;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.client.indices.CreateIndexRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;

public class OpenSearchConsumer  {

    public static RestHighLevelClient createOpenSearchClient(){
        String connectionString = "http://localhost:9200";

        RestHighLevelClient restHighLevelClient;
        URI connectionUri = URI.create(connectionString);

        String userInfo = connectionUri.getUserInfo();
        String[] auth = userInfo.split(":");
        CredentialsProvider cp = new BasicCredentialsProvider();
        cp.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials(auth[0],auth[1]));

        restHighLevelClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost(connectionUri.getHost(),connectionUri.getPort(),connectionUri.getScheme()))
                .setHttpClientConfigCallback(
                        httpAsyncClientBuilder -> httpAsyncClientBuilder.setDefaultCredentialsProvider(cp).setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                )
        );
        return restHighLevelClient;
    }

    public static void main(String[] args) throws IOException {
        // first create an OpenSearch Client
        Logger log = LoggerFactory.getLogger(OpenSearchConsumer.class.getSimpleName());

        RestHighLevelClient openSearchClient = createOpenSearchClient();

        // we need to create the index on OpenSearch if it doesn't exist already

        CreateIndexRequest createIndexRequest = new CreateIndexRequest("sample-index");
        openSearchClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        log.info("Te sample-index created.");


        // create our Kafka Client

        // main code logic

        // close things


    }

}
