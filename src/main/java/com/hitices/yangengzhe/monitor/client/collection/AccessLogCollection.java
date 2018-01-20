package com.hitices.yangengzhe.monitor.client.collection;

import java.awt.List;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.hitices.yangengzhe.monitor.client.util.FileUtil;
import com.yammer.metrics.core.HealthCheck.Result;


/**
* monitor.client
* 负责监控tomcat的access.log文件
* @date 2018年1月20日 下午1:37:46
* @author gengzhe.ygz
* 
*/
public class AccessLogCollection implements Collection  {
    private ArrayList<String> content;
    
    private final String logID = "_temp_access";
    private String filename;
    private long pointer;
    
    public AccessLogCollection(String filename){
        content = new ArrayList<String>();
        this.filename = filename;
        String str = FileUtil.getLine(logID);
        pointer = str==null?0:Long.parseLong(str);
    }
    
    public void collect() {
        File logFile = new File(filename);
        try {
            long len = logFile.length(); 
            if(len < pointer){
                pointer = 0;  
            }else{  
                RandomAccessFile  randomFile= new RandomAccessFile(logFile,"r");  
                randomFile.seek(pointer);//移动文件指针位置   
                String tmp = "";  
                while((tmp = randomFile.readLine()) != null) {  
                    content.add(tmp);
                    pointer = randomFile.getFilePointer();  
                }  
                randomFile.close();  
            }  
        } catch (Exception e) {  
          //实时读取日志异常，记录
            System.out.println("read error: "+e);
        } finally {  
            //将pointer 落地
            FileUtil.putTxt(logID, pointer+"");
        }
    }

    public void filter() {
        for (String string : content) {
        }
    }

    public ArrayList<String> send() {
        ArrayList<String> result = new ArrayList<String>();
        Iterator<String> iterator = content.iterator();
        while(iterator.hasNext()){
            String string = iterator.next();
            result.add(string);
            iterator.remove();
        }
        return result;
    }

}
