package interfaceTest;

import java.io.File;

import com.flf.util.DatabaseSpaceUtil;
import com.flf.util.FileSpaceUtil;

public class SapceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String database = "home_jiajia";
		double result = DatabaseSpaceUtil.getDateBaseSpace(database);
		System.out.println("数据库空间大小为："+result+"MB");
		
		double totalSize = FileSpaceUtil.getDirSize(new File("f:\\迅雷下载"));
		System.out.println("文件夹大小为："+String.format("%.2f", totalSize)+"MB");
	}

}
