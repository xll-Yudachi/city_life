package com.yudachi.citylife.task;

import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.dto.JobDetail;
import com.yudachi.citylife.service.JobService;
import com.yudachi.citylife.util.ElasticSearchClient;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

public class EsSynchronizedTask extends TimerTask {
    private static final int STATISTICS_SCHEDULE_HOUR = 0;
    private static boolean isRunning = false;
    private ServletContext context = null;

    public EsSynchronizedTask(ServletContext context) {
        this.context = context;
    }

    @Override
    public void run() {
        Calendar cal = Calendar.getInstance();
        if (!isRunning) {
            //查看是否为凌晨
            if (STATISTICS_SCHEDULE_HOUR == cal.get(Calendar.HOUR_OF_DAY))
            {
                isRunning = true;
                context.log("开始执行指定任务");
                //TODO 添加自定义的详细任务
                executeTask();
                //指定任务执行结束
                isRunning = false;
                context.log("指定任务执行结束");
            }
        } else {
            context.log("上一次任务执行还未结束");
        }
    }

    /**
     * 执行任务
     */
    public void executeTask() {
        RestHighLevelClient client = ElasticSearchClient.getClient();
        try {
            JobService jobService = new JobService();
            List<Integer> jobAllId = jobService.findJobAllId();
            for (Integer id : jobAllId) {
                JobDetail jobDetail = jobService.findJobById(id + "");
                IndexRequest indexRequest = new IndexRequest("job_info", "job", String.valueOf(id)).source(JSON.toJSONString(jobDetail), XContentType.JSON);
                IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
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
    }
}
