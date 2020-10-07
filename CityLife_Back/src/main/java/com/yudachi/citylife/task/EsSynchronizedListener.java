package com.yudachi.citylife.task;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;

@SuppressWarnings("all")
public class EsSynchronizedListener implements ServletContextListener {
    private Timer timer = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        timer = new Timer(true);
        sce.getServletContext().log("定时器已启动");
        timer.schedule(new EsSynchronizedTask(sce.getServletContext()), 0, 3000);//每隔1小时
        sce.getServletContext().log("已经添加任务调度表");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        timer.cancel();
        sce.getServletContext().log("定时器销毁");
    }
}
