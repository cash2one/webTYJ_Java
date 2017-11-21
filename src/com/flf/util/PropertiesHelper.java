package com.flf.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @description <p>配置文件帮助类</p>
 * @author Hardy
 * @date 2015-12-15
 */
public class PropertiesHelper {
	public static Properties proper= null;  
    public String readProperties(String key){  
        if(this.proper==null){  
             InputStream in = this.getClass().getResourceAsStream("/data.properties");  
             try {  
                 this.proper = new Properties();  
                 this.proper.load(in);  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return this.proper.getProperty(key);
    }
}
