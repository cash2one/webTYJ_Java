package com.flf.util;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.flf.entity.Bill;
import com.flf.entity.PaymentDetails;

public class PrintPay implements Printable {
	private static Graphics2D g2d;
	private static PaymentDetails PaymentDetails;
	
	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
		if (page > 0) {
			return NO_SUCH_PAGE;
			}		
		g2d = (Graphics2D) g;
		printPay(PaymentDetails);
		return PAGE_EXISTS;

	}
	

	public static void printPay(PaymentDetails PaymentDetails)
	{
		//获取收银员工号
		String staffNumber=PaymentDetails.getStaffNumber();
		//获取交易单号
		String paymentNum=PaymentDetails.getPaymentNum();
		//获取总金额
		
		//获取收款
		if(PaymentDetails.getCashSum()==null)
		{
			PaymentDetails.setCashSum(0.00);
		}
		if(PaymentDetails.getCreditCardSum()==null)
		{
			PaymentDetails.setCreditCardSum(0.00);
		}if(PaymentDetails.getWechatSum()==null)
		{
			PaymentDetails.setWechatSum(0.00);
		}	
		double receipt=PaymentDetails.getCashSum()+PaymentDetails.getCreditCardSum()+PaymentDetails.getWechatSum();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=sdf.format(new Date());
		g2d.setFont(new Font("Default", Font.PLAIN, 15));
		g2d.drawString("翔恒科技", 40, 15);
		g2d.setFont(new Font("Default", Font.PLAIN, 12));
		g2d.drawString("缴费记录", 45, 30);
		g2d.drawString("交易单号"+paymentNum, 7, 43);
		g2d.drawString("收费类型：" + "缴费", 7, 56);
		g2d.setFont(new Font("Default", Font.PLAIN, 9));
		g2d.drawString("项目", 7, 70);
		g2d.drawString("数量", 35, 70);
		g2d.drawString("折扣", 65, 70);
		g2d.drawString("价格", 95, 70);
		g2d.drawString("------------------------------------------", 7,80);	
		
		//获取收费列表
		List<Bill> bill=PaymentDetails.getBills();
		int length=bill.size();
		double summoney=0.00;
		for(int i=0;i<length;i++)
		{
			double sum=(bill.get(i).getTotalLastOweSum()+bill.get(i).getTotalOverdue()+bill.get(i).getTotalCurrentOweSum());
			summoney=summoney+sum;
			g2d.drawString(bill.get(i).getChargeTypeName(), 7, i*10+90);
			g2d.drawString("1", 40, i*10+90);
			g2d.drawString("\\", 70, i*10+90);
			g2d.drawString(String.valueOf(sum), 95, i*10+90);
		}
		g2d.drawString("------------------------------------------", 7,length*10+90);	
		g2d.drawString("总计:"+summoney+"(元)",7,length*10+100);
		g2d.drawString("收款:"+receipt+"(元)",7,length*10+110);
		if(summoney<=receipt)
		{
			g2d.drawString("找零:" +String.valueOf(receipt-summoney)+"(元)", 7, length*10+120);
		}
		else{
			g2d.drawString("未支付:" +String.valueOf(summoney-receipt)+"(元)", 7, length*10+120);
		}
		g2d.drawString("收银员工号:"+staffNumber, 7, length*10+130);
		g2d.drawString("打印时间" +date , 7, length*10+140);
		g2d.drawString("谢谢惠顾,欢迎下次光临", 20, length*10+150);
		g2d.drawString("请妥善保管收银单", 25, length*10+160);
		g2d.drawString("http://www.everwing.com.cn/" ,7, length*10+170);
		g2d.drawString("XXXX-XXXXXXXX",25,length*10+180);
	}

	public  void Print(PaymentDetails PaymentDetails) {
			
		// 通俗理解就是书、文档
		Book book = new Book();

		// 打印格式
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);

		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		p.setSize(135, 500);
		p.setImageableArea(0, 0, 205, 1000);
		pf.setPaper(p);
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new PrintPay(), pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPageable(book);
		try {
			PrintPay.PaymentDetails=PaymentDetails;
			job.print();
			
		} catch (PrinterException e) {
			System.out.println("================打印出现异常");
		}
	}
}