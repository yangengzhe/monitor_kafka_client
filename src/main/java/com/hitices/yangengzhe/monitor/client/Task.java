package com.hitices.yangengzhe.monitor.client;

import java.util.ArrayList;

import com.hitices.yangengzhe.monitor.client.collection.Collection;

/**
* monitor.client
* @date 2018年1月20日 下午1:35:24
* @author gengzhe.ygz
* 
*/
public class Task implements Runnable {
    Collection instance;
    Task(Collection instance){
        this.instance = instance;
    }

    public void run() {
        instance.collect();
        instance.filter();
        //此处发送数据
        ArrayList<String> result = instance.send();
        for (String string : result) {
            System.out.println(string);
        }

    }

}
