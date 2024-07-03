package com.meituan.ES;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * @Author WXY
 * @Description 测试ES
 * @Date 2024-05-14 19:56
 * @Version 1.0
 */
public class ESTest_search {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        //查询索引
        GetIndexRequest indexRequest = new GetIndexRequest("user");
        GetIndexResponse response = client.indices().get(indexRequest,RequestOptions.DEFAULT);
        System.out.println(response.getAliases());
        System.out.println(response.getSettings());
        System.out.println(response.getMappings());
        //删除索引
//        AcknowledgedResponse deleteResponse = client.indices().delete(new DeleteIndexRequest("user"), RequestOptions.DEFAULT);
//
//        System.out.println(deleteResponse.isAcknowledged());
        
        client.close();
    }
}
