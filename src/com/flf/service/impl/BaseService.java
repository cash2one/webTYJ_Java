package com.flf.service.impl;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import com.flf.plugin.Configure;
import com.flf.request.HttpsRequest;
import com.flf.request.ScanPayResData;
import com.flf.service.IServiceRequest;

/**
 * User: lp
 * 服务的基类
 */
public class BaseService{

    //API的地址
    private String apiURL;

    //发请求的HTTPS请求器
    private HttpsRequest serviceRequest;

    public BaseService(String api) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        apiURL = api;
        Class c = Class.forName(Configure.HttpsRequestClassName);
        serviceRequest = (HttpsRequest) c.newInstance();
    }

    protected ScanPayResData sendPost(Object xmlObj) throws UnrecoverableKeyException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        return serviceRequest.savePost(apiURL,xmlObj);
    }

    /**
     * 供商户想自定义自己的HTTP请求器用
     * @param request 实现了IserviceRequest接口的HttpsRequest
     */
    public void setServiceRequest(HttpsRequest request){
        serviceRequest = request;
    }
}
