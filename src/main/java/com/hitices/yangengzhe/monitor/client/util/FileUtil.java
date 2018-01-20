package com.hitices.yangengzhe.monitor.client.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

/**
* monitor.client
* @date 2018年1月20日 下午2:00:37
* @author gengzhe.ygz
* 
*/
public class FileUtil {
    public static String getLine(String filename){
        File file = new File(filename);
        if(!file.exists()) return null;
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String lineTxt = br.readLine();
            br.close();
            return lineTxt;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static void putTxt(String filename,String str){
        try {
            Writer w=new FileWriter(filename,false);
            w.write(str);
            w.close();
        } catch (IOException e) {
            System.out.println("写入失败");
        }
    }
    
}
