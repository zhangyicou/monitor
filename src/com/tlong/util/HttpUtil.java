package com.tlong.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.log4j.Logger;
public class HttpUtil {
	 /** 日志logger */
    protected final static Logger logger = Logger.getLogger(HttpUtil.class);
    
    private static int _timeout=7200000;  
    private static final String CONTENT_CHARSET = "UTF-8";  
    
	public static String post(String uri, String content) throws IOException{  
        String data= "";  
        HttpClient httpClient= new HttpClient();  
        httpClient.setConnectionTimeout(_timeout);  
        httpClient.setTimeout(_timeout);  
          
        PostMethod method = null;  
        try{  
            method= new PostMethod();  
            method.setURI(new URI(uri, false));  
            //param  
            RequestEntity requestEntity = new StringRequestEntity(content, "application/json","UTF-8");  
			method.setRequestEntity(requestEntity);  
            int statusCode = httpClient.executeMethod(method);  
            if (statusCode != HttpStatus.SC_OK) {  
            	logger.error("Method failed: " + method.getStatusLine());  
            }  
            data= new String(method.getResponseBody());  
        }catch(HttpException e){  
        	logger.error("Please check your provided http address!");  
        }catch(IOException e){  
        	logger.error(e.getMessage());  
        }catch(Exception e){  
        	logger.error(e.getMessage());  
        }finally{  
            if(method!=null) method.releaseConnection();  
        }  
        return data;  
    }  
	
	
	public static String restGet(String url, NameValuePair[] nameValuePairs){
		HttpClient client = new HttpClient();
		try{
			client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, CONTENT_CHARSET);   
			client.setConnectionTimeout(_timeout);  
		    client.setTimeout(_timeout);  
			client.getHostConfiguration().setHost(url, 80, "http");
			GetMethod method = new GetMethod(url);
			method.setRequestHeader("Content-type", "application/json; charset=UTF-8");
			if (null != nameValuePairs && nameValuePairs.length > 0)
				method.setQueryString(nameValuePairs);
			int statusCode = client.executeMethod(method); // 打印服务器返回的状�?
			 if (statusCode == HttpStatus.SC_OK) {
				 InputStream stream = method.getResponseBodyAsStream();
					
					BufferedReader br = new BufferedReader(new InputStreamReader(stream,"UTF-8"));
					StringBuffer buf = new StringBuffer();
					String line;
					while (null != (line = br.readLine())) {
						buf.append(line).append("\n");
					}
					System.out.println(buf.toString());
					// 释放连接
					method.releaseConnection();
					return buf.toString();
			 }else{
				 logger.error("Method failed: " + method.getStatusLine());  
			 }
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String restPut(String uri, Map paramMap) throws IOException{  
        String data= "";  
        HttpClient httpClient= new HttpClient();  
        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, CONTENT_CHARSET);   
        httpClient.setConnectionTimeout(_timeout);  
        httpClient.setTimeout(_timeout);  
        PutMethod method = null;  
        try{  
            method= new PutMethod();  
            method.setURI(new URI(uri, false));  
            //param  
            if(paramMap!=null){  
                NameValuePair[] NameValuePairs = new NameValuePair[paramMap.size()] ;  
                Iterator keys= paramMap.keySet().iterator();  
                int i = 0;  
                while(keys.hasNext()){  
                    String key= (String)keys.next();  
                     NameValuePair param = new NameValuePair(key, (String)paramMap.get(key));  
                     NameValuePairs[i] = param;  
                     i++;  
                }  
                method.setQueryString(NameValuePairs);  
            }  
  
            int statusCode = httpClient.executeMethod(method);  
            if (statusCode == HttpStatus.SC_OK) {  
            	data= new String(method.getResponseBody(),"utf-8");  
            }  else{
            	logger.error("Method failed: " + method.getStatusLine());  
            }
             
        }catch(HttpException e){  
            logger.error("Please check your provided http address!");  
        }catch(IOException e){  
        	logger.error(e.getMessage());  
        }catch(Exception e){  
        	logger.error(e.getMessage());  
        }finally{  
            if(method!=null) method.releaseConnection();  
        }  
        return data;  
    }  
	
	
	public static String restDelete(String uri) throws IOException{  
        String data= "";  
        HttpClient httpClient= new HttpClient();  
        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, CONTENT_CHARSET);   
        httpClient.setConnectionTimeout(_timeout);  
        httpClient.setTimeout(_timeout);  
          
        DeleteMethod method = null;  
        try{  
            method= new DeleteMethod();  
            method.setURI(new URI(uri,false));  
            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());  
            int statusCode = httpClient.executeMethod(method);  
            if (statusCode != HttpStatus.SC_OK) {  
            	logger.error("Method failed: " + method.getStatusLine());  
            }  
            data= new String(method.getResponseBody(),"utf-8");  
        }catch(HttpException e){  
        	logger.error("Please check your provided http address!");  
        }catch(IOException e){  
        	logger.error(e.getMessage());  
        }catch(Exception e){  
        	logger.error(e.getMessage());  
        }finally{  
            if(method!=null) method.releaseConnection();  
        }  
        return data;  
    }  
}
