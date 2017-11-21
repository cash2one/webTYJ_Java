package com.flf.service.impl;
import com.flf.plugin.Configure;
import com.flf.request.ScanPayReqData;
import com.flf.request.ScanPayResData;
import com.flf.service.ScanPayService;

public class ScanPayServiceImpl  extends BaseService implements ScanPayService {

    public ScanPayServiceImpl() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        super(Configure.PAY_API);
    }

    /**
     * 请求支付服务
     * @param scanPayReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的数据
     * @throws Exception
     */
    public ScanPayResData request(ScanPayReqData scanPayReqData) throws Exception {
        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
    	ScanPayResData responseString = sendPost(scanPayReqData);

        return responseString;
    }
}
