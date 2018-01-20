package com.hitices.yangengzhe.monitor.client.collection;

import java.util.ArrayList;

/**
* monitor.client
* @date 2018年1月20日 下午1:35:45
* @author gengzhe.ygz
* 
*/
public interface Collection {
    void collect();
    void filter();
    ArrayList<String> send();
}
