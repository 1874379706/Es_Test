package com.meituan.ES;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @Author WXY
 * @Description 测试ES
 * @Date 2024-05-14 19:56
 * @Version 1.0
 */
public class ESTest_Doc_Insert_Batch {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        
        
        //批量插入数据
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest().index("user").id("1001").source("age",22,"name","wxy"));
        bulkRequest.add(new IndexRequest().index("user").id("1002").source("name","ghm","age",21));
        bulkRequest.add(new IndexRequest().index("user").id("1003").source("name","985","age",0.5));
        bulkRequest.add(new IndexRequest().index("user").id("1004").source("name","yky","age",23));
        bulkRequest.add(new IndexRequest().index("user").id("1005").source("name","mjs"));
        bulkRequest.add(new IndexRequest().index("user").id("1006").source("name","xxn"));
        BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(response.getItems());

        client.close();
    }
}
