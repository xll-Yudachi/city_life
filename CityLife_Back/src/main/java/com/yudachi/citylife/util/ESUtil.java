package com.yudachi.citylife.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.db.Page;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yudachi.citylife.dto.JobDetail;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ESUtil {

    /**
     * Elasticsearch 添加
     *
     * @param index     索引名
     * @param type      索引类型
     * @param id        文档id（可以自生成，也可以用数据库Id）
     * @param jobDetail 插入文档对象
     * @return: void
     **/
    public static void insert(String index, String type, String id, JobDetail jobDetail) {
        RestHighLevelClient client = ElasticSearchClient.getClient();
        try {
            IndexRequest indexRequest = new IndexRequest(index, type, id).source(JSON.toJSONString(jobDetail), XContentType.JSON);
            IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println("insert response -----> " + response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Elasticsearch 删除
     *
     * @param index 索引名
     * @param type  索引类型
     * @param id    文档id（可以自生成，也可以用数据库Id）
     * @return: void
     **/
    public static void delete(String index, String type, String id) {
        RestHighLevelClient client = ElasticSearchClient.getClient();
        try {
            DeleteRequest deleteRequest = new DeleteRequest(index, type, id);
            DeleteResponse response = client.delete(deleteRequest, RequestOptions.DEFAULT);
            System.out.println("delete response --------> " + response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    /**
     * Elasticsearch 根据文档 id 查找
     *
     * @param index 索引名
     * @param type  索引类型
     * @param id    文档id（可以自生成，也可以用数据库Id）
     * @return: JobDetail
     **/
    public static JobDetail search(String index, String type, String id) {
        RestHighLevelClient client = ElasticSearchClient.getClient();
        GetRequest getRequest = new GetRequest(index, type, id);
        try {
            GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
            if (response.isExists()) {
                String sourceAsString = response.getSourceAsString();
                JobDetail jobDetail = JSONObject.parseObject(sourceAsString, JobDetail.class);
                return jobDetail;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return null;
    }


    /**
     * Elasticsearch 分页查询
     *
     * @param pageable
     * @param jobDetail
     * @param index
     * @return: com.yudachi.citylife.util.PageResult<com.yudachi.citylife.dto.JobDetail>
     **/
    public static PageResult<JobDetail> listPage(Page pageable, JobDetail jobDetail, String index) {
        RestHighLevelClient client = ElasticSearchClient.getClient();
        try {
            //创建检索请求
            SearchRequest searchRequest = new SearchRequest(index);
            //创建搜索构建者
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            //设置构建搜索属性
            //需要注意这里是从多少条开始
            sourceBuilder.from(pageable.getPageNumber() * pageable.getPageSize());
            //共返回多少条数据
            sourceBuilder.size(pageable.getPageSize());
            //自定义组合查询
            BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
            if (!StringUtils.isEmpty(jobDetail.getComName())) {
                queryBuilder.filter(QueryBuilders.wildcardQuery("comName", "*" + jobDetail.getComName() + "*"));
            }
            if (!StringUtils.isEmpty(jobDetail.getJobSalary())) {
                queryBuilder.filter(QueryBuilders.termQuery("comSalary", jobDetail.getJobSalary()));
            }
            if (!StringUtils.isEmpty(jobDetail.getJobDegree())) {
                queryBuilder.filter(QueryBuilders.termQuery("comDegree", jobDetail.getJobDegree()));
            }
            if (!StringUtils.isEmpty(jobDetail.getComAbbreviation())) {
                queryBuilder.filter(QueryBuilders.wildcardQuery("comAbbreviation", "*" + jobDetail.getComAbbreviation() + "*"));
            }
            if (!ObjectUtil.isEmpty(jobDetail.getComStage())) {
                queryBuilder.filter(QueryBuilders.termQuery("comStage", jobDetail.getComStage()));
            }
            if (!ObjectUtil.isEmpty(jobDetail.getComScale())) {
                queryBuilder.filter(QueryBuilders.termQuery("comScale", jobDetail.getComScale()));
            }
            if (!ObjectUtil.isEmpty(jobDetail.getComIndustry())) {
                queryBuilder.filter(QueryBuilders.termQuery("comIndustry", jobDetail.getComIndustry()));
            }
            if (!StringUtils.isEmpty(jobDetail.getJobSkillTag())) {
                if (!StringUtils.isEmpty(jobDetail.getComAbbreviation())) {
                    queryBuilder.filter(QueryBuilders.wildcardQuery("comSkillTag", "*" + jobDetail.getJobSkillTag() + "*"));
                }
            }
            if (!ObjectUtil.isEmpty(jobDetail.getComWelfare())) {
                StringBuilder sb = new StringBuilder();
                jobDetail.getComWelfare().stream().forEach(item -> sb.append(item));
                queryBuilder.filter(QueryBuilders.wildcardQuery("comWelfare", "*" + sb.toString() + "*"));
            }
            if (!ObjectUtil.isEmpty(jobDetail.getJobProvince())) {
                queryBuilder.filter(QueryBuilders.termQuery("comProvince", jobDetail.getJobProvince()));
            }
            sourceBuilder.query(queryBuilder);
            //传入构建进行搜索
            searchRequest.source(sourceBuilder);
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            //处理结果
            List<JobDetail> list = new ArrayList<>();
            SearchHits hits = searchResponse.getHits();
            hits.forEach(item -> list.add(JSON.parseObject(item.getSourceAsString(), JobDetail.class)));
            return new PageResult(hits.getTotalHits(), list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new PageResult<>();
    }


    /**
     * ElasticSearch 高亮分页查询
     *
     * @param pageable
     * @param content
     * @return: com.yudachi.citylife.util.PageResult<com.yudachi.citylife.dto.JobDetail>
     **/
    public static PageResult<JobDetail> searchContent(Page pageable, String content) {
        RestHighLevelClient client = ElasticSearchClient.getClient();
        try {
            if (pageable.getPageSize() == 0){
                pageable.setPageSize(1);
            }
            SearchResponse searchResponse = searchHighlight((pageable.getPageNumber() - 1) * pageable.getPageSize(), pageable.getPageNumber() * pageable.getPageSize(), content, client, "jobName", "comName", "comAbbreviation", "jobProvince");
            List<JobDetail> list = Arrays.stream(searchResponse.getHits().getHits()).map(ESUtil::toHighLightJobDetail).collect(Collectors.toList());
            long totalHits = searchResponse.getHits().getTotalHits();
            return new PageResult<>(totalHits, list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new PageResult<>();
    }

    /**
     * SearchHit 转换为高亮字段对象
     */
    private static JobDetail toHighLightJobDetail(SearchHit searchHit) {
        JobDetail jobDetail = JSON.parseObject(searchHit.getSourceAsString(), JobDetail.class);
        Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
        if (!highlightFields.isEmpty()) {
            HighlightField comName = highlightFields.get("comName");
            if (!ObjectUtil.isEmpty(comName)) {
                jobDetail.setComName(Arrays.stream(comName.getFragments()).map(Text::string).collect(Collectors.joining("\n")));
            }
            HighlightField abbreviation = highlightFields.get("comAbbreviation");
            if (!ObjectUtil.isEmpty(abbreviation)) {
                jobDetail.setComAbbreviation(Arrays.stream(abbreviation.getFragments()).map(Text::string).collect(Collectors.joining("\n")));
            }
            HighlightField province = highlightFields.get("jobProvince");
            if (!ObjectUtil.isEmpty(province)) {
                jobDetail.setJobProvince(Arrays.stream(province.getFragments()).map(Text::string).collect(Collectors.joining("\n")));
            }
            HighlightField jobName = highlightFields.get("jobName");
            if (!ObjectUtil.isEmpty(jobName)) {
                jobDetail.setJobName(Arrays.stream(jobName.getFragments()).map(Text::string).collect(Collectors.joining("\n")));
            }
        }
        return jobDetail;
    }

    /**
     * 构建高亮字段 进行 多字段模糊查询
     */
    private static SearchResponse searchHighlight(int from, int size, String content, RestHighLevelClient client, String... fields) throws IOException {
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        for (String field : fields) {
            highlightBuilder.field(makeHighlightContent(field));
        }
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //自定义条件
        boolQueryBuilder.should(QueryBuilders.multiMatchQuery(content, fields).fuzziness(Fuzziness.AUTO));
        //boolQueryBuilder.should(QueryBuilders.wildcardQuery("comName", "*" + content + "*"));
        /*boolQueryBuilder.should(QueryBuilders.wildcardQuery("jobName", "*" + content + "*"));*/
        return searchDocument(client, highlightBuilder, boolQueryBuilder, from, size);
    }

    /**
     * 构建SearchRequest, SearchSourceBuilder , 执行search方法
     */
    private static SearchResponse searchDocument(RestHighLevelClient client, HighlightBuilder highlightBuilder, QueryBuilder queryBuilder, int from, int size) throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        if (highlightBuilder != null) {
            searchSourceBuilder.highlighter(highlightBuilder);
        }
        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.from(from);
        searchSourceBuilder.size(size);
        searchRequest.source(searchSourceBuilder);
        return client.search(searchRequest, RequestOptions.DEFAULT);
    }

    /**
     * 封装高亮查询字段
     */
    private static HighlightBuilder.Field makeHighlightContent(String fieldName) {
        HighlightBuilder.Field highlightContent = new HighlightBuilder.Field(fieldName);
        highlightContent.preTags("<span style=\"color:red\">");
        highlightContent.postTags("</span>");
        return highlightContent;
    }
}
