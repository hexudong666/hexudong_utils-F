package com.hexudong.utils;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:  FileUtil   
 * @Description: 文件工具类  
 * @date:   2020年1月3日 上午9:06:40
 */
public class FileUtil {
	/**
	 * @Title: getExtName   
	 * @Description: 文件扩展名
	 * @param: @param str
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getExtName(String str) {
		if(StringUtil.isNull(str)) {
			return null;
		}
		if(!str.contains(".")) {
			throw new RuntimeException("无法获取文件扩展名");
		}
		return str.substring(str.indexOf("."));
	}
	/**
	 * @Title: delete   
	 * @Description: 递归删除文件   
	 * @param: @param file      
	 * @return: void      
	 * @throws
	 */
	public static void delete(File file) {
		/** 获取文件列表 **/
		File[] listFiles = file.listFiles();
		for(File theFile : listFiles) {
			/** 如果是文件夹，递归删除 **/
			if(theFile.isDirectory()) {
				delete(theFile);
				/** 删除空文件夹 **/
				theFile.delete();
			}else {
				/** 如果是文件，直接删除 **/
				theFile.delete();
			}
			
		}
	}
	/**
	 * @Title: delete   
	 * @Description: 递归删除文件   
	 * @param: @param pathname      
	 * @return: void      
	 * @throws
	 */
	public static void delete(String pathname) {
		delete(new File(pathname));
	}
	/**
	 * 获取系统当前用户目录
	 * @return
	 */
	public static String getSystemUserHome() {
		return System.getProperty("user.home");
	}
	/**
	 * @Title: getSystemTempDirectory   
	 * @Description: 操作系统临时目录
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getSystemTempDirectory() {
		return System.getProperty("java.io.tmpdir");
	}
	/**
	 * @Title: getFileSize   
	 * @Description: 获得文件大小
	 * 返回文件以指定单位大小表示
	 * File a.txt=2k  
	 * @param: @param file
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getFileSize(File file) {
		long length = file.length();
		double len = length/1024.0;
		return String.format("%.2f",len)+"kb";
	}
	/**
	 * @Title: readFile
	 * @Description: 读取文件内容
	 * @param file
	 * @param charset
	 * @return
	 * @throws IOException
	 * @return: String
	 */
	public static String readFile(File file, String charset) throws IOException {
		// 创建输出流对象
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
		// 定义缓冲对象
		StringBuffer sb = new StringBuffer();
		// 定义读取每行的结果
		String content = null;
		// 循环读取
		while ((content = br.readLine()) != null) {
			// 加入缓冲对象
			sb.append(content);
		}
		// 关闭流
		br.close();
		// 返回结果
		return sb.toString();

	}
	/**
	 * 
	    * @Title: readTxtOfLine
	    * @Description: 读取文件内容到list
	    * @param @param path
	    * @param @return    参数
	    * @return List<String>    返回类型
	    * @throws
	 */
	public static List<String> readTxtOfLine(String path) {
		FileInputStream fis = null;
		Reader isr = null;
		BufferedReader buffer = null;
		List<String> list = null;
		try {
			fis = new FileInputStream(new File(path));
			isr = new InputStreamReader(fis,"utf-8");
			buffer = new BufferedReader(isr);
			String line = "";
			list = new ArrayList<String>();
			while((line=buffer.readLine())!=null) {
				list.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * @Title: writeFile
	 * @Description: 按照指定的编码把内容写入指定的文件中
	 * @param path
	 * @param content
	 * @param charset
	 * @throws IOException
	 * @return: void
	 */
	public static void writeFile(String path, String content, String charset) throws IOException {
		// 创建写入的文件
		File file = new File(path);
		// 判断父目录是否存在
		if (!file.getParentFile().exists()) {
			// 创建父目录
			file.getParentFile().mkdirs();
		}
		// 创建输出流对象
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		bw.write(content);
		bw.flush();
		bw.close();
	}
}
