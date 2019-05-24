package com.isoft.commons.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

/**
 * https://blog.csdn.net/zhoushou6/article/details/80292271
 * @createTime 2019年5月24日 上午10:26:27
 * @describe * apache.commons.io.IOUtils常用方法的使用
 *           对字节流inputStream,outStream,writer,reader字符流的常用方法的使用
 */
public class TestCommon {
	public static void main(String[] args) throws IOException {
		//testLineIterator();
		//testWrite();
		testReadLines();
	}

	/**
	 * CloseQuietly可以关闭inputStream,outputStream,reader,writer流
	 * 
	 * @throws IOException
	 */
	public static void testCloseQuietly() throws IOException {
		String filename = "D:" + File.separator + "data.txt";
		File f = new File(filename);
		InputStream in = new FileInputStream(f);
		// 读取内容
		byte[] b = new byte[1024];
		in.read(b);
		System.out.println(new String(b));
		OutputStream out = new FileOutputStream(f, true);
		String str = "我们是幸运的";
		out.write(str.getBytes());
		IOUtils.closeQuietly(in);
		IOUtils.closeQuietly(out);
	}

	/**
	 * toString的使用
	 * 
	 * @throws IOException
	 */
	public static void testToString() throws IOException {
		String filename = "D:" + File.separator + "data.txt";
		File f = new File(filename);
		InputStream in = new FileInputStream(f);
		System.out.println(IOUtils.toString(in));
		IOUtils.closeQuietly(in);
	}

	/**
	 * copy的使用 copy能拷贝Integer.MAX_VALUE的字节数据，即2^31-1。
	 * 如果是很大的数据，那么可以选择用copyLarge方法，适合拷贝较大的数据流，比如2G以上
	 * 
	 * @throws IOException
	 */
	public static void testCopy() throws IOException {
		String filename = "D:" + File.separator + "data.txt";
		String filename2 = "D:" + File.separator + "data2.txt";
		File f = new File(filename);
		File f2 = new File(filename2);
		InputStream input1 = new FileInputStream(f2);
		InputStream in = new FileInputStream(f);
		System.out.println("未复制之前：" + IOUtils.toString(input1));
		
		OutputStream out = new FileOutputStream(f2);
		IOUtils.copy(in, out);
		IOUtils.closeQuietly(in);
		IOUtils.closeQuietly(out);
		InputStream input2 = new FileInputStream(f2);
		System.out.println("复制之后:" + IOUtils.toString(input2));
		IOUtils.closeQuietly(input1);
		IOUtils.closeQuietly(input2);
	}

	/**
	 * ToByteArray的使用
	 * 
	 * @throws IOException
	 */
	public static void testToByteArray() throws IOException {
		String filename = "D:" + File.separator + "data.txt";
		File f = new File(filename);
		InputStream in = new FileInputStream(f);
		byte[] byteArray = IOUtils.toByteArray(in);
		System.out.println(new String(byteArray));
		IOUtils.closeQuietly(in);
	}

	/**
	 * 测试write
	 * 
	 * @throws IOException
	 */
	public static void testWrite() throws IOException {
		String filename = "D:" + File.separator + "data.txt";
		File f = new File(filename);
		OutputStream out = new FileOutputStream(f);
		IOUtils.write("我们是幸运的", out);
		IOUtils.closeQuietly(out);

		InputStream in = new FileInputStream(f);
		System.out.println(IOUtils.toString(in));
		IOUtils.closeQuietly(in);
	}

	
	public static void testWrite2() throws IOException {
		String filename = "D:" + File.separator + "data.txt";
		File f = new File(filename);
		OutputStream out = new FileOutputStream(f,true); //可以追加
		IOUtils.write("我们是幸运的\r\n", out);
		IOUtils.closeQuietly(out);

		InputStream in = new FileInputStream(f);
		System.out.println(IOUtils.toString(in));
		IOUtils.closeQuietly(in);
	}
	
	
	
	/**
	 * 测试ToInputStream
	 * 
	 * @throws IOException
	 */
	public static void testToInputStream() throws IOException {

		InputStream inputStream = IOUtils.toInputStream("LHQ是幸运的");
		System.out.println(IOUtils.toString(inputStream));
		IOUtils.closeQuietly(inputStream);
	}

	/**
	 * 测试ReadLines 分行读取内容
	 * 
	 * @throws IOException
	 */
	public static void testReadLines() throws IOException {
		String filename = "D:" + File.separator + "data.txt";
		File f = new File(filename);
		Reader input = new FileReader(f);
		List readLines = IOUtils.readLines(input);
		for (Object object : readLines) {
			System.out.println(object);
		}
		IOUtils.closeQuietly(input);
	}

	/**
	 * 测试LineIterator LineIterator可以构造器可以接受一个Reader
	 * 通常在读取大文件时候将BufferedReader装进去性能会比较好
	 * 
	 * @throws IOException
	 */
	public static void testLineIterator() throws IOException {
		// 于安全考虑这里推荐使用io包的LineIterator，并且其在性能上也优于普通流
		String filename = "D:" + File.separator + "data.txt";
		File f = new File(filename);
		Reader reader = new FileReader(f); //通常在读取大文件时候将BufferedReader装进去性能会比较好
		LineIterator lineIterator = IOUtils.lineIterator(reader);
		while (lineIterator.hasNext()) {
			System.out.println(lineIterator.nextLine());
		}
		lineIterator.close();
		IOUtils.closeQuietly(reader);
	}
}
