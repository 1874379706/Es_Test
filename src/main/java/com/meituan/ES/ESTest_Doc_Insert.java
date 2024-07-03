package com.meituan.ES;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @Author WXY
 * @Description 测试ES
 * @Date 2024-05-14 19:56
 * @Version 1.0
 */
public class ESTest_Doc_Insert {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        IndexRequest indexRequest = new IndexRequest();   
        indexRequest.index("user").id("1001");
        User user = new User("wxy", 23);
        
        //向es中插入数据必须将对象变成json格式
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        //添加数据并告诉其格式
        indexRequest.source(userJson, XContentType.JSON);

        //向索引中插入数据
        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(response.getResult());

        client.close();
    }
}
