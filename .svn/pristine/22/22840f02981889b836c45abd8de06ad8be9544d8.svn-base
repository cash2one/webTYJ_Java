package com.flf.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
public class JavaCT {
	private URLClassLoader loader;

	public boolean checkIf(String prame) {
        try {  
            String className = "RunTime";  
            String classDir = System.getProperty("user.dir");  
            File file = new File(classDir, className + ".java");  
            PrintWriter out = new PrintWriter(new FileOutputStream(file));  
            // 代码  
            StringBuffer sbf = new StringBuffer(128);  
            sbf.append("public class ");  
            sbf.append(className);  
            sbf.append("{");  
            sbf.append("public boolean check() {"); 
            sbf.append("if("+prame+"){");
            sbf.append("return true;");
            sbf.append("}else{return false;}");  
            sbf.append("}");
            sbf.append("}");
            String code = sbf.toString();  
            out.println(code);  
            out.flush();  
            out.close();  
            // 编译  
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();    
            compiler.run(null, null, null, "-encoding", "UTF-8","-d",classDir, file.getName());  
            URL url = new URL("file:/" + classDir + File.separator);  
            loader = new URLClassLoader(new URL[] { url });  
            Class<?> clazz = loader.loadClass(className);  
            Object obj = clazz.newInstance();  
            Method method = clazz.getMethod("check");  
            return (boolean) method.invoke(obj);
        } catch (Exception e) {  
            e.printStackTrace();
            return false;
        }  
    }
	public static void main(String[] args) {
		JavaCT test=new JavaCT();
		System.out.println(test.checkIf("(975.0<=200)&&(10>=1&&10<=4||10==11||10==12)"));
	}
}
