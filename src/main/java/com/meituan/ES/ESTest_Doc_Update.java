package com.meituan.ES;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
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
public class ESTest_Doc_Update {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("user").id("1001");
        updateRequest.doc(XContentType.JSON,"age",21);
        UpdateResponse response = client.update(updateRequest, RequestOptions.DEFAULT);

        System.out.println(response.getResult());

        client.close();
    }
}
