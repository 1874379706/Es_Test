package com.meituan.ES;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.ClearScrollAction;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

/**
 * @Author WXY
 * @Description 测试ES
 * @Date 2024-05-14 19:56
 * @Version 1.0
 */
public class ESTest_Doc_Search {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        
        
        //条件查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        //构造查询条件，全量查询
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        searchRequest.source(query);
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//条件查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        //构造查询条件，termQuery 查询符合条件的记录
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.termQuery("age","21"));
//        searchRequest.source(query);
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //分页
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        //构造查询条件，termQuery 查询符合条件的记录
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //当前页的起始位置
//        query.from(0);
//        //每页显示几条
//        query.size(2);
//        searchRequest.source(query);
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //排序
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        //构造查询条件，termQuery 查询符合条件的记录
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //根据指定的字段排序
//        query.sort("age", SortOrder.DESC);
//        searchRequest.source(query);
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //过滤字段
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        //构造查询条件，termQuery 查询符合条件的记录
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //过滤字段
//        String[] excludes = {};
//        String[] includes = {"name"};
//        //根据includes,excludes过滤展示
//        query.fetchSource(includes,excludes);
//        
//        searchRequest.source(query);
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //组合查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        //构造查询条件，termQuery 查询符合条件的记录
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        //boolQueryBuilder.must  .should .mustNot
//        boolQueryBuilder.must(QueryBuilders.matchQuery("name","yky"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age",21));
//        builder.query(boolQueryBuilder);
//
//        searchRequest.source(builder);
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //范围查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        //构造查询条件，termQuery 查询符合条件的记录
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        RangeQueryBuilder boolQueryBuilder = QueryBuilders.rangeQuery("age");
//        
//        boolQueryBuilder.gt("20");
//        boolQueryBuilder.lte("23");
//        
//        builder.query(boolQueryBuilder);
//
//        searchRequest.source(builder);
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
        
//        //模糊查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        builder.query(QueryBuilders.fuzzyQuery("name","waay").fuzziness(Fuzziness.ONE));
//        
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

//        //高亮查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        TermsQueryBuilder query = QueryBuilders.termsQuery("name", "wxy");  
//        
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<front color='red'>");
//        highlightBuilder.postTags("</front>");
//        highlightBuilder.field("name");
//        builder.highlighter(highlightBuilder);
//        builder.query(query);
//        request.source(builder);
//        SearchResponse response = client.search( request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //聚合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        //对年龄最大的进行聚合
//        AggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//        builder.aggregation(aggregationBuilder);
//        
//        request.source(builder);
//        SearchResponse response = client.search( request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //分组查询
        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        //对根据年龄分组
        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("age").field("age");
        builder.aggregation(aggregationBuilder);

        request.source(builder);
        SearchResponse response = client.search( request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        for (SearchHit hit : hits){
            System.out.println(hit.getSourceAsString());
        }

        client.close();
    }
}
