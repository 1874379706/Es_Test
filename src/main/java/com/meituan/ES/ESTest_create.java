package com.meituan.ES;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * @Author WXY
 * @Description 测试ES
 * @Date 2024-05-14 19:56
 * @Version 1.0
 */
public class ESTest_create {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        //创建索引
        CreateIndexRequest indexRequest = new CreateIndexRequest("user");
        CreateIndexResponse response = client.indices().create(indexRequest, RequestOptions.DEFAULT);
        boolean acknowledged = response.isAcknowledged();
        System.out.println(acknowledged);
        client.close();
    }
}
