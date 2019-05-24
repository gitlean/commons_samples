package com.isoft.commons.collections;

import java.util.Iterator;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferUtils;
import org.apache.commons.collections.buffer.BoundedFifoBuffer;
//import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Buffer
 * @author john
 * @date 2018年10月3日
 * @time 上午7:50:15
 * @describe:
 */
public class BufferUsage {
	public static void main(String[] args) {
		demoBufferUsage();
	}

	public static void demoBufferUsage() {

		System.out.println(StringUtils.center(" demoBagUsage ", 40, "="));

		// data setup
		Book book1 = new Book("Refactoring Workbook", "7-5083-2208-8", 29.8);
		Book book2 = new Book("J2EE Design Patterns", "7-5083-3099-4", 45);
		Book book3 = new Book("Agile Software Development", "7-5083-1503-0", 59);
		Book book4 = new Book("Professional JSP", "7-5053-8005-2", 100);

		// create a Buffer
		Buffer buffer = BufferUtils.typedBuffer(new BoundedFifoBuffer(3), Book.class); // key
																						// line1
		buffer.add(book1);
		buffer.add(book2);
		buffer.add(book3);
		Book removed = (Book) buffer.remove();// key line2
		System.out.println("Removed:");
		System.out.println(removed);
		buffer.add(book4);// key line3

		// get items in buffer
		for (int i = 0; i < 3; i++) {
			System.out.println(buffer.get());
			buffer.remove();
		}
		System.out.println(StringUtils.repeat("=", 40));
	}
}