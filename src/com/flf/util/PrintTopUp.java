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

import com.flf.entity.AssetAccount;

public class PrintTopUp implements Printable {
	private static Graphics2D g2d;
	private static AssetAccount assetAccount;
	
	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
		if (page > 0) {
			return NO_SUCH_PAGE;
			}		
		g2d = (Graphics2D) g;
		printTopUp(assetAccount);
		return PAGE_EXISTS;

	}
	

	public static void printTopUp(AssetAccount assetAccount)
	{
		//获取收银员工号
		
		//获取交易单号
		
		//获取总金额
		if(assetAccount.getAddPrice()==null)
		{
			assetAccount.setAddPrice(0.00);
		}
		
		//获取收款
			//现金支付款
		if(assetAccount.getPaymentDetails().get(0).getCashSum()==null)
		{
			assetAccount.getPaymentDetails().get(0).setCashSum(0.00);
		}
		if(assetAccount.getPaymentDetails().get(0).getWechatSum()==null)
		{
			assetAccount.getPaymentDetails().get(0).setWechatSum(0.00);
		}
		if(assetAccount.getPaymentDetails().get(0).getCreditCardSum()==null)
		{
			assetAccount.getPaymentDetails().get(0).setCreditCardSum(0.00);
		}
		double receipt=assetAccount.getPaymentDetails().get(0).getCashSum()+assetAccount.getPaymentDetails().get(0).getWechatSum()+assetAccount.getPaymentDetails().get(0).getCreditCardSum();
		
		if(assetAccount.getChargeTypeName()==null)
		{
			assetAccount.setChargeTypeName("全部");			
		}
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=sdf.format(new Date());
		g2d.setFont(new Font("Default", Font.PLAIN, 15));
		g2d.drawString("翔恒科技", 65, 15);
		g2d.setFont(new Font("Default", Font.PLAIN, 12));
		//g2d.drawString("充值记录", 45, 30);
		
		g2d.drawString("交易单号:"+"44030000010200520160700001", 7, 30);
//		g2d.drawString("交易单号:"+null, 7, 30);
		//g2d.drawString("收费类型：" + "充值", 7, 56);
		g2d.setFont(new Font("Default", Font.PLAIN, 9));
		g2d.drawString("项目", 7, 45);
		g2d.drawString("数量", 42, 45);
		g2d.drawString("折扣", 77, 45);
		g2d.drawString("单价", 112, 45);
		g2d.drawString("总价", 147, 45);
		g2d.drawString("---------------------------------------------------------------", 7,55);	
		g2d.drawString("充值", 7, 65);
		g2d.drawString("1", 47, 65);
		g2d.drawString("\\", 82, 65);
		g2d.drawString(assetAccount.getAddPrice().toString(), 112, 65);
		g2d.drawString(assetAccount.getAddPrice().toString(), 147, 65);
		g2d.drawString("---------------------------------------------------------------", 7,75);	
		g2d.drawString("总计:"+assetAccount.getAddPrice().toString()+"(元)",7,85);
		g2d.drawString("收款:"+receipt+"(元)",7,95);
		g2d.drawString("找零:" +(receipt-assetAccount.getAddPrice())+"(元)", 7, 105);
		g2d.drawString("收银员工号:"+"YG0001", 7, 115);
		g2d.drawString("打印时间:" +date , 7, 125);
		g2d.drawString("谢谢惠顾,欢迎下次光临", 50, 135);
		g2d.drawString("请妥善保管收银单", 60, 145);
		g2d.drawString("http://www.everwing.com.cn/" ,40, 155);
		g2d.drawString("XXXX-XXXXXXXX",60,165);
	}

	public  void Print(AssetAccount assetAccount) {
			
		// 通俗理解就是书、文档
		Book book = new Book();

		// 打印格式
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);

		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		p.setSize(250, 500);
		p.setImageableArea(0, 0, 250, 1000);
		pf.setPaper(p);
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new PrintTopUp(), pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPageable(book);
		try {
			PrintTopUp.assetAccount=assetAccount;
			job.print();
			
		} catch (PrinterException e) {
			System.out.println("================打印出现异常");
		}
	}
}