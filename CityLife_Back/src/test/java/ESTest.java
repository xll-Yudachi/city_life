import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.dto.JobDetail;
import com.yudachi.citylife.service.JobService;
import com.yudachi.citylife.util.ElasticSearchClient;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.List;

public class ESTest {
    public static void main(String[] args) {
        RestHighLevelClient client = ElasticSearchClient.getClient();
        // 增
        try {
            JobService jobService = new JobService();
            List<Integer> jobAllId = jobService.findJobAllId();
            for (Integer id : jobAllId) {
                JobDetail jobDetail = jobService.findJobById(id + "");
                IndexRequest indexRequest = new IndexRequest("job_info", "job", String.valueOf(id)).source(JSON.toJSONString(jobDetail), XContentType.JSON);
                IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
                System.out.println(response);
            }

        }catch (Exception e){
                e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 删
       /* RestHighLevelClient client = ElasticSearchClient.getClient();
        DeleteRequest deleteRequest = new DeleteRequest("job_info", "job", "2");
        try {
            client.delete(deleteRequest, RequestOptions.DEFAULT);
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        // 查
       /* RestHighLevelClient client = ElasticSearchClient.getClient();
        GetRequest getRequest = new GetRequest("job_info", "job", "1");
        GetResponse getResponse = null;
        try {
            getResponse = client.get(getRequest, RequestOptions.DEFAULT);
            if (getResponse.isExists()) {
                String sourceAsString = getResponse.getSourceAsString();
                JobDetail jobDetail = JSONObject.parseObject(sourceAsString, JobDetail.class);
                System.out.println(jobDetail);
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        // 分页查询
        //创建检索请求
        /*RestHighLevelClient client = ElasticSearchClient.getClient();
        SearchRequest searchRequest = new SearchRequest("job_info");
        //创建搜索构建者
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //设置构建搜索属性
        sourceBuilder.from(0); // 需要注意这里是从多少条开始
        sourceBuilder.size(10); //共返回多少条数据
       *//* sourceBuilder.sort(new FieldSortBuilder("id").order(SortOrder.ASC)); //根据自己的需求排序*//*

        *//*if (!StringUtils.isEmpty(coutent)) {
            //自定义组合查询
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            TermQueryBuilder termQuery = QueryBuilders.termQuery(STATUS, STATUS);
            MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("coutent", coutent).fuzziness(Fuzziness.AUTO); //模糊匹配
            boolQueryBuilder.must(termQuery).must(queryBuilder);
            sourceBuilder.query(boolQueryBuilder);
        }*//*

        //传入构建进行搜索
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = null;
        try {
            searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            //处理结果
            RestStatus restStatus = searchResponse.status();
            List<JobDetail> list = new ArrayList<>();
            SearchHits hits = searchResponse.getHits();
            hits.forEach(item -> list.add(JSON.parseObject(item.getSourceAsString(), JobDetail.class)));
            long totalHits = hits.getTotalHits();
            System.out.println(list);
            System.out.println(list.size());
            System.out.println(totalHits);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/


        //高亮
        /*try {
            new ESTest().searchContent(new Page(0, 1), "信息");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        // 增
        /*JobService jobService = new JobService();
        List<Integer> jobAllId = jobService.findJobAllId();
        for (Integer id : jobAllId) {
            JobDetail jobDetail = jobService.findJobById(id + "");
            jobDetail.setComName("xxx");
            ESUtil.insert("job_info","job",id + 117 + "", jobDetail);
        }*/

        // 删
        //ESUtil.delete("job_info","job", "16");

        // 查
        /*System.out.println(ESUtil.search("job_info", "job", "17"));*/

        /*JobDetail jobDetail = new JobDetail();
        jobDetail.setComName("xxx");
        jobDetail.setComAbbreviation("");
        PageResult<JobDetail> pageResult = ESUtil.listPage(new Page(0, 2), jobDetail, "job_info");
        System.out.println(pageResult.getTotal());
        System.out.println(pageResult.getRows().size());
        System.out.println(pageResult.getRows());*/

       /* PageResult<JobDetail> pageResult = ESUtil.searchContent(new Page(0, 2), "信息");
        System.out.println(pageResult.getTotal());
        System.out.println(pageResult.getRows().size());
        System.out.println(pageResult.getRows());*/
    }

    /*// 高亮
    *//**
     * 搜索入口 搜索结果处理
     *//*
    public void searchContent(Page pageable, String content) throws IOException {
        *//*SearchResponse searchResponse = searchHighlight(pageable.getPageSize() * pageable.getPageNumber(), pageable.getPageSize(), content, "account", "name");*//*
        SearchResponse searchResponse = searchHighlight(pageable.getPageSize() * pageable.getPageNumber(), pageable.getPageSize(), content, "comName");
        List<JobDetail> list = Arrays.stream(searchResponse.getHits().getHits()).map(this::toHighLightUser).collect(Collectors.toList());
        long totalHits = searchResponse.getHits().getTotalHits();
        System.out.println(list);
        System.out.println(totalHits);
    }

    *//**
     * SearchHit 转换为高亮字段对象
     *//*
    private JobDetail toHighLightUser(SearchHit searchHit){
        JobDetail jobDetail = JSON.parseObject(searchHit.getSourceAsString(), JobDetail.class);
        Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
        if (!highlightFields.isEmpty()){
            HighlightField comName = highlightFields.get("comName");
            if (comName != null){
                jobDetail.setComName(Arrays.stream(comName.getFragments()).map(Text::string).collect(Collectors.joining("\n")));
            }
           *//* HighlightField name = highlightFields.get("name");
            if (!StringUtils.isEmpty(name)){
                user.setName(Arrays.stream(name.getFragments()).map(Text::string).collect(Collectors.joining("\n")));
            }*//*
        }
        return jobDetail;
    }

    *//**
     * 构建高亮字段 进行 多字段模糊查询
     *//*
    private SearchResponse searchHighlight(int from, int size, String content, String ... fields) throws IOException{
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        for (String field : fields){
            highlightBuilder.field(makeHighlightContent(field));
        }
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //自定义条件
        boolQueryBuilder.should(QueryBuilders.multiMatchQuery(content, fields).fuzziness(Fuzziness.AUTO));
        boolQueryBuilder.should(QueryBuilders.wildcardQuery("comName", "*" + content + "*"));
        return searchDocument(highlightBuilder, boolQueryBuilder , from , size);
    }

    *//**
     * 构建SearchRequest, SearchSourceBuilder , 执行search方法
     *//*
    private SearchResponse searchDocument(HighlightBuilder highlightBuilder, QueryBuilder queryBuilder, int from, int size) throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        if (highlightBuilder != null){
            searchSourceBuilder.highlighter(highlightBuilder);
        }
        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.from(from);
        searchSourceBuilder.size(size);
        searchRequest.source(searchSourceBuilder);
        return client.search(searchRequest, RequestOptions.DEFAULT);
    }
    *//**
     * 封装高亮查询字段
     *//*
    private HighlightBuilder.Field makeHighlightContent(String fieldName){
        HighlightBuilder.Field highlightContent = new HighlightBuilder.Field(fieldName);
        highlightContent.preTags("<span style=\"color:red\">");
        highlightContent.postTags("</span>");
        return highlightContent;
    }*/
}
