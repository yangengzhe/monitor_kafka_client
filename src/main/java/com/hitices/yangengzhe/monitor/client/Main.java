package com.hitices.yangengzhe.monitor.client;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.hitices.yangengzhe.monitor.client.collection.AccessLogCollection;
import com.hitices.yangengzhe.monitor.client.collection.Collection;

/**
* monitor.client
* @date 2018年1月20日 下午1:34:16
* @author gengzhe.ygz
* 
*/
public class Main {
    
    public static void main(String args[]){
        //此处从配置中读取采集的个数，创建线程 替换1
        ScheduledExecutorService  exec = Executors.newScheduledThreadPool(1); 
        //循环创建开始
        Collection instance = new AccessLogCollection("/usr/local/apache-tomcat-7.0.65/logs/localhost_access_log.2018-01-17.txt");
        Task task = new Task(instance);
        exec.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS); 
    }
}
