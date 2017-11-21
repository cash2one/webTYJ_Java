package com.flf.service.impl;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import sun.misc.BASE64Decoder;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.flf.entity.OrderAttachment;
import com.flf.entity.User;
import com.flf.mapper.OrderAttachmentMapper;
import com.flf.service.OrderAttachmentService;
import com.flf.util.JsonUtil;
@WebService
public class OrderAttachmentServiceImpl implements OrderAttachmentService {

	private OrderAttachmentMapper orderAttachmentMapper;
	
	public OrderAttachmentMapper getOrderAttachmentMapper() {
		return orderAttachmentMapper;
	}

	public void setOrderAttachmentMapper(OrderAttachmentMapper orderAttachmentMapper) {
		this.orderAttachmentMapper = orderAttachmentMapper;
	}

	@Override
	public List<OrderAttachment> listPageOrderAttachment(
			OrderAttachment orderAttachment) {
		// TODO Auto-generated method stub
		return orderAttachmentMapper.listPageOrderAttachment(orderAttachment);
	}

	@Override
	public List<OrderAttachment> listAllOrderAttachment() {
		// TODO Auto-generated method stub
		return orderAttachmentMapper.listAllOrderAttachment();
	}

	@Override
	public OrderAttachment getOrderAttachmentById(String id) {
		// TODO Auto-generated method stub
		return orderAttachmentMapper.getOrderAttachmentById(id);
	}

	@Override
	public int insertOrderAttachment(OrderAttachment orderAttachment) {
		// TODO Auto-generated method stub
		return orderAttachmentMapper.insertOrderAttachment(orderAttachment);
	}

	@Override
	public int updateOrderAttachment(OrderAttachment orderAttachment) {
		// TODO Auto-generated method stub
		return orderAttachmentMapper.updateOrderAttachment(orderAttachment);
	}

	@Override
	public int deleteOrderAttachment(String id) {
		// TODO Auto-generated method stub
		return orderAttachmentMapper.deleteOrderAttachment(id);
	}

	@Override
	public Boolean AddAttachments(String id, String attachments,String attachmenttype) {
		// TODO Auto-generated method stub
		JSONArray jsons=JSONArray.fromObject(attachments);
		List<Map<String,Object>> list=(List<Map<String, Object>>) JSONArray.toCollection(jsons,HashMap.class);//获取附件bas64字符串和文件类型的集合
		List<OrderAttachment> orderAttachments=new ArrayList<OrderAttachment>();
		for (Map<String,Object> map : list) {

			if (map.get("base64str") == null){ // 图像数据为空  
				return false;
			}
			BASE64Decoder decoder = new BASE64Decoder();
			OutputStream out=null;
			try {  
				// Base64解码  
				byte[] bytes = decoder.decodeBuffer((String) map.get("base64str"));//获取map中base64加密过的字符串
				for (int i = 0; i < bytes.length; ++i) {
					if (bytes[i] < 0) {// 调整异常数据  
						bytes[i] += 256;
					}
				}      
				HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
				String path = request.getSession().getServletContext().getRealPath("/uploads");//获取uploads文件夹在服务器上的绝对路径
				//生成jpeg图片
				Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				String fileName = path+"\\"+now+id+map.get("type"); //设置生产文件的名称和文件类型
				out = new FileOutputStream(fileName);
				out.write(bytes);
				OrderAttachment orderAttachment=new OrderAttachment();
				orderAttachment.setFilePath(fileName);//文件在服务器上的绝对路径
				orderAttachment.setFileName(now.toString()+id);//文件名称
				orderAttachment.setFileSrcType(map.get("SrcType").toString());//附件类型
				orderAttachment.setDbLastUpdSrc(map.get("type").toString());//获取上传文件后缀
				String state=map.get("state").toString();
				String StateFlg=map.get("StateFlg").toString();
				orderAttachment.setPublishCd(Byte.parseByte(state));//获取文件状态
				orderAttachment.setFileDockStatFlg(Byte.parseByte(StateFlg));//是否如档
				orderAttachment.setFileRevNum(map.get("RevNum").toString());//获取文件版本号
				Date date=new Date();  
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				orderAttachment.setFileDate(sdf.format(date));//获取系统当前时间
				orderAttachment.setComments(map.get("remark").toString());//获取备注信息
				orderAttachment.setProcess(attachmenttype);//处理请求
				orderAttachments.add(orderAttachment);
			} catch (Exception e) {  
				e.printStackTrace();
				return false;
			}finally{
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		}
		orderAttachmentMapper.insertOrderAttachments(orderAttachments);//批量添加到数据库
		return true;
	}

	@Override
	public List<OrderAttachment> listPageOrderattachment() {
		// TODO Auto-generated method stub
		OrderAttachment orderAttachment=new OrderAttachment();
		List<OrderAttachment> orderAttachments = orderAttachmentMapper.listPageOrderAttachment(orderAttachment);
		return orderAttachments;
	}

	@Override
	public OrderAttachment getOrderAttachmentByIdRest(String id) {
		// TODO Auto-generated method stub
		OrderAttachment orderAttachment=orderAttachmentMapper.getOrderAttachmentById(id);
		return orderAttachment;
	}

	@Override
	public void AllOrderAttachment(OrderAttachment orderAttachment) {
		// TODO Auto-generated method stub
		orderAttachmentMapper.insertOrderAttachment(orderAttachment);
		return;
	}

	@Override
	public void UpdateOrderAttachment(OrderAttachment orderAttachment) {
		// TODO Auto-generated method stub
		orderAttachmentMapper.updateOrderAttachment(orderAttachment);
		return;
	}

	@Override
	public void DeleteOrderAttachment(String id) {
		// TODO Auto-generated method stub
		orderAttachmentMapper.deleteOrderAttachment(id);
		return;
	}
}
