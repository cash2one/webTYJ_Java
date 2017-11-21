package interfaceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.binding.soap.interceptor.SoapInterceptor;
import org.apache.cxf.binding.soap.saaj.SAAJOutInterceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;

import com.flf.service.UserService;
import com.flf.util.WsClinetAuthHandler;



 
/** 
12. * @author Kevin 
13. * 瀹㈡埛绔皟鐢ㄦ湇鍔″櫒绔毚闇插嚭鏉ョ殑鏈嶅姟 
14. * 瀹㈡埛绔笉鏄洿鎺ヨ窡杩滅鏈嶅姟鍣ㄦ墦浜ら亾锛岃�鏄�杩囪繙绔湇鍔″櫒浠ｇ悊锛屽嵆瀛樻牴锛屾墍浠ュ鎴风棣栧厛瑕佹嬁鍒板瓨鏍�
 */  
public class AppUserInterfaceRe {  
 
   /** 
19.     * @param args 
 * @throws Exception 
  */  
   public static void main(String[] args) throws Exception { 
	   WebClient client = WebClient.create("http://127.0.0.1:8888/webTYJ/cxfws/rest/");
/*   Prepare prepare=new Prepare();
=======
	   ServiceRequest request  = new ServiceRequest();
//	   request.setServiceRequestId("16");
//	   request.setCustomerId("37");
//	   System.out.println(client.path("ServiceRequest/insertServiceRequest").accept(MediaType.APPLICATION_JSON).post(request,ServiceRequest.class)+"aaaa");
//	   request.setServiceRequestId("13");
//	   request.setCustomerId("30");
//	   System.out.println(client.path("ServiceRequest/updateServiceRequest").accept(MediaType.APPLICATION_JSON).put(request)+"aaaa");
	   
	   Tasks tasks = new Tasks();
	   tasks.setServerId("14");
	   tasks.setCustomerId("0645a10d-1594-11e5-ace1-02004c4f4f50");
	   System.out.println(client.path("Tasks/insertTasks").accept(MediaType.APPLICATION_JSON).post(tasks,Tasks.class)+"aaa");
//	   QuoteOrders orders = new QuoteOrders();
//	   orders.setTaskId("13");
//	   System.out.println(client.path("QuoteOrders/insertQuoteOrders").accept(MediaType.APPLICATION_JSON).post(orders,QuoteOrders.class)+"aaa");
	   
//	   DisposeOrder disposeOrder = new DisposeOrder();
//	   disposeOrder.setOperatorId("13");
//	   disposeOrder.setRemarks("sdfsgsdgdaa");
//	   System.out.println(client.path("DisposeOrder/insertDisposeOrder").accept(MediaType.APPLICATION_JSON).post(disposeOrder,DisposeOrder.class)+"aaa");
	   
//	   System.out.println(client.path("ServiceRequest/deleteServiceRequest/10").accept(MediaType.TEXT_PLAIN).delete());
/*	   Prepare prepare=new Prepare();
>>>>>>> .r63
	   prepare.setPostId(1);
	   prepare.setPrepareId(3);
	   prepare.setProjectId(2);*/
	   
	/*  Map<String, Object> outProps = new HashMap<String, Object>();  
       outProps.put(WSHandlerConstants.ACTION,  
               WSHandlerConstants.USERNAME_TOKEN);  
       outProps.put(WSHandlerConstants.USER, "admin");  
       outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);  
       // 鎸囧畾鍦ㄨ皟鐢ㄨ繙绋媤s涔嬪墠瑙﹀彂鐨勫洖璋冨嚱鏁癢sClinetAuthHandler锛屽叾瀹炵被浼间簬涓�釜鎷︽埅鍣� 
       outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,  
               WsClinetAuthHandler.class.getName());  
       ArrayList<SoapInterceptor> list = new ArrayList<SoapInterceptor>();  
       // 娣诲姞cxf瀹夊叏楠岃瘉鎷︽埅鍣紝蹇呴』  
       list.add(new SAAJOutInterceptor());  
       list.add(new WSS4JOutInterceptor(outProps)); 
         
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	    factory.setAddress("http://10.0.14.203:9999/System/cxfws/UserService");
	    factory.setServiceClass(UserService.class);
	    //瀹㈡埛绔坊鍔燾fx鏃ュ織鎷︽埅鍣�
	    factory.getInInterceptors().add(new LoggingInInterceptor());  
	    factory.getOutInterceptors().add(new LoggingOutInterceptor()); 
	   //娉ㄥ叆鎷︽埅鍣紝鐢ㄤ簬鍔犲瘑瀹夊叏楠岃瘉淇℃伅  
     //factory.getOutInterceptors().addAll(list); 
	    UserService welcome = (UserService) factory.create(); 
	    //System.out.println(welcome.login("15998938393", "938393")); 	
	    System.out.println(welcome.updateBindingPhone("13006373200", "13986184990","566689"));*/
	   
	 /*  UnionpayCollectionTotall un = new UnionpayCollectionTotall();
	   un.setProjectName("鐗╀笟椤圭洰");
	   un.setProjectId("1");
	   System.out.println(client.path("UnionpayCollectionTotall/getUnionpayCollectionTotallById").accept(MediaType.APPLICATION_JSON).get()+"aaaa");*/
	 //  MeterReadingProgram meterReadingProgram=new MeterReadingProgram();
	 //  meterReadingProgram.setCurrentExecutor("姹磱");
	  // System.out.println(client.path("MeterReadingProgram/insertMeterReadingProgram").accept(MediaType.APPLICATION_JSON).post(meterReadingProgram,MeterReadingProgram.class)+"aaa");
	  // System.out.println("sadda");
	 
	 
	 //System.out.println(client.path("AppUser/AddAppUser").accept(MediaType.APPLICATION_JSON).post(appuser,AppUser.class)+"aaa");
	  // System.out.println(client.path("AppUser/DeleteAppUserById/4").accept(MediaType.TEXT_PLAIN).delete());

	//  System.out.println(client.path("AppUser/AddAppUser").accept(MediaType.APPLICATION_JSON).post(appuser,AppUser.class)+"aaa");
	   //System.out.println(client.path("AppUser/DeleteAppUserById/4").accept(MediaType.TEXT_PLAIN).delete());
//	   PersonEmphasis emp = new PersonEmphasis();
//	   emp.setEmphasisId("06361f7d-1594-11e5-ace1-02004c4f4f50");
//	   emp.setEnterpriseId("22");
//	   System.out.println(client.path("PersonEmphasis/UpdatePersonEmphasis").accept(MediaType.APPLICATION_JSON).put(emp)+"aaaa");
   }
}  
